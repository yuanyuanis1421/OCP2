package com.opji.nio.accesDirectory;


import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.nio.file.*;

/**
 * Esta clase devuelve todos los ficheros de tipo txt que se encuentren dentro de un directorio password
 * @author Juan
 *
 */

public class MyPathMatcher extends SimpleFileVisitor<Path>{
/**
 *  E://test
 *       | password
 *             |One.java
 *             |Dos.txt
 *             |subdirectory
 *                   | Tres.txt
 *                   | Cuatro.java
 *  
 *  */
	
	private static final String PATH ="E://test1";
	
	PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/password/**.txt"); //** significa cualquier directorio
	
	public static void main(String ...args){
		
		MyPathMatcher myPathMatcher = new MyPathMatcher();
		try {
			Files.walkFileTree(Paths.get(PATH), myPathMatcher);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FileVisitResult visitFile(Path file, BasicFileAttributes attributes){
		if(matcher.matches(file)){
			System.out.println(file.getFileName());
			System.out.println(file);
		}
		return FileVisitResult.CONTINUE;
	}
	
}
