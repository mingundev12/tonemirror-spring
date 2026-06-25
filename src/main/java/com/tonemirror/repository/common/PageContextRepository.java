package com.tonemirror.repository.common;

import com.tonemirror.entity.common.PageContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageContextRepository {
    PageContext findByLangIdAndPageId(Long langId, Long pageId);

    Long count();
}
