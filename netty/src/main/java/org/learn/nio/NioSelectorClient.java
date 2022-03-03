package org.learn.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
  * @description TODO
  * @author lbx
  * @date 2022/3/3 9:05
  * @version 1.0.0
 **/
public class NioSelectorClient {

    static class  Client extends Thread{
        private String name;

        private Random random = new Random(7);

        Client(String name){
            this.name = name;
        }

        @Override
        public void run() {
            try {
                SocketChannel channel = SocketChannel.open();
                channel.configureBlocking(false);
                channel.connect(new InetSocketAddress("127.0.0.1",9999));
                while (!channel.finishConnect()){
                    Thread.sleep(1000);
                }
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                for (int i = 0;i<5;i++){
                    TimeUnit.MILLISECONDS.sleep(100 * random.nextInt(10));
                    String str = "Message from " + name + ", number:" + i;
                    byteBuffer.put(str.getBytes());
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        channel.write(byteBuffer);
                    }
                    byteBuffer.clear();
                }
                int read = channel.read(byteBuffer);
                System.out.println("服务端消息：" + new String(byteBuffer.array(), 0, read, StandardCharsets.UTF_8));
                channel.close();
                channel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Client("Client-1"));
        executorService.submit(new Client("Client-2"));
        executorService.submit(new Client("Client-3"));
        executorService.shutdown();
//        new Client("Client-3").start();
    }
}
