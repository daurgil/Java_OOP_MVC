/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.reg_user.Model.utils.lib_Rfiles;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.admin.Model.classes.admin_class;
import framework.modules.users.admin.Model.classes.singleton_admin;
import framework.modules.users.reg_user.Model.classes.reg_user_class;
import framework.modules.users.reg_user.Model.classes.singleton_reg;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class R_auto_json {
    
    public static void auto_savejson_reg(){
		String PATH=null;
			
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/reg_user/Model/utils/reg_files/json/auto_json.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_reg.reg.size()>0){
			try{
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("reg_user_class", reg_user_class.class);
				
				
					
				Gson gson = new Gson();
				String json = gson.toJson(singleton_reg.reg);
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
                    + "/src/framework/modules/users/reg_user/Model/utils/reg_files/json/auto_json.json";
			
			File path = new File(PATH);
			
			if (path.exists()) {
				JsonReader reader = new JsonReader(new FileReader(PATH));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for (JsonElement element : list) {
					u = json.fromJson(element, reg_user_class.class);
					singleton_reg.reg.add(u);
                //singleton.admin = (ArrayList<Usuarios>) xstream.fromXML(new FileReader(PATH));
				}
			}
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_json"), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
