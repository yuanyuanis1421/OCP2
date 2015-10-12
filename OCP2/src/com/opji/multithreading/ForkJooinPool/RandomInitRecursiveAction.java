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

	
	@Override //Estamos obligados a implementar este método de la clase RecursiveAction
	protected void compute() {						
	
		
		if(end - start <= THRESHOLD){                //¿Es suficientemente pequeño para realizar la tarea solo?.
			for(int i = 0; i <=(end-start); i++){
				for(int j=0; j<=100;j++){
					data[i]=ThreadLocalRandom.current().nextInt();
				}
			}
		}else{										 // Tarea demasiado grande, dividir.
			int half = ((end-start)/2) + start;
			
			RandomInitRecursiveAction initRecursiveAction = new RandomInitRecursiveAction(start, half, data);
			initRecursiveAction.fork();				 // Encolamos la parte izquierda.
			
			RandomInitRecursiveAction initRecursiveAction2 = new RandomInitRecursiveAction(half, end , data);
			initRecursiveAction2.compute();			 // Trabajamos con la parte derecha.
			
			initRecursiveAction.join();				 // Hasta que no acabamos la parte derecha no continuamos
													 // con la izquierda-
		}
	}
	
	
	public static void main (String ...args){
		
		long timeIni, timeEnd;
		int data[] = new int[10000000];				 // Número de vallas a pintar
		/**Constructor*/
		RandomInitRecursiveAction recursiveAction = new RandomInitRecursiveAction(0, data.length, data);	
		
		
		/** Realizamos invocación Recursiva con varios Threads(Tantos como ForkJoinPool considere en función de procesadores disponibles)*/
		timeIni = System.currentTimeMillis();
		ForkJoinPool fjPool = new ForkJoinPool();
		fjPool.invoke(recursiveAction);			
		timeEnd = System.currentTimeMillis();
	    System.out.println("El tiempo transcurrido con RecursiveAction: " + (timeEnd - timeIni));    
	    
	    
	    /**TESTEAMOS TIEMPOS CON UN SOLO THREAD PARA COMPARAR*/
	    timeIni = System.currentTimeMillis();
		doYourSelf();							
		timeEnd = System.currentTimeMillis();
		System.out.println("El tiempo transcurrido un solo Thread: " + (timeEnd - timeIni));
	
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
