package org.example.mediaclient.mapper;

import org.example.mediaclient.dto.CreatorDTO;
import org.springframework.stereotype.Component;
import org.xproce.lab.Creator;

@Component
public class CreatorMapper {
    public CreatorDTO toDto(Creator creator) {
        CreatorDTO dto = new CreatorDTO();
        dto.setName(creator.getName());
        dto.setEmail(creator.getEmail());
        dto.setId(creator.getId());
        return dto;
    }
}
