package com.yet.spring.service;

import com.yet.spring.module.FileModule;
import com.yet.spring.module.FileExtension;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@Lazy
public class FileModuleService {
    private final List<FileModule> modules;
    private final File file;
    public FileModule currentModule;

    @Autowired
    public FileModuleService(List<FileModule> modules, File file) {
        this.modules = modules;
        this.file = file;
        currentModule = getCurrentModule();
    }

    public FileModule getCurrentModule() {
        FileExtension extension = getExtension();
        for (FileModule module:
             modules) {
            if (module.doesSupport(extension)) {
                return module;
            }
        }

        throw new IllegalArgumentException("Extension does not supported!");
    }

    private FileExtension getExtension() {
        String extension = FilenameUtils.getExtension(file.getPath());
        return FileExtension.valueOf(extension.toUpperCase());
    }


}
