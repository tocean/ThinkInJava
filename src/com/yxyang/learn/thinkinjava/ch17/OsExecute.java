package com.yxyang.learn.thinkinjava.ch17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 执行os命令
 * @author yxyang
 *
 */
public class OsExecute {
	public static void command(String command) {
		boolean err = false;
		
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			System.out.println("sleep over");
			
			//以进程的输出作为输入流
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String s;
			while ((s = results.readLine()) != null) {
				System.out.println(s);
			}
			results.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		command("ls -al");
	}
}
