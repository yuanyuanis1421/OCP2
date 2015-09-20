package com.opji.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizingAPath {
	public static void main(String ...args){
		Path p1 = Paths.get("e:\\temp","aux1", "..", "aux2", "..", "aux3");
		try {
			Files.createDirectory(p1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String buildProject = "/Build_Project/scripts";
		String upTwoDirectories = "../..";
		String myProject = "/MyProject/source";
		
		Path p2 = Paths.get(buildProject, upTwoDirectories, myProject);
		
		System.out.println("Original: "+p2);
		System.out.println("Normalizado: "+p2.normalize());
		
		System.out.println(Paths.get("/a/./b/./c").normalize());
		System.out.println(Paths.get(".classpath").normalize());
		System.out.println(Paths.get("/a/b/c/..").normalize());
		System.out.println(Paths.get("../a/b/c").normalize());
	}
}
