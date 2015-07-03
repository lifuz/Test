package com.prd.client;


public class TestClient {

	public static void main(String[] args) throws Exception {
		
		//创建客户端类对象
		MyServiceStub mss = new MyServiceStub();
		//创建要调用的WebService方法的类，作用是设置访问的参数
		MyServiceStub.SayHello  method = new MyServiceStub.SayHello();
		//设置访问方法的参数
		method.setName("李富");
		//使用客户端类的WebService方法，并获取返回值
		System.out.println(mss.sayHello(method).local_return);
		
	}
	
}
