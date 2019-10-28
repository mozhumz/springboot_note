package com.hyj.demo.base;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        new ThreadTest().test();

    }

    public synchronized void test() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hh");
            }
        };

        System.out.println("start...");
        Thread t=new Thread(runnable);
        this.wait(1000);
        t.start();
        System.out.println("ok");
        this.notify();
        Executors.newFixedThreadPool(5);
    }
}
