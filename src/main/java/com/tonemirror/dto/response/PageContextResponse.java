package com.tonemirror.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tools.jackson.databind.JsonNode;

@Getter
@AllArgsConstructor
public class PageContextResponse {
    private final String lang;
    private final String page;
    private final JsonNode contexts;
}
