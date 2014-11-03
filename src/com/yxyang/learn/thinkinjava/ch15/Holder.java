package com.yxyang.learn.thinkinjava.ch15;

class Fruit {

}

class Apple extends Fruit {

}

class Orange extends Fruit {

}

class Jonathan extends Apple {
	
}
/**
 * 基本泛型类示例
 * 
 * @author yxyang
 *
 * @param <T>
 */
public class Holder<T> {
	private T a;

	public Holder(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}

	public void set(T a) {
		this.a = a;
	}

	public boolean equals(Object obj) {
		return a.equals(obj); // equals是object中的操作
	}

	public static void main(String[] args) {
		Holder<Apple> appleHolder = new Holder<Apple>(new Apple());
		Apple a = appleHolder.get();
		appleHolder.set(a);

		// fruitHolder不能调用参数位泛型参数的函数,因为不知道确切类型
		Holder<? extends Fruit> fruitHolder = appleHolder;

		Fruit f = fruitHolder.get();
		Apple a1 = (Apple) fruitHolder.get();

		try {
			Orange o = (Orange) fruitHolder.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(f.equals(a));
		System.out.println("success");
	}
}
