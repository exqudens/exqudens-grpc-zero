package exqudens.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloServer {

    public static void main(String... args) {
        try {

            Server server = ServerBuilder
            .forPort(8080)
            .addService(new HelloServiceImpl())
            .build();

            server.start();
            server.awaitTermination();

        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
