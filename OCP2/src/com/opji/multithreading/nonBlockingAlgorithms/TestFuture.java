package com.opji.multithreading.nonBlockingAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestFuture {
	
	private static final int NUM_PROCESSORS = Runtime.getRuntime().availableProcessors();
	
	
	@SuppressWarnings("unused")
	public static void main (String ...args){
		
		final Counter counter = new Counter();
		
		List<Future<Integer>> lista = new ArrayList<Future<Integer>>();
		ExecutorService executor = Executors.newFixedThreadPool(NUM_PROCESSORS);
		
		for(int i = 0;i<500;i++){
			Callable<Integer> callable = new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					Integer number = counter.increment();
					System.out.println(number);
					return number;
				}
			};
			
			Future<Integer> item = executor.submit(callable);
			lista.add(item);
		}
		
		List<Runnable> listaRunnables = null;
		try{
			executor.shutdown();
			executor.awaitTermination(220, TimeUnit.MILLISECONDS);
			if(executor.isTerminated()){
				System.out.println("termino");
			}else{
				listaRunnables = executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(Future<Integer> future: lista){
			try {
				 set.add(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		if(lista.size()!= set.size()){
			throw new RuntimeException("Dobles entradas??");
		}
		
	}
}