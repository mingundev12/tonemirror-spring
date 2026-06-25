package com.tonemirror.service;

import com.tonemirror.entity.files.GeneratedFileLog;
import com.tonemirror.entity.files.SavedFileLog;
import com.tonemirror.repository.files.GeneratedFileLogRepository;
import com.tonemirror.repository.files.SavedFileLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileLogService {
    private final SavedFileLogRepository savedFileRepository;
    private final GeneratedFileLogRepository generatedFileRepository;

    // 파일 저장
    @Transactional
    public void saveFile(String originFileName, String fileUrl) {
        SavedFileLog file = new SavedFileLog(originFileName, fileUrl);

        savedFileRepository.save(file);
    }

    // 파일 삭제
    @Transactional
    public void softDeleteFiles(LocalDateTime targetTime) {
        LocalDateTime now = LocalDateTime.now();
        long deleted = savedFileRepository.softDeleteByCreatedAtBefore(targetTime, now);
        deleted += generatedFileRepository.softDeleteByCreatedAtBefore(targetTime, now);

        log.info("Deleted {} Files", deleted);
    }

    // 유효기간 지난 파일 조회
    @Transactional(readOnly = true)
    public List<String> getOverTimedFileUrls(LocalDateTime targetTime) {
        List<String> savedFileUrls = savedFileRepository.findFileUrlByCreatedAtBefore(targetTime);
        List<String> generatedFileUrls = generatedFileRepository.findFileUrlByCreatedAtBefore(targetTime);

        return Stream.concat(savedFileUrls.stream(), generatedFileUrls.stream()).toList();
    }
}
