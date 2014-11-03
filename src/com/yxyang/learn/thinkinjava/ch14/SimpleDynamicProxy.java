package com.yxyang.learn.thinkinjava.ch14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

/**
 * 简单的动态代理示例
 * @author yxyang
 *
 */

class DynamicProxyHandler implements InvocationHandler {
	private Object realObj;
	public DynamicProxyHandler(Object realObj) {
		this.realObj = realObj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//这这里可以做些其他操作
		System.out.println("proxy:" + proxy.getClass());
		return method.invoke(realObj, args);
	}

}

public class SimpleDynamicProxy {
	static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("hello");
	}
	
	public static void main(String[] args) {
		RealObject obj = new RealObject();
		consumer(obj);
		Interface iface = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), 
				new Class[] {Interface.class}, 
				new DynamicProxyHandler(obj));
		consumer(iface);
	}
}
