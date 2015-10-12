package com.opji.multithreading.CExcutors;

import java.util.concurrent.Executor;

public class BNewThreadExecutor implements Executor {
	
	
	/**
	 * Este Executor usa un nuevo HILO para cada tarea :
	 */
	@Override
	public void execute(Runnable command) {
		Thread thread = new Thread(command);
		thread.start();

	}

	public static void main(String[] args) {
		Runnable command = new Runnable() {
			
			@Override
			public void run() {
				// do some task here
				
			}
		};
		Executor executor = new BNewThreadExecutor();
		executor.execute(command);

	}

}
