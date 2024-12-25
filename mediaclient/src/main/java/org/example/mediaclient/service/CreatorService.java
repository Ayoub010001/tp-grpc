package org.example.mediaclient.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.mediaclient.dto.CreatorDTO;
import org.example.mediaclient.dto.VideoDTO;
import org.example.mediaclient.mapper.CreatorMapper;
import org.example.mediaclient.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.lab.CreatorIdRequest;
import org.xproce.lab.CreatorServiceGrpc;
import org.xproce.lab.VideoStream;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreatorService {
    @GrpcClient("mediaserver")
    private CreatorServiceGrpc.CreatorServiceBlockingStub stub;

    @Autowired
    private CreatorMapper creatorMapper;

    @Autowired
    private VideoMapper videoMapper;

    public CreatorDTO getCreator(String id) {
        CreatorIdRequest request = CreatorIdRequest.newBuilder().setId(id).build();
        return creatorMapper.toDto(stub.getCreator(request));
    }

    public List<VideoDTO> getCreatorVideos(String creatorId) {
        CreatorIdRequest request = CreatorIdRequest.newBuilder().setId(creatorId).build();
        VideoStream videoStream = stub.getCreatorVideos(request);
        return videoStream.getVideosList()
                .stream()
                .map(videoMapper::toVideoDTO)
                .collect(Collectors.toList());
    }
}
