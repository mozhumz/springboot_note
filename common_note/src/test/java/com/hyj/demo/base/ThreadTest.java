package com.hyj.demo.base;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    private final Object lock=new Object();
    private static final ExecutorService pool = Executors.newFixedThreadPool(20);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        pool.submit(runnable);
        pool.shutdown();
        new ThreadTest().test();
        System.out.println("ok");

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
        lock.wait();
        t.start();
        System.out.println("test ok");
        this.notifyAll();
//        Executors.newFixedThreadPool(5);
    }
}
