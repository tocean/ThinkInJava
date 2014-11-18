package com.yxyang.learn.thinkinjava.ch21;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程, 如果所有的用户线程都结束了, jvm进程结束
 * @author yxyang
 *
 */
public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		
		System.out.println("all daemons thread start");
		TimeUnit.MILLISECONDS.sleep(2000L);
	}
}
