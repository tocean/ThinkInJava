package com.yxyang.learn.thinkinjava.ch15;

import java.util.ArrayList;
import java.util.List;

public class ListOfGeneric<T> {
	private List<T> array = new ArrayList<T>();
	
	public void add(T item) {
		array.add(item);
	}
	
	public T get(int i) {
		return array.get(i);
	}
	
	public static void main(String[] args) {
		ListOfGeneric<Integer> list = new ListOfGeneric<Integer>();
		
		list.add(1);
		list.add(2);
		
		System.out.println(list.get(1));
	}
}
