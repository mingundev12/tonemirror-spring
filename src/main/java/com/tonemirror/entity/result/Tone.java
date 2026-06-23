package com.tonemirror.entity.result;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tone")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tone_id")
    private Long toneId;

    @Column(name = "tone_label", nullable = false)
    private String toneLabel;
}
