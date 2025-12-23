package com.example.api;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeApiApplication {
    public static void main(String[] args) {
        // Load .env file
        Dotenv.configure().ignoreIfMissing().load();
        SpringApplication.run(RecipeApiApplication.class, args);
    }
}