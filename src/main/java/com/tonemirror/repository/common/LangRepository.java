package com.tonemirror.repository.common;

import com.tonemirror.entity.common.Lang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LangRepository extends JpaRepository<Lang,Long> {
    Lang findByCode(String code);

//    Long count();
}
