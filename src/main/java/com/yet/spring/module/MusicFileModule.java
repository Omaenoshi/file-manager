package com.yet.spring.module;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
@Lazy
public class MusicFileModule extends FileModule{
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

    private static File file;

    @Autowired
    public MusicFileModule(File file) {
        super(SUPPORTED_EXTENSIONS, FUNCTIONS_DESCRIPTION, FUNCTIONS_NAMES);
        MusicFileModule.file = file;
    }

    private static void displayName() throws InvalidDataException, UnsupportedTagException, IOException {
        Mp3File mp3file = new Mp3File(file);
        if (mp3file.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            System.out.println("Track: " + id3v1Tag.getTrack());
        }
        else {
            System.out.println("Unfortunately the file has no tags.");
        }
    }

    private static void displayDuration() throws InvalidDataException, UnsupportedTagException, IOException {
        Mp3File mp3file = new Mp3File(file);
        System.out.println(mp3file.getLengthInSeconds() + " seconds");
    }

    private static void deleteFile() throws IOException {
        FileUtils.delete(file);
    }
}
