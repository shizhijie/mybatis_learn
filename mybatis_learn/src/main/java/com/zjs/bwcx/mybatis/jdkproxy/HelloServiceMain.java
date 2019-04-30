package com.zjs.bwcx.mybatis.jdkproxy;

public class HelloServiceMain {
	
	public static void main(String[] args) {
		HelloServiceProxy helloHandler = new HelloServiceProxy();
		HelloService proxy = (HelloService) helloHandler.bind(new HelloServiceImpl());
		proxy.sayHello("zhangsan");
	}
}
