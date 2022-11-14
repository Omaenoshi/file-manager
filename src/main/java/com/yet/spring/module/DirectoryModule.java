package com.yet.spring.module;

import jdk.jfr.Category;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Lazy
public class DirectoryModule extends FileModule{

    private static final FileExtension[] SUPPORTED_EXTENSIONS = {FileExtension.DIRECTORY};
    private static final String[] FUNCTIONS_DESCRIPTION = {
            "1. List files in a directory.",
            "2. Count the size of all files in a directory.",
            "3. Delete file."
    };
    private static File file;
    private static final Map<Integer, String> FUNCTIONS_NAMES = new HashMap<>(); static {
        FUNCTIONS_NAMES.put(1, "listFiles");
        FUNCTIONS_NAMES.put(2, "countSize");
        FUNCTIONS_NAMES.put(3, "deleteFile");
    }
    @Autowired
    protected DirectoryModule(File file) {
        super(SUPPORTED_EXTENSIONS, FUNCTIONS_DESCRIPTION, FUNCTIONS_NAMES);
        DirectoryModule.file = file;
    }

    private static void listFiles() {
        List<File> files = (List<File>) FileUtils.listFiles(file, null, true);
        files.forEach(System.out::println);
    }

    private static void countSize() {
        long size = FileUtils.sizeOfDirectory(file);
        System.out.println("Size is " + size + " bytes");
    }

    private static void deleteFile() throws IOException {
        FileUtils.delete(file);
    }
}
