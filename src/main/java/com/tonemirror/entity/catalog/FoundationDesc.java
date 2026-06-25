package com.tonemirror.entity.catalog;

import com.tonemirror.entity.common.Lang;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "foundation_desc",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_foundation_lang",
                        columnNames = {"foundation_id", "lang_id"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoundationDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foundation_desc_id")
    private Long foundationDescId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foundation_id", nullable = false)
    private Foundation foundation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_id", nullable = false)
    private Lang lang;

    @Column(name = "brand_name", nullable = false, length = 20)
    private String brandName;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "color_name", nullable = false, length = 50)
    private String colorName;

    // todo : 서비스 도메인에 맞춰 생성자 구성할 것
}
