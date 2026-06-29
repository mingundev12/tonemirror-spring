package com.tonemirror.dto.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneratedFileDto {
    @JsonProperty("parent_file_id")
    private Long parentFileId;

    @JsonProperty("file_type")
    private String fileType;

    @JsonProperty("file_url")
    private String fileUrl;
}
