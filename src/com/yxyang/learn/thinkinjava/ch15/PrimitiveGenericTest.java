package com.yxyang.learn.thinkinjava.ch15;

import java.io.ObjectInputStream;
import java.util.List;

interface Generator <T> {
	T next();
}

class RandomGenerator {
	static class String implements Generator<java.lang.String> {
		String(int n) {
			
		}
		
		public java.lang.String next() {
			return "hello";
		}
	}
	
	static class Integer implements Generator<java.lang.Integer> {
		Integer() {
			
		}
		
		public java.lang.Integer next() {
			return 10;
		}
	}
}

class RandomIntGenerator implements Generator {

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return 10;
	}
	
}
class FArray {
	public static <T> T[] fill(T[] a, Generator<T> gen) {
		for (int i = 0; i < a.length; i++) {
			a[i] = gen.next();
		}
		
		return a;
	}
}

public class PrimitiveGenericTest {
	public static void main(String[] args) {
		String[] strings = FArray.fill(new String[7], new RandomGenerator.String(10));
		for (String str : strings) {
			System.out.println(str);
		}
		
		//int[] a = FArray.fill(new Integer[10], new RandomIntGenerator());
		
		@SuppressWarnings("unchecked")
		List<Integer> list = List.class.cast(new Object());
		System.out.println(list.size());
		
	}
}
