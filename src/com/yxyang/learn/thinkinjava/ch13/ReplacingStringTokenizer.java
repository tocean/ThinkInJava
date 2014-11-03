package com.yxyang.learn.thinkinjava.ch13;

import java.util.StringTokenizer;

public class ReplacingStringTokenizer {
	public static void main(String[] args) {
		StringTokenizer token = new StringTokenizer("I feel\thappy\nff");
		while (token.hasMoreElements()) {
			System.out.println(token.nextToken());
		}
	}
}
