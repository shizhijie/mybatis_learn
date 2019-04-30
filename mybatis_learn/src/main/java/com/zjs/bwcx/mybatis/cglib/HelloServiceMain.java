package com.zjs.bwcx.mybatis.cglib;

public class HelloServiceMain {
	
	public static void main(String[] args) {
		HelloServiceCglib cglib = new HelloServiceCglib();
		HelloServiceImpl proxy = (HelloServiceImpl) cglib.getInstance(new HelloServiceImpl());
		proxy.sayHello("zhangshan");
	}
}
