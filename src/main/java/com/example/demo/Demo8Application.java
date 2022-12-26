package com.example.demo;

import com.example.demo.controller.StudentController;
import com.example.demo.service.implement.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Demo8Application  {
    public static void main(String[] args) {
        SpringApplication.run(Demo8Application.class, args);
    }
}
