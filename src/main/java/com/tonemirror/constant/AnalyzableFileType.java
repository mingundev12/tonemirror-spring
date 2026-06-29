package com.tonemirror.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum AnalyzableFileType {
    JPG("image/jpeg"),
    PNG("image/png"),
    WEBP("image/webp");

    private final String contentType;

    private static final Map<String, AnalyzableFileType> BY_CONTENT_TYPE = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(
                    AnalyzableFileType::getContentType,
                    Function.identity()
            ));

    public static boolean isAnalyzableFileType(String contentType) {
        if(contentType == null) return false;
        return BY_CONTENT_TYPE.containsKey(contentType);
    }
}
