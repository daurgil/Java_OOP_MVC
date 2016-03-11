package framework.modules.users.Model.utils_users.lib_files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.Model.classes.reg_user_class;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.admin.Model.classes.admin_class;
import framework.modules.users.admin.Model.classes.singleton_admin;

public class auto_json {
	
	
	//	JSON	//
	//			//
	public static void auto_savejson_admin(){
		String PATH=null;
			
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/Config/Model/files_config/files/admin_files/json/auto_json.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_admin.admin.size()>0){
			try{
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("admin_class", admin_class.class);
				
				
					
				Gson gson = new Gson();
				String json = gson.toJson(singleton_admin.admin);
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
		
	public static void auto_openjson_admin() {
		
		String PATH = null;
		admin_class a = new admin_class("");
		
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("admin_class", admin_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/Config/Model/files_config/files/admin_files/json/auto_json.json";
			
			File path = new File(PATH);
			
			if (path.exists()) {
				JsonReader reader = new JsonReader(new FileReader(PATH));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for (JsonElement element : list) {
					a = json.fromJson(element, admin_class.class);
					singleton_admin.admin.add(a);
                //singleton.admin = (ArrayList<Usuarios>) xstream.fromXML(new FileReader(PATH));
				}
			}
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_json"), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	
	public static void auto_savejson_client(){
		String PATH=null;
			
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/Config/Model/files_config/files/client_files/json/auto_json.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_user.client.size()>0){
			try{
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("client_class", client_class.class);
				
				
					
				Gson gson = new Gson();
				String json = gson.toJson(singleton_user.client);
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
                    + "/src/framework/modules/Config/Model/files_config/files/client_files/json/auto_json.json";
			
			File path = new File(PATH);
			
			if (path.exists()) {
				JsonReader reader = new JsonReader(new FileReader(PATH));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for (JsonElement element : list) {
					c = json.fromJson(element, client_class.class);
					singleton_user.client.add(c);
                //singleton.admin = (ArrayList<Usuarios>) xstream.fromXML(new FileReader(PATH));
				}
			}
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_json"), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	
	public static void auto_savejson_reg(){
		String PATH=null;
			
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/Config/Model/files_config/files/reg_files/json/auto_json.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_user.reg.size()>0){
			try{
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("reg_user_class", reg_user_class.class);
				
				
					
				Gson gson = new Gson();
				String json = gson.toJson(singleton_user.reg);
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
	
	public static void auto_openjson_reg() {
		
		String PATH = null;
		reg_user_class u = new reg_user_class("");
		
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("reg_user_class", reg_user_class.class);
			
			PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/Config/Model/files_config/files/reg_files/json/auto_json.json";
			
			File path = new File(PATH);
			
			if (path.exists()) {
				JsonReader reader = new JsonReader(new FileReader(PATH));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for (JsonElement element : list) {
					u = json.fromJson(element, reg_user_class.class);
					singleton_user.reg.add(u);
                //singleton.admin = (ArrayList<Usuarios>) xstream.fromXML(new FileReader(PATH));
				}
			}
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_json"), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

}
