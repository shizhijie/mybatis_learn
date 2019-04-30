package com.zjs.bwcx.mybatis.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectService {
	
	/**
	 * @Title: sayHello   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param name      
	 * @return: void      
	 * @throws
	 */
	public void sayHello(String name) {
		System.out.println("hello  "+name);
	}
	
	/**
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @Title: main   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param args      
	 * @return: void      
	 * @throws
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//通过反射创建ReflectService对象
		Object service = Class.forName(ReflectService.class.getName()).newInstance();
		//获取服务方法--sayHello
		Method method = service.getClass().getMethod("sayHello", String.class);
		//反射方法调用
		method.invoke(service, "zhangsan");
	}
}
