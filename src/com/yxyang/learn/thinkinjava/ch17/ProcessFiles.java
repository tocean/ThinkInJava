package com.yxyang.learn.thinkinjava.ch17;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
	public interface Strategy {
		void process(File file);
	}
	
	private String ext;
	private Strategy strategy;
	
	public ProcessFiles(Strategy strategy, String ext) {
		this.ext = ext;
		this.strategy = strategy;
	}
	
	/**
	 * 处理目录
	 * @param root
	 * @throws IOException 
	 */
	public void processDirectoryTree(File root) throws IOException {
		for (File file : Directory.walk(root.getAbsoluteFile(), ".*\\." + ext)) {
			strategy.process(file.getCanonicalFile());
		}
	}
	
	/**
	 * 处理多个参数, 可以是文件或目录, 文件可以不以.ext结尾
	 * @param args
	 * @throws IOException 
	 */
	public void start(String[] args) {
		try {
			if (args.length == 0) {
				processDirectoryTree(new File("."));
			} else {
				for (String arg : args) {
					File fileArg = new File(arg);
					if (fileArg.isDirectory()) {
						processDirectoryTree(fileArg);
					} else {
						if (!arg.endsWith("." + ext)) {
							arg += "." + ext;
						}
						
						strategy.process(fileArg);
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new ProcessFiles(new Strategy() {
			
			@Override
			public void process(File file) {
				System.out.println(file);
				
			}
		}, "java").start(args);
	}
}
