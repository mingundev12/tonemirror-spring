package com.tonemirror.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "page_text")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PageText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_text_id")
    private Long pageTextId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_id", nullable = false)
    private Lang lang;

    @Column(name = "data_set", columnDefinition = "JSON")
    private String dataSet;

    public PageText(Page page, Lang lang, String dataSet) {
        this.page = page;
        this.lang = lang;
        this.dataSet = dataSet;
    }
}
