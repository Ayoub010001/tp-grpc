
package org.example.mediaserver.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.mediaserver.dao.VideoEntity;
import org.example.mediaserver.mappers.CreatorMapper;
import org.example.mediaserver.mappers.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.xproce.lab.*;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class VideoService extends VideoServiceGrpc.VideoServiceImplBase {

    public List<VideoEntity> listVideos = new ArrayList<>();

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public void uploadVideo(UploadVideoRequest request, StreamObserver<Video>
            responseObserver) {
        VideoEntity videoEntity = videoMapper.toVideoEntity(request);
        Video video = videoMapper.toVideoProto(videoEntity);
        // Send the response
        listVideos.add(videoEntity);
        responseObserver.onNext(video);
        responseObserver.onCompleted();
    }

    @Override
    public void getVideo(VideoIdRequest request, StreamObserver<Video> responseObserver) {

        VideoEntity videoEntity = listVideos.stream()
                .filter(video -> video.getId().equals(request.getId()))
                .findFirst()
                .orElseThrow(() -> Status.NOT_FOUND
                        .withDescription("Video not found with id: " + request.getId())
                        .asRuntimeException());

        responseObserver.onNext(videoMapper.toVideoProto(videoEntity));
        responseObserver.onCompleted();
    }
}
