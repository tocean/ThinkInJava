package com.yxyang.learn;

import java.lang.reflect.Method;

import com.yxyang.learn.thinkinjava.ch14.A;
import com.yxyang.learn.thinkinjava.ch14.HiddenC;

public class HiddenImplementation {
	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		a.f();
		
		//不能把a强制转换为c,因为没有c的访问权限
		
		callHiddenMethod(a, "g");
		
	}
	
	//使用反射调用看不到的函数
	static void callHiddenMethod(Object a, String method) throws Exception{
		Method m = a.getClass().getDeclaredMethod(method);
		
		m.setAccessible(true);
		m.invoke(a);
	}
}
