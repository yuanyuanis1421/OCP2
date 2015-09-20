package com.opji.others.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class URLReader {
	private static final String URL_BASE = "http://archive.fiba.com/pages/eng/fa/player/p/pid/21377/pid2/28569/sid/2236/tid/288/tid2/362/_/2003_European_Championship_for_Men/index.html";
    private static final String CONTENT_INI ="<table class=\"accu\"";
    private static final String CONTENT_END ="</table>";
    private static final String XML_INI ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String XML_END ="</xml>";
    private static final String PATH = "E://temp//Nowitzki.xml";
										
	public static void main(String[] args) throws Exception{
        URL URL = new URL(URL_BASE);
        BufferedReader in = new BufferedReader(new InputStreamReader(URL.openStream()));

        String inputLine;
        boolean semaphore = false;
        StringBuilder builder = new StringBuilder();
        builder.append(XML_INI);
        while((inputLine = in.readLine()) != null){
        	if(semaphore||inputLine.contains(CONTENT_INI)){
        		builder.append(inputLine);
        		semaphore = true;
        		if(inputLine.contains(CONTENT_END)){
        			semaphore = false;
        			System.out.println(true);
        		}
        	}
        		
        	
        }
        in.close();
        builder.append(XML_END);
        System.out.println(builder);
        
        Path path = Paths.get(PATH);
        Files.deleteIfExists(path);
        Files.createFile(path);
        
        Files.write(path, builder.toString().replace("&nbsp;", "").getBytes());
    }
}