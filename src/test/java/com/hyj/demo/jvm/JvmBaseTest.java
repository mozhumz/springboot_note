package com.hyj.demo.jvm;

import org.junit.Test;

public class JvmBaseTest {
	@Test
	public void test1(){
		ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
		try {
//			Class.forName("com.hyj.demo.jvm.Test1");
			classLoader.loadClass("com.hyj.demo.jvm.Test1").newInstance();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
