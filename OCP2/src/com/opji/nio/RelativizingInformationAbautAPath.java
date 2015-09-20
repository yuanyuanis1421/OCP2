package com.opji.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizingInformationAbautAPath {
	
	public static void main(String ...args){
		Path p1 = Paths.get("/home/usr");
		Path p2 = Paths.get("/home/usr/music/tailor.mp3");
		
		Path mp3 = p1.relativize(p2);
		System.out.println(mp3);
		int i = 0;
		
		Path absolute1 = Paths.get("/home/java");
		Path absolute2 = Paths.get("/usr/local");
		Path absolute3 = Paths.get("/home/java/temp/music");
		Path relative1 = Paths.get("temp");
		Path relative2 = Paths.get("temp/music.pdf");
		Path relative3  = Paths.get("hareCrismas");
		
		System.out.println(i++ +": "+absolute1.relativize(absolute3));
		System.out.println(i++ +": "+absolute3.relativize(absolute1));
		System.out.println(i++ +": "+absolute2.relativize(absolute1));
		System.out.println(i++ +": "+relative1.relativize(relative2));
		try {
			System.out.println(i++ +": "+absolute1.relativize(relative2));//GENERA UNA EXCEPCION
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e1) {
			}
		}
		
		try {
			System.out.println(i++ +": "+relative3.relativize(relative2));//
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}
}
