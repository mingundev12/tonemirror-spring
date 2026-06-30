package com.tonemirror.service;

import com.tonemirror.dto.files.FileInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class FastApiService {

    private final RestTemplate restTemplate;

    @Value("${m2m.fastapi-url:http://python-server:8000/ai}")
    private String fastApiUrl;

    public String requestAnalyzation(FileInfoDto targetFile) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("parentFileId", targetFile.getFileId());
        requestBody.put("filePath", targetFile.getFileUrl());

        // python 서버의 "이미지 전처리" router 엔드포인트로 요청
        String requestUrl = fastApiUrl + "/preprocess";
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
        log.info("[▲] M2M Outbound Request to Python Container -> URL: {}", requestUrl);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(requestUrl, request, String.class);

            log.info("[▼] M2M Inbound Response Sync Success.");
            return response.getBody();
        } catch (HttpStatusCodeException e) {
            // 분석 실패시 파이썬에서 보내주는 오류 메시지를 그대로 받아적어 보내기
            String pythonErrorBody = e.getResponseBodyAsString();
            log.warn("[-] Python AI Server Logic Error Response : {}", pythonErrorBody);
            throw new IllegalArgumentException(pythonErrorBody);
        } catch (Exception e) {
            log.error("[-] M2M 가상 네트워크 통신 실패 : {}", e.getMessage());
            throw new RuntimeException("AI 분석 서버와의 가상 네트워크 통신 실패", e);
        }
    }
}
