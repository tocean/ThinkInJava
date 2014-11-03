package com.yxyang.learn.thinkinjava.ch17;

import java.io.StringReader;

/**
 * StringBuilder,以String对象作为输入
 * @author yxyang
 *
 */
public class MemoryInput {
	public static void main(String[] args) throws Exception {
		StringReader in = new StringReader(BufferedInputFile.read(".project"));
		int c;
		while ((c = in.read()) != -1) {
			System.out.print((char)c);
		}
		
	}
}
