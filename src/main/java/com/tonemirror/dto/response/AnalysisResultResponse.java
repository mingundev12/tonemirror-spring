package com.tonemirror.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tonemirror.util.JsonParseUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tools.jackson.databind.JsonNode;

@Getter
@AllArgsConstructor
public class AnalysisResultResponse {
    @JsonProperty("data")
    private JsonNode data;

    public AnalysisResultResponse(String str) {
        this.data = JsonParseUtil.stringToJsonNode(str);
    }
}
