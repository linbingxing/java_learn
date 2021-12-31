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
    public void zip() {
        Flux flux1 = Flux.just(1, 2);
        Flux flux2 = Flux.just(3, 4);
        Flux.zip(flux1, flux2).subscribe(System.out::println);

        Flux.just(5, 6).zipWith(Flux.just(7, 8))
                .subscribe(System.out::println);

        Flux.just(1, 2).zipWith(Flux.just(3, 4), (s1, s2) ->
                String.format("%s+%s=%s", s1, s2, s1 + s2))
                .subscribe(System.out::println);

    }

    @Test
    public void defaultIfEmpty() {
        Flux.just(null).defaultIfEmpty(33).subscribe(System.out::println);
    }

    @Test
    public void takeUntil() {
        Flux.range(1, 100).takeUntil(i -> i == 10).subscribe(System.out::println);
        System.out.println("takeWhile");
        Flux.range(1, 100).takeWhile(i -> i <= 10)
                .subscribe(System.out::println);
        System.out.println("bufferUntil");
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0)
                .subscribe(System.out::println);
        System.out.println("bufferWhile");
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0)
                .subscribe(System.out::println);
    }

    @Test
    public void skipUntil() {
        Flux.range(1, 100).skipUntil(i -> i == 10).subscribe(System.out::println);
        System.out.println("skipWhile");
        Flux.range(1, 100).skipWhile(i -> i < 10).subscribe(System.out::println);
    }

    @Test
    public void any() {
        Flux.just(3, 5, 7, 9, 11, 15, 16, 17)
                .any(e -> e % 2 == 0)
                .subscribe(isExisted -> System.out.println(isExisted));

        Flux.just("abc", "ela", "ade", "pqa", "kang")
                .all(a -> a.contains("a"))
                .subscribe(isAllContained -> System.out.println(isAllContained));

    }

    @Test
    public void concat() {
        Flux.concat(
                Flux.range(1, 3),
                Flux.range(4, 2),
                Flux.range(6, 5)
        ).subscribe(System.out::println);
    }

    @Test
    public void reduce() {
        Flux.range(1, 10).reduce((x, y) -> x + y)
                .subscribe(System.out::println);
    }

    @Test
    public void reduceWith() {
        Flux.range(1, 10).reduceWith(() -> 5, (x, y) -> x + y)
                .subscribe(System.out::println);

    }

    @Test
    public void log() {
        Flux.just(1, 2).log().subscribe(System.out::println);
    }

    @Test
    public void debug() {
        Mono.just(0).map(x -> 1 / x)
                .checkpoint("debug").subscribe(System.out::println);
    }

    @Test
    public void test() {
        // range操作符创建从[1到100]的整数序列
        Flux.range(1, 100)
                // repeat操作符在源流完成之后一次又一次地订阅源响应式流。
                // repeat操作符订阅流操作符的结果、接收从1到100的元素以及onComplete信号，
                // 然后再次订阅、接收，不断重复该过程
                .repeat().
                // 使用collectList操作符尝试将所有生成的元素收集到一个集合中。
                // 由于是无限流，最终它会消耗所有内存，导致OOM。
                collectList().
                // block操作符触发实际订阅并阻塞正在运行的线程，直到最终结果到达
                // 当前场景不会发生，因为响应流是无限的。
                block();
    }

}
