package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * File对象可以用来创建目录, 删除文件, 查看文件信息
 * @author yxyang
 *
 */
public class MakeDirectories {
	/**
	 * 打印文件的信息
	 * @param f
	 */
	private static void fileData(File f) {
		System.out.println("absolute path:" + f.getAbsolutePath() + 
				"\n can read:" + f.canRead() +
				"\n can write:" + f.canWrite() +
				"\n getName:" + f.getName() +
				"\n getParent:" + f.getParent() +
				"\n getPath:" + f.getPath() +
				"\n length:" + f.length() +
				"\n lastModified:" + f.lastModified());
		
		if (f.isFile()) {
			System.out.println("it is file");
		} else if (f.isDirectory()) {
			System.out.println("it is directory");
		}
	}
	
	public static void main(String[] args) {
		File f = new File("a");
		fileData(f);
		
		System.out.println(f.mkdir());
		System.out.println(f.delete());
	}
}
