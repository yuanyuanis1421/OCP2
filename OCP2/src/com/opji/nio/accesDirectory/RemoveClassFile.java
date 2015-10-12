package com.opji.nio.accesDirectory;

import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoveClassFile extends SimpleFileVisitor<Path> {

	private static final String LAST = "src";
	private static final String PATH = "E:\\temp\\" + LAST;
	private static final String DIRECTORY = "dir";
	private static final String ARCHIVE = "archive";
	private static final String JAVA_EXT = ".java";
	private static final String CLASS_EXT = ".class";

	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println(file);
		return FileVisitResult.CONTINUE;

	}

	public static void main(String... args) {

		RemoveClassFile classFile = new RemoveClassFile();

		escribeSeparadorConTit("mostrar Estructura Inicial");
		try {
			classFile.mostrarEstructura();
		} catch (IOException e) {

			e.printStackTrace();
		}

		escribeSeparadorConTit("borar Estructura Inicial");
		try {
			classFile.borrarEstructura();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			crearEstructura(5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		escribeSeparadorConTit("mostrar nueva Estructura");
		try {
			classFile.mostrarEstructura();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void escribeSeparadorConTit(String titulo) {
		System.out.println("*********************" + titulo + "****************************");
		System.out.println("*********************************************************************");
	}

	private static void crearEstructura(int deepLevel) throws IOException {

		StringBuilder dinamicPATH = new StringBuilder();
		dinamicPATH.append(PATH);

		for (int i = 0; i <= deepLevel; i++) {
			// crear un archivo .java
			Files.createFile(Paths.get(dinamicPATH + File.separator + ARCHIVE + i + JAVA_EXT));
			// crear un archivo .class
			Files.createFile(Paths.get(dinamicPATH + File.separator + ARCHIVE + i + CLASS_EXT));
			// si aplica, crear un directorio
			if (i < deepLevel) {
				dinamicPATH.append(File.separator).append(DIRECTORY).append(i);
				Files.createDirectory(Paths.get(dinamicPATH.toString()));
			}
		}
	}

	private void mostrarEstructura() throws IOException {
		Files.walkFileTree(Paths.get(PATH), this);

	}

	private void borrarEstructura() throws IOException {
		DeleteStructure deleteStructure = new DeleteStructure();
		Files.walkFileTree(Paths.get(PATH), deleteStructure);
	}

	class DeleteStructure extends SimpleFileVisitor<Path> {
		public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes)  {

			try {
				Files.delete(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("fichero" + file + "borrado: " + !Files.exists(file));

			return FileVisitResult.CONTINUE;
		}

		public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes basicFileAttributes) {

			System.out.println("pre: " + file);
			return FileVisitResult.CONTINUE;
		}

		public FileVisitResult postVisitDirectory(Path dir, IOException i) throws IOException {
			System.out.println("post:" + dir + " ... fileName?: " + dir.getFileName());
			if (dir.getFileName().toString().equals(LAST)) {
				return FileVisitResult.CONTINUE;
			}
			System.out.println("borrado" + dir);
			Files.deleteIfExists(dir);
			return FileVisitResult.CONTINUE;
		}
	}

	

}
