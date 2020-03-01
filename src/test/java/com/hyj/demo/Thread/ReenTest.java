package com.hyj.demo.Thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenTest {
    /**
     * 必须为全局变量
     */
    static ReentrantLock reentrantLock=new ReentrantLock();
    public static void work(){

        reentrantLock.lock();
        try {
            String name=Thread.currentThread().getName();
            System.out.println(name+":start");
            Thread.sleep(5000);
            System.out.println(name+":ok");
        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                 work();
                }
            }).start();
        }
    }
}
