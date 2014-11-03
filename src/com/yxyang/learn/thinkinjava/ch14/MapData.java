package com.yxyang.learn.thinkinjava.ch14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapData <K, V> {
	public static <K,V> Map<K, V> map(List<K> list, V value) {
		if (list == null) {
			return null;
		}
		
		Map<K, V> map = new HashMap<K, V>();
		for (K key : list) {
			map.put(key, value);
		}
		
		return map;
	}
}
