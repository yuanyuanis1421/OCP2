package com.opji.nio.accesDirectory;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

/**
 * Supón que estás escribiendo un programa de
	instalación. Tienes que checkear que el directorio en el que pretendes instalar está vacío. 
	De no ser así, esperarás a que el usuario manualmente borre el directorio antes de continuar.
 * @author Juan
 */
public class WatchServiceTest {
/**
 * 	
 * /installation
		| – directoryToDelete
		| – other
 * @throws IOException 
 */
	public static void main(String ...args) throws IOException{
		
		Path path = Paths.get("E://installation");  // cogemos el directorio que contiene los files o directories 
													//de los que nos queremos preocupar
		
		WatchService watcher = FileSystems.getDefault().newWatchService();
		
		path.register(watcher, ENTRY_DELETE, ENTRY_CREATE, ENTRY_MODIFY);
		
		while(true){
			WatchKey key;
			try {
				key = watcher.take();  // esperamos a borrar.
			} catch (InterruptedException e) {
				return;
			}
			
			
			for(WatchEvent<?> event : key.pollEvents()){
				WatchEvent.Kind<?> kind = event.kind();
				System.out.println(kind.name());		//CREATE, DELETE, MODIFY
				System.out.println(kind.type());        //Siempre un PAth para nosotros.
				System.out.println(event.context());    // Nombre del fichero
				String name = event.context().toString();
				if(name.equals("directoryToDelete")&&kind.name().equals("ENTRY_DELETE")){
					System.out.format("Directory deleted, now we can proceed");
					return;
				}
			}
			key.reset();								// Necesario para seguir buscando por eventos.
		}
	}
}
