package framework.modules.Config.Model.classes;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework.modules.Config.Model.classes.language.class_language;

import framework.modules.Config.Model.files_config.auto_config;
import framework.modules.users.Model.classes.admin_class;
import framework.modules.users.Model.classes.client_class;
import framework.modules.users.Model.classes.reg_user_class;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.utils_users.BLL.funtions_files;
import framework.modules.users.Model.utils_users.lib_files.auto_json;

@XStreamAlias("class_config")
public class class_config implements Serializable{
	@XStreamAlias("instance")
	private static class_config instance;
	
	
	@XStreamAlias("format_date")
	private String format_date;
	@XStreamAlias("currency")
	private char currency;
	@XStreamAlias("decimals")
	private int decimals;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("theme")
	private String theme;
	@XStreamAlias("file_format")
	private String file_format;
	
	public class_config(){
		
		format_date="dd/MM/yyyy";
		currency='€';
		decimals=2;
		language="en";
		theme="metal";
		file_format="json";
		
	}
	
	public static class_config getinstance(){
		if (instance==null){
			instance = new class_config();
			
			singleton_user.admin= new ArrayList<admin_class>();
			singleton_user.client= new ArrayList<client_class>();
			singleton_user.reg= new ArrayList<reg_user_class>();
			
                        auto_json.auto_openjson_admin();
                        //funtions_files.auto_open();
			//class_language.getinstance();
			
			//auto_config.auto_openconfig();
                        
		}
		return instance;
	}

	public String getFormat_date() {
		return format_date;
	}

	public void setFormat_date(String format_date) {
		this.format_date = format_date;
	}

	public char getCurrency() {
		return currency;
	}

	public void setCurrency(char currency) {
		this.currency = currency;
	}

	public int getDecimals() {
		return decimals;
	}

	public void setDecimals(int decimals) {
		this.decimals = decimals;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getFile_format() {
		return file_format;
	}

	public void setFile_format(String file_format) {
		this.file_format = file_format;
	}
	
	public String toString() {
		
		String chain="";
		
		chain=chain+class_language.getinstance().getProperty("date")+getFormat_date()+"\n";
		chain=chain+class_language.getinstance().getProperty("currency")+getCurrency()+"\n";
		chain=chain+class_language.getinstance().getProperty("decimals")+getDecimals()+"\n";
		chain=chain+class_language.getinstance().getProperty("lang")+getLanguage()+"\n";
		chain=chain+class_language.getinstance().getProperty("theme")+getTheme()+"\n";
		chain=chain+class_language.getinstance().getProperty("file")+getFile_format()+"\n";
		
		return chain;
	}
}
