package com.yxyang.learn.thinkinjava.ch15;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker <T> {
	//可以认为T不具有任何信息
	Class<T> kind;
	
	public ArrayMaker(Class<T> kind) {
		System.out.println(kind.getName());
		this.kind = kind;
	}
	
	T[] create(int size) {
		T[] arr = (T[])Array.newInstance(kind, size);
		
		return null;
	}
	
	public static void main(String[] args) {
		ArrayMaker<Integer> stringMaker = new ArrayMaker<Integer>(Integer.class);
		Integer[] arr = stringMaker.create(10);
		System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.toString((String[])Array.newInstance(String.class, 10)));
		
		Integer[] arr1 = (Integer[]) Array.newInstance(Integer.class, 10);
		System.out.println(Arrays.toString(arr1));
		
		Class<?> c = Integer.class;
		Integer[] arr2 = (Integer[]) Array.newInstance(c, 10);
		System.out.println(arr2);
	}
}
