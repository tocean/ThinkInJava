package com.yxyang.learn.thinkinjava.ch15;

import com.yxyang.learn.thinkinjava.Generator;

public class Fibonacci implements Generator<Integer> {
	private int count;
	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return fib(count++);
	}
	
	int fib(int n) {
		if (n < 2) {
			return 1;
		}
		
		return fib(n - 1) + fib(n - 2);
	}
	
	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		
		for (int i = 0; i < 18; i++) {
			System.out.println(gen.fib(i));
		}
	}
}
