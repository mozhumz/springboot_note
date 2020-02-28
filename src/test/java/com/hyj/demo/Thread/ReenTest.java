package com.hyj.demo.Thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenTest {

    public static void work(){
        ReentrantLock reentrantLock=new ReentrantLock();
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
