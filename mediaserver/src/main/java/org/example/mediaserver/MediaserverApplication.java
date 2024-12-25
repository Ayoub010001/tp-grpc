package org.example.mediaserver;

import org.example.mediaserver.dao.CreatorEntity;
import org.example.mediaserver.service.CreatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaserverApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {


            // Create a test creator
            CreatorEntity creator = CreatorEntity.builder()
                    .id("creator1")
                    .name("John Doe")
                    .email("john@example.com")
                    .build();

        };
    }
}
