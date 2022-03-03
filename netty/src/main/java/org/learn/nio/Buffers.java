package org.learn.nio;

import java.nio.ByteBuffer;

/**
  * @description TODO
  * @author lbx
  * @date 2022/3/3 9:24
  * @version 1.0.0
 **/
public class Buffers {

    ByteBuffer readBuffer;
    ByteBuffer writeBuffer;

    public Buffers(int readCapacity, int writeCapacity){
        readBuffer = ByteBuffer.allocate(readCapacity);
        writeBuffer = ByteBuffer.allocate(writeCapacity);
    }

    public ByteBuffer getReadBuffer(){
        return readBuffer;
    }

    public ByteBuffer gerWriteBuffer(){
        return writeBuffer;
    }
}
