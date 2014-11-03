package com.yxyang.learn.thinkinjava.ch14;

public class Pet {
	private String name;
	public Pet(String name) {
		this.name = name;
	}
	
	public Pet() {
		name = "Pet";
	}
	
	@Override
	public String toString() {
		return name;
	}
}
