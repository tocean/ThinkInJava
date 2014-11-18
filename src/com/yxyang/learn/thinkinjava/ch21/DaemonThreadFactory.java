package com.yxyang.learn.thinkinjava.ch21;

import java.util.concurrent.ThreadFactory;

/**
 * 线程工厂, 把所有线程设定为守护线程
 * @author yxyang
 *
 */
public class DaemonThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
}
