package com.opji.jdbc.driverManager;

import java.util.concurrent.ThreadLocalRandom;

public class Borrar {

	public static void main(String[] args) {
	
		for(int i = 0; i<=8;i++){
			for(int j =0;j<=i+1;j++){
				System.out.print(ThreadLocalRandom.current().nextInt(0, 9));
			}
			System.out.println();
			for(int j =0;j<=i+1;j++){
				System.out.print(ThreadLocalRandom.current().nextInt(0, 9));
			}
			System.out.println();
		}

	}

}
