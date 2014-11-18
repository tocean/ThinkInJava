package com.yxyang.learn.thinkinjava.ch17;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ViewBuffer {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
		bb.rewind();
		
		while(bb.hasRemaining()) {
			System.out.print(bb.position() + " ->" + bb.get() + ",");
		}
		System.out.println();
		
		IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
		while (ib.hasRemaining()) {
			System.out.print(ib.position() + " ->" + ib.get() + ",");
		}
	}
}
