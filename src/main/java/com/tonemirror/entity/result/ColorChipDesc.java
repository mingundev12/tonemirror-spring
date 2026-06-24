package com.tonemirror.entity.result;

import com.tonemirror.entity.common.Lang;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "color_chip_desc",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_color_lang",
                        columnNames = {"color_id", "lang_id"}
                )
        } // 복합 Unique Key 설정
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ColorChipDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_chip_desc_id")
    private Long colorChipDescId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", nullable = false)
    private ColorChip color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_id", nullable = false)
    private Lang lang;

    @Column(name = "color_name", length = 50)
    private String colorName;

    // todo : 서비스 도메인에 맞춰 생성자 구성할 것
//    public ColorChipDesc(ColorChip color, Lang lang, String colorName) {
//        if (color == null || lang == null || colorName == null) {
//            throw new IllegalArgumentException("color, lang, and colorName are mandatory");
//        }
//        this.color = color;
//        this.lang = lang;
//        this.colorName = colorName;
//    }
}
