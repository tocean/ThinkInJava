package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author yxyang
 *
 */
public class ZipCompress {
	public static void main(String[] args) throws IOException {
		
		//把多个文件压缩成zip格式
		FileOutputStream f = new FileOutputStream("test.zip");
		CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("a test of java zipping");
		
		for (String arg : args) {
			System.out.println("writing file " + arg);
			BufferedReader in = new BufferedReader(new FileReader(arg));
			zos.putNextEntry(new ZipEntry(arg));
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			in.close();
			out.flush();
		}
		
		out.close();
		
		System.out.println("Checksum:" + csum.getChecksum().getValue());
		
		System.out.println("read files");
		FileInputStream fi = new FileInputStream("test.zip");
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		ZipInputStream zi = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(zi);
		
		ZipEntry ze;
		while((ze = zi.getNextEntry()) != null) {
			System.out.println("reading file " + ze);
			int x;
			while((x = bis.read()) != -1) {
				System.out.write(x);
			}
		}
		System.out.println("Checksum:" + csumi.getChecksum().getValue());
		bis.close();
	}
}
