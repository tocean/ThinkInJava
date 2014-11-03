package com.yxyang.learn.thinkinjava.ch15;

class ClassAsFactory <T> {
	T x;
	public ClassAsFactory(Class<T> kind) {
		try {
			x = kind.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

class Employee {
	
}

class InstantiateGenericType {
	public static void main(String[] args) {
		ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
		System.out.println("create employee success");
		
		//此句会出现运行时错误,因为Integer并没有默认构造函数
		ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
	}
}