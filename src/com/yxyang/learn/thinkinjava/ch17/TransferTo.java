package com.yxyang.learn.thinkinjava.ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 在两个通道之间传输数据
 * @author yxyang
 *
 */
public class TransferTo {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.exit(1);
		}
		
		FileChannel in = new FileInputStream(args[0]).getChannel();
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		
		in.transferTo(0, in.size(), out);
	}
}
