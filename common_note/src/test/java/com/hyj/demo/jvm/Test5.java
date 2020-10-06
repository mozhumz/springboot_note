package com.hyj.demo.jvm;

import java.util.Random;

/**
 * 接口中定义的变量均是常量
 * 当一个接口初始化时，父接口并不会都初始化
 * 只有使用到父接口时（如引用父接口的常量），才会初始化
 * 当子接口的常量在编译期不能确定时，其所有父接口都会初始化
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(Child5.b);
    }
}
interface Grand5{
    int g=0;
}

interface Parent5 extends Grand5{
    public static final int a=1;
}

interface Child5 extends Parent5{
    public static final int b= new Random().nextInt(5);
}