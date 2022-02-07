package org.learn.jvm.demob;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
  * @description TODO
  * @author lbx
  * @date 2022/2/7 16:16
  * @version 1.0.0
 **/
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
