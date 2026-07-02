package com.tonemirror.service;

import com.tonemirror.constant.AnalyzableFileType;
import com.tonemirror.dto.files.FileInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileSaveService {
    private final FileLogService fileLogService;

    @Value("${file.upload-dir:/app/storage}")
    private String uploadDir;

    public FileInfoDto saveFile(MultipartFile file){
        // 파일 정합성 체크
        MultipartFile originFile = validateFile(file);

        // 파일 저장 및 기록 생성
        String originalFilename = originFile.getOriginalFilename();
        String storedFilename = validateFileName(originalFilename);

        File targetFile = Paths.get(uploadDir, storedFilename).toFile();

        try {
            if(!targetFile.getParentFile().exists()){
                targetFile.getParentFile().mkdirs();
            }
            originFile.transferTo(targetFile);
            log.info("[+] File Local Writing Success : {}", targetFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("서버 내부 파일 스토리지 저장 실패", e);
        }

        return fileLogService.saveFile(originalFilename, targetFile.getAbsolutePath());
    }

    private MultipartFile validateFile(MultipartFile file){
        if(file==null || file.isEmpty()){
            throw new IllegalArgumentException("진단할 파일이 존재하지 않습니다.");
        }

        String contentType = file.getContentType();
        if(!AnalyzableFileType.isAnalyzableFileType(contentType)){
            throw new IllegalArgumentException("분석 가능한 이미지 파일 형식이 아닙니다.");
        }

        return file;
    }

    private String validateFileName(String originalFilename){
        if(originalFilename == null || !originalFilename.contains(".")) {
            throw new IllegalArgumentException("올바르지 않은 파일명 형식입니다.");
        }
        int lastDotIndex = originalFilename.lastIndexOf(".");
        if(lastDotIndex == originalFilename.length() - 1){
            throw new IllegalArgumentException("파일 확장자명이 존재하지 않습니다.");
        }

        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        return UUID.randomUUID() + extension;
    }
}
