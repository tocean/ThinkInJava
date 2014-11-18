package com.yxyang.learn.thinkinjava.ch17;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

/**
 * 向ByteBuffer中写入数据, 读取数据
 * @author yxyang
 *
 */
public class GetData {
	public static void main(String[] args) {
		ByteBuffer buff = ByteBuffer.allocate(1024);
		int i = 0;
		while (i++ < 1024) {
			if (buff.get() != 0) {
				System.out.println("non-zero");
			}
		}
		System.out.println(i);
		buff.rewind();
		
		ShortBuffer sb = buff.asShortBuffer(); //此调用每次都返回一个新对象
		sb.put((short)1234);
		sb.put((short)5678);
		System.out.println(sb.position());
		System.out.println(buff.getShort());	
		System.out.println(buff.getShort());	
		buff.rewind();
	}
}
