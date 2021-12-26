package com.learn.projectreactor.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;

public class FluxDemo {

    public static void main(String[] args) {
        Flux.range(1,100).subscribe(System.out::println);
    }
}
