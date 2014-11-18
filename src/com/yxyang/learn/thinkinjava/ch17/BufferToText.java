package com.yxyang.learn.thinkinjava.ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	public static void main(String[] args) throws IOException {
		// 写入文件, 从文件中读取, 然后调用ByteBuffer.asCharBuffer进行输出, 但是是乱码
		FileChannel fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(1024);
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		fc.close();
		buff.rewind();

		// 使用系统默认的编码方式进行解码, 能正常输出
		String encoding = System.getProperty("file.encoding");
		System.out.println("decoding using " + encoding + " "
				+ Charset.forName(encoding).decode(buff));

		// 写文件, 写时指定编码方式
		fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes("UTF-16BE")));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		
		System.out.println(buff.asCharBuffer());
		
		//使用CharBuffer进行写入
		fc = new FileOutputStream("data2.txt").getChannel();
		buff = ByteBuffer.allocate(24);
		buff.asCharBuffer().put("some text");
		fc.write(buff);
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		fc.close();
	}
}
