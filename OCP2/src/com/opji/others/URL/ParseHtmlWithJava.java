package com.opji.others.URL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ParseHtmlWithJava {

	public static void main(String... args) {
		try {
			URL url = new URL("http://www.google.es");
			URLConnection uc = url.openConnection();

			InputStreamReader input = new InputStreamReader(uc.getInputStream());
			BufferedReader in = new BufferedReader(input);
			String inputLine;

			FileWriter outFile = new FileWriter("orhancan");
			PrintWriter out = new PrintWriter(outFile);

			while ((inputLine = in.readLine()) != null) {
				out.println(inputLine);
			}

			in.close();
			out.close();

			File fXmlFile = new File("orhancan");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList prelist = doc.getElementsByTagName("body");
			System.out.println(prelist.getLength());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
