package org.learn.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable {

    ServerSocketChannel serverSocketChannel;

    Selector selector;

    public Reactor(int port) {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            // 并且在selectionKey对象附加了一个Acceptor对象，这是用来处理连接请求的类
//            selectionKey.attach(new Acceptor(serverSocketChannel,selector));
            selectionKey.attach(new MultiAcceptor(serverSocketChannel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
      while (true){
          try {
              selector.select();
              Set<SelectionKey> selectionKeySet = selector.selectedKeys();
              Iterator<SelectionKey> iterator = selectionKeySet.iterator();
              while (iterator.hasNext()){
                  SelectionKey selectionKey = iterator.next();
                  dispatcher(selectionKey);
                  iterator.remove();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }

      }
    }

    private void dispatcher(SelectionKey selectionKey){
        Runnable runnable = (Runnable) selectionKey.attachment();
        runnable.run();
    }

    public static void main(String[] args) {
        Reactor reactor = new Reactor(9090);
        reactor.run();
    }
}
