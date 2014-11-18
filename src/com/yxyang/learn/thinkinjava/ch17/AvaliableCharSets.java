package com.yxyang.learn.thinkinjava.ch17;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * 打印系统所有可用的字符
 * @author yxyang
 *
 */
public class AvaliableCharSets {
	public static void main(String[] args) {
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
		
		Iterator<String> it = charSets.keySet().iterator();
		while (it.hasNext()) {
			String csName = it.next();
			System.out.print(csName);
			
			//别名
			Iterator<String> aliases = charSets.get(csName).aliases().iterator();
			if (aliases.hasNext()) {
				System.out.print(": ");
			}
			
			while(aliases.hasNext()) {
				System.out.print(aliases.next());
				if (aliases.hasNext()) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}
}
