package com.tonemirror.repository.common;

import com.tonemirror.entity.common.PageContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageContextRepository extends JpaRepository<PageContext, Long> {
    PageContext findByLang_LangIdAndPage_PageId(Long langId, Long pageId);

//    Long count();
}
