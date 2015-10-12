package com.opji.multithreading.AReetrantReadWriteLock;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MaxValueColection {

	
	List<Integer> lista = new ArrayList<Integer>();
	
	ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	
	public void add(Integer i){						// Un solo hilo por escritura.
		reentrantReadWriteLock.writeLock().lock();
		try{
			lista.add(i);
		}finally{
			reentrantReadWriteLock.writeLock().unlock();
		}
	}
	
	public int findMax(){							// multiples hilos lectores concurrentes
		reentrantReadWriteLock.readLock().lock();
		try{
			return Collections.max(lista);
		}finally{
			reentrantReadWriteLock.readLock().unlock();
		}
	}
	public int findMin(){							// multiples hilos lectores concurrentes
		reentrantReadWriteLock.readLock().lock();
		try{
			return Collections.min(lista);
		}finally{
			reentrantReadWriteLock.readLock().unlock();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		MaxValueColection maxValueColection = new MaxValueColection();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<=10000000;i++){  //Rellenamos la lista
					maxValueColection.add(ThreadLocalRandom.current().nextInt(0,999999999));
				}
			}
		});
		
		t1.start();
		t1.join();
		
		System.out.println("Maximo: "+maxValueColection.findMax());
		System.out.println("Minimo: "+maxValueColection.findMin());

	}

}
