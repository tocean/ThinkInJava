package com.yxyang.learn.thinkinjava.ch15;

class HasF {
	public void f() {
		System.out.println("HasF:f()");
	}
}

class HasG {
	public void g() {
		
	}
}

class Manipulation <T extends HasF, V extends HasG> {
	private T obj1;
	private V obj2;
	Manipulation(T x1, V x2) {
		obj1 = x1;
		obj2 = x2;
	}
	
	public void manipulate() {
		obj1.f();
		obj2.g();
	}
	
	public static void main(String[] args) {
	}
}
