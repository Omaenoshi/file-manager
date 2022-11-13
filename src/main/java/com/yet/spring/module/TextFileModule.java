package com.yet.spring.module;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
@Lazy
public class TextFileModule implements FileModule {
    private static final FileExtension[] SUPPORTED_TYPES = {FileExtension.TXT};
    private static final String[] FUNCTIONS_DESCRIPTION = {
            "1. Counting and displaying the number of lines.",
            "2. Output the frequency of occurrence of each character.",
            "3. Delete file."
    };
    private static final Map<Integer, String> FUNCTIONS_NAMES = new HashMap<>(); static {
        FUNCTIONS_NAMES.put(1, "countNumberOfLines");
        FUNCTIONS_NAMES.put(2, "countFrequencyOfChar");
        FUNCTIONS_NAMES.put(3, "deleteFile");
    }

    private final File file;
    @Autowired
    public TextFileModule(File file) {
        this.file = file;
    }

    @Override
    public boolean doesSupport(FileExtension type) {
        return ArrayUtils.contains(SUPPORTED_TYPES, type);
    }

    @Override
    public void showFunctionDescription() {
        for (String line:
             FUNCTIONS_DESCRIPTION) {
            System.out.println(line);
        }
    }

    private void deleteFile() throws IOException {
        FileUtils.delete(file);
        System.out.println("File deleted successfully");
    }

    private void countNumberOfLines() throws IOException {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.readLine() != null)
                count++;
        }
        System.out.println("Number of lines is " + count);
    }

    private void countFrequencyOfChar() throws IOException {
        Map<Character, Integer> result = new TreeMap<>();

        int c;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while((c = br.read()) != -1) {
                if (!Character.isLetter(c)) continue;
                if(!result.containsKey((char)c)) {
                    result.put((char)c, 1);
                } else {
                    int number = result.get((char)c);
                    result.put((char)c, number + 1);
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("File is empty");
            return;
        }
        for(Map.Entry<Character, Integer> pair : result.entrySet())
            System.out.println(pair.getKey() + ": " + pair.getValue());
    }

    @Override
    public void doFunction(int functionNum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = TextFileModule.class.getDeclaredMethod(FUNCTIONS_NAMES.get(functionNum));
        method.invoke(this);
    }
}
