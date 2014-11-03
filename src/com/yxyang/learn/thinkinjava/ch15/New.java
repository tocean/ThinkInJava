package com.yxyang.learn.thinkinjava.ch15;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class New {
	//使用方法泛型, 可以进行参数推断
	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}
	
	public static void f(Map<String, String> m) {
		
	}
	public static void main(String[] args) {
		Map<String, String> map = New.map();
		f(map);
		
		//仅在赋值处进行类型推断
		//f(New.map());
		@SuppressWarnings("rawtypes")
		//此处直接进行赋值,生成对象时不进行参数声明, 编译器会抱怨, 不如上面的那种优雅
		Map<String, Object> map1 = new HashMap();
		map1.put("abc", 1);
		
		System.out.println(map1);
		
		//类型擦除
		Class<?> class1 = new ArrayList<Integer>().getClass();
		Class<?> class2 = new ArrayList<String>().getClass();
		
		System.out.println(class1 == class2);
		
	}
}
