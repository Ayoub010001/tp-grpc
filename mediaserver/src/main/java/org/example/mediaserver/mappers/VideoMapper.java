package org.example.mediaserver.mappers;

import org.example.mediaserver.dao.CreatorEntity;
import org.example.mediaserver.dao.VideoEntity;
import org.springframework.stereotype.Component;
import org.xproce.lab.Creator;
import org.xproce.lab.UploadVideoRequest;
import org.xproce.lab.Video;

import java.util.UUID;
@Component
public class VideoMapper {

    private CreatorMapper creatorMapper;

    public VideoMapper(CreatorMapper creatorMapper) {
        this.creatorMapper = creatorMapper;
    }

    public VideoEntity toVideoEntity(UploadVideoRequest request) {
        CreatorEntity creatorEntity  = creatorMapper.toCreatorEntity(request.getCreator());

        return VideoEntity.builder()
                .id(UUID.randomUUID().toString())
                .title(request.getTitle())
                .description(request.getDescription())
                .url(request.getUrl())
                .durationSeconds(request.getDurationSeconds())
                .creator(creatorEntity)
                .build();
    }

    public Video toVideoProto(VideoEntity entity) {
        Creator creator = creatorMapper.toCreatorProto(entity.getCreator());
        return Video.newBuilder()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setDescription(entity.getDescription())
                .setUrl(entity.getUrl())
                .setDurationSeconds(entity.getDurationSeconds())
                .setCreator(creator)
                .build();
    }
}
