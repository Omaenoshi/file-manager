package com.yet.spring;

import com.yet.spring.module.FileModule;
import com.yet.spring.module.FileType;
import com.yet.spring.service.FileModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.beans.ConstructorProperties;
import java.io.File;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FileManagerApplication {
    static String path;
    static FileModuleService service;

    @Bean
    @Lazy
    public File file() {
        return new File(path);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(FileManagerApplication.class);
        System.out.println("enter file name");

        Scanner sc = new Scanner(System.in);
        path = sc.nextLine();
        service = ctx.getBean(FileModuleService.class);
    }
}
