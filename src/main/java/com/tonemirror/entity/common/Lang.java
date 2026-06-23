package com.tonemirror.entity.common;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lang")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long langId;

    @Column(name = "lang_code", nullable = false, length = 10)
    private String langCode;

    public Lang(String langCode) {
        this.langCode = langCode;
    }
}