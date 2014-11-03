package com.yxyang.learn.thinkinjava.ch17;

public class DirectoryDemo {
	public static void main(String[] args) {
		PPrint.pprint(Directory.walk(".").dirs);
		System.out.println("=========================");
		
		PPrint.pprint(Directory.walk(".", "Eras.*").files);
		
	}
}
