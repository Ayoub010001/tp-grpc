package org.example.mediaserver.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.mediaserver.service.VideoService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(5555)
                .addService(new VideoService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
