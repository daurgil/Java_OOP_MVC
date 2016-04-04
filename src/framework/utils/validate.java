package framework.utils;

import framework.modules.Menu_config.Model.classes.class_config;

public class validate {
	
	//dni;
	private static final String pattern_name= "^[a-zA-ZñÑ\\s]*$";
	private static final String pattern_surname= "[a-zA-ZñÑ\\s]*$";
	private static final String pattern_mobile= "[0-9]{9}";
	private static final String pattern_email= "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$";
	private static final String pattern_nick= "^[a-zA-Z0-9_-]{3,15}$";
	private static final String pattern_password= "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
	private static final String pattern_avatar= "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	private static final String pattern_date1="^(([0-2]?\\d)|([3][0-1]))\\/(([0]?\\d)|([1][0-2]))\\/(\\d{4})$";
	private static final String pattern_date2="^(([0-2]?\\d)|([3][0-1]))\\-(([0]?\\d)|([1][0-2]))\\-(\\d{4})$";
	private static final String pattern_date3="^(19|20)?[0-9]{2}[/](0?[1-9]|1[012])[/](0?[1-9]|[12][0-9]|3[01])$";
	private static final String pattern_date4="^(19|20)?[0-9]{2}[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$";
	private static final String pattern_age="^[0-9]{1,2}$";
	private static final String pattern_antique="^[0-9]{1,2}$";
	private static final String pattern_activity="[0-9]{1,9}";
	private static final String pattern_shopping="([0-9]{1,4}.[0-9]{0,2})$";
	private static final String pattern_type="^[a-zA-ZñÑ\\s]*$";
	
	public static boolean validate_dni(String dni) {
		String s = "[0-9]{8}[a-zA-Z]";
		String letters = "TRWAGMYFPDXBNJZSQVHLCKET";
		boolean result = true;

		result = dni.matches(s);

		if (result) {
			int modul = (Integer.parseInt(dni.substring(0, 8))) % 23;
			char letter = letters.charAt(modul);

			if (letter != dni.substring(8).toUpperCase().charAt(0))
				result = false;
		}

		return result;
	}
	
	public static boolean validate_name(String name) {
		return name.matches(pattern_name);
	}
	
	public static boolean validate_surname(String surname) {
		return surname.matches(pattern_surname);
	}
	
	public static boolean validate_mobile(String mobile) {
		return mobile.matches(pattern_mobile);
	}

	public static boolean validate_email(String email) {
		return email.matches(pattern_email);
	}
	
	public static boolean validate_nick(String user) {
		return user.matches(pattern_nick);
	}
	
	public static boolean validate_password(String password) {
		return password.matches(pattern_password);
	}
	
	public static boolean validate_avatar(String avatar) {
		return avatar.matches(pattern_avatar);
	}
	
	public static boolean validate_date(String date) {
		String date_format="";
		//class_config.getinstance().getFormat_date()
		switch (class_config.getinstance().getFormat_date()) {
		case "dd/MM/yyyy":
			date_format=pattern_date1;
			break;
			
		case "dd-MM-yyyy":
			date_format=pattern_date2;
			break;
			
		case "yyyy/MM/dd":
			date_format=pattern_date3;
			break;
		
		case "yyyy-MM-dd":
			date_format=pattern_date4;
			break;
		default:
			break;
		}
		return date.matches(date_format);
	}
	
	public static boolean validate_age(String mobile) {
		return mobile.matches(pattern_age);
	}
	
	/*public static boolean validate_date_cont(String date_cont) {
		return date_cont.matches(pattern_d_cont);
	}*/
	
	public static boolean validate_antique(String antique) {
		return antique.matches(pattern_antique);
	}
	
	/*public static boolean validate_salary(String salary) {
		return salary.matches(pattern_salary);
	}*/
	
	public static boolean validate_activity(String activity) {
		return activity.matches(pattern_activity);
	}
	
	/*public static boolean validate_discharge_date(String discharge_date) {
		return discharge_date.matches(pattern_discharge);
	}*/
	
	public static boolean validate_shopping(String shopping) {
		return shopping.matches(pattern_shopping);
	}
	
	public static boolean validate_type(String type) {
		return type.matches(pattern_type);
	}
	
}
