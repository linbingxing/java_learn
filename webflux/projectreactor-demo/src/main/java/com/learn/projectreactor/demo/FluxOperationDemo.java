package com.learn.projectreactor.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class FluxOperationDemo {

    public static void main(String[] args) {
        //buffer操作符
        Flux.range(1, 10).buffer(5).subscribe(System.out::println);
        System.out.println("=============");
        Flux.range(1, 10).bufferTimeout(2, Duration.ofMillis(1)).subscribe(System.out::println);
    }

    // 判断是否为素数的方法
    private static boolean isPrime(Integer integer) {
        double sqrt = Math.sqrt(integer);
        if (integer < 2) return false;
        if (integer == 2 || integer == 3) return true;
        if (integer % 2 == 0) return false;
        for (int i = 3; i <= sqrt; i++) {
            if (integer % i == 0) return false;
        }
        return true;
    }

    @Test
    public void testWindown() {
        //window操作符
        System.out.println("======window操作符=======");
        Flux.range(1, 5).window(3).toIterable().forEach(w -> {
            w.subscribe(System.out::println);
            System.out.println("-------");
        });

        Flux.range(101, 20).windowUntil(FluxOperationDemo::isPrime, true)
                .subscribe(window -> window.collectList().subscribe(item -> System.out.println("window:" + item)));
    }

    @Test
    public void testMap() {
        Flux.range(1, 10).map(i -> "Number-" + i).subscribe(System.out::println);

    }

    @Test
    public void testFlatMap() {
        Flux.range(1, 10).flatMap(x -> Mono.just(x * x)).subscribe(System.out::println);
    }


    @Test
    public void testFilter() {
        Flux.just(1, 2, 3, 4).filter(t -> t % 2 == 0).subscribe(System.out::println);

        Flux.just(1, 2, 3, 4).filter(t -> t % 2 == 0).takeLast(1).subscribe(System.out::println);
    }

    @Test
    public void takeUntilOther() throws InterruptedException {
        System.out.println("开始");
        Mono<String> start = Mono.just("start").delayElement(Duration.ofSeconds(3));
        Mono<String> stop = Mono.just("stop").delayElement(Duration.ofSeconds(6));
        Flux.interval(Duration.ofMillis(500)).map(item -> "fluxelement" + item)
                .skipUntilOther(start)
                .takeUntilOther(stop)
                .subscribe(System.out::println);
        Thread.sleep(10000);
    }

    @Test
    public void thenAndWhen() {
        Flux.just(1, 2, 3)
                .map(t -> t + 1)
                .then()
                .subscribe(System.out::println);

        Flux.just(1, 2, 3)
                .thenMany(Flux.just(4, 5))
                .subscribe(System.out::println);
    }

    @Test
    public void merge() throws InterruptedException {

        Flux.merge(Flux.range(10, 10)
                .delayElements(Duration.ofMillis(100)), Flux.range(1000, 10)
                .delayElements(Duration.ofMillis(100)))
                .subscribe(System.out::println);
        Thread.sleep(10000);


    }

    @Test
    public void mergeSequential() throws InterruptedException {


        Flux.mergeSequential(Flux.range(10, 10)
                .delayElements(Duration.ofMillis(100)), Flux.range(1000, 10)
                .delayElements(Duration.ofMillis(100)))
                .subscribe(System.out::println);
        Thread.sleep(10000);
    }


    @Test
    public void zip(){
        Flux flux1 = Flux.just(1, 2);
        Flux flux2 = Flux.just(3, 4);
        Flux.zip(flux1, flux2).subscribe(System.out::println);

        Flux.just(5, 6).zipWith(Flux.just(7, 8))
                .subscribe(System.out::println);

        Flux.just(1, 2).zipWith(Flux.just(3, 4), (s1, s2) ->
                String.format("%s+%s=%s", s1, s2, s1 + s2))
                .subscribe(System.out::println);

    }
}
