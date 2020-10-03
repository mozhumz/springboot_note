package com.hyj.demo.jvm;

/**
 * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lcom.hyj.demo.jvm.Parent4
 * 这种形式。该实例的类型是动态生成的类型，其父类型就是Object。
 * 对于数组来说，JavaDoc经常将构成数组的元索为Component,实际上就是将数组降低一个维度后的类型。
 * 助记符：
 * anewarray:表示创建一个引用类型的（如类、接口、数组）数组，并将其引用值压入栈顶stack
 * newarray:表示创建一个指定的原始类型（如int、float、char等）的数组，并将其引用值压入栈顶
 */
public class Test4 {
    public static void main(String[] args) {
        Parent4[]parent4s=new Parent4[1];
        System.out.println(parent4s.getClass());
        System.out.println(parent4s.getClass().getSuperclass());
//        Parent4[][]parent4s1=new Parent4[1][1];
//        System.out.println(parent4s1.getClass());
//        System.out.println(parent4s1.getClass().getSuperclass());
        int[]arr=new int[1];
        System.out.println(arr.getClass());
        System.out.println(arr.getClass().getSuperclass());
    }
}

class Parent4{
    static {
        System.out.println("parent4 static block");
    }
}