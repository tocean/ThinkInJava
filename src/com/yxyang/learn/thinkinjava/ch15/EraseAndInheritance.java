package com.yxyang.learn.thinkinjava.ch15;

import java.lang.reflect.Array;
import java.util.ArrayList;

class GenericBase<T> {
	private T element;
	public void set(T arg) {
		element = arg;
	}
	
	public T get() {
		return element;
	}
}

class Derived<T> extends GenericBase<T> {
	
}

class Derived2 extends GenericBase {
	
}

class A {
	
}

class B {
	
}

class C extends A {
	
}
public class EraseAndInheritance {
	public static void main(String[] args) {
		Derived2 d2 = new Derived2();
		d2.get();
		d2.set(new Object());
		//d2.set(obj); //在set处有了警告
		ArrayList list = new ArrayList();
		
		Derived d = new Derived();		
		
		
		A[] arrA = new A[10];
		B[] arrB = new B[10];
		C[] arrC = new C[10];
		//arrA = arrB;
		arrA = arrC;
		arrC = (C[]) arrA;
		
		A a = new A();
		B b = new B();
		C c = new C();
		
		//a = b;
		a = c;
		c = (C) a;
		
		A[] arr = (A[]) Array.newInstance(A.class, 100);
	}
}
