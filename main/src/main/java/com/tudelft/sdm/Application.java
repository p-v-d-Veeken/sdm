package com.tudelft.sdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
@ComponentScan("com.tudelft.sdm")
public class Application {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
