package com.yxyang.learn.thinkinjava.ch15;

import java.util.List;

/**
 * ? super Apple 和 ? extends Apple的区别
 * ? super Apple表示任何可能的Apple的父类, 所以可以写入任何Apple和Apple的超类的对象
 * ? extends Apple 表示任何可能的Apple的超类, 所以写入任何类 都有可能导致类型不安全, 所以java不允许写入任何对象,除了null
 * @author yxyang
 *
 */
public class SuperTypeWildcards {
	static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new Jonathan());
		
		//not valid
		//apples.add(new Fruit());
	}
	
	static void writeTo1(List<? extends Apple> apples) {
		apples.add(null);
	}
}
