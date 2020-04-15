package com.hyj.demo.Thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CountDownLatch;

@AllArgsConstructor
@Data
public class MyRun implements Runnable {
    private CountDownLatch countDownLatch;


    @Override
    public void run() {
        System.out.println("run start");
        try {
            Thread.sleep(1000);
            System.out.println("ssss");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }

    }
}
