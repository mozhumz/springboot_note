package com.hyj.demo.proxy;

import lombok.Data;

@Data
public class Aoo {
	private String id;
	private String name;
	private Integer mon;

	private Aoo(){}

	static {
		 int a=1;
		System.out.println(a);

	}
//	private Aoo(String name){
//		this.name=name;
//	}

	private Aoo(String name,Integer mon){
		this.name=name;
		this.mon=mon;
	}

	public void test(){
		System.out.println(this.name+","+this.id);
	}
}
