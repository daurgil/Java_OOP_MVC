package framework.modules.Menu_config.Model.classes;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import framework.classes.connectionDB;
import framework.modules.Menu_config.Model.classes.language.class_language;
import framework.modules.Menu_config.Model.files_config.auto_config;
import framework.modules.users.reg_user.Model.classes.reg_user_class;
import framework.modules.users.admin.Model.classes.admin_class;
import framework.modules.users.admin.Model.classes.singleton_admin;
import framework.modules.users.admin.Model.utils.lib_Afiles.A_auto_json;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.client.Model.classes.singleton_client;
import framework.modules.users.client.Model.utils.lib_Cfiles.C_auto_json;
import framework.modules.users.reg_user.Model.classes.singleton_reg;
import framework.modules.users.reg_user.Model.utils.lib_Rfiles.R_auto_json;
import framework.utils.appearance;




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
		language="eng";
		theme="Metal";
		file_format="json";
		
	}
	
	public static class_config getinstance(){
		if (instance==null){
			instance = new class_config();
			
			singleton_admin.admin= new ArrayList<admin_class>();
			singleton_client.client= new ArrayList<client_class>();
			singleton_reg.reg= new ArrayList<reg_user_class>();
			
//                        A_auto_json.auto_openjson_admin();
//                        C_auto_json.auto_openjson_client();
//                        R_auto_json.auto_openjson_reg();
                        //funtions_files.auto_open();
			auto_config.auto_openconfig();
                        //class_language.getinstance();
			singleton_config.lang=new class_language();
                        
                        connectionDB.init_BasicDataSourceFactory();
                        
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
                appearance.theme_selected(theme);
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
