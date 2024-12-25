package org.example.mediaserver;

import org.example.mediaserver.dao.CreatorEntity;
import org.example.mediaserver.dao.VideoEntity;
import org.example.mediaserver.service.CreatorService;
import org.example.mediaserver.service.VideoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MediaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaserverApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CreatorService creatorService, VideoService videoService) {
        return args -> {
            // First add a creator
            CreatorEntity creator = CreatorEntity.builder()
                    .id("creator1")
                    .name("John Doe")
                    .email("john@example.com")
                    .build();
            creatorService.listCreators.add(creator);

            // Then add a video in VideoService
            VideoEntity video = VideoEntity.builder()
                    .id("video1")
                    .title("Test Video")
                    .description("Test Description")
                    .url("https://example.com")
                    .durationSeconds(100)
                    .creator(creator)
                    .build();
            videoService.listVideos.add(video);
            VideoEntity video2 = VideoEntity.builder()
                    .id("video2")
                    .title("Test Video")
                    .description("Test Description")
                    .url("https://example.com")
                    .durationSeconds(100)
                    .creator(creator)
                    .build();
            videoService.listVideos.add(video2);
        };
    }
}
