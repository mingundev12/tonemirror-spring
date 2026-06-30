package com.tonemirror.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonParseUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static JsonNode stringToJsonNode(String str) {
        // 예외발생의 경우 handler에 캐치될 것이기 때문에 그냥 단순 처리만 담당
        return MAPPER.readTree(str);
    }
}
