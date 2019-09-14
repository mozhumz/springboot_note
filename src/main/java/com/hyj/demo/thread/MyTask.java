package com.hyj.demo.thread;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class MyTask implements Runnable{
    ExecutorService executorService= Executors.newFixedThreadPool(5);
    private MyTask2 myTask2;
    @Override
    public void run() {
        System.out.println("MyTask");
        for(int i=0;i<5;i++){
            executorService.execute(myTask2);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        MyTask myTask=new MyTask();
        MyTask2 myTask2=new MyTask2();
        myTask.setMyTask2(myTask2);
        for(int i=0;i<10000;i++){
            executorService.execute(myTask);
        }
    }
}
