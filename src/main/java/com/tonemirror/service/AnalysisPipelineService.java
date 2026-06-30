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

        // 결과값 Json 규격 문자열을 Dto 객체로 변환
        /// 결과값 데이터셋 조립 및 Json 가공 후 리턴
        /// 유의미한 가공데이터 -> 진단된 퍼스널 컬러별
        /// 사용자 언어에 맞는 결과 문자열
        /// 베스트 컬러 + 워스트 컬러
        /// 추천 파운데이션 목록
        /// 원본 이미지 Url
        /// 리액트 -> 파이썬 상호작용에 사용될 안면 피부영역 이미지 Url

        return new AnalysisResultResponse(result);
    }
}
