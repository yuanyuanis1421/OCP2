package com.opji.multithreading.nonBlockingAlgorithms;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	
	private AtomicInteger atomicInteger = new AtomicInteger();
	
	public int get(){
		return atomicInteger.get();
	}
	
	public int increment(){
		return atomicInteger.incrementAndGet();
	}
}
