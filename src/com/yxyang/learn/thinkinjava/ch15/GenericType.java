package com.yxyang.learn.thinkinjava.ch15;

/*
 * 泛型参数,类可以不是泛型的
 */
public class GenericType {
	public <T>void f(T x) {
		System.out.println(x.getClass().getSimpleName());
	}
	
	public static void main(String[] args) {
		GenericType g = new GenericType();
		
		g.f("");
		g.f(1);
		g.f(2.0f);
		g.f(3.1d);
	}
}
