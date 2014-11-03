package com.yxyang.learn.thinkinjava.ch17;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 显示目录下的文件列表, 并且支持过滤
 * @author yxyang
 *
 */
public class DirList {
	public static void main(String[] args) {
		File path = new File(".");
		
		String[] list = null;
		if (args.length == 0) {
			list = path.list();
		} else {
			path.list(new DirFilter(args[0]));
		}
		
		//排序
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}

class DirFilter implements FilenameFilter {
	private Pattern pattern;
	
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}
