package com.yxyang.learn.thinkinjava.ch15;

class D {
	
}

class E {
	
}
public class ArrayOfGenericReference {
	//static Generic<Integer>[] gia = new Generic<Integer>[10];
	
	public static void main(String[] args) {
		D[] dArr = new D[10];
		Object[] objArr = dArr;
		
		objArr[1] = new E(); //ArrayStoreException, 保存的内容不是D或D的子类
		//B[] 
	}
}
