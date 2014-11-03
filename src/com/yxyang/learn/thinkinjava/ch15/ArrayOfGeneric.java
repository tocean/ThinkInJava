package com.yxyang.learn.thinkinjava.ch15;

class Generic <T> {
	
}

public class ArrayOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;
	
	public static void main(String[] args) {
		//会出现运行时错误
		//gia = (Generic<Integer>[]) new Object[SIZE];
		
		gia = new Generic[SIZE];
		System.out.println(gia.getClass().getSimpleName());
		gia[0] = new Generic<Integer>();
		//编译时错误
		//gia[1] = new Generic<Double>();
	}
}
