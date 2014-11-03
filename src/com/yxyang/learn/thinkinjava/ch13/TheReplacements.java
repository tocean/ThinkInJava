package com.yxyang.learn.thinkinjava.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*! herer's a block of test to use as input to
    the regular expression matcher. note that we'll
    first extract  !*/

public class TheReplacements {
	public static void main(String[] args) throws IOException {
		InputStream is = TheReplacements.class.getClassLoader().getResourceAsStream(
				"test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String str = null;
		StringBuilder strBuilder = new StringBuilder();
		while((str = br.readLine()) != null) {
			strBuilder.append(str);
			strBuilder.append("\n");
		}
		br.close();
		is.close();
		
		String s = strBuilder.toString();
		Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		
		//去掉
		if (mInput.find()) {
			s = mInput.group(1);
		}
		System.out.println(s);
		
		s = s.replaceAll(" {2,}", " ");
		System.out.println(s);
		
		s = s.replaceAll("(?m)^ +", "");
		System.out.println(s);
		
		s = s.replaceFirst("[aeiou]", "(VOWEL)");
		System.out.println(s);
		
		//把小写的aeiou替换成大写的
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		
		StringBuffer sbuf = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sbuf, m.group().toUpperCase());
		}
		m.appendTail(sbuf);
		
		System.out.println(sbuf.toString());
	}
}
