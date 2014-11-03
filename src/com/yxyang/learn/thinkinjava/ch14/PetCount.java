package com.yxyang.learn.thinkinjava.ch14;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 计数
 * @author yxyang
 *
 */
public class PetCount {
	static class PetCounter extends HashMap<String, Integer> {
		public void count(String type) {
			Integer quanlity = get(type);
			if (quanlity == null) {
				put(type, 1);
			} else {
				put(type, quanlity + 1);
			}
		}
	}
	
	public static void countPets(PetCreator creator) {
		PetCounter counter = new PetCounter();
		
		for (Pet pet : creator.createArray(20)) {
			System.out.println(pet.getClass().getSimpleName());
			if (pet instanceof Pet) {
				counter.count("Pet");
			} 
			if (pet instanceof Dog) {
				counter.count("Dog");
			}
			if (pet instanceof Mutt) {
				counter.count("Mutt");
			}
		}
		System.out.println(counter);
	}
	
	public static void main(String[] args) {
		countPets(new ForNameCreator());
	}
} 
