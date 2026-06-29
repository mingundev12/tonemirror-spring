package com.tonemirror.service;

import com.tonemirror.repository.catalog.*;
import com.tonemirror.util.LanguageEnumUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogService {
    private final ToneRepository toneRepository;
    private final ToneDescRepository toneDescRepository;
    private final ColorChipRepository colorRepository;
    private final ColorChipDescRepository colorDescRepository;
    private final FoundationRepository foundationRepository;
    private final FoundationDescRepository foundationDescRepository;
}
