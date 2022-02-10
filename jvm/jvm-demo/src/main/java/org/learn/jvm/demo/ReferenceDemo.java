package org.learn.jvm.demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
  * @description TODO
  * @author lbx
  * @date 2022/2/10 9:29
  * @version 1.0.0
 **/
public class ReferenceDemo {


    public static void main(String[] args) throws InterruptedException {
       // softRefMemoryEnough();

      //  softRefMemoryNotEnough();

     //   weakRefMemoryEnough();

        PhantomReferenceTest();
    }

    public static void softRefMemoryEnough(){
        Object obj = new Object();

        SoftReference<Object> softReference = new SoftReference<>(obj);

        System.out.println(obj);
        System.out.println(softReference.get());

        //将对象置空，在内存够用的情况下，按理来说softReference对象是不会被回收的
        obj = null;
        System.gc();
        System.out.println(obj);
        System.out.println(softReference.get());
    }

    public static void softRefMemoryNotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        try {
            byte[] bytes = new byte[85 * 1024 * 1024];
        } catch (Throwable e) {
           // e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    public static void weakRefMemoryEnough() {
        Object o1 = new Object();
        //弱引用对象
        WeakReference<Object> weakReference = new WeakReference(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(weakReference.get());
    }

    public static void PhantomReferenceTest() throws InterruptedException {
        Object o1 = new Object();
        //开启一个引用队列
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        //虚引用必须和引用队列一起使用
        PhantomReference<Object> reference = new PhantomReference<>(o1, queue);

        System.out.println(o1);
        System.out.println(reference.get());
        //还未回收之前，引用队列是空的
        System.out.println(queue.poll());

        System.out.println("================");
        o1 = null;

        System.gc();
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(reference.get());
        //回收之后，回收的对象到了引用队列里
        System.out.println(queue.poll());
    }
}
