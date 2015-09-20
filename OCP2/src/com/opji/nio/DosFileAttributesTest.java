package com.opji.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest {
	public static void main (String ...args) throws IOException {
		
		Path path = Paths.get("c:\\test");
		Files.deleteIfExists(path);
		Files.createFile(path);
		crearAtributos(path, true, true);
		
		DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println("isHidden: " +dos.isHidden());
		System.out.println("isReadOnly: " +dos.isReadOnly());
		crearAtributos(path, false, false);
		
		//Hay que volver a leer el  dosFileAtribute
		dos = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println("isHidden: " +dos.isHidden());
		System.out.println("isReadOnly: " +dos.isReadOnly());
		
		//Hay otra forma perop no es el objeto de examen
		DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
		view.setHidden(true);
		view.setReadOnly(false);
		
		System.out.println("isHidden: " +dos.isHidden());
		System.out.println("isReadOnly: " +dos.isReadOnly());
		
		Files.deleteIfExists(path);
	}

	private static void crearAtributos(Path path, boolean b1, boolean b2) throws IOException {
		
		Files.setAttribute(path, "dos:hidden", b1);
		Files.setAttribute(path, "dos:readonly",b2);
		
	}
}
