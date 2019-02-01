package exqudens.grpc;

import generated.exqudens.grpc.HelloRequest;
import generated.exqudens.grpc.HelloResponse;
import generated.exqudens.grpc.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
        .append("Hello, ")
        .append(request.getFirstName())
        .append(" ")
        .append(request.getLastName())
        .toString();

        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
