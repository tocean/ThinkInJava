package com.yxyang.learn.thinkinjava.ch17;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 交换相邻字符串
 * @author yxyang
 *
 */
public class UsingBuffers {
	private static void symmetricScramble(CharBuffer buf) {
		while (buf.hasRemaining()) {
			buf.mark();
			char c1 = buf.get();
			char c2 = buf.get();
			buf.reset();
			buf.put(c2).put(c1);
		}
	}
	public static void main(String[] args) {
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
	}
}
