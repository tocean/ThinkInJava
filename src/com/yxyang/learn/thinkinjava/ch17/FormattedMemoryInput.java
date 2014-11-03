package com.yxyang.learn.thinkinjava.ch17;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;

/**
 * 
 * @author yxyang
 *
 */
public class FormattedMemoryInput {
	public static void main(String[] args) throws Exception {
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(
				BufferedInputFile.read(".project").getBytes()));

		try {
			while (true) {
				System.out.print((char)in.readByte());
			}
		} catch (EOFException e) {
			
		}
		
		in.close();
		
		DataInputStream in1 = new DataInputStream(new ByteArrayInputStream(
				BufferedInputFile.read(".project").getBytes()));
		while (in1.available() > 0) {
			System.out.print((char)in1.readByte());
		}
		
		in1.close();
	}
}
