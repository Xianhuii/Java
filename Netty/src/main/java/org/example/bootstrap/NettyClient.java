package org.example.bootstrap;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.example.handler.FirstClientHandler;

import java.util.List;

public class NettyClient {
    private String host;
    private int port;
    private List<? extends ChannelHandler> channelHandlers;

    public NettyClient(String host, int port, List<? extends ChannelHandler> channelHandlers) {
        this.host = host;
        this.port = port;
        this.channelHandlers = channelHandlers;
    }

    public void run() {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        channelHandlers.forEach(handler -> {
                            ch.pipeline().addLast(handler);
                        });
                    }
                });
        bootstrap
                .connect(host, port)
                .addListener(future -> {
                    if (future.isSuccess()) {
                        System.out.println("连接成功");
                    } else {
                        System.out.println("连接失败");
                    }
                });
    }
}
