package com.hyj.demo.proxy;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProxyTest {
	@Test
	public void test1() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Class<Aoo> c = Aoo.class;
		Constructor<Aoo> constructor = c.getDeclaredConstructor();
		constructor.setAccessible(true);
		Aoo aoo = constructor.newInstance();
//		Aoo aoo=c.newInstance();
		System.out.println(aoo);

		/*以下调用带参的、私有构造函数*/
		Constructor c1 = c.getDeclaredConstructor(new Class[]{String.class,Integer.class});
		c1.setAccessible(true);
		Aoo p1 = (Aoo) c1.newInstance(new Object[]{"我是参数值",1});
		System.out.println("有参的构造函数\t" + p1);


	}
}
