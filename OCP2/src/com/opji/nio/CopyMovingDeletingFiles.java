package com.opji.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyMovingDeletingFiles {
	
	

	public static void main(String[] args) throws IOException {
		/*Path source = Paths.get("e:\\temp\\directory");
		Path target = Paths.get("e:\\temp\\aux");
		
		if(!Files.exists(source)){
			Files.createDirectory(source);
		}
		
		Files.copy(source, target);
		
		
		System.out.println(Files.exists(source));
		System.out.println(Files.exists(target));
		
		try {
			Files.delete(target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Files.exists(source));
		System.out.println(Files.exists(target));
		
		Files.move(source, target);
		
		System.out.println(Files.exists(source));
		System.out.println(Files.exists(target));*/
		
		Path programca = Paths.get("e:\\temp\\directory\\juan\\programa.txt");
		Path target = Paths.get("e:\\temp","juanele");
		Files.delete(target);
		Files.move(programca, target);
	}

}
