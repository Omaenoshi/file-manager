package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class TextFileModule implements FileModule {

    private static final FileExtension[] SUPPORTED_TYPES = {FileExtension.TXT};
    private static final String[] FUNCTIONS_DESCRIPTION = {
            "1. Counting and displaying the number of lines.",
            "2. Output the frequency of occurrence of each character.",
            "3. Come up with your own function."
    };
    private static final Map<Integer, String> FUNCTIONS_NAMES = new HashMap<>(); {
        FUNCTIONS_NAMES.put(1, "countNumberOfLines");
        FUNCTIONS_NAMES.put(2, "countFrequencyOfChar");
        FUNCTIONS_NAMES.put(3, "comeUp");
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
        for (String line:
             FUNCTIONS_DESCRIPTION) {
            System.out.println(line);
        }
    }

    private void countNumberOfLines() {
        System.out.println("Number of lines is " + 0);
    }

    @Override
    public void doFunction(int functionNum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = TextFileModule.class.getDeclaredMethod(FUNCTIONS_NAMES.get(functionNum));
        method.invoke(this);
    }
}
