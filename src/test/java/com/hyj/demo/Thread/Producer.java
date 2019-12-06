package com.hyj.demo.Thread;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * wait与sleep
 * 均为Java多线程中会使用到的两个延迟函数。
 * wait()是Object类的方法，所以每一个对象能使用wait()方法。
 * sleep()是Thread类中的静态方法
 *
 * 这两者一起比较的重点主要在于调用这两个方法都可以使当前调用线程暂停执行。
 * 但是sleep不会释放锁，但会让出cpu，sleep会在指定的休眠时间后自动唤醒。
 * wait则会释放锁，让出系统资源，并且加入wait set中，wait不会自动唤醒，而需要notify()或者notifyAll()唤醒
 * Notify和notifyAll
 * Notify: 随机唤醒等待当前对象锁的一个线程
 * notifyAll:notifyAll()方法来通知所有等待当前对象锁的线程，但是一次只会有一个等待的线程能拿到锁
 *
 * 另一个区别在于wait与notify、notifyAll只能在同步代码块中使用，
 * （直接调用编译不会报错，但运行时会抛出异常java.lang.IllegalMonitorStateException），而sleep可以在任何地方使用
 */
public class Producer extends Thread {
	public static Boolean run = true;//控制是否生产和消费
	public static final Integer MAX_CAPACITY = 5;//缓冲区最大数量
	public static final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();//缓冲队列
	@Override
	public void run() {
		while (run) {
			synchronized (queue) {
				while (queue.size() >= MAX_CAPACITY * 2) {
					try {
						System.out.println("缓冲队列已满，等待消费");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				try {
					String string = UUID.randomUUID().toString();
					queue.put(string);
					System.out.println("生产:" + string);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				queue.notify();//通知生产者和消费者
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("main start");
		for (int i=0;i<3;i++){
			new Consumer().start();
		}
		new Producer().start();
		System.out.println("main end");
	}



}

class Consumer extends Thread {
	@Override
	public void run() {
		while (Producer.run) {
			synchronized (Producer.queue) {
				while (Producer.queue.isEmpty()) {
					try {
						System.out.println("队列为空，等待生产");
						Producer.queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				try {
					System.out.println("消费：" + Producer.queue.take());
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Producer.queue.notifyAll();//通知生产者和消费者
			}
		}
	}
}