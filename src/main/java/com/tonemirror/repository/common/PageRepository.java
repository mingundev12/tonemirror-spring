package com.tonemirror.repository.common;

import com.tonemirror.entity.common.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    Page findByPageName(String pageName);

//    Long count();
}
