package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFile {
	public static byte[] read(File file) throws IOException {
		BufferedInputStream br = new BufferedInputStream(new FileInputStream(
				file));
		try {
			byte[] data = new byte[br.available()];
			br.read(data);
			return data;
		} finally {
			br.close();
		}
	}
	
	public static byte[] read(String bFile) throws IOException {
		return read(new File(bFile));
	}

	public static void main(String[] args) {
		
	}
}
