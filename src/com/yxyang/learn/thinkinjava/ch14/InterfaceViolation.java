package com.yxyang.learn.thinkinjava.ch14;

class B implements A {
	public void f() {
		
	}
	
	public void g() {
		
	}
}

public class InterfaceViolation {
	public static void main(String[] args) {
		A a = new B();
		a.f();
		
		if (a instanceof B) {
			B b = (B) a; //强制转换
			b.g();
		}
	}
}
