package com.opji.multithreading.ForkJooinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
class FindMaxPositionRecursiveTask extends RecursiveTask<Integer> {

	
	private static final int THRESHOLD = 1000;
	private int start;
	private int end;
	private int[] data;
	
	FindMaxPositionRecursiveTask(int start, int end, int[] data) {
		
		this.start = start;
		this.end = end;
		this.data = data;
		
	}
	
	
	@Override
	protected Integer compute() {
		if(end-start <= THRESHOLD){    // la tare es pequeña 
			int position = 0;
			for(int i = start; i< end;i++){
				if(data[i]>data[position]){
					position = i;
				}
			}
			return position;
		}else{
			
			int halfWay = ((end - start)/2) + start;
			FindMaxPositionRecursiveTask  taskLeft= new FindMaxPositionRecursiveTask(start, halfWay, data);
			
			taskLeft.fork(); //encolamos la zona de la izquierda
			
			FindMaxPositionRecursiveTask taskRight = new FindMaxPositionRecursiveTask(halfWay, end, data);
			int positionLeft = taskRight.compute(); // ejecutamos la parte derecha
			int positionRight = taskLeft.join(); //esperamos a que acabe la parte derecha
			
			if(data[positionRight]>data[positionLeft]){
				return positionRight;
			}else{
				return positionLeft;
			}
		}
		
	}
	
	public static void main(String ...args){
		
		int[] data = new int[10000000];
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		RandomInitRecursiveAction recursiveAction = new RandomInitRecursiveAction(0, data.length, data);
		forkJoinPool.invoke(recursiveAction);
		
		FindMaxPositionRecursiveTask task = new FindMaxPositionRecursiveTask(0, data.length, data);
		Integer position = forkJoinPool.invoke(task);
		System.out.println("La posicion: "+ position +"tiene el valor: "+data[position]);
	}

}
