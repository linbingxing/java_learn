package org.learn.nio;

import java.nio.ByteBuffer;

/**
  * @description TODO
  * @author lbx
  * @date 2022/3/1 14:58
  * @version 1.0.0
 **/
public class BufferDemo {

    public static void main(String[] args) {
        //1.创建一个指定长度的缓冲区, 以ByteBuffer为例
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        for (int i = 0;i< 5;i++){
            System.out.println(byteBuffer.get());
        }
        //2.创建一个有内容的缓冲区
        ByteBuffer wap = ByteBuffer.wrap("learn".getBytes());
        for (int i = 0;i < 5;i++){
            System.out.println(wap.get());
        }
    }
}
