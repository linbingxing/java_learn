package com.learn.projectreactor.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxTest {


    public static void main(String[] args) {
        Flux<String> helloWorld = Flux.just("Hello", "World");
        StepVerifier.create(helloWorld)
                .expectNext("Hello")
                .expectNext("World")
                .expectComplete()
                .verify();
    }

    @Test
    public void testExpectNextMatches() {
        StepVerifier
                .create(Flux.just("jian-hu", "xiang-hu"))
                .expectSubscription()
                .expectNextMatches(e -> e.startsWith("jian"))
                .expectNextMatches(e -> e.startsWith("xiang"))
                .expectComplete()
                .verify();
    }

    @Test
    public void testAssertNext() {

        StepVerifier.create(Flux.just(1, 2, 3))
                .expectSubscription()
                .assertNext(t -> t.equals(1))
                .expectComplete()
                .verify();


    }

    @Test
    public void testStepVerifierWithError() {
        Flux<String> helloWorld = Flux.just("Hello", "World");
        Flux<String> helloWorldWithException = helloWorld.concatWith(Mono.error(new IllegalArgumentException("exception")));
        StepVerifier.create(helloWorldWithException)
                .expectNext("Hello")
                .expectNext("World")
                .expectErrorMessage("exception")
                .verify();

    }

}
