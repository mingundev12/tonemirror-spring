package com.tonemirror.entity.result;

import com.tonemirror.entity.common.Lang;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "tone_desc",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_tone_lang",
                        columnNames = {"tone_id", "lang_id"}
                )
        } // 복합 Unique Key 설정
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToneDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tone_desc_id")
    private Long toneDescId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tone_id", nullable = false)
    private Tone tone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_id", nullable = false)
    private Lang lang;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "best_tip", columnDefinition = "TEXT")
    private String bestTip;

    @Column(name = "worst_tip", columnDefinition = "TEXT")
    private String worstTip;
}
