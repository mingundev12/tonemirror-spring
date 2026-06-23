package com.tonemirror.entity.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lang")
@Getter
@NoArgsConstructor
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