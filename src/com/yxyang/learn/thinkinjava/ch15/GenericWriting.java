package com.yxyang.learn.thinkinjava.ch15;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
	static <T> void writeExact(List<? super T> list, T item) {
		list.add(item);
	}
	
	static List<Apple> apples = new ArrayList<Apple>();
	static List<Fruit> fruits = new ArrayList<Fruit>();
	
	static void f1() {
		writeExact(apples, new Apple());
		//此处去了这个限制
		writeExact(fruits, new Apple());
	}
	
	public static void main(String[] args) {
		f1();
	}
}
