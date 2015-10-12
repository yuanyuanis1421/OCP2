package com.opji.multithreading.collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteCollectionsTest {
	private static final int MAXARRAY = 1000;
	static CopyOnWriteArrayList<Integer>  lista = new CopyOnWriteArrayList<Integer>();
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i< MAXARRAY;i++){
					System.out.println("Hola"+i);
					lista.add(i);
					System.out.println("Adios"+i);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(Integer e : lista){
					try{
					if(e%100 == 0){
						lista.remove(e+1);
					}
					}catch(UnsupportedOperationException ea){
						ea.printStackTrace();
					}
				}
				
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
	}
}
