package com.yxyang.learn.thinkinjava.ch14;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

	private static String[] typeNames = {
			"com.yxyang.learn.thinkinjava.ch14.Mutt",
			"com.yxyang.learn.thinkinjava.ch14.Pug",
			"com.yxyang.learn.thinkinjava.ch14.EgyptionMau",
			"com.yxyang.learn.thinkinjava.ch14.Manx",
			"com.yxyang.learn.thinkinjava.ch14.Cymric",
			"com.yxyang.learn.thinkinjava.ch14.Rat",
			"com.yxyang.learn.thinkinjava.ch14.Mouse",
			"com.yxyang.learn.thinkinjava.ch14.Hamster"};

	static {
		loader();
	}

	@SuppressWarnings("unchecked")
	static void loader() {
		try {
			for (String name : typeNames) {
				types.add((Class<? extends Pet>) Class.forName(name));
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}
	
	
	public static void main(String[] args) {
	}

}
