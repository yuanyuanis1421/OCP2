package com.opji.tema0;

import java.io.IOException;

public class SupressedExceptions2 {
	
	public static void main(String[] args) throws InterruptedException {
		SupressedExceptions2 supressedExceptions = new SupressedExceptions2();
		supressedExceptions.cierraRecursos();
	}
	class Bad implements AutoCloseable{
		String name;
		Bad(String name){
			this.name = name;
		}

		@Override
		public void close() throws IOException {
			throw new IOException("Closing - "+name);
		}
		
	}
	private void cierraRecursos() throws InterruptedException {
		try(Bad bad = new Bad("1"); Bad bad2 = new Bad("2")){
			//do Stuff
		}catch (Exception e) {
			System.err.println(e.getMessage());
			Thread.sleep(15);
			for(Throwable t : e.getSuppressed()){
				System.out.println("suppresed: "+t);
			}
		}	
	}
}
