package com.yet.spring.service;

import com.yet.spring.module.FileModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileModuleService {
    private static List<FileModule> modules;

    @Autowired
    public FileModuleService(List<FileModule> modules) {
        FileModuleService.modules = modules;
    }


}
