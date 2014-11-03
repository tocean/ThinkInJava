package com.yxyang.learn.thinkinjava.ch14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 反射示例
 * @author yxyang
 *
 */
public class ShowMethods {
	private void f() {
		
	}
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("need args");
			System.exit(0);
		}
		//匹配 xxx.
		Pattern p = Pattern.compile("\\w+\\.");
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods(); //只能拿到public的
			Constructor[] ctors = c.getConstructors();
			
			if (args.length == 1) {
				for (Method m : methods) {
					System.out.println(p.matcher(m.toString()).replaceAll(""));
				}
				
				for (Constructor ctor : ctors) {
					System.out.println(p.matcher(ctor.toString()).replaceAll(""));
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
