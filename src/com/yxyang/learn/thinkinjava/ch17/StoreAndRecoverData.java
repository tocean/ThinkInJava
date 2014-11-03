package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 存储和恢复数据
 * @author yxyang
 *
 */
public class StoreAndRecoverData {
	public static void main(String[] args) throws Exception {
		//向文件中写入, 支持缓存
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
		
		out.writeDouble(3.1415926);
		out.writeUTF("this is pai");
		
		out.writeDouble(1.41413);
		out.writeUTF("square of 2");
		out.close();
		
		//读取文件
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		in.close();
	}
}
