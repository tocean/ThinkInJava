package com.yxyang.learn.thinkinjava.ch15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ByteSet {
	public static void main(String[] args) {
		Byte[] pos = {1,2,3,4,5,6,7,8,9};
		Set<Byte> myset = new HashSet<Byte>(Arrays.asList(pos));
		
		Set<Byte> myset2 = new HashSet<Byte>(Arrays.<Byte>asList(pos));
	}
}
