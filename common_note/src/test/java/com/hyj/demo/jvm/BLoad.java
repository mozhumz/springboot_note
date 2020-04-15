package com.hyj.demo.jvm;

import lombok.Data;

@Data
public class BLoad {
	private String id="1";
	static {
		System.out.println("load Bload");
	}
}
