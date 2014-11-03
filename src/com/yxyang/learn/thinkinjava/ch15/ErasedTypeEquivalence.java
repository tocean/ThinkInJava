package com.yxyang.learn.thinkinjava.ch15;

import java.util.ArrayList;

public class ErasedTypeEquivalence {
	public static void main(String[] args) {
		//ArrayList<String>和ArrayList<Integer>中的泛型参数信息被擦除了,因此都是ArrayList,
		//class相同
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		
		System.out.println(c1 == c2);
	}
}
