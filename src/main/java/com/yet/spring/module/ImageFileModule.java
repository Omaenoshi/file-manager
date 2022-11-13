package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageFileModule implements FileModule{
    private static final FileExtension[] SUPPORTED_EXTENSIONS = {FileExtension.JPG, FileExtension.PNG};
    private static final String[] FUNCTIONS_DESCRIPTION = {
            "1. "
    };

    @Override
    public boolean doesSupport(FileExtension type) {
        return ArrayUtils.contains(SUPPORTED_EXTENSIONS, type);
    }

    @Override
    public void count() {

    }

    @Override
    public void showFunctionDescription() {

    }

    @Override
    public void doFunction(int functionNum) {

    }
}
