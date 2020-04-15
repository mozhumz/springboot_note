package com.hyj.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class ProxyFactory{


	//给目标对象生成代理对象
	public static Object getProxyInstance(Object target){
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//运用反射执行目标对象方法
						Object returnValue = method.invoke(target, args);
						return returnValue;
					}
				}
		);
	}

	//给目标类生成代理对象
	public static Object getProxyInstance2(final Class target){

		return Proxy.newProxyInstance(
				target.getClassLoader(),
				target.getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//运用反射执行目标对象方法
						Object returnValue = method.invoke(target.newInstance(), args);
						return returnValue;
					}
				}
		);
	}

}
