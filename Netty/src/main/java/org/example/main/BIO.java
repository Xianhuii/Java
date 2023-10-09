package org.example.main;

import java.io.*;
import java.net.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class BIO {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        int port = 8080;
        CompletableFuture<Void> server = CompletableFuture.runAsync(() -> {
            try {
                server(8080);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Thread.sleep(3000);
        CompletableFuture<Void> client = CompletableFuture.runAsync(() -> {
            try {
                client(port);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        client.get();
    }

    public static void server(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        System.out.println(clientSocket.getPort());
        try (InputStream inputStream = clientSocket.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader);
             OutputStream outputStream = clientSocket.getOutputStream();
             PrintWriter printWriter = new PrintWriter(outputStream)) {
            String request, resposne;
            while ((request = reader.readLine()) != null) {
                System.out.println(request);
                if ("Done".contains(request)) {
                    break;
                }
                resposne = request;
                printWriter.println(resposne);
            }
        }
    }

    public static void client(int port) throws IOException {
        Socket client = new Socket();
        SocketAddress serverAddress = new InetSocketAddress(port);
        client.connect(serverAddress);
        try (PrintWriter printWriter = new PrintWriter(client.getOutputStream());) {
            printWriter.println("request");
            printWriter.println("1");
            printWriter.println("2");
            printWriter.println("3");
            printWriter.println("4");
            printWriter.println("Done");
        }
        client.close();
    }
}
