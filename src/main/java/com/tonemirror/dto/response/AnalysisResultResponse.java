package com.tonemirror.dto.response;

import com.tonemirror.util.JsonParseUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tools.jackson.databind.JsonNode;

@Getter
@AllArgsConstructor
public class AnalysisResultResponse {
    private JsonNode results;

    public AnalysisResultResponse(String str) {
        this.results = JsonParseUtil.stringToJsonNode(str);
    }
}
