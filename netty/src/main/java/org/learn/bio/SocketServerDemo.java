package org.learn.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServerDemo {

    public static void main(String[] args) throws IOException {
        //1.创建一个线程池,如果有客户端连接就创建一个线程, 与之通信
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器已启动");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接");
            //4.开启新的线程处理
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handle(socket);
                }
            });
        }
    }

    public static void handle(Socket socket) {
        try {
            System.out.println("线程ID:" + Thread.currentThread().getId() + " 线程名称:" + Thread.currentThread().getName());
            //从连接中取出输入流来接收消息
            InputStream is = socket.getInputStream();
            byte[] b = new byte[1024];
            int read = is.read(b);
            System.out.println("客户端:" + new String(b, 0, read));
            //连接中取出输出流并回话
            OutputStream os = socket.getOutputStream();
            os.write("Hello,".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭连接
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

