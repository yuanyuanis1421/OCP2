package com.opji.multithreading.AReentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {
	
	private  int  count = 0;
	
	private Lock lock = new ReentrantLock();
	
	Condition condition = lock.newCondition();
	
	private void increment(){
		for(int i = 0; i<10000;i++){
			count++;
		}
	}
	
	public  void  firstThread() throws InterruptedException{
		lock.lock();
		
		System.out.println("Waiting ...");
		condition.await();
		System.out.println("Wake up");
		
		try{	
			increment();
		}finally{
			lock.unlock();
		}
	}
	
	public  void secondThread() throws InterruptedException{
		lock.lock();
		
		Thread.sleep(500);
		System.out.println("Press Enter key to continue:");
		new Scanner(System.in).nextLine();
		System.out.println("Enter key pressed");
		condition.signal();
		
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}
	
	public void finished(){
		System.out.println(count);
	}

}
