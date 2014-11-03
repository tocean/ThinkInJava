package com.yxyang.learn.thinkinjava.ch14;

import java.util.ArrayList;
import java.util.List;

class CountedInteger {
	private static long counter;
	private long id = counter++;

	public CountedInteger() {
		System.out.println("in CountedInteger()");
	}
	public CountedInteger(int i) {
		System.out.println("in CountedInteger(int)");
	}

	@Override
	public String toString() {
		return Long.toString(id);
	}
}

/**
 * 
 * @author yxyang
 *
 * @param <T>
 */
public class FilledList<T> {
	private Class<T> type;

	public FilledList(Class<T> type) {
		this.type = type;
	}

	// 返回一个包含n个T类的对象的列表
	public List<T> create(int nElements) {
		List<T> list = new ArrayList<T>();

		try {
			for (int i = 0; i < nElements; i++) {
				T obj = type.newInstance(); //T必须要有一个默认构造函数,否则会报异常
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
		
		System.out.println(fl.create(15));
		
		Object obj = new CountedInteger();
		System.out.println(obj.getClass().getSimpleName()); //obj对象的class对象包含了对象的准确类型信息
		CountedInteger ci = (CountedInteger) obj; //强制类型转换, 如果obj的实际类型不是CounterInteger或它的子类,则抛出ClassCastException
		
		if (obj instanceof CountedInteger) {
			System.out.println("obj instanceof CountedInteger");
		}
	}
}
