package com.yxyang.learn.thinkinjava.ch15;

import java.awt.Color;

interface HasColor {
	Color getColor();
}

class Colored<T extends HasColor> {
	T item;
	
	Colored(T item) {
		this.item = item;
	}
	
	T getItem() {
		return item;
	}
	
	Color color() {
		return item.getColor();
	}
}

class Dimension {
	int x;
	int y;
	int z;
}

class ColoredDimension<T extends Dimension & HasColor> {
	private T item;
	ColoredDimension(T item) {
		this.item = item;
	}
	
	T getItem() {
		return item;
	}
	
	Color color() {
		return item.getColor();
	}
	
	int getX() {
		return item.x;
	}
	int getY() {
		return item.y;
	}
	
	int getZ() {
		return item.z;
	}
}

interface Weight {
	int weight();
}

/**
 * 能作为Solid的类 必须继承了Dimension并且实现了HasColor和Weight接口
 * @author yxyang
 *
 * @param <T>
 */
class Solid<T extends Dimension & HasColor & Weight> {
	T item;
	Solid(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
	
	Color color() {
		return item.getColor();
	}
	
	int getX() {
		return item.x;
	}
	int getY() {
		return item.y;
	}
	
	int getZ() {
		return item.z;
	}
	int weight() {
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor, Weight {

	@Override
	public int weight() {
		return 0;
	}

	@Override
	public Color getColor() {
		return null;
	}
}
public class BasicBounds {
	public static void main(String[] args) {
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getX();
	}
}
