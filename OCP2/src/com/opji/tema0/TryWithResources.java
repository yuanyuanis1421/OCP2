package com.opji.tema0;

public class TryWithResources {
	
	class One implements AutoCloseable{
		public void close()  {
			System.out.println("Close -One");
		}
	}
	
	class Two implements AutoCloseable{
		public void close()  {
			System.out.println("Close -Two");			
		}
	}
	
	public static void main(String ...args){
		TryWithResources resources = new TryWithResources();
		resources.cerrarRecurso();
	}
	
	private void cerrarRecurso() {
		try(One one = new One();Two two = new Two()){
			System.out.println("try");
			throw new RuntimeException();
		}catch(Exception e){
			System.out.println("catch");
		}finally {
			System.out.println("finally");
		}
		
	}
}
