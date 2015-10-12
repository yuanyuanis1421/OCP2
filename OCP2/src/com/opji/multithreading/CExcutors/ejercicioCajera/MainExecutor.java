package com.opji.multithreading.CExcutors.ejercicioCajera;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
	
	private static final int numCajeras = 1024;
	
	public static void main(String ...args){
		List<Cliente>  list = new ArrayList<Cliente>();
		
		list.add(new Cliente("Cliente 1", new int[] {1, 2,3,4,5})); //15 sec
		list.add(new Cliente("Cliente 2", new int[] {1, 2,3,4,1})); //11 sec
		list.add(new Cliente("Cliente 3", new int[] {1, 2,3,1,1})); //8 sec
		list.add(new Cliente("Cliente 4", new int[] {1, 2,3,1,5})); //12 sec
		list.add(new Cliente("Cliente 5", new int[] {1, 2,2,2,2})); //9 sec
		list.add(new Cliente("Cliente 6", new int[] {1, 2,1,1,1})); //6 sec
		list.add(new Cliente("Cliente 7", new int[] {2, 5,3,4,5})); //19 sec
		list.add(new Cliente("Cliente 8", new int[] {2, 2,2,1,3})); //10 sec
		// total 90 sec
		
		ExecutorService executorService = Executors.newFixedThreadPool(numCajeras);
		long initialTime = System.currentTimeMillis();
		
		
		for (Cliente cliente : list) {
			Runnable runnable =new CajereraRunnable(cliente, initialTime);
			executorService.execute(runnable);
		}
		executorService.shutdown();// cierro el ejecutor
		while(!executorService.isTerminated()){
			Thread.currentThread();
			//Aquí espero en bucle hasta que las tareas se completen.
			Thread.yield();
		}
		
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("El tiempo final es: " + (tiempoFinal - initialTime)/1000 +"sec");
		
	}
}
