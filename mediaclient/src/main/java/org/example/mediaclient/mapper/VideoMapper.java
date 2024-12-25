package org.example.mediaclient.mapper;

import org.example.mediaclient.dto.VideoDTO;
import org.springframework.stereotype.Component;
import org.xproce.lab.Video;

@Component
public class VideoMapper {
    public VideoDTO toVideoDTO(Video video) {
        VideoDTO videoDTO = new VideoDTO();
        videoDTO.setId(video.getId());
        videoDTO.setTitle(video.getTitle());
        videoDTO.setDescription(video.getDescription());
        videoDTO.setUrl(video.getUrl());
        videoDTO.setDurationSeconds(video.getDurationSeconds());
        return videoDTO;
    }
}
