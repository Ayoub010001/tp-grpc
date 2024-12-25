package org.example.mediaclient.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.mediaclient.dto.VideoDTO;
import org.example.mediaclient.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.lab.UploadVideoRequest;
import org.xproce.lab.Video;
import org.xproce.lab.VideoIdRequest;
import org.xproce.lab.VideoServiceGrpc;
@Service
public class VideoService {
    @GrpcClient("mediaserver")
    private VideoServiceGrpc.VideoServiceBlockingStub stub;

    @Autowired
    private VideoMapper videoMapper;

    public VideoDTO uploadVideo(UploadVideoRequest videoRequest) {
        Video video = stub.uploadVideo(videoRequest);
        return videoMapper.toVideoDTO(video);
    }
    public VideoDTO getVideo(String id) {
        VideoIdRequest request = VideoIdRequest.newBuilder().setId(id).build();
        Video video = stub.getVideo(request);
        return videoMapper.toVideoDTO(video);
    }
}
