package com.yxyang.learn.thinkinjava.ch17;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

/**
 * 内存映射文件
 * @author yxyang
 *
 */
public class LargeMappedFiles {
	static int length = 0x8ffffff;
	public static void main(String[] args) throws Exception {
		MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel().map(MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			out.put((byte)'x');
		}
		
		System.out.println("finished writing");
		
		for (int i = length / 2; i < length / 2 + 6; i++) {
			System.out.println((char)out.get(i));
		}
	}
}
