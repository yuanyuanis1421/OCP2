package com.opji.locale;

import java.util.Locale;

public class LocaleRefresh {
	public static void main (String ...args){
		Locale locale1 = new Locale("es"); //Constructor Locale(String language)
		
		System.out.println(locale1.getLanguage()); //Imprime es
		System.out.println(locale1.getCountry()); // No imprime nada
		
		Locale locale2 = new Locale("es", "IT");  // Constructor Locale(String language, String country)
		
		
		System.out.println("\n"+locale2.getLanguage()); //Imprime es
		System.out.println(locale2.getCountry()); // Imprime IT
		System.out.println(locale2.getDisplayLanguage()); //Imprime español
		System.out.println(locale2.getDisplayCountry()); // Imprime España
		
		Locale locale3 = Locale.getDefault(); //Gets the current value of the default locale for this instance of the Java Virtual Machine.
		
		System.out.println("\n"+locale3.getLanguage()); //Imprime es
		System.out.println(locale3.getCountry()); // No imprime nada
		
		
		
	}
}
