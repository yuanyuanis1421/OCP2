package com.opji.nio.accesDirectory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintDirs extends SimpleFileVisitor<Path> {
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		System.out.println("pre: " + dir);
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		System.out.println("file: " + file);
		return FileVisitResult.TERMINATE;
	}

	public FileVisitResult visitFileFailed(Path file, IOException exc) {
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		System.out.println("post: " + dir);
		return FileVisitResult.CONTINUE;
		
	}



	public static void main(String[] args) throws Exception {
		PrintDirs dirs = new PrintDirs();
		Files.walkFileTree(Paths.get("/home"), dirs);
		
	
		
	}
}