package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

@Component
public class ImageFileModule implements FileModule{

    private static final FileExtension[] SUPPORTED_TYPES = {FileExtension.JPG, FileExtension.PNG};

    @Override
    public boolean doesSupport(FileExtension type) {
        return ArrayUtils.contains(SUPPORTED_TYPES, type);
    }

    @Override
    public void count() {

    }
}
