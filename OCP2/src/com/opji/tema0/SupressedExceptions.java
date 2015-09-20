package com.opji.tema0;

import java.io.IOException;

public class SupressedExceptions {
	class One implements AutoCloseable{

		@Override
		public void close() throws Exception {
			throw new IOException("Clossing");
		}
	}
	public static void main(String ...args){
		SupressedExceptions supressedExceptions = new SupressedExceptions();
		supressedExceptions.cierraRecursos();
	}
	private  void cierraRecursos() {
		try(One one = new One()){
			throw new Exception("Try");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			for(Throwable t: e.getSuppressed()){
				System.out.println("Supressed:" + t);
			}
		}
		
	}
}
