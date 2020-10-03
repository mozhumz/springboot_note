package com.hyj.demo.jvm;

/**
 * 对于静态字段，只有直接定义了该字段的类才会被初始化
 * 当一个类初始化时，要求其全部父类都已经被初始化完毕了
 * -XX:+TraceClassLoading 用于追踪类的加载信息并打印
 *-XX:+<option> 表示开启option选项 （是一个开关参数）
 *-XX:-<option> 表示关闭option选项（是一个开关参数）
 * -XX:<option>=<value> 将option的值设置为value （K V参数）
 */
public class Test1 {

//	static {
//		System.out.println("test1 static block");
//	}

	public static void main(String[] args) {
		System.out.println(MyChild.str);
	}



}
class MyChild extends MyParent{
	public static String str2="child";
	static {
		System.out.println("child static block");
	}
}

class MyParent {
	public static String str="parent v";
	static {
		System.out.println("parent block");
	}
}