package org.learn.jvm.demo;

/**
  * @description TODO
  * @author lbx
  * @date 2022/2/7 12:52
  * @version 1.0.0
 **/
public class StringPool {
    public static void main(String[] args) {
        String i = "hello";
        String j = "World";
        String k = "hello" + "World";

        String l = new String("hello");

        System.out.println(i==l);
    }
}
