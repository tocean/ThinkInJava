package com.yxyang.learn.thinkinjava.ch14;

import java.util.ArrayList;

/**
 * 外观模式
 * @author yxyang
 *
 */
public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();
	
	public static Pet randomPet() {
		return creator.randomPet();
	}
	
	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}
	
	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}
}
