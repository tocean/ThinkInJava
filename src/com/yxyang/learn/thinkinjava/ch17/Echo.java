package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读取标准输入, 并输出
 * @author yxyang
 *
 */
public class Echo {
	public static void main(String[] args) throws IOException {
		//把System.in封装成BufferedReader
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while ((s = stdin.readLine()) != null && s.length() != 0) {
			System.out.println(s);
		}
		stdin.close();
	}
}
