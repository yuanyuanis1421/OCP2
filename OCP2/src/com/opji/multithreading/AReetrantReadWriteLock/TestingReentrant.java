package com.opji.multithreading.AReetrantReadWriteLock;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestingReentrant {

	public static void main(String[] args) {
		
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
		list.add(2);
		list.add(4);
		list.add(6);
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			Integer index = it.next();
			System.out.println(index);
			list.remove(index);
			//list.add(8);
		}

	}

}
