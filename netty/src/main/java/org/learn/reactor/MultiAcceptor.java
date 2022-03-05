package org.learn.reactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MultiAcceptor implements Runnable {

    private ServerSocketChannel serverSocketChannel;
    private final int core = 8;
    private int index;
    private SubReactor[] subReactors = new SubReactor[core];
    private Thread[] threads = new Thread[core];
    private final Selector[] selectors = new Selector[core];

    public MultiAcceptor(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
        for (int i = 0; i < core; i++) {
            try {
                selectors[i] = Selector.open();
            } catch (IOException e) {
                e.printStackTrace();
            }
            subReactors[i] = new SubReactor(selectors[i]);
            threads[i] = new Thread(subReactors[i]);
            threads[i].start();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("acceptor thread:" + Thread.currentThread().getName());

            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("有客户端连接上来了," + socketChannel.getRemoteAddress());
            socketChannel.configureBlocking(false);
            selectors[index].wakeup();
            SelectionKey selectionKey = socketChannel.register(selectors[index], SelectionKey.OP_READ);
            selectionKey.attach(new WorkHandler(socketChannel));
            if (++index == threads.length) {
                index = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
