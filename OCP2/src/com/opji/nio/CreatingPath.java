package com.opji.nio;

import java.io.File;
import java.net.URI;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPath {
	
	public static void main (String ...args) {
		
		//public final class java.nio.file.Paths ... Paths es una clase final
		
		Path p1 = Paths.get("/tmp", "file.txt"); // IN UNIX
		Path p2 = Paths.get("d:\\temp","file1.txt"); // IN Windows with backslash
		Path p3 = Paths.get("d:\\temp\\juan\\juan1.txt"); // Recuerda, es necesario dos backslash para escapar el caracter
		
		// Los ficheros tambien pueden ser directorios
		
		Path p4 = Paths.get("d:\\temp\\juan"); // Esto es un directorio
		
		/**Hay que tener cuidado cuando cremos Paths, ten en cuenta que los ejemplos anteriores son rutas absolutas 
		 * ya que empezan por c:\\ o por /tmp . Cuando no empezamos por el root , la ruta es considerada relativa
		 * lo que implica que Java mira en el directorio actual.
		 * 
		 * Observa el siguiente ejemplo, ¿Que file1.txt crees que p6 tiene en mente?											*/
		
		Path p6 = Paths.get("tmp","juan1.txt");				// Esto es una ruta relativa
		/** 	/(root)
				 	|-- tmp
				 		  | - file1.txt
				 		  | - tmp
				 			    | - file1.txt
		
		*/
		
		/**Buenop, depende de si en el programa es ejecutado desde el root o desde el directorio actua.. 
		 * Si el directorio actual es /tmp/tmp entonces ejecutara el file1.txt de mayor profundidad, si la ruta actual
		 * es cualquier otra ruta, hará referencia a un fichero que no existe. Si eñ dorectorio actual
		 * es root, entonces se refiere al file1.txt menos profundo.*/
		
		//CUIDADO CON URI ... Uniform Resource Identifier
		
		try{
			Path p = Paths.get("file:///c://temp/lololo");
		}catch(InvalidPathException e){
			e.printStackTrace();
		}
		//Genera una excepción en tiempo de ejecución
		// Si necesitamos un URI
		Path p = Paths.get(URI.create("file:///c://temp/lololo"));
		
		/**
		 * POR ULTIMO ... y no entra en el examen:
		 * */
		
		File file = null;
		Path path = null;
		
		Path convertedPath = file.toPath();
		File convertedFile = path.toFile();
		
		
	}
}
