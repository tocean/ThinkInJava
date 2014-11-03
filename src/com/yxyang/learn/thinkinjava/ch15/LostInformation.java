package com.yxyang.learn.thinkinjava.ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Frob {
	
}

class Fnorkle {
	
}

class Quark <T> {
	
}

class Particle<POSITION, MOMENTUM> {
	
}

public class LostInformation {
	public static void main(String[] args) {
		List<Frob> list = new ArrayList<Frob>();
		
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		
		//没有泛型时list的用法
		List oldList = new ArrayList();
		oldList.add(3);
		
		Integer i = (Integer) oldList.get(0);
	}
}
