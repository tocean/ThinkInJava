package com.yxyang.learn.thinkinjava.ch17;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
	public static void main(final String[] args) {
		File path = new File(".");

		String[] list = null;
		if (args.length == 0) {
			list = path.list();
		} else {
			path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return pattern.matcher(name).matches();
				}
			});
		}

		// 排序
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
