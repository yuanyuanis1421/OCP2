package com.opji.multithreading.collections.blockingQueues;


import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueDemo {

	private static final LinkedTransferQueue<String> LINKED_TRANSFER_QUEUE = new LinkedTransferQueue<String>();
	
	private static String[] arrDeCoches= {"Audi", "Renault", "Toyota","Skoda", "Fiat", "Nissan", "Kia", "Critroen", "Ford", "Mercedes", "Land Rover", "Suzuki", "Seat"};
	
	public static void main(String[] args) throws InterruptedException {
	
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Producer producer = new LinkedTransferQueueDemo().new Producer();
		Consumer consumer = new LinkedTransferQueueDemo().new Consumer();
		executorService.execute(producer);
		executorService.execute(consumer);
		
		
		
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			executorService.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			List<Runnable> unfinished = executorService.shutdownNow();
			if(Objects.nonNull(unfinished)){
				System.err.println("MAL ROLLO NO HA ACABADO BIEN: "+unfinished);
			}
		}
		
		probarOtrosMetodos();
		
		
	}
	
	
	
	private static void probarOtrosMetodos() throws InterruptedException {
		
		//Rellenar la cola		
		rellenaLaCola();
		
		System.out.println("Primer elemento de la Cola(element()): "+LINKED_TRANSFER_QUEUE.element());// No remueve el primer elemento y lanza
																									  // NoSuchElementException si si no hay elementos
		
		System.out.println("Primer elemento de la Cola(peek()): "+LINKED_TRANSFER_QUEUE.peek());      // No remueve el primer elemento y devuelve null si esta valio
		
		System.out.println();
		while(!LINKED_TRANSFER_QUEUE.isEmpty()){
			System.out.println(""+ LINKED_TRANSFER_QUEUE.poll()); // Remueve la cabeza de la cola(1er elemento)
																  // Si está vacia devuelve null
		}
		rellenaLaCola();
		
		System.out.println();
		System.out.println("poll(wainting)...."+LINKED_TRANSFER_QUEUE.poll(10, TimeUnit.MILLISECONDS)); /***
		Hace lo mismo que el anterior pero espera lanza InterruptedException*/
		
		System.out.println("remove ...devuelbe booleano: "+ LINKED_TRANSFER_QUEUE.remove("Renault"));
		
		System.out.println("Take: "+LINKED_TRANSFER_QUEUE.take() );
		
		
	}



	private static void rellenaLaCola() {
		for(int i = 0; i< arrDeCoches.length;i++){
			LINKED_TRANSFER_QUEUE.add(arrDeCoches[i]);
		}
	}



	private class Producer implements Runnable{

		@Override
		public void run() {
			for(int i = 0; i< arrDeCoches.length;i++){
				boolean ok = LINKED_TRANSFER_QUEUE.tryTransfer(arrDeCoches[i]);
				if(ok == false){
					System.out.println("PRODUCER... No se pudo transferir a la primera el coche: ** "+ arrDeCoches[i]);
					try {
						LINKED_TRANSFER_QUEUE.transfer(arrDeCoches[i]);//Transferencia a la fuerza
						System.out.println("PRODUCER Creo que en el elemento **** "+i +"**** la cola quedo bloqueada");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	
	private class Consumer implements Runnable{
		public void run(){
			for(int i = 0; i< arrDeCoches.length; i++){
				try {
					String elemento = LINKED_TRANSFER_QUEUE.take();
					System.out.println(" RECIBIDO: ******** "+ elemento.toUpperCase());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
