package com.tonemirror.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tonemirror.dto.files.GeneratedFileDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisResultDto {
    @JsonProperty("status")
    private String status;

    @JsonProperty("personal_color")
    private String personalColor;

    @JsonProperty("detected_skin_hex")
    private String detectedSkinHex;

    @JsonProperty("files")
    private List<GeneratedFileDto> files;
}
