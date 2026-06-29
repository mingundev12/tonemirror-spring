package com.tonemirror.dto.files;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneratedFileDto {
    @JsonProperty("file_type")
    private String fileType;

    @JsonProperty("file_url")
    private String fileUrl;
}
