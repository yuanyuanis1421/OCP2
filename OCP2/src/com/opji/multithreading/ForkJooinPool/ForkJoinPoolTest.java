package com.opji.multithreading.ForkJooinPool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {

	public static void main(String[] args) {
		ForkJoinPool fjpool = new ForkJoinPool();
		
		
		System.out.println(Runtime.getRuntime().availableProcessors());// N�mero de procesadores disponibles
		System.out.println(fjpool.getParallelism());                   // Nivel de paralelismo
		
		
	
	}

}
