package com.yxyang.learn.thinkinjava.ch14;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {
	static class PetCount extends LinkedHashMap<Class<? extends Pet>, Integer> {
		PetCount() {
			super(MapData.map(LiteralPetCreator.allTypes, 0));
		}
		
		public void count(Pet pet) {
			for (Map.Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
				if (entry.getKey().isInstance(pet)) {
					put(entry.getKey(), entry.getValue() + 1);
				}
			}
		}
		
		public static void main(String[] args) {
			PetCount petCount = new PetCount();
			for (Pet pet : Pets.arrayList(20)) {
				petCount.count(pet);
			}
			
			System.out.println(petCount);
		}
	}
}
