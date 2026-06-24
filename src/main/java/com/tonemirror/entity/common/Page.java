package com.tonemirror.entity.common;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "page")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "page_name", length = 30, nullable = false)
    private String pageName;

    // todo : 서비스 도메인에 맞춰 생성자 구성할 것
//    public Page(String pageName) {
//        this.pageName = pageName;
//    }
}
