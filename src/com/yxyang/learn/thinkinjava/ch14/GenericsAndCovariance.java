package com.yxyang.learn.thinkinjava.ch14;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	
}

class Apple extends Fruit {
	
}

public class GenericsAndCovariance {
	static void f(List<? extends Fruit> list) {
		for (Fruit f : list) {
			System.out.println(f.getClass().getSimpleName());
		}
	}
	public static void main(String[] args) {
		List<Fruit> flist = new ArrayList<Fruit>();
		flist.add(new Fruit());
		f(flist);
		
		List<Apple> alist = new ArrayList<Apple>();
		alist.add(new Apple());
		f(alist);
		
	}
}
