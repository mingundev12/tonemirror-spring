package com.tonemirror.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "page")
@Getter
@NoArgsConstructor
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "page_name", length = 30, nullable = false)
    private String pageName;

    public Page(String pageName) {
        this.pageName = pageName;
    }
}
