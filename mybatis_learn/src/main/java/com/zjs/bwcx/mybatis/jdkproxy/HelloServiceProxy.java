package com.zjs.bwcx.mybatis.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler{
	
	/*
	  * 真实服务对象
	 */
	private Object target;
	
	/**
	 * @Title: bind   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param target
	 * @param: @return      
	 * @return: Object      
	 * @throws
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}
	
	/**
	 * <p>Title: invoke</p>   
	 * <p>Description: 通过代理对象调用方法首先进入这个方法</p>   
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable   
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println("##############我是jdk动态代理###############");
		Object result = null;
		//反射方法前调用
		System.err.println("我准备说hello.");
		//执行方法，想点关于执行HelloServiceImpl的sayHello方法
		result = method.invoke(target, args);
		//反射方法后调用
		System.err.println("我说过hello了.");
		return result;
	}

}
