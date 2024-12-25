package org.example.mediaclient.controller;

import org.example.mediaclient.dto.CreatorDTO;
import org.example.mediaclient.dto.VideoDTO;
import org.example.mediaclient.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creators")
public class CreatorController {
    @Autowired
    private CreatorService creatorService;

    @GetMapping("/{id}")
    public CreatorDTO getCreator(@PathVariable String id) {
        return creatorService.getCreator(id);
    }

    @GetMapping("/{id}/videos")
    public List<VideoDTO> getCreatorVideos(@PathVariable String id) {
        return creatorService.getCreatorVideos(id);
    }
}
