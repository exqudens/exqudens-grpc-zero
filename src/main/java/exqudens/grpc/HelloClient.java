package exqudens.grpc;

import generated.exqudens.grpc.HelloRequest;
import generated.exqudens.grpc.HelloResponse;
import generated.exqudens.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {

    public static void main(String... args) {
        try {
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("localhost", 8080)
                    .usePlaintext()
                    .build();

            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            HelloResponse response = stub.hello(HelloRequest.newBuilder().setFirstName("AAA").build());
            System.out.println(response);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

}
