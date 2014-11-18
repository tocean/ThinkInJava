package com.yxyang.learn.thinkinjava.ch21;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程创建的线程, 也是守护线程
 * @author yxyang
 *
 */
class Daemon implements Runnable {
	private Thread[] t = new Thread[10];
	
	@Override
	public void run() {
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started");
		}
		
		for (int i = 0; i < t.length; i++) {
			System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon());
		}
		while(true) {
			Thread.yield();
		}
	}
}

class DaemonSpawn implements Runnable {
	@Override
	public void run() {
		while (true) {
			Thread.yield();
		}
	}
}

public class Daemons {
	public static void main(String[] args) throws InterruptedException {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		
		TimeUnit.SECONDS.sleep(1);
	}
}
