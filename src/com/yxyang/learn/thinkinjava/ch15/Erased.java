package com.yxyang.learn.thinkinjava.ch15;

public class Erased<T> {
	private final int SIZE = 100;
	
	private T[] f(Object arg) {
		//if (arg instanceof T) {} //运行时被擦除
		//T t = new T();
		//T[] array = new T[SIZE];
		T[] array = (T[])new Object[SIZE];
		return array;
	}
	
	public static void main(String[] args) {
		Erased<Integer> e = new Erased<Integer>();
		Integer[] arr = e.f(0);
		
		//Integer[] arr = (Integer[]) new Object[10];
		//A a = (A) new Object();
	}
}
