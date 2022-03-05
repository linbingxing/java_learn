package org.learn.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerHandlerThreadPool implements Runnable {
    static ExecutorService pool = Executors.newFixedThreadPool(2);

    private SocketChannel socketChannel;

    public WorkerHandlerThreadPool(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            System.out.println("WorkerHandlerThreadPool thread :" + Thread.currentThread().getName());
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            pool.execute(new Process(socketChannel, buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
