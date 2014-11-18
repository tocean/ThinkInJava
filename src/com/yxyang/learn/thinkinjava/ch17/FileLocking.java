package com.yxyang.learn.thinkinjava.ch17;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 文件加锁
 * @author yxyang
 *
 */
public class FileLocking {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream(new File("file.txt"));
		
		FileLock fl = fos.getChannel().tryLock();
		if (fl != null) {
			System.out.println("locked file");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			System.out.println("release lock");
		}
		fos.close();
	}
}
