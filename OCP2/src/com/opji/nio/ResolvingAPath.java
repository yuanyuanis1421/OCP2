package com.opji.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvingAPath {
	
	public static void main(String ...args){
		
		Path dir = Paths.get("/home/java");
		Path file = Paths.get("models/Model.pdf");
		Path result = dir.resolve(file);
		System.out.println("result = " + result);
		
		Path absolute = Paths.get("/home/java");
		Path relative = Paths.get("dir");
		file = Paths.get("Model.pdf");
		System.out.println("1: " + absolute.resolve(relative));
		System.out.println("2: " + absolute.resolve(file));
		System.out.println("3: " + relative.resolve(file));
		System.out.println("4: " + relative.resolve(absolute)); // BAD
		System.out.println("5: " + file.resolve(absolute)); // BAD
		System.out.println("6: " + file.resolve(relative)); // BAD
		
		
	}
}
