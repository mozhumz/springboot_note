package com.hyj.demo.thread;


public class MyTask2 implements Runnable{

    @Override
    public void run() {
        System.out.println("MyTask2");
        for(int i=0;i<5;i++){
            System.out.println("haha"+i);
        }
    }
}
