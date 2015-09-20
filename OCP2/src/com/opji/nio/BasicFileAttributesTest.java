package com.opji.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasicFileAttributesTest {
	
	public static void main(String ...args) throws IOException{
		Path path = Paths.get("E:\\temp\\directory\\juan\\juanele");
		BasicFileAttributes basic = Files.readAttributes(path, BasicFileAttributes.class);
		
		System.out.println("creationTime: "+basic.creationTime());
		System.out.println("lastAccessTime: "+basic.lastAccessTime());
		System.out.println("lastModifiedTime: "+basic.lastModifiedTime());
		System.out.println("isDirectory: "+basic.isDirectory());
		
		BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		
		basicView.setTimes(FileTime.from(new Date().getTime(), TimeUnit.MILLISECONDS), FileTime.from(new Date().getTime(), TimeUnit.MILLISECONDS), FileTime.from(new Date().getTime(), TimeUnit.MILLISECONDS));
	
		
		System.out.println("\ncreationTime: "+basic.creationTime());
		System.out.println("lastAccessTime: "+basic.lastAccessTime());
		System.out.println("lastModifiedTime: "+basic.lastModifiedTime());
		System.out.println("isDirectory: "+basic.isDirectory());
	}
}
