package com.yxyang.learn.thinkinjava.ch21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {
	
	//原子操作
	private AtomicInteger i = new AtomicInteger(0);
	public int getValue() {
		return i.get();
	}
	
	private void eventIncrement() {
		i.addAndGet(2);
	}
	
	@Override
	public void run() {
		while (true) {
			eventIncrement();
		}
	}
	
	public static void main(String[] args) {
		Collection<String> c = Collections.synchronizedCollection(new ArrayList<String>());
		
		Iterator<String> it = c.iterator();
		c.add("");
		
		it.next();
		//5秒之后自动关闭
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.err.println("aborting");
				System.exit(0);
			}
		}, 5000);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		AtomicIntegerTest ai = new AtomicIntegerTest();
		exec.execute(ai);
		
		while (true) {
			int val = ai.getValue();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(1);
			}
		}
		
	}
}
