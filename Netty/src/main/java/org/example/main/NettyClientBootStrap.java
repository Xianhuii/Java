package org.example.main;

import org.example.bootstrap.NettyClient;
import org.example.handler.FirstClientHandler;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NettyClientBootStrap {
    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient(
                "127.0.0.1",
                8080,
                Stream.of(new FirstClientHandler()).collect(Collectors.toList()));
        nettyClient.run();
    }
}
