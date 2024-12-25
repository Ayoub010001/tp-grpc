package org.example.mediaclient.controller;

import org.example.mediaclient.dto.VideoDTO;
import org.example.mediaclient.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xproce.lab.Creator;
import org.xproce.lab.UploadVideoRequest;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping("/upload")
    public VideoDTO uploadVideo() {
        Creator creator = Creator.newBuilder()
                .setName("Ghostfriek")
                .setEmail("email@email.com")
                .setId("1b66")
                .build();

        UploadVideoRequest request = UploadVideoRequest.newBuilder()
                .setTitle("Test Video")
                .setDescription("A test video description")
                .setUrl("url")
                .setDurationSeconds(100)
                .setCreator(creator)
                .build();

        return videoService.uploadVideo(request);
    }
    @GetMapping("/{id}")
    public VideoDTO getVideo(@PathVariable String id) {
        return videoService.getVideo(id);
    }
}
