package com.yet.spring;

import com.yet.spring.service.FileModuleService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

@SpringBootApplication
public class FileManagerApplication {
    private static String fileName;

    @Bean
    @Lazy
    public File file() {
        return new File(fileName);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(FileManagerApplication.class);

        fileName = getFileName();
        FileModuleService service = ctx.getBean(FileModuleService.class);
        service.showFunctions();
    }

    private static String getFileName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name");
        return sc.nextLine();
    }
}