package com.opji.locale.resourceBundle;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBoundleTest1 {
	
	private static final String LABEL= "Labels";
	public static void main (String ...args) throws IOException{
		
		
		ResourceBundle rb = ResourceBundle.getBundle(LABEL, new Locale("en"));
		
		System.out.println("getBaseBundleName: "+rb.getBaseBundleName());
		System.out.println("getLocale: "+rb.getLocale());
		

		
		System.out.println("hello: "+rb.getString("hello"));
		
		rb = ResourceBundle.getBundle("com.opji.locale.resourceBundle.Labels", new Locale("es", "ES"));
		System.out.println(rb.getObject("hello"));
	}
}
