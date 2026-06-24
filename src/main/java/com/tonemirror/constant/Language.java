package com.tonemirror.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public enum Language {
    KO("KOR", "한국어", "kr"),
    EN("ENG", "English", "gb");

    private final String code;
    private final String label;
    private final String flag;

    // react 페이지 제공용 언어 목록 데이터셋
    public final static List<Language> languages = Arrays.asList(values());

    public static Language fromCode(String code) {
        if (code == null || code.isBlank()) {
            return KO;
        }

        return languages.stream().filter(
                lang -> lang.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid language code: " + code));
    }
}
