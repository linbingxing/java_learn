package org.learn.reactor;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable{

    ServerSocketChannel serverSocketChannel;

    Selector selector;

    public Acceptor(ServerSocketChannel serverSocketChannel, Selector selector) {
        this.serverSocketChannel = serverSocketChannel;
        this.selector = selector;
    }

    @Override
    public void run() {
      try {
          SocketChannel socketChannel = serverSocketChannel.accept();
          socketChannel.configureBlocking(false);
          System.out.println("有客户端连接上来了," + socketChannel.getRemoteAddress());
          SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
          selectionKey.attach(new WorkerHandlerThreadPool(socketChannel));
      }catch (Exception e){

      }
    }
}
