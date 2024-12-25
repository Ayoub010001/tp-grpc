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
public class CreatorEntity {
    //@Id
    private String id;
    private String name;
    private String email;
}
