package org.example.mediaserver.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.mediaserver.dao.CreatorEntity;
import org.example.mediaserver.mappers.CreatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.xproce.lab.Creator;
import org.xproce.lab.CreatorIdRequest;
import org.xproce.lab.CreatorServiceGrpc;
import org.xproce.lab.VideoStream;

import java.util.ArrayList;
import java.util.List;


@GrpcService
public class CreatorService extends CreatorServiceGrpc.CreatorServiceImplBase {

    public static List<CreatorEntity> listCreators = new ArrayList<>();

    @Autowired
    private CreatorMapper creatorMapper;


    @Override
    public void getCreator(CreatorIdRequest request, StreamObserver<Creator> responseObserver) {
        CreatorEntity creatorEntity = listCreators.stream()
                .filter(creator -> creator.getId().equals(request.getId()))
                .findFirst()
                .orElseThrow(() -> Status.NOT_FOUND
                        .withDescription("Creator not found with id: " + request.getId())
                        .asRuntimeException());

        Creator creator = creatorMapper.toCreatorProto(creatorEntity);
        responseObserver.onNext(creator);
        responseObserver.onCompleted();
    }

    @Override
    public void getCreatorVideos(CreatorIdRequest request, StreamObserver<VideoStream> responseObserver) {
        super.getCreatorVideos(request, responseObserver);
    }
}
