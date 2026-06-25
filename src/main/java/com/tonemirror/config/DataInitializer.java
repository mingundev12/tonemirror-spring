package com.tonemirror.config;

import com.tonemirror.service.PageContextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final PageContextService pageContextService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Checking initial dataset integrity...");

        if(pageContextService.hasData()) {
            log.info("Initial PageContexts already exists. Skipping PageContexts initialization...");
        } else {
            log.warn("Initial PageContexts doesn't exist. Initializing master data via TSV parser...");
            // todo : 페이지 컨텍스트 tsv 파싱작업
        }
        // todo : result 데이터셋 컨텍스트 csv 파싱작업
    }
}
