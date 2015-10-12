package com.opji.multithreading.CExcutors.ejercicioScheduledExecutorService;

import java.text.DateFormat;
import java.util.Date;

class Task implements Runnable {

	
	private String name;
	
	Task(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	@Override
	public void run() {
		
	
		
		
		
		System.out.println("La tarea" + name +" se ejecuta a la hora " + new Date());

	}

}
