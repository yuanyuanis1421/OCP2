package com.opji.nio;

import java.nio.file.Paths;

import java.nio.file.Path;

public class RetrivingInformationAbautAPath {

	public static void main(String ...args){
		Path path = Paths.get("C:\\Users\\Public\\Pictures\\Sample Pictures");
		//Path path = Paths.get("C:\\Users\\Public\\Pictures\\Sample Pictures");
		System.out.println("getFileName: "+ path.getFileName());
		System.out.println("getNameCount: "+ path.getNameCount());
		System.out.println("getFileSystem: "+ path.getFileSystem());
		System.out.println("getParent: "+ path.getParent());
		System.out.println("getRoot: "+ path.getRoot());
		System.out.println("getName: "+ path.getName(0));
		System.out.println("subpath: "+ path.subpath(0, 2));
		
		//Además la Path Interface extiende de Iterable<Path>
		//Como sabemos toda interface que tenga correctamente implementada Iterable<?> puede ser usada en un ebhaced loop
		
		int spaces = 1;
		for (Path subPath: path){
			System.out.format("%" + spaces +"s%s%n", "", subPath );
			spaces +=2;
		}
		

	}
}
