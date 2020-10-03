package com.hyj.demo.jvm;

import java.lang.reflect.Field;

/**
 * 常量在编译阶段会存储在调用该常量的方法的类的常量池中
 * 因此常量和本类的加载无关（使用常量时，本类并不会被加载），
 * 甚至可以将编译后的本类的class文件删除，也能访问本类的常量
 * 如Parent2的常量，Parent2不会初始化，其静态块不会被执行
 *
 * 反编译查看class编译情况：javap -c com.hyj.demo.jvm.Test2
 * 助记符：
 * ldc表示将int, float或是String类型的常置值从常量池中推送至栈顶stack
 * bipush表示将单字节[-128 ,127]的常置值推送至栈顶
 * sipush表示将一个短整型常置值[-32768 ,32767]推送至栈顶
 * iconst_1表示将int类型1推送至栈顶[iconst_1 ,iconst_5]
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Parent2.str);
    }
}

class Parent2{
    public static final String str="parent2";
    public static final int a=11;
    static {
        System.out.println("parent2 static block");
    }
}
