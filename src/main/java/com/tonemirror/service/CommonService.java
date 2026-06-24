package com.tonemirror.service;

import com.tonemirror.repository.common.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonService {
    private final LangRepository langRepository;
    private final PageRepository pageRepository;
    private final PageContextRepository pageContextRepository;
}
