package com.tonemirror.repository.common;

import com.tonemirror.entity.common.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository {
    Page findByPageName(String pageName);
}
