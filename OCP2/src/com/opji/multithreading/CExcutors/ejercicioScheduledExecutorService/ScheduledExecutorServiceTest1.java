package com.opji.multithreading.CExcutors.ejercicioScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest1 {

	public static void main(String[] args) {
		
		Task task1 = new Task("Lavar la ropa");
		Task task2 = new Task("Hace la habitación");
		
		ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(2);
		
		scheduled.scheduleAtFixedRate(task1, 4, 6, TimeUnit.SECONDS);
		scheduled.schedule(task2, 1, TimeUnit.SECONDS);
		
		try {
			scheduled.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scheduled.shutdown();

	}

}
