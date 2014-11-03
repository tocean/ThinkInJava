package com.yxyang.learn.thinkinjava.ch15;

import java.util.ArrayList;
import java.util.List;

/**
 * 无解通配符
 * @author yxyang
 *
 */
public class UnboundedWildcards1 {
	static List list1;
	static List<?> list2;
	static List<? extends Object> list3;

	static void assign1(List list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	static void assign2(List<?> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	static void assign3(List<? extends Object> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	public static void main(String[] args) {
		List<Integer> intArr = new ArrayList<Integer>();
		intArr.add(1);
		List<?> list1 = intArr;
		
		List<? extends Object> list2 = intArr;
		
		//?和? extends Object有什么区别 应该是只在编译时有差别, 运行时都擦除到Object
		//list1.add(1);
		Object obj1 = list1.get(0);
		Object obj2 = list2.get(0);
		
		System.out.println(obj1);
		System.out.println(obj2);
	}
}
