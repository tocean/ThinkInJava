package com.yxyang.learn.thinkinjava.ch17;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 使用试图缓冲器, 读写int
 * 
 * @author yxyang
 *
 */
public class IntBufferDemo {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(1024);
		IntBuffer ib = bb.asIntBuffer();
		
		ib.put(new int[] { 11, 42, 47, 99, 143, 811, 1016 });
		System.out.println(ib.get(3));
		ib.put(3, 1811);
		
		ib.flip();
		while (ib.hasRemaining()) {
			System.out.println(ib.get());
		}
		
	}
}
