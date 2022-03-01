package org.learn.nio;

import java.nio.ByteBuffer;

/**
 * @author lbx
 * @version 1.0.0
 * @description TODO
 * @date 2022/3/1 15:40
 **/
public class BufferGetDemo {

    public static void main(String[] args) {
        //1.创建一个指定长度的缓冲区, 以ByteBuffer为例
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put("123".getBytes());
        System.out.print("position=" + byteBuffer.position());
        System.out.print("   limit=" + byteBuffer.limit());
        System.out.print("   capacity=" + byteBuffer.capacity());
        System.out.print("   remaining=" + byteBuffer.remaining());
        System.out.println();

        //切换读模式
        System.out.println("读取数据--------------");
        byteBuffer.flip();
        System.out.println();
        System.out.print("position=" + byteBuffer.position());
        System.out.print("   limit=" + byteBuffer.limit());
        System.out.print("   capacity=" + byteBuffer.capacity());
        System.out.print("   remaining=" + byteBuffer.remaining());
        System.out.println();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println(byteBuffer.get());
        }
        System.out.println();

        //读取指定索引字节
        System.out.println("读取指定索引字节--------------");
        System.out.println(byteBuffer.get(0));

        System.out.println("读取多个字节--------------");
        //重复读取
        byteBuffer.rewind();

        byte[] bytes = new byte[3];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes));

        // 将缓冲区转化字节数组返回
        System.out.println("将缓冲区转化字节数组返回--------------");
        byte[] array = byteBuffer.array();
        System.out.println(new String(array));
        System.out.println();
        System.out.print("position=" + byteBuffer.position());
        System.out.print("   limit=" + byteBuffer.limit());
        System.out.print("   capacity=" + byteBuffer.capacity());
        System.out.print("   remaining=" + byteBuffer.remaining());
        System.out.println();
        // 切换写模式,覆盖之前索引所在位置的值
        System.out.println("写模式--------------");
        byteBuffer.clear();
        System.out.println();
        System.out.print("position=" + byteBuffer.position());
        System.out.print("   limit=" + byteBuffer.limit());
        System.out.print("   capacity=" + byteBuffer.capacity());
        System.out.print("   remaining=" + byteBuffer.remaining());
        System.out.println();
        byteBuffer.put("abc".getBytes());
        System.out.println(new String(byteBuffer.array()));
    }
}
