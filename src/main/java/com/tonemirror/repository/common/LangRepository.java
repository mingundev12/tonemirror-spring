package com.tonemirror.repository.common;

import com.tonemirror.entity.common.Lang;
import org.springframework.stereotype.Repository;

@Repository
public interface LangRepository {
    Lang findByCode(String code);
}
