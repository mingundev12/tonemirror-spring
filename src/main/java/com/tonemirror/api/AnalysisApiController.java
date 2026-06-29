package com.tonemirror.api;

import com.tonemirror.dto.response.AnalysisResultResponse;
import com.tonemirror.dto.response.ApiResponse;
import com.tonemirror.service.AnalysisPipelineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AnalysisApiController {
    private final AnalysisPipelineService analysisPipelineService;

    @PostMapping("/api/analysis")
    public ResponseEntity<ApiResponse<AnalysisResultResponse>> uploadAndAnalyze(
            @RequestPart("file") List<MultipartFile> files) {

        AnalysisResultResponse response = analysisPipelineService.processPersonalColorAnalysis(files);

        return ResponseEntity.ok(new ApiResponse<>("analyze success", response));
    }
}
