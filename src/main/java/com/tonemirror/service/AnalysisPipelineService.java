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
    private final FastApiService fastApiService;

    public AnalysisResultResponse processPersonalColorAnalysis(List<MultipartFile> files) {
        // 파일 정합성 체크 및 저장
        FileInfoDto targetFile = fileSaveService.saveFile(files);

        // 파이썬 서버 전송 (FastApiService 호출해서 처리)
        String result = fastApiService.requestAnalyzation(targetFile);

        // 결과값 데이터셋 조립 및 리턴

        return null;
    }
}
