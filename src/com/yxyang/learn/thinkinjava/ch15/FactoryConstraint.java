package com.yxyang.learn.thinkinjava.ch15;
/**
 * 工厂方法(解决在泛型类中创建泛型参数的对象)
 * 为了在泛型中创建泛型参数的对象,需要为每一个用到的泛型参数, 编写一个工厂类.
 * 把这个工厂类对象(使用接口的形式)传递给泛型类,泛型类使用这个工厂对象创建泛型参数的对象
 * @author yxyang
 *
 */
interface FactoryI<T> {
	T create();
}

class Foo <T> {
	private T x;
	public <F extends FactoryI<T>> Foo(F factory) {
		//使用工厂对象来创建泛型参数的对象
		x = factory.create();
	}
}

/*
 * 定义工厂, 包含一个创建对象的方法
 */
class IntegerFactory implements FactoryI<Integer> {
	@Override
	public Integer create() {
		return 0;
	}
}

class Widget {
	public static class Factory implements FactoryI<Widget> {
		@Override
		public Widget create() {
			// TODO Auto-generated method stub
			return new Widget();
		}
	}
}

public class FactoryConstraint {
	public static void main(String[] args) {
		new Foo<Integer>(new IntegerFactory());
		System.out.println("create integer success");
		
		new Foo<Widget>(new Widget.Factory());
		System.out.println("create Widget success");
	}
}