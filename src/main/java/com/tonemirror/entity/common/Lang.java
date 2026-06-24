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

    @Column(name = "code", nullable = false, length = 10)
    private String code;

    // todo : 서비스 도메인에 맞춰 생성자 구성할 것
//    public Lang(String langCode) {
//        this.langCode = langCode;
//    }
}