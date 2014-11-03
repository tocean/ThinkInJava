package com.yxyang.learn.thinkinjava.ch15;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken <T> {
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public GenericArrayWithTypeToken(Class<T> type, int sz) {
		System.out.println(type.getSimpleName());
		//type为确切的类型, 因此会生成确切的类型数组, 
		//如果type为Integer.class,则下面这行相当于:
		//Object[] array = (Object[])Array.newInstance(Integer.class, sz)
		array = (T[]) Array.newInstance(type, sz);
	}
	
	public void put(int index, T item) {
		array[index] = item;
	}
	
	public T get(int index) {
		return array[index];
	}
	
	public T[] rep() {
		return array;
	}
	
	public static void main(String[] args) {
		GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);
		Integer[] ia = gai.rep();
	}
}
