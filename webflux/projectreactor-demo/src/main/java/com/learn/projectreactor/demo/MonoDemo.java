package com.learn.projectreactor.demo;

import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class MonoDemo {

    public static void main(String[] args) {
        Mono<String> just = Mono.just("hello");
        just.subscribe(System.out::println);

        Mono.justOrEmpty(Optional.of("hello"))
                .subscribe(System.out::println);

        Mono<Object> objectMono = Mono.justOrEmpty(null);
        objectMono.subscribe(System.out::println);

        // 避免空指针异常，返回不包含任何值的Optional对象。
        Mono<Object> objectMono1 = Mono.justOrEmpty(Optional.empty());
        objectMono1.subscribe(System.out::println);

        //动态创建
        Mono.create(sink ->
                sink.success("jianxiang")).subscribe(System.out::println);


    }
}
