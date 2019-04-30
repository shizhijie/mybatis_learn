package com.zjs.bwcx.mybatis.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class HelloServiceCglib implements MethodInterceptor{
	
	private Object target;
	
	/**
	 * 
	 * @Title: getInstance   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   创建代理对象
	 * @param: @param target
	 * @param: @return      
	 * @return: Object      
	 * @throws
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		//回掉方法
		enhancer.setCallback(this);
		//创建代理对象
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.err.println("#################我是CGLIB的动态代理###################");
		//反射方法前调用
		System.err.println("我准备说hello.");
		Object returnObj = proxy.invoke(obj, args);
		//反射方法后调用
		System.err.println("我说过hello了.");
		return returnObj;
	}

}
