package org.learn.nio;

import java.nio.ByteBuffer;

/**
  * @description TODO
  * @author lbx
  * @date 2022/3/1 15:40
  * @version 1.0.0
 **/
public class BufferPutDemo {

    public static void main(String[] args) {
        //1.创建一个指定长度的缓冲区, 以ByteBuffer为例
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.print("position="+byteBuffer.position());
        System.out.print("   limit="+byteBuffer.limit());
        System.out.print("   capacity="+byteBuffer.capacity());
        System.out.print("   remaining="+byteBuffer.remaining());
        System.out.println();
        //添加一个字节
        System.out.println("添加一个字节:");
        byteBuffer.put((byte) 97);
        System.out.print("position="+byteBuffer.position());
        System.out.print("   limit="+byteBuffer.limit());
        System.out.print("   capacity="+byteBuffer.capacity());
        System.out.print("   remaining="+byteBuffer.remaining());
        System.out.println();

        //添加一个字节数组
        System.out.println("添加一个字节数组:");
        byteBuffer.put("hello".getBytes());
        System.out.print("position="+byteBuffer.position());
        System.out.print("   limit="+byteBuffer.limit());
        System.out.print("   capacity="+byteBuffer.capacity());
        System.out.print("   remaining="+byteBuffer.remaining());
        System.out.println();

        System.out.println(byteBuffer.get());

        System.out.print("position="+byteBuffer.position());
        System.out.print("   limit="+byteBuffer.limit());
        System.out.print("   capacity="+byteBuffer.capacity());
        System.out.print("   remaining="+byteBuffer.remaining());
        System.out.println();

        //添加一个字节数组
        System.out.println("当添加超过缓冲区的长度时会报错:");
        byteBuffer.put("hello11222222".getBytes());
        System.out.print("position="+byteBuffer.position());
        System.out.print("   limit="+byteBuffer.limit());
        System.out.print("   capacity="+byteBuffer.capacity());
        System.out.print("   remaining="+byteBuffer.remaining());
        System.out.println();
    }
}
