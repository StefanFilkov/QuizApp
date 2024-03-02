package com.example.quizproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = "com.example.quizproject.db.entities")
@EnableJpaRepositories(basePackages = "com.example.quizproject.db.repositories")
public class QuizProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizProjectApplication.class, args);

    }

}
