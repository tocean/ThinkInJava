package com.yxyang.learn.thinkinjava.ch15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class MinxinProxy implements InvocationHandler {
	Map<String, Object> delegatesByMethod;
	
	public MinxinProxy(TwoTuple<Object, Class<?>>... pairs) {
		//把每一个类的调用方法和这个类的对象的映射关系保存到map中
		delegatesByMethod = new HashMap<String, Object>();
		for (TwoTuple<Object, Class<?>> pair : pairs) {
			for (Method method : pair.second.getMethods()) {
				String methodName = method.getName();
				if (!delegatesByMethod.containsKey(methodName)) {
					delegatesByMethod.put(methodName, pair.first);
				}
			}
		}
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//每次进行调用时, 都会先查到该方法所属的对象, 然后调用该对象的方法
		String methodName = method.getName();
		Object delegate = delegatesByMethod.get(methodName);
		
		return method.invoke(delegate, args);
	}
	
	public static Object newInstance(TwoTuple... pairs) {
		
		Class[] interfaces = new Class[pairs.length];
		for (int i = 0; i < pairs.length; i++) {
			interfaces[i] = (Class) pairs[i].second;
		}
		
		ClassLoader cl = pairs[0].getClass().getClassLoader();
		return Proxy.newProxyInstance(cl, interfaces, new MinxinProxy(pairs));
	}
	
}

interface TimeStamped {
	long getStamp();
}

class TimeStampedImp implements TimeStamped {

	@Override
	public long getStamp() {
		// TODO Auto-generated method stub
		return new Date().getTime();
	}
	
}

interface SerialNumbered {
	long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
	
	private static long counter = 1;
	private final long serialNumber = counter++;
	@Override
	public long getSerialNumber() {
		return serialNumber;
	}
}

interface Basic {
	void set(String val);
	String get();
}

class BasicImpl implements Basic {
	private String val;
	@Override
	public void set(String val) {
		this.val = val;
	}

	@Override
	public String get() {
		return val;
	}
	
}
/**
 * 动态代理混型
 * @author yxyang
 *
 */
public class DynamicProxyMixin {
	public static void main(String[] args) {
		/**
		 * 传递要进行混型的对象和类
		 */
		Object mixin = MinxinProxy.newInstance(
				new TwoTuple<Basic, Class<Basic>>(new BasicImpl(), Basic.class),
				new TwoTuple<TimeStamped, Class<TimeStamped>>(new TimeStampedImp(), TimeStamped.class));
		
		Basic b = (Basic) mixin;
		TimeStamped t = (TimeStamped) mixin;
		
		b.set("hello");
		System.out.println(b.get());
		
		System.out.println(t.getStamp());
	}
}
