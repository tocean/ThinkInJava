package com.yxyang.learn.thinkinjava.ch15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface IHasG {
	void g();
}

class HasG1 implements IHasG {

	@Override
	public void g() {
		System.out.println("in HasG1:g()");
	}
	
}

class ProxyHandler implements InvocationHandler {
	private HasG1 hasG1;
	public ProxyHandler(HasG1 hasG1) {
		this.hasG1 = hasG1;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before invoke");
		Object obj = method.invoke(hasG1, args);
		System.out.println("after invoke");
		return obj;
	}

}
public class DynamicProxy {
	public static void main(String[] args) {
		Object proxyObj = Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), new Class[]{IHasG.class}, new ProxyHandler(new HasG1()));
		IHasG hasG = (IHasG) proxyObj;
		hasG.g();
	}
}
