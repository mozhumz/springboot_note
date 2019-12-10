package com.hyj.demo.jvm;

public class ALoad {
	public  BLoad bLoad=new BLoad();
	static {
		System.out.println("Aload");
	}

	public static void test(){
		System.out.println("test");
	}

//	public void test(){
//		BLoad bLoad=new BLoad();
//	}

	public static void main(String[] args) {
		ALoad.test();
		System.out.println("ok");
	}
}
