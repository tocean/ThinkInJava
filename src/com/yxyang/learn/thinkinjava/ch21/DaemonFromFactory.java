package com.yxyang.learn.thinkinjava.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 每一个线程池在生成时, 都接受一个ThreadFactory对象, 可以在ThreadFactory对象中设定线程为守护线程
 * @author yxyang
 *
 */
public class DaemonFromFactory implements Runnable {

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
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 10; i++) {
			exec.execute(new DaemonFromFactory());
		}
		
		System.out.println("all daemons started");
		TimeUnit.MILLISECONDS.sleep(1000);
	}

}
