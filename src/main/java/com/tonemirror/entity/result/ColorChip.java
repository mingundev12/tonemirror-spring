package com.tonemirror.entity.result;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "color_chip")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ColorChip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Long colorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tone_id")
    private Tone tone;

    @Column(name = "is_best")
    private boolean isBest;

    @Column(name = "hex_code", length = 7)
    private String hexCode;
}
