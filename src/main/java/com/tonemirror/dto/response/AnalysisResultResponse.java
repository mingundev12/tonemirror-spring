package com.tonemirror.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tools.jackson.databind.JsonNode;

@Getter
@AllArgsConstructor
public class AnalysisResultResponse {
    private JsonNode results;
}
