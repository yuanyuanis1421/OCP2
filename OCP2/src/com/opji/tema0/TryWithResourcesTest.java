package com.opji.tema0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryWithResourcesTest {
	public static void main(String... args) throws IOException {
		Reader reader = null;
		try {
			Files.createFile(Paths.get(""));// read from file
			
		} catch (IOException e) {
			//log();
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// ignore exceptions on closing file
				}
			}
		}
		
	}
	public void crearTryWithResources() throws FileNotFoundException, IOException{
		File file = new File("c:\\hhahaha");
		try(Reader reader = new BufferedReader(new FileReader(file))){
		}catch (IOException e) {
			throw e;
		}
	
	}
	
	// ok because AutoCloseable allows throwing any Exception
	class A implements AutoCloseable {
		public void close() throws Exception {
		}
	}

	// ok because subclasses or implementing methods can throw
	// a subclass of Exception or none at all
	class B implements AutoCloseable {
		public void close() {
		}
	}

	class C implements AutoCloseable {
		public void close() throws IOException {
		}
	}

	// ILLEGAL – Closeable only allows IOExceptions or subclasses
	/*class D implements Closeable {
		public void close() throws Exception {
		}
	}

	// ok because Closeable allows throwing IOException
	class E implements Closeable {
		public void close() throws IOException {
		}
	}
*/
	
}
