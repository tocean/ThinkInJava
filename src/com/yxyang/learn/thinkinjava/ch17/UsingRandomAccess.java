package com.yxyang.learn.thinkinjava.ch17;

import java.io.RandomAccessFile;

public class UsingRandomAccess {
	private static String file = "rtest.data";
	
	private static void display() throws Exception {
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++) {
			System.out.println(rf.readDouble());
		}
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void main(String[] args) throws Exception {
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		//写入7个double, 1个string
		for (int i = 0; i < 7; i++) {
			rf.writeDouble(i * 1.414);
		}
		rf.writeUTF("the end of the file");
		rf.close();
		display();
		rf = new RandomAccessFile(file, "rw");
		rf.seek(8 * 5); //定位到第40个字节
		rf.writeDouble(47.0001);
		rf.close();
		
		display();
	}
}
