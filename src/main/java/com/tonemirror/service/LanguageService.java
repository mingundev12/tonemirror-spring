package com.tonemirror.service;

import com.tonemirror.constant.Language;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    // 각종 다국어 데이터셋에 대응하기 위해 재사용성이 높은 코드를 별도의 서비스 메서드로 분리
    public Language findLanguageFromCode(String langCode) {
        try {
            return Language.fromCode(langCode);
        } catch (Exception e) {
            return Language.KO;
        }
    }
}
