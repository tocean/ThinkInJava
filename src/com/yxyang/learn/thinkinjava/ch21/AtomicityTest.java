package com.yxyang.learn.thinkinjava.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
	
	private int i = 0;
	
	/**
	 * 如果想要保证原子操作, 这里需要加上synchronized关键字
	 * @return
	 */
	private int getValue() {
		return i;
	}
	
	public synchronized void eventIncrement() {
		i++;
		i++;
	}
	
	
	@Override
	public void run() {
		while (true) {
			eventIncrement();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		
		Thread.sleep(1);
		System.out.println(at.getValue());
		while (true) {
			int val = at.getValue();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}

}
