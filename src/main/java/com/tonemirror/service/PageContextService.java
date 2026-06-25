package com.tonemirror.service;

import com.tonemirror.constant.Language;
import com.tonemirror.dto.response.PageContextResponse;
import com.tonemirror.entity.common.Lang;
import com.tonemirror.entity.common.Page;
import com.tonemirror.entity.common.PageContext;
import com.tonemirror.repository.common.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageContextService {
    private final LangRepository langRepository;
    private final PageRepository pageRepository;
    private final PageContextRepository pageContextRepository;
    private final ObjectMapper objectMapper;

    // 언어별 페이지 컨텍스트 제공
    @Transactional(readOnly = true)
    public PageContextResponse getPageContext(String pageName, String langCode) {
        Language language;
        try {
            language = Language.fromCode(langCode);
        } catch (Exception e) {
            language = Language.KO;
        }

        Lang lang = langRepository.findByCode(language.getCode());
        Page page = pageRepository.findByPageName(pageName);

        if(lang == null || page == null) {
            throw new IllegalArgumentException("there is no page or lang information");
        }

        PageContext pageContext = pageContextRepository.findByLangIdAndPageId(lang.getLangId(), page.getPageId());

        if(pageContext == null) {
            throw new IllegalArgumentException("there is no page context information");
        }

        try {
            JsonNode contextsNode = objectMapper.readTree(pageContext.getContext());
            return new PageContextResponse(lang.getCode(), page.getPageName(), contextsNode);
        } catch (Exception e) {
            throw new IllegalStateException("json parse error");
        }
    }

    // 초기 데이터셋 존재여부 확인
    @Transactional(readOnly = true)
    public boolean hasData() {
        Long langCount = langRepository.count();
        Long pageCount = pageRepository.count();
        Long contextCount = pageContextRepository.count();

        return (langCount > 0 && pageCount > 0 && contextCount > 0);
    }

    // todo : *.tsv 에서 page별 컨텍스트 추출하여 DB저장하는 메서드
    @Transactional
    public void loadFileAndSaveData(List<String> tsvFileUrls){

    }
}
