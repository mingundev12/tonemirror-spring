package com.tonemirror.entity.common;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "page_context")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PageContext {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_context_id")
    private Long pageContextId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_id", nullable = false)
    private Lang lang;

    @Column(name = "context", columnDefinition = "JSON")
    private String context;

    public PageContext(Page page, Lang lang, String context) {
        this.page = page;
        this.lang = lang;
        this.context = context;
    }
}
