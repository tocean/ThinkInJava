package com.yxyang.learn.thinkinjava.ch15;

public class GenericArray2 <T> {
	//使用Object数组而不是T数组, 因此
	private Object[] array;
	
	public GenericArray2(int sz) {
		array = new Object[sz];
	}
	
	public T get(int index) {
		return (T) array[index];
	}
	
	public void put(int index, T item) {
		array[index] = item;
		System.out.println(array[index].getClass().getSimpleName());
	}
	
	public T[] rep() {
		return (T[])array;
	}
	
	static class A {
		
	}
	public static void main(String[] args) {
		GenericArray2<Integer> gai = new GenericArray2<Integer>(10);
		for (int i = 0; i < 10; i++) {
			gai.put(i, i);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(gai.get(i) + " ");
		}
		
		System.out.println();
		
		//gai内部的array的类型在定义时就确定了, 为Object[], 因此下面的转型会失败
		Integer[] ia = gai.rep();
	}
}
