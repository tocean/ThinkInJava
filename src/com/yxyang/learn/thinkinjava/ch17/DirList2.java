package com.yxyang.learn.thinkinjava.ch17;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
	public static FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}

	public static void main(String[] args) {
		File path = new File(".");

		String[] list = null;
		if (args.length == 0) {
			list = path.list();
		} else {
			path.list(filter(args[0]));
		}

		// 排序
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
