package org.example.mediaserver.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VideoEntity {
    //@Id
    private String id;
    private String title;
    private String description;
    private String url;
    private int durationSeconds;

    //@ManyToOne
    //@JoinColumn(name = "creator_id")
    private CreatorEntity creator;
}
