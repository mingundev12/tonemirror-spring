package com.tonemirror.entity.catalog;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foundation")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Foundation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foundation_id")
    private Long foundationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tone_id")
    private Tone tone;

    @Column(name = "label", nullable = false, length = 20)
    private String label;

    @Column(name = "brightness", nullable = false)
    private Integer brightness;

    @Column(name = "hex", nullable = false, length = 7)
    private String hex;

    // todo : 서비스 도메인에 맞춰 생성자 구성할 것
}
