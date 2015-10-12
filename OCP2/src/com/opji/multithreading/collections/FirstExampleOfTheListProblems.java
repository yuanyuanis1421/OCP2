package com.opji.multithreading.collections;

import java.util.ArrayList;
import java.util.List;

public class FirstExampleOfTheListProblems implements Runnable{

	
	List<Integer> lista = new ArrayList<Integer>();
	
	FirstExampleOfTheListProblems(){
		for(int i = 0; i<=100000;i++){
			lista.add(i);
		}
	}
	
	public void run(){
		String name = Thread.currentThread().getName();
		while(!lista.isEmpty())
			System.out.println("El Thread "+name+"removed"+lista.remove(0));
	}
	
	public static void main(String[] args) {
		
		FirstExampleOfTheListProblems theListProblems = new FirstExampleOfTheListProblems();
		
		Thread t1 =  new Thread(theListProblems);
		Thread t2 = new Thread(theListProblems);
		
		t1.start();
		t2.start();
		

	}

}
