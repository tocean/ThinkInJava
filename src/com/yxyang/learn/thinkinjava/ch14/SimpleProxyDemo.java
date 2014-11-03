package com.yxyang.learn.thinkinjava.ch14;

/**
 * 简单代理示例
 * @author yxyang
 *
 */

interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

/*
 * 实际对象
 */
class RealObject implements Interface {

	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("somethingElse " + arg);
	}
}

/**
 * 简单代理
 * @author yxyang
 *
 */
class SimpleProxy implements Interface {
	private Interface proxied; //被代理对象
	
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	
	@Override
	public void doSomething() {
		//执行某些操作,如记录日志,记录程序运行时间等
		System.out.println("SimpleProxy doSomething"); 
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("SimpleProxy somethingElse arg " + arg);
		proxied.somethingElse(arg);
	}
}

public class SimpleProxyDemo {
	
	static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("hello");
	}
	public static void main(String[] args) {
		RealObject obj = new RealObject();
		consumer(obj);
		
		consumer(new SimpleProxy(obj));
	}
}
