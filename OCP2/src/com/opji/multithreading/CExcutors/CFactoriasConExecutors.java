package com.opji.multithreading.CExcutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class CFactoriasConExecutors {

	public static void main(String[] args) {
		
		/**
		 * ---------------CachedThreadPool-----------------
		 * 
		 * Crea un grupo de subprocesos(thread pool) que crea nuevos threads seg�n sea necesario, 
		 * pero los threads ya construidos cuando est�n disponibles. Estas pools  suelen mejorar el rendimiento 
		 * de los programas que ejecutan muchas tareas as�ncronas de corta duraci�n. En las llamadas a execute se
		 * volver�n a utilizar hilos previamente construidos si est�n disponibles. 
		 * Si ning�n thread existente est� disponible, un nuevo hilo se crear� y se a�ade a la piscina. 
		 * Los Hilos que no han sido utilizados por sesenta segundos se terminan y se eliminan de cach�.
		 * De este modo, una piscina que permanece inactiva durante el tiempo suficiente no consumir� ning�n recurso.
		 * Ten en cuenta que pools con propiedades similares pero diferentes detalles 
		 * (por ejemplo, par�metros de tiempo de espera) se pueden crear utilizando constructores ThreadPoolExecutor.
		 */
		ExecutorService a = Executors.newCachedThreadPool(); 
		
		ScheduledExecutorService poolExecutor = Executors.newScheduledThreadPool(4);
		
	
		
		

	}

}
