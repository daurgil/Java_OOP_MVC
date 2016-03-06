package framework.modules.users.Model.utils_users;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;
import framework.utils.menus;

public class especials_funtions {
	
	/**
	 * Function to use a special menu to choose between 2 options
	 * @param message
	 * @param title
	 * @param language
	 * @return String depend of the election of the user
	 */
	public static String yes_no(String message, String title){
		String state="";
		int option=0;
		String [] type={class_language.getinstance().getProperty("yes"),
				class_language.getinstance().getProperty("no")};
		
		switch (class_config.getinstance().getLanguage()) {
		case "en":
			option=menus.menu_botton(type, message, title);
			break;
		case "es":
			option=menus.menu_botton(type, message, title);
			break;
		case "val":
			option=menus.menu_botton(type, message, title);
			break;
		}
		
		if(option==0)
			state=class_language.getinstance().getProperty("state_op1");
		else
			state=class_language.getinstance().getProperty("state_op2");
		
		return state;
	}
	
	/**
	 * Function to use a special menu to choose between 2 options
	 * @param message
	 * @param title
	 * @param language
	 * @return boolean
	 */
	public static boolean premium(String message, String title){
		boolean state=false;
		int option=0;
		String [] type={class_language.getinstance().getProperty("yes"),
				class_language.getinstance().getProperty("no")};
		
		switch (class_config.getinstance().getLanguage()) {
		case "en":
			option=menus.menu_botton(type, message, title);
			break;
		case "es":
			option=menus.menu_botton(type, message, title);
			break;
		case "val":
			option=menus.menu_botton(type, message, title);
			break;
		}
		
		if(option==0)
			state=true;
		
		return state;
	}


}
