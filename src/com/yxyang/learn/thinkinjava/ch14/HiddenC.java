package com.yxyang.learn.thinkinjava.ch14;


class C implements A {
	@Override
	public void f() {
		System.out.println("public C.f()");
	}
	
	public void g() {
		System.out.println("public C.g()");
	}
}
public class HiddenC{
	public static A makeA() {
		return new C();
	}
}
