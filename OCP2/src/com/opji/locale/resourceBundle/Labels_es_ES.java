package com.opji.locale.resourceBundle;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Labels_es_ES extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "hello", new StringBuilder("from Java").toString() } };
	}
	public static void main(String ...args){
		
		ResourceBundle rb = ResourceBundle.getBundle("com.opji.locale.resourceBundle.Labdels", new Locale("HS", "ES"));
		System.out.println(rb.getObject("hello"));
		
		Locale.setDefault(Locale.GERMANY);
		Locale locale = new Locale("en", "UK");
		rb = ResourceBundle.getBundle("RB", locale);
		System.out.println(rb.getString("ride.in") +rb.getString("elevator"));
		
	}

}
