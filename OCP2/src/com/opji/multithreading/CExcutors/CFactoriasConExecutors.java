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
		 * Crea un grupo de subprocesos(thread pool) que crea nuevos threads según sea necesario, 
		 * pero los threads ya construidos cuando estén disponibles. Estas pools  suelen mejorar el rendimiento 
		 * de los programas que ejecutan muchas tareas asíncronas de corta duración. En las llamadas a execute se
		 * volverán a utilizar hilos previamente construidos si están disponibles. 
		 * Si ningún thread existente está disponible, un nuevo hilo se creará y se añade a la piscina. 
		 * Los Hilos que no han sido utilizados por sesenta segundos se terminan y se eliminan de caché.
		 * De este modo, una piscina que permanece inactiva durante el tiempo suficiente no consumirá ningún recurso.
		 * Ten en cuenta que pools con propiedades similares pero diferentes detalles 
		 * (por ejemplo, parámetros de tiempo de espera) se pueden crear utilizando constructores ThreadPoolExecutor.
		 */
		ExecutorService a = Executors.newCachedThreadPool(); 
		
		ScheduledExecutorService poolExecutor = Executors.newScheduledThreadPool(4);
		
	
		
		

	}

}
