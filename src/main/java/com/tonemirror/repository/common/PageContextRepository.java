package com.tonemirror.repository.common;

import com.tonemirror.entity.common.PageContext;
import org.springframework.stereotype.Repository;

@Repository
public interface PageContextRepository {
    PageContext findByLangIdAndPageId(Long langId, Long pageId);
}
