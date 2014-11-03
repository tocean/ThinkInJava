package com.yxyang.learn.thinkinjava.ch14;

import java.util.HashMap;

public class TypeCounter extends HashMap<Class<?>, Integer>{
	private Class<?> baseType;
	
	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}
	
	public void count(Object obj) {
		Class<?> type = obj.getClass();
		
		if (!baseType.isAssignableFrom(type)) {
			throw new RuntimeException();
		}
		
		countClass(type);
	}
	
	public void countClass(Class<?> type) {
		put(type, get(type) == null ? 1 : get(type) + 1);
		
		Class<?> superClass = type.getSuperclass();
		
		if (superClass != null && baseType.isAssignableFrom(superClass)) {
			countClass(superClass);
		}
	}
}
