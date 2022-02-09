package org.learn.jvm.demo;

/**
  * @description TODO
  * @author lbx
  * @date 2022/2/9 9:44
  * @version 1.0.0
 **/
public class ClassLoaderTest {

    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器，扩展加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        //获取扩展加载器的上层启动类加载器，这里会获取不到
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        //获取用户自定义类的加载器
        ClassLoader appClassLoder = ClassLoaderTest.class.getClassLoader();
        System.out.println(appClassLoder);

        //获取核心类库使用的启动类加载器
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);
    }
}
