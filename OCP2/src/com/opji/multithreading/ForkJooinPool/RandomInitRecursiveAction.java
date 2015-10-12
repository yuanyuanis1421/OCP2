package com.opji.multithreading.ForkJooinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("serial")
public class RandomInitRecursiveAction extends RecursiveAction {


	private int start;
	private int end;
	private int[] data;
	private static final int THRESHOLD = 1000;
	
	RandomInitRecursiveAction(int start, int end, int[] data){
		this.start = start;
		this.end = end;
		this.data = data;
	}

	
	@Override
	protected void compute() {
	
		
		if(end - start <= THRESHOLD){                //Es pequeño
			for(int i = 0; i <=(end-start); i++){
				for(int j=0; j<=100;j++){
					data[i]=ThreadLocalRandom.current().nextInt();
				}
			}
		}else{										// tarea demasiado grande dividir
			int half = ((end-start)/2) + start;
			RandomInitRecursiveAction initRecursiveAction = new RandomInitRecursiveAction(start, half, data);
			initRecursiveAction.fork(); // encolamos la parte izquierda
			RandomInitRecursiveAction initRecursiveAction2 = new RandomInitRecursiveAction(half, end , data);
			initRecursiveAction2.compute();// trabajamos con la parte derecha
			initRecursiveAction.join();
		}
	}
	
	public static void main (String ...args){
		int data[] = new int[10000000];
		long timeIni = System.currentTimeMillis();
		
		ForkJoinPool fjPool = new ForkJoinPool();
		
		RandomInitRecursiveAction recursiveAction = new RandomInitRecursiveAction(0, data.length, data);
		
		/*RandomInitRecursiveAction recursiveAction = new RandomInitRecursiveAction(0, data.length, data);
		recursiveAction.compute();*/
		fjPool.invoke(recursiveAction);
		
		long timeEnd = System.currentTimeMillis();
	    long timeResult = timeEnd - timeIni ;
	    System.out.println("El tiempo transcurrido con RecursiveAction " + timeResult);
			    
	    timeIni = System.currentTimeMillis();
		doYourSelf();
		timeEnd = System.currentTimeMillis();
		
		timeResult = timeEnd - timeIni;
		System.out.println("El tiempo transcurrido un solo Thread " + timeResult);
	}
	private static void  doYourSelf(){
		int data[] = new int[10000000];
		for (int i = 0; i < data.length; i++) {
			for(int j=0; j<=100;j++){
				data[i]=ThreadLocalRandom.current().nextInt();
			}
		}
	}

}
