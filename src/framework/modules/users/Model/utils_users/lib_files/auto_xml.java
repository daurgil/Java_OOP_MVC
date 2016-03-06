package framework.modules.users.Model.utils_users.lib_files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;

import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.Model.classes.admin_class;
import framework.modules.users.Model.classes.client_class;
import framework.modules.users.Model.classes.reg_user_class;
import framework.modules.users.Model.classes.singleton_user;

public class auto_xml {

	/*
	 * For xml can recognize the code
	 */
	private static final String ENCODING = "UTF-8";
	
	//	XML		//
	//			//
	
	public static void auto_savexml_admin(){
		
		String PATH = null;
		
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/admin_files/xml/auto_xml.xml";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_user.admin.isEmpty()){
			File path = new File(PATH);
			
			path.delete();
		}else{
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, admin_class.class);
				
				
				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(singleton_user.admin, osw);
				StringBuffer xml = new StringBuffer();
				xml.append(header);
				xml.append(os.toString());
				
	                
	            FileWriter fileXml = new FileWriter(PATH);
	            fileXml.write(xml.toString());
	            fileXml.close();
	            osw.close();
	            os.close();
	            
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_save_xml"), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	
	}
	
	public static void auto_openxml_admin() {
		String PATH;

        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, admin_class.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/admin_files/xml/auto_xml.xml";

            File path = new File(PATH);

            if (path.exists()) {
                singleton_user.admin = (ArrayList<admin_class>) xstream.fromXML(new FileReader(PATH));
            }

        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_xml"),
             "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	
	
	public static void auto_savexml_client(){
		
		String PATH = null;
		
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/client_files/xml/auto_xml.xml";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_user.client.isEmpty()){
			File path = new File(PATH);
			
			path.delete();
		}else{
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, client_class.class);
				
				
				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(singleton_user.client, osw);
				StringBuffer xml = new StringBuffer();
				xml.append(header);
				xml.append(os.toString());
				
	                
	            FileWriter fileXml = new FileWriter(PATH);
	            fileXml.write(xml.toString());
	            fileXml.close();
	            osw.close();
	            os.close();
	            
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_save_xml"), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	
	}
	
	public static void auto_openxml_client() {
		String PATH;

        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, client_class.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/client_files/xml/auto_xml.xml";

            File path = new File(PATH);

            if (path.exists()) {
                singleton_user.client = (ArrayList<client_class>) xstream.fromXML(new FileReader(PATH));
            }

        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_xml"),
             "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	
	
	public static void auto_savexml_reg(){
		
		String PATH = null;
		
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/reg_files/xml/auto_xml.xml";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_user.reg.isEmpty()){
			File path = new File(PATH);
			
			path.delete();
		}else{
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, reg_user_class.class);
				
				
				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(singleton_user.reg, osw);
				StringBuffer xml = new StringBuffer();
				xml.append(header);
				xml.append(os.toString());
				
	                
	            FileWriter fileXml = new FileWriter(PATH);
	            fileXml.write(xml.toString());
	            fileXml.close();
	            osw.close();
	            os.close();
	            
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_save_xml"), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	
	}
	
	public static void auto_openxml_reg() {
		String PATH;

        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, reg_user_class.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/reg_files/xml/auto_xml.xml";

            File path = new File(PATH);

            if (path.exists()) {
                singleton_user.reg = (ArrayList<reg_user_class>) xstream.fromXML(new FileReader(PATH));
            }

        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_xml"),
             "Error", JOptionPane.ERROR_MESSAGE);
        }
	}


}
