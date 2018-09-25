package com.mmall.concurrency.example.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RateLimiterExample2 {

    private static RateLimiter rateLimiter = RateLimiter.create(5);

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 100; i++) {
            rateLimiter.acquire();
            handle(i);
        }
    }

    private static void handle(int i){
        log.info("{}", i);
    }
}
