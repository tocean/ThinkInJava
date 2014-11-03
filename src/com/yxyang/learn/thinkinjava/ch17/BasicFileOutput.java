package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 写入到文件
 * @author yxyang
 *
 */
public class BasicFileOutput {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(".project")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("testout"))));
		
		String line = null;
		while ((line = in.readLine()) != null) {
			out.println(line);
		}
		
		in.close();
		out.close();
	}
}
