package com.yet.spring.module;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
@Lazy
@Scope("prototype")
public class ImageFileModule extends FileModule{
    private static final FileExtension[] SUPPORTED_EXTENSIONS = {FileExtension.JPG, FileExtension.PNG};
    private static final String[] FUNCTIONS_DESCRIPTION = {
            "1. Display image size.",
            "2. Display exif information.",
            "3. Delete file."
    };
    private static final Map<Integer, String> FUNCTIONS_NAMES = new HashMap<>(); static {
        FUNCTIONS_NAMES.put(1, "displaySize");
        FUNCTIONS_NAMES.put(2, "displayExif");
        FUNCTIONS_NAMES.put(3, "deleteFile");
    }
    private static File file;

    @Autowired
    public ImageFileModule(File file) {
        super(SUPPORTED_EXTENSIONS, FUNCTIONS_DESCRIPTION, FUNCTIONS_NAMES);
        ImageFileModule.file = file;
    }

    private static void displaySize() {
        long size = FileUtils.sizeOf(file);
        System.out.println("File size is " + size + " bytes.");
    }

    private static void displayExif() throws ImageProcessingException, IOException {
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        for (Directory directory : metadata.getDirectories()) {
            for (Tag allTags : directory.getTags()) {

                System.out.println(allTags);
            }
        }
    }

    private static void deleteFile() throws IOException {
        FileUtils.delete(file);
    }

}
