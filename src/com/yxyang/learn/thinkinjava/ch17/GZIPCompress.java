package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 压缩文件成gzip格式, 读取gzip文件
 * @author yxyang
 *
 */
public class GZIPCompress {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.exit(1);
		}
		
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
		
		int c;
		while((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
		
		System.out.println("read gzip file");
		
		BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
		String s;
		while ((s = in2.readLine()) != null) {
			System.out.println(s);
		}
		in2.close();
	}
}
