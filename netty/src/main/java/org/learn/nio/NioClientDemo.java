package org.learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author lbx
 * @version 1.0.0
 * @description TODO
 * @date 2022/3/2 13:47
 **/
public class NioClientDemo {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
        socketChannel.write(ByteBuffer.wrap("你好，我是客户端".getBytes(StandardCharsets.UTF_8)));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(byteBuffer);
        System.out.println("服务端消息：" + new String(byteBuffer.array(), 0, read, StandardCharsets.UTF_8));
        socketChannel.close();
    }
}
