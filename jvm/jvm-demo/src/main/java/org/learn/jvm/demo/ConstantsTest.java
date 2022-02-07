package org.learn.jvm.demo;

/**
  * @description TODO
  * @author lbx
  * @date 2022/2/7 11:10
  * @version 1.0.0
 **/
public class ConstantsTest {

    public String name = "Hello World";
    public final int num = 100;

    public ConstantsTest(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println(name);
        System.out.println(num);
    }
}
