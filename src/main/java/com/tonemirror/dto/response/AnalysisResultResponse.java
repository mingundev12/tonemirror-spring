package com.tonemirror.dto.response;

import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

@Getter @Setter
public class AnalysisResultResponse {
    private String message;
    private JsonNode results;

    public AnalysisResultResponse(String errorMsg) {
        this.message = errorMsg;
        this.results = null;
    }

    public AnalysisResultResponse(JsonNode results) {
        this.message = "analyze success";
        this.results = results;
    }
}
