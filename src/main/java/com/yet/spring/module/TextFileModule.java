package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class TextFileModule implements FileModule {

    private static final FileExtension[] SUPPORTED_TYPES = {FileExtension.TXT};
    private static final String[] FUNCTIONS_DESCRIPTION = {
            "1. Counting and displaying the number of lines.\n",
            "2. Output the frequency of occurrence of each character.\n",
            "3. Come up with your own function.\n"
    };
    private static final Map<Integer, String> FUNCTIONS_NAME = new HashMap<>(); {
    };

    @Override
    public boolean doesSupport(FileExtension type) {
        return ArrayUtils.contains(SUPPORTED_TYPES, type);
    }

    @Override
    public void count() {

    }

    @Override
    public void showFunctionDescription() {

    }
}
