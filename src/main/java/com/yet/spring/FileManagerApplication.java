package com.yet.spring;

import com.yet.spring.service.FileModuleService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class FileManagerApplication {
    static String fileName;
    static FileModuleService service;

    @Bean
    @Lazy
    public File file() {
        return new File(fileName);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(FileManagerApplication.class);

        fileName = getFileName();
        service = ctx.getBean(FileModuleService.class);
    }

    private static String getFileName() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter file name");
            return sc.nextLine();
        }
    }
}