package com.tonemirror.service;

import com.tonemirror.dto.files.FileInfoDto;
import com.tonemirror.dto.response.AnalysisResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnalysisPipelineService {
    private final FileSaveService fileSaveService;

//    @Value("${m2m.fastapi-url:http://fastapi-service:8000/ai/analyze}")
//    private String fastApiUrl;

    public AnalysisResultResponse processPersonalColorAnalysis(List<MultipartFile> files) {
        // 파일 정합성 체크 및 저장
        FileInfoDto targetFile = fileSaveService.saveFile(files);

        // 파이썬 서버 전송 (FastApiService 호출해서 처리)

        return null;
    }
}
