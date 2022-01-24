package org.learn.jvm.demo;

/**
  * @description
 *
 * -Xss1m
 * -Xss1024k
 * -Xss1048576
 *
  * @author lbx
  * @date 2022/1/24 17:15
  * @version 1.0.0
 **/
public class StackOutMemoryErrorDemo {

    static long count = 0;

    public static void main(String[] args) {
        count ++;

        System.out.println(count);

        main(args);
    }
}
