package org.example.mediaclient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VideoDTO {
    private String id;
    private String title;
    private String description;
    private String url;
    private int durationSeconds;
}
