package com.opji.nio.accesDirectory;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest {
	
	private static final String PATH = "e:\\temp";
	public static void main(String ...args){
		
		//0 Haz los ejercicios del libro
		Path path1 = Paths.get(PATH+File.separator+"One.txt");
		Path path2 = Paths.get(PATH+File.separator+"home"+File.separator+"One.txt");
		
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
		
		System.out.println(matcher.matches(path1));
		System.out.println(matcher.matches(path2));
		System.out.println(matcher.matches(Paths.get("One.txt")));
		
		
		//1)Encuentra todos los archivos dentro de un directorio o subdirectorio que sean .exe dada esta ruta, imprimelos y cuentalos.
		//2)Encuentra todos los archivos que tengan la palabra puta
	}
}
