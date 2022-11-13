package com.yet.spring.service;

import com.yet.spring.module.FileModule;
import com.yet.spring.module.FileType;
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
        FileType type = getType();
        for (FileModule module:
             modules) {
            if (module.doesSupport(type)) {
                return module;
            }
        }

        throw new IllegalArgumentException("Extension does not supported!");
    }

    private FileType getType() {
        String extension = FilenameUtils.getExtension(file.getPath());
        return FileType.valueOf(extension.toUpperCase());
    }


}
