package com.zjs.bwcx.mybatis.jdkproxy;

public class HelloServiceImpl implements HelloService {
	
	/**
	 * <p>Title: sayHello</p>   
	 * <p>Description: </p>   
	 * @param name   
	 * @see com.zjs.bwcx.mybatis.jdkproxy.HelloService#sayHello(java.lang.String)
	 */
	public void sayHello(String name) {
		System.err.println("hello "+name);
	}

}
