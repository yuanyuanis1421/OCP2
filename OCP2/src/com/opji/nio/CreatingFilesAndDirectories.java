package com.opji.nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CreatingFilesAndDirectories {

	private static Scanner scanner;
	public static void main(String[] args) throws IOException {
		
		Path ruta = Paths.get("e:\\temp");
		Path path = Paths.get("e:\\temp", "file1.txt");
		System.out.println(Files.isDirectory(ruta));
		System.out.println(Files.exists(path));
		
		try {
			Files.createFile(path);   // Si el fichero existe devuelve un IOException
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Path path1 = Paths.get("e:\\temp","directory");
		Path path2 = Paths.get("e:\\temp","directory", "juan");
		Path file = Paths.get("e:\\temp","directory", "juan","programa.txt");
		
		try{
			Files.createDirectory(path1);
			Files.createDirectory(path2);
			Files.createFile(file);
		
		}catch(FileAlreadyExistsException e){
			e.printStackTrace();
		}
		
		System.out.println("Existe la ruta 1: "+Files.exists(path1)+" nombre: "+ path1.getFileName());
		System.out.println("Existe la ruta 2: "+Files.exists(path2)+" nombre: "+ path2);
		System.out.println("Existe el fichero: "+Files.exists(file)+" nombre: " +file);
		
		
		
		String texto = devuelveTexto();
		
		Files.write(file, texto.getBytes());
		
		List<String> texto1 =Files.readAllLines(file);
		
		for(String linea: texto1){
			System.out.println(linea);
		}

	}
	private static String devuelveTexto(){
		String texto1 = "Hola me llamo Juan";
		return texto1;
	}

}
