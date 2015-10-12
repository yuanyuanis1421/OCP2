package com.opji.multithreading.Condition;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
	// Lo que hace esta clase es la misma funcionalidad que provee la clase
	// ArrayBlockingQueue

	private Lock lock = new ReentrantLock();
	private Condition noVacio = lock.newCondition();
	private Condition noLleno = lock.newCondition();

	Object[] myArray = new Object[100];
	int contador = 0;

	public void ponerObjeto(Object o) throws InterruptedException {

		lock.lock();
		try {
			while (contador == myArray.length-1)
				noLleno.await();
			++contador;
			myArray[contador] = o;

			noVacio.signal();

		} finally {
			lock.unlock();
		}
	}

	public Object cogerObjeto() throws InterruptedException {
		lock.lock();
		try {
			while (contador == 0)
				noVacio.await();
			
			--contador;
			noLleno.signal();
			return myArray[contador + 1];
			
		} finally {
			lock.unlock();
		}

	}

	public static void main(String... args) throws InterruptedException {
		BoundedBuffer boundedBuffer = new BoundedBuffer();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i <= 10000; i++) {
					try {
						int nuevoEntero = ThreadLocalRandom.current().nextInt(1, 999);
						System.out.println(i + ") Se pone el objeto:" + nuevoEntero);
						boundedBuffer.ponerObjeto(nuevoEntero);
						if (i % 200 == 0) {
							Thread.sleep(1);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i <= 10000; i++) {
						Object o = boundedBuffer.cogerObjeto();
						System.out.println(i + ") Se consume el objeto:" + o);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
