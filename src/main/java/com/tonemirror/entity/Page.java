package com.tonemirror.entity;

import jakarta.persistence.*;

@Entity
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pageId;

    @Column(name = "page_name", length = 30, nullable = false)
    private String pageName;
}
