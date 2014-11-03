package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringBufferInputStream;

/**
 * 经典的读取文件内容的代码
 * @author yxyang
 *
 */
public class BufferedInputFile {
	
	public static String read(String fileName) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
		
		String s = null;
		StringBuilder sb = new StringBuilder();
		
		while ((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(read(".project"));
	}
}
