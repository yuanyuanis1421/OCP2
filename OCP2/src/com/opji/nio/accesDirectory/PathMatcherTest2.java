package com.opji.nio.accesDirectory;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest2 {
	public static void main(String ...args){
		
		/**1**************************************************************************/
		Path path1 = Paths.get("/home/One.txt"); //Incluye directorio
		Path path2 = Paths.get("One.txt");       //No incluye directorio
		String glob ="glob:*.txt";
		matches(path1, glob);         //false
		matches(path2, glob);         //true
		
		
		System.out.println();
		/**2**************************************************************************/
		Path path = Paths.get("/com/mierada/One.java");
		
		matches(path,"glob:*.java");     //FALSE encuentra cualquier carácter excepto par el directorio frontera.
		matches(path, "glob:**/*.java"); //TRUE encuentra cualquier cosa inlcuido el directorio frontera y luego 
										 //	    /* y cualquier cosa que acabe en .java
		matches(path, "glob:*");         //FALSE cualquier cosa sin el directorio
		matches(path, "glob:**");        //TRUE cualquier cosa incluyendo el directorio.
		
		
		System.out.println();
		/**3**************************************************************************/
		path1 = Paths.get("One.java");
		path2 = Paths.get("One.ja^a");
		matches(path1, "glob:*.????");      // true
		matches(path1, "glob:*.???");       // false
		matches(path2, "glob:*.????");      // true
		matches(path2, "glob:*.???");       // false
		
		System.out.println();
		/**4**************************************************************************/
		path1 = Paths.get("Bert-book");
		path2 = Paths.get("Kathy-horse");
		matches(path1, "glob:{Bert*,Kathy*}");    // true
		matches(path1, "glob:{Bert*,Kathy}");     // true
		matches(path2, "glob:{Bert,Kathy*}");     // true
		matches(path2, "glob:{Bert,Kathy}*");     // true
		matches(path1, "glob:{Bert,Kathy}");      // false
		
		System.out.println();
		/**5**************************************************************************/
		path1 = Paths.get("0*b/test/1");
		path2 = Paths.get("9\\*b/test/1");
		Path path3 = Paths.get("01b/test/1");
		Path path4 = Paths.get("0*b/1");
		glob = "glob:[0-9]\\*{A*,b}/**/1";
		matches(path1, glob);                     // true
		matches(path2, glob);                     // false
		matches(path3, glob);                     // false
		matches(path4, glob);                     // false
		// Tambien podemos poner conjuntos de caracteres como [a-z] o [0-9] o [@#~€] esto es exactamente igual que en expresiones regulares.
	
		/**
		 *  ■ [0-9] One single digit. Can also be read as any one character from 0 to 9.
			■ \\* The literal character asterisk rather than the asterisk that means to match anything. 
			   A  single backslash before * escapes it. However, Java won't let you type a single backslash, 
			   so you have to escape the backslash itself with another backslash.
			■ {A*,b} Either a capital A followed by anything or the single character b.
			■      One or more directories with any name.
			■ 1    The single character 1.
		 * 
		 * 
		 * */
	}
	
	public static void matches(Path path, String glob){
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
		System.out.println(matcher.matches(path));
	}
}
