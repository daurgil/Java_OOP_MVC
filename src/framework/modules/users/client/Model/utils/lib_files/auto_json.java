/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.client.Model.utils.lib_files;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.client.Model.classes.singleton_client;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class auto_json {
    
    public static void auto_savejson_client(){
		String PATH=null;
			
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/client/Model/utils/client_files/json/auto_json.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_client.client.size()>0){
			try{
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("client_class", client_class.class);
				
				
					
				Gson gson = new Gson();
				String json = gson.toJson(singleton_client.client);
				FileWriter fileXml =new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();
					
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_save_json"),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			File path = new File(PATH);
			
			path.delete();
			
		}
	}
	
	public static void auto_openjson_client() {
		
		String PATH = null;
		client_class c = new client_class("");
		
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("client_class", client_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/client/Model/utils/client_files/json/auto_json.json";
			
			File path = new File(PATH);
			
			if (path.exists()) {
				JsonReader reader = new JsonReader(new FileReader(PATH));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for (JsonElement element : list) {
					c = json.fromJson(element, client_class.class);
					singleton_client.client.add(c);
                //singleton.admin = (ArrayList<Usuarios>) xstream.fromXML(new FileReader(PATH));
				}
			}
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_json"), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
