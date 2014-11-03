package com.yxyang.learn.thinkinjava.ch15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pet {

}

class Dog extends Pet {

}

class Cat extends Pet {

}

public class CheckedList {

	static void oldStyleMethod(List probDogs) {
		probDogs.add(new Cat());
	}

	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1);

		// Collections增加了运行时的类型安全
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(),
				Dog.class);
		try {
			oldStyleMethod(dogs2);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
