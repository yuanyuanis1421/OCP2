package com.opji.multithreading.collections.blockingQueues;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
	
	private static final SynchronousQueue<String> queue = new SynchronousQueue<String>();
	private static final String EVENT = "event";
	
	
	public static void main(String[] args) {
		
		
		Thread producer = new Thread(new Runnable() {
			
			
			public void run()   {
				for(int i = 0; i<30;i++){
					
					
						String element = new StringBuilder(EVENT).append(i).toString();
					try {
						queue.put(element);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					//	System.out.println(i+") PRODUCER: "+ element);
					
					
				}			
			}
		});
		
		producer.start();
		
		Thread consumer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<30;i++){
					try {
						if(i==25){
							producer.interrupt();
						}
						String element = queue.take();
						System.out.println(i+") CONSUMER: "+element);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		consumer.start();

	}

}
