package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

@Component
public class TextFileModule implements FileModule {

    private static final FileType[] SUPPORTED_TYPES = {FileType.TXT};

    @Override
    public boolean doesSupport(FileType type) {
        return ArrayUtils.contains(SUPPORTED_TYPES, type);
    }
}
