package com.yxyang.learn.thinkinjava.ch17;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 内存映射io的效率
 * @author yxyang
 *
 */
public class MappedIO {
	private static int numOfInts = 4000000;
	private static int numOfUbuffInts = 200000;
	private abstract static class Tester {
		private String name;
		
		public Tester(String name) {
			this.name = name;
		}
		
		public void runTest () {
			System.out.print(name + ":");
			
			try {
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration/1.0e9);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public abstract void test() throws IOException;
	}
	
	private static Tester[] tests = {
		new Tester("Stream Read/Write") {
			
			@Override
			public void test() throws IOException {
				RandomAccessFile raf = new RandomAccessFile("temp.tmp", "rw");
				
				raf.writeInt(1);
				for (int i = 0; i < numOfUbuffInts; i++) {
					raf.seek(raf.length() - 4);
					raf.writeInt(raf.readInt());
				}
				raf.close();
			}
		},
		
		new Tester("Mapped Read/Write") {
			
			@Override
			public void test() throws IOException {
				FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
				IntBuffer ib = fc.map(MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				ib.slice();
				ib.put(0);
				for (int i = 1; i < numOfUbuffInts; i++) {
					ib.put(ib.get(i - 1));
				}
				fc.close();
			}
		}
	};
	
	public static void main(String[] args) {
		for (Tester test : tests) {
			test.runTest();
		}
	}
}
