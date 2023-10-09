package org.example.main;

import io.netty.channel.ChannelHandler;
import org.example.bootstrap.NettyServer;
import org.example.handler.FirstServerHandler;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NettyServerBootStrap {
    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer(
                8080,
                Stream.of(new FirstServerHandler()).collect(Collectors.toList()));
        nettyServer.run();
    }
}
