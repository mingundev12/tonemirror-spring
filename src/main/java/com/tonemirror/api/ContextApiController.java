package com.tonemirror.api;

import com.tonemirror.dto.response.ApiResponse;
import com.tonemirror.dto.response.PageContextResponse;
import com.tonemirror.service.PageContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContextApiController {
    private final PageContextService service;

    @GetMapping("/api/{pageName}")
    public ResponseEntity<ApiResponse<PageContextResponse>> getPageContext(
            @PathVariable String pageName,
            @RequestParam(value = "lang", required = false) String lang
    ) {
        PageContextResponse response = service.getPageContext(pageName, lang);
        return ResponseEntity.ok(new ApiResponse<>("page load success", response));
    }
}
