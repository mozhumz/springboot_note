package com.hyj.demo.jvm;

/**
 * 类中代码的执行顺序是从上到下：从上到下赋予默认值，再从上到下初始化（赋予真实值）
 *
 */
public class Test6 {
    public static void main(String[] args) {
        Singleton.getOne();
        System.out.println(Singleton.a1);
        System.out.println(Singleton.a2);
    }
}

class Singleton{
    public static int a1=1;

    public static Singleton singleton=new Singleton();
    private Singleton(){
        //a1初始化后的值++
        a1++;
        //a2完成准备后的值++
        a2++;
        System.out.println(a1);
        System.out.println(a2);
    }
    //a2初始化
    public static int a2=0;

    public static Singleton getOne(){
        return singleton;
    }
}
