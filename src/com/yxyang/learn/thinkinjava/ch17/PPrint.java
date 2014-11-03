package com.yxyang.learn.thinkinjava.ch17;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
	public static String pformat(Collection<?> c) {
		if (c == null || c.size() == 0) {
			return "[]";
		}
		
		StringBuilder result = new StringBuilder("[");
		for (Object ele : c) {
			if (c.size() != 1) {
				result.append("\n");
			}
			result.append(ele);
		}
		
		if (c.size() != 1) {
			result.append("\n");
		}
		
		result.append("]");
		return result.toString();
	}
	
	public static void pprint(Collection<?> c) {
		System.out.println(pformat(c));
	}
	
	public static void pprint(Object[] c) {
		System.out.println(pformat(Arrays.asList(c)));
	}
	
	public static void main(String[] args) {
		System.out.println(pformat(Arrays.asList("helll0", "world")));
	}
}
