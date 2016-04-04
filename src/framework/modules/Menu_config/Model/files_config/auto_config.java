package framework.modules.Menu_config.Model.files_config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import framework.modules.Menu_config.Model.classes.class_config;
import framework.modules.Menu_config.Model.classes.language.class_language;
import framework.utils.appearance;

public class auto_config {

	public static void auto_openconfig(){
		
		String PATH = null;
		class_config config = new class_config();
		
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("class_config", class_config.class);
			
			PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/Menu_config/Model/files_config/auto_config.json";
			
			File path = new File(PATH);
			
			if (path.exists()) {
				JsonReader reader = new JsonReader(new FileReader(PATH));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				config = json.fromJson(root, class_config.class);
				class_config.getinstance().setFormat_date(config.getFormat_date());
				class_config.getinstance().setCurrency(config.getCurrency());
				class_config.getinstance().setDecimals(config.getDecimals());
				class_config.getinstance().setLanguage(config.getLanguage());
				class_config.getinstance().setTheme(config.getTheme());
				appearance.theme_selected(config.getinstance().getTheme());
				//class_config.getinstance().setFile_format(config.getFile_format());
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void auto_saveconfig(){
		
		String PATH=null;
		
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/Menu_config/Model/files_config/auto_config.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
			
			try{
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("class_config", class_config.class);
				
				
					
				Gson gson = new Gson();
				String json = gson.toJson(class_config.getinstance());
				FileWriter fileXml =new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();
					
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_save_json"),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		
		
	}
}
