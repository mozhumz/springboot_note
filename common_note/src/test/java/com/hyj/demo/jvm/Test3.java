package com.hyj.demo.jvm;

import java.util.UUID;

/**
 * 当一个常量的值并非编译期能确定的，那么常量不会放到调用该常量的类的常量池中
 * 这会导致本类的主动使用（即定义该常量的类被主动使用）
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(Parent3.str);
    }
}

class Parent3{
    public static final String str= UUID.randomUUID().toString();
    static {
        System.out.println("parent3 static block");
    }
}