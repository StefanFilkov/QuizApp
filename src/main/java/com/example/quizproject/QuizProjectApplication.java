package com.example.quizproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QuizProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizProjectApplication.class, args);
    }

    @GetMapping("/hello")
    public String HelloWorld(@RequestParam(value = "am", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
