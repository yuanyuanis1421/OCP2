package com.opji.multithreading.CExcutors.ejercicioCajera;

import static java.lang.System.out;

public class CajereraRunnable implements Runnable {

	
	private Cliente cliente;
	private long initialTime;
	
	public CajereraRunnable(Cliente cliente, long initialTime) {
		this.cliente = cliente;
		this.initialTime = initialTime;
		
	}
	

	public void run() {
		out.println("La cajera: " + Thread.currentThread().getName() 
				+" COMIENZA A PROCESAR EL CLIENTE: " + cliente.getNombre() +" en el tiempo: " 
				+(System.currentTimeMillis() -this.initialTime)/1000 +" sec");
		
		
	
		for(int i = 0; i< cliente.getCarroCompra().length; i++){
			
			esperaElTiempo(cliente.getCarroCompra()[i]);
			
			out.println("procesando el producto: "+ (i+1) +" del " + Thread.currentThread().getName()
					+" en el tiempo: "+(System.currentTimeMillis() -this.initialTime)/1000 +" sec");
		}
		
		
		
		
		out.println("La cajera  " + Thread.currentThread().getName() 
				+" HA TERMINADO DE PROCESAR " + cliente.getNombre() +" en el tiempo: " 
				+(System.currentTimeMillis() -this.initialTime)/1000 +" sec");
	}

	
	
	private void esperaElTiempo(int i) {
		
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public long getInitialTime() {
		return initialTime;
	}
	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}
	
	

}
