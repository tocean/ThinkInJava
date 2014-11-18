package com.yxyang.learn.thinkinjava.ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件复制
 * @author yxyang
 *
 */
public class ChannelCopy {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.exit(1);
		}
		
		FileChannel in = new FileInputStream(args[0]).getChannel();
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		
		while (in.read(buff) != -1) {
			buff.flip();
			out.write(buff);
			buff.clear();
		}
		
		in.close();
		out.close();
	}
}
