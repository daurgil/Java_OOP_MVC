package framework.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import framework.modules.Menu_config.Model.classes.class_config;

public class format {

	public static String format_1d(float number){//Format for numbers with 1 decimal
		
		DecimalFormat format_1d=new DecimalFormat(".#"); 
		return format_1d.format(number);
	}
	
	public static String format_2d(float number){//Format for numbers with 2 decimal
		
		DecimalFormat format_2d=new DecimalFormat(".##"); 
		return format_2d.format(number);
	}
	
	public static String format_3d(float number){//Format for numbers with 3 decimal
		
		DecimalFormat format_3d=new DecimalFormat(".###"); 
		return format_3d.format(number);
	}
	
	public static String Format_Dollar(float moneda) {
		NumberFormat coins = NumberFormat.getCurrencyInstance(Locale.US);// Dolar
		return coins.format(moneda);
	}

	public static String Format_Libra(float moneda) {
		NumberFormat coins = NumberFormat.getCurrencyInstance(Locale.UK);// Libras
		return coins.format(moneda);
	}

	public static String Format_Euro(float moneda) {
		NumberFormat coins = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro
		return coins.format(moneda);
	}
	
	public static String currency(float moneda){
		
		String currency=null;
		
		switch (class_config.getinstance().getCurrency()) {
		case '€':
			currency=format.Format_Euro(moneda);
			break;
			
		case '$':
			currency=format.Format_Dollar((moneda*1.09246f));
			break;
			
		case '£':
			currency=format.Format_Libra((moneda*0.728380f));
			break;

		}
		
		return currency;
	}
	
	
}
