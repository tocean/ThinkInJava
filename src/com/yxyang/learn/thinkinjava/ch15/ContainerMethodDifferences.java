package com.yxyang.learn.thinkinjava.ch15;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class ContainerMethodDifferences {
	static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<String>();
		
		for (Method m : type.getMethods()) {
			result.add(m.getName());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(methodSet(Collection.class));
	}
}
