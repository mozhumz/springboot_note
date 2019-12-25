package com.hyj.demo.jvm;

import lombok.Data;

@Data
public class ALoad {
//	public  BLoad bLoad=new BLoad();
	static {
		System.out.println("Aload");
	}
	private Integer code=1;
	private String name="张三";

	public static void test(){
		System.out.println("test");
	}


	public static void main(String[] args) {
		ALoad.test();
		System.out.println(new ALoad().toString());

	}
}
