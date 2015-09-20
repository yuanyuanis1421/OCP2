package com.opji.nio.accesDirectory;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;

public class DirectoryStreamTest1 {
	
	public static void main (String ...args) throws IOException {
		Path dir = Paths.get("c:\\Users");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,"[vJ]*")) { // so we don't have close()
			for (Path path : stream) // loop through the stream
				System.out.println(path.getFileName());
		}
	}
}
