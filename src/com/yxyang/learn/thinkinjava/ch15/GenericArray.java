package com.yxyang.learn.thinkinjava.ch15;

public class GenericArray <T> {
	private T[] array;
	
	public GenericArray(int sz) {
		//array = new T[sz];
		array = (T[]) new Object[sz];
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
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
		
		//Integer[] arr = gai.rep(); //Integer类型被擦除,执行这句会导致ClassCastException
		Object[] arr = gai.rep(); //这样,编译器实际的类型就丢失了
	}
}
