package com.tonemirror.service;

import com.tonemirror.dto.response.AnalysisResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisPipelineService {
    private final FileLogService fileLogService;


    public AnalysisResultResponse processPersonalColorAnalysis(List<MultipartFile> files) {
        return null;
    }
}
