package com.opji.multithreading.CExcutors;


import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class EMyCalleable implements Callable<Integer> {
	
	@Override
	public Integer call(){
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for(int i = 1; i<= count; i++){
			System.out.println("procesing ..." +i);
		}
		return count;
	}
	
	public static void main(String ...args){
		Callable<Integer> call = new EMyCalleable();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Integer> future = executorService.submit(call);
		try {
			Integer v = future.get();
			System.out.println("Ran ..."+v);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("FAILED");
		}
		
		executorService.shutdown();//No more tasks
									//But finishing current tasks
		try {
			boolean termindo = executorService.awaitTermination(2, TimeUnit.SECONDS);
			//wait 2 SECONDS to running task to finish
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(executorService.isTerminated()){
				List<Runnable> unfinished = executorService.shutdownNow();
			}
		}
	}
}
