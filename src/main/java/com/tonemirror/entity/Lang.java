package com.tonemirror.entity;

import jakarta.persistence.*;

@Entity
public class Lang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long langId;

    @Column(name = "lang_code", nullable = false, length = 10)
    private String langCode;
}