package com.tonemirror.repository.common;

import com.tonemirror.entity.common.Lang;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LangRepository {
    Lang findByCode(String code);

    Long count();
}
