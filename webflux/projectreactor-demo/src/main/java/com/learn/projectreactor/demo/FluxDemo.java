package com.learn.projectreactor.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class FluxDemo {

    public static void main(String[] args) {

        Flux<String> just = Flux.just("hello", "world");
        just.subscribe(System.out::println);

        Flux<String> stringFlux = Flux.fromArray(new String[]{"hello", "world", "edu", "senior", "junior"});
        stringFlux.subscribe(System.out::println);

        Flux<Integer> integerFlux = Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        integerFlux.subscribe(System.out::println);

        // 第一个参数是起点，第二个参数表示序列中元素的数量
        Flux<Integer> range = Flux.range(2021, 5);
        range.subscribe(System.out::println);

        Flux.interval(Duration.ofSeconds(2), Duration.ofMillis(200)).subscribe(System.out::println);

        Flux.empty().subscribe(System.out::println);

        //通过动态方法创建
        Flux.generate(sink -> {

            sink.next("learn webflux");

            sink.complete();

        }).subscribe(System.out::println);

        Flux.generate(() -> 1, (i, sink) -> {
            sink.next(i);
            if (i == 10) {
                sink.complete();
            }
            return ++i;

        }).subscribe(System.out::println);

        Flux.create(sink -> {
            for (int i = 0; i < 5; i++) {
                sink.next("learn webflux" + i);
            }
            sink.complete();
        }).subscribe(System.out::println);

    }
}
