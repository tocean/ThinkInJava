package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
	/**
	 * 读取文件内容
	 * 
	 * @param fileName
	 * @return
	 */
	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();

		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(
					fileName).getAbsoluteFile()));

			String s;
			try {
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 把字符串写入到文件中
	 * 
	 * @param fileName
	 * @param text
	 */
	public static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());

			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 构造函数, 读取文件内容,用splitter分割, 放到数组中
	 * 
	 * @param fileName
	 * @param splitter
	 */
	public TextFile(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));

		if (get(0).equals("")) {
			remove(0);
		}
	}

	/**
	 * 默认用\n进行分割
	 * 
	 * @param fileName
	 */
	public TextFile(String fileName) {
		this(fileName, "\n");
	}

	/**
	 * 把数组内容写入到文件中, 换行分割
	 * 
	 * @param fileName
	 */
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				for (String item : this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {

		}
	}

	public static void main(String[] args) {
		//调用静态文件读写文件
		String file = read(".project");
		write("text.txt", file);
		
		TextFile text = new TextFile("text.txt");
		text.write("text2.txt");
		
		TreeSet<String> words = new TreeSet<String>(new TextFile(".project", "\\W+"));
		//小于a的key, 包括数字和大写开头的单词
		System.out.println(words.headSet("a"));
	}
}
