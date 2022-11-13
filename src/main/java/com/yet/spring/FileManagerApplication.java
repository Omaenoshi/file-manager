package com.yet.spring;

import com.yet.spring.module.FileModule;
import com.yet.spring.module.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FileManagerApplication {
    static List<FileModule> modules;

    @Autowired
    public FileManagerApplication(List<FileModule> modules) {
        FileManagerApplication.modules = modules;
    }



    public static void main(String[] args) {
        SpringApplication.run(FileManagerApplication.class, args);
        FileType type = FileType.valueOf("txt".toUpperCase());
        System.out.println(type);
    }
}
