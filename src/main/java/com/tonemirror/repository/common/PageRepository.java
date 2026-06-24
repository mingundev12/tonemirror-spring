package com.tonemirror.repository.common;

import com.tonemirror.entity.common.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository {
    Page findByPageName(String pageName);

    Long count();
}
