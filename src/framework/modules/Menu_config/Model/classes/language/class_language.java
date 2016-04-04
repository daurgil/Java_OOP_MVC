package framework.modules.Menu_config.Model.classes.language;

import framework.modules.Menu_config.Model.classes.class_config;
import java.io.IOException;
import java.util.Properties;


public class class_language extends Properties{
	
	//private String language;

	private static class_language instance;
	
	public static class_language getinstance(){
		if(instance==null){
			instance= new class_language();
		}
		return instance;
		
	}
	
	public class_language(){
		
		switch (class_config.getinstance().getLanguage()) {
		case "en":
			getProperties("english.properties");
			break;
		case "es":
			getProperties("Spanish.properties");
			break;
		case "val":
			getProperties("Valencian.properties");
			break;
		default:
			getProperties("english.properties");
			break;
		}
	}
	
	public String toString(){
		return class_config.getinstance().getLanguage();
	}
	
	public void setLanguage() {
		//this.language = class_config.getinstance().getLanguage();
		switch(class_config.getinstance().getLanguage()){
	    case "en":
	    	getProperties("english.properties");
	        break;
	    case "es":
	    	getProperties("Spanish.properties");
	        break;
	    case "val":
	    	getProperties("Valencian.properties");
	        break;
	    default:
	        getProperties("english.properties");
		}
	}
	
	public void getProperties(String language) {
        try {
            this.load( getClass().getResourceAsStream(language) );
        } catch (IOException ex) {
        }
    }
	
}
