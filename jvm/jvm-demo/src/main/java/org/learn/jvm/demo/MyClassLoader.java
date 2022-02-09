package org.learn.jvm.demo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
  * @description TODO
  * @author lbx
  * @date 2022/2/9 10:25
  * @version 1.0.0
 **/
public class MyClassLoader extends ClassLoader {

    private String codePath;

    public MyClassLoader(ClassLoader parent, String codePath) {
        super(parent);
        this.codePath = codePath;
    }

    public MyClassLoader(String codePath) {
        this.codePath = codePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.获取字节码路径
            String fileName = codePath+name+".class";
            // 2.获取输入流
            bis = new BufferedInputStream(new FileInputStream(fileName));
            // 3.获取输出流
            baos = new ByteArrayOutputStream();
            // 4.io读写
            int len;
            byte[] data = new byte[1024];
            while ((len=bis.read(data)) != -1){
                baos.write(data,0,len);
            }
            // 5.获取内存中字节数组
            byte[] byteCode = baos.toByteArray();
            // 6.调用defineClass将字节数组转成class对象
            Class<?> defineClass = defineClass(null,byteCode,0,byteCode.length);
            return defineClass;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader("D:/code_workspaces/java_learn/jvm/jvm-demo/target/classes/org/learn/jvm/demo/");
        Class<?> clazz = classLoader.loadClass("StringPool");
        System.out.println("类加载器是"+clazz.getClassLoader().getClass().getName());
    }
}
