package com.opji.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReadingAndWrintgAttriubittesEasyWay {

	public static void main(String[] args) {
		
		//Creamos unas fecha
		Date date = new GregorianCalendar(2012, 12, 25).getTime();
		//OLD WAY
		File file = new File("e:\\temp\\Juanelesss.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.setLastModified(date.getTime());
		System.out.println(file.lastModified());
		file.delete();
		
		
		//NEW WAY
		Path path = Paths.get("e:\\temp\\Juanelesss.txt");
		FileTime time = FileTime.fromMillis(date.getTime());
		try {
			Files.createFile(path);
		
			Files.setLastModifiedTime(path, time);
		
			System.out.println(Files.getLastModifiedTime(path));
		
			Files.delete(path);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		// Permisos con NIO
		// con la clase Files podemos preguntar:
		
		Files.isReadable(path);
		Files.isExecutable(path);
		Files.isWritable(path);
		
		
		try {
			Files.isHidden(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Files.isDirectory(path);
		Files.exists(path);
		
		

	}

}
