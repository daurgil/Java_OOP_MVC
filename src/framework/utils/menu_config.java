package framework.utils;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;

public class menu_config {
	
	public static void menu_config(){
		
		String[] config_menu={class_language.getinstance().getProperty("date"),
				class_language.getinstance().getProperty("currency"),class_language.getinstance().getProperty("decimals"),
				class_language.getinstance().getProperty("lang"),class_language.getinstance().getProperty("file"),
				class_language.getinstance().getProperty("theme"),class_language.getinstance().getProperty("back")};
		
		String[] date_op={"dd/mm/yyyy","dd-mm-yyyy","yyyy/mm/dd","yyyy-mm-dd"};
		String[] currency_op={"€","$","£"};
		String[] decimal_op={"1","2","3"};
		String[] language_op={"en","es","val"};
		String[] file_format={"JSON","XML","TXT"};
		String[] theme={"Metal","Windows","Motif","Nimbus"};
		
		int opt=0;
		String select="";
		
		opt=menus.menu_botton(config_menu, class_language.getinstance().getProperty("config_msg"),
				class_language.getinstance().getProperty("config_t"));
		
		switch (opt) {
		case 0:
			select=menus.combobox(date_op, class_language.getinstance().getProperty("combox_msg"),
					class_language.getinstance().getProperty("config_t"));
			switch (select) {
			case "dd/mm/yyyy":
				class_config.getinstance().setFormat_date(select);
				break;
			case "dd-mm-yyyy":
				class_config.getinstance().setFormat_date(select);
				break;
			case "yyyy/mm/dd":
				class_config.getinstance().setFormat_date(select);
				break;
			case "yyyy-mm-dd":
				class_config.getinstance().setFormat_date(select);
				break;
			}
			
			break;

		case 1:
			select=menus.combobox(currency_op, class_language.getinstance().getProperty("combox_msg"),
					class_language.getinstance().getProperty("config_t"));
			switch (select) {
			case "€":
				class_config.getinstance().setCurrency('€');
				break;
			case "$":
				class_config.getinstance().setCurrency('$');
				break;
			case "£":
				class_config.getinstance().setCurrency('£');
				break;
			}
			break;

		case 2:
			select=menus.combobox(decimal_op, class_language.getinstance().getProperty("combox_msg"),
					class_language.getinstance().getProperty("config_t"));
			switch (select) {
			case "1":
				class_config.getinstance().setDecimals(1);
				break;
			case "2":
				class_config.getinstance().setDecimals(2);
				break;
			case "3":
				class_config.getinstance().setDecimals(3);
				break;
			}
			break;
		case 3:
			select=menus.combobox(language_op, class_language.getinstance().getProperty("combox_msg"),
					class_language.getinstance().getProperty("config_t"));
			switch (select) {
			case "en":
				class_config.getinstance().setLanguage("en");
				class_language.getinstance().setLanguage();
				break;
			case "es":
				class_config.getinstance().setLanguage("es");
				class_language.getinstance().setLanguage();
				break;
			case "val":
				class_config.getinstance().setLanguage("val");
				class_language.getinstance().setLanguage();
				break;
			
			}
			break;
		case 4:
			select=menus.combobox(file_format, class_language.getinstance().getProperty("combox_msg"),
					class_language.getinstance().getProperty("config_t"));
			switch (select) {
			case "JSON":
				class_config.getinstance().setFile_format("json");
				break;
			case "XML":
				class_config.getinstance().setFile_format("xml");
				break;
			case "TXT":
				class_config.getinstance().setFile_format("txt");
				break;
			}
			break;
		case 5:
			select=menus.combobox(theme, class_language.getinstance().getProperty("combox_msg"),
					class_language.getinstance().getProperty("config_t"));
			switch (select) {
			case "Metal":
				class_config.getinstance().setTheme("metal");
				appearance.theme_selected(select);
				break;
			case "Windows":
				class_config.getinstance().setTheme("windows");
				appearance.theme_selected(select);
				break;
			case "Motif":
				class_config.getinstance().setTheme("motif");
				appearance.theme_selected(select);
				break;
			case "Nimbus":
				class_config.getinstance().setTheme("nimbus");
				appearance.theme_selected(select);
				break;
			
		default:
			break;
		}
				
		}
		
	}
	
}
