package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
@Lazy
public class MusicFileModule implements FileModule{
    private static final FileExtension[] SUPPORTED_EXTENSIONS = {FileExtension.MP3};
    private static final String[] FUNCTIONS_DESCRIPTION = {
            "1. Display track name.",
            "2. Output duration in seconds.",
            "3. Delete file."
    };
    private static final Map<Integer, String> FUNCTIONS_NAMES = new HashMap<>(); static {
        FUNCTIONS_NAMES.put(1, "displayName");
        FUNCTIONS_NAMES.put(2, "displayDuration");
        FUNCTIONS_NAMES.put(3, "deleteFile");
    }

    private final File file;

    @Autowired
    public MusicFileModule(File file) {
        this.file = file;
    }

    @Override
    public boolean doesSupport(FileExtension type) {
        return ArrayUtils.contains(SUPPORTED_EXTENSIONS, type);
    }

    @Override
    public void showFunctionDescription() {
        for (String line:
                FUNCTIONS_DESCRIPTION) {
            System.out.println(line);
        }
    }

    @Override
    public void doFunction(int functionNum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MusicFileModule.class.getDeclaredMethod(FUNCTIONS_NAMES.get(functionNum));
        method.invoke(this);
    }
}
