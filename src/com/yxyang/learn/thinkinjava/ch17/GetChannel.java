package com.yxyang.learn.thinkinjava.ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	private static final int BSIZE = 1024;
	
	public static void main(String[] args) throws Exception {
		//写入文件
		FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
		FileChannel fc = fileOutputStream.getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		
		//再次写入文件
		fc = new RandomAccessFile("data.txt", "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("some more".getBytes()));
		fc.close();
		
		//读取文件
		fc = new FileInputStream("data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		while (buff.hasRemaining()) {
			System.out.print((char)buff.get());
		}
		System.out.println();
		fc.close();
	}
}
