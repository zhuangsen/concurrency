package com.mmall.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        scheduledExecutorService.schedule(()->log.warn("schedule run"),3,TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(()->log.warn("scheduleAtFixedRate run"),1,3,TimeUnit.SECONDS);

//        scheduledExecutorService.shutdown();

        Timer timer = new Timer();
        //TimerTask是抽象类，此处不支持lambda表达式
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        },new Date(),5*1000);

    }
}
