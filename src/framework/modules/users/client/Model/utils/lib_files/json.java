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
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.client.Model.classes.client_class;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pelu
 */
public class json {
    
   public static void savejson_client(){
		String PATH=null;
			try{
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("client", client_class.class);
				
				JFileChooser filechooser= new JFileChooser();
				
				filechooser.setAcceptAllFileFilterUsed(false);
	            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
				
				int selection= filechooser.showSaveDialog(null);
				if (selection ==JFileChooser.APPROVE_OPTION) {
					File JFC = filechooser.getSelectedFile();
					PATH = JFC.getAbsolutePath();
					PATH = PATH+ ".json";
					
					Gson gson = new Gson();
					String json = gson.toJson(singleton_user.client);
					FileWriter fileXml =new FileWriter(PATH);
					fileXml.write(json.toString());
					fileXml.close();
					
					JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito",
							"Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error al grabar el JSON",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public static void openjson_client() {
		
		String PATH = null;
		client_class c = new client_class("");
		
		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("client", client_class.class);
			
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
			
			int selection = filechooser.showOpenDialog(null);
			if(selection == filechooser.APPROVE_OPTION) {
				File JFC = filechooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				
				singleton_user.client.clear();
				
				JsonReader reader = new JsonReader(new FileReader(PATH));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for (JsonElement element : list) {
					c = json.fromJson(element, client_class.class);
					singleton_user.client.add(c);
				}
			}
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
