package org.example.mediaserver.mappers;

import org.example.mediaserver.dao.CreatorEntity;
import org.springframework.stereotype.Component;
import org.xproce.lab.Creator;

@Component
public class CreatorMapper {
    public CreatorEntity toCreatorEntity(Creator creator) {
        return CreatorEntity.builder()
                .id(creator.getId())
                .name(creator.getName())
                .email(creator.getEmail())
                .build();
    }

    public Creator toCreatorProto(CreatorEntity entity) {
        return Creator.newBuilder()
                .setId(entity.getId())
                .setName(entity.getName())
                .setEmail(entity.getEmail())
                .build();
    }
}
