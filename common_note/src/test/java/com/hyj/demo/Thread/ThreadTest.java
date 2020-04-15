package com.hyj.demo.Thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args) {
        MyRun r=new MyRun(countDownLatch);
        ExecutorService pool= Executors.newFixedThreadPool(10);
        pool.submit(r);
        pool.shutdown();
        System.out.println("test end");
    }


    /**
     * junit是将test作为参数传递给了TestRunner的main函数。并通过main函数进行执行。
     *
     * test函数在main中执行。如果test执行结束，那么main将会调用System.exit(0);即使还有其他的线程在运行，main也会调用System.exit(0);
     *
     * System.exit()是系统调用，通知系统立即结束jvm的运行，即使jvm中有线程在运行，
     * jvm也会停止的。所以会出现之前的那种情况。其中System.exit(0);的参数如果是0，表示系统正常退出，如果是非0，表示系统异常退出
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        MyRun r=new MyRun(countDownLatch);
        new Thread(r).start();
        countDownLatch.await();
        System.out.println("test end");
    }
}
