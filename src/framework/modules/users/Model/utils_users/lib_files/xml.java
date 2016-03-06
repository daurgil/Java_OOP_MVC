package framework.modules.users.Model.utils_users.lib_files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;

import framework.modules.users.Model.classes.admin_class;
import framework.modules.users.Model.classes.client_class;
import framework.modules.users.Model.classes.reg_user_class;
import framework.modules.users.Model.classes.singleton_user;

public class xml {
	
	private static final String ENCODING = "UTF-8";
	
	public static void savexml_admin(){
		String PATH = null;
		
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
			
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			
            int selection = filechooser.showSaveDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
            	File JFC = filechooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH+".xml";
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void openxml_admin() {
		String PATH = null;
		
		try {
			
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, admin_class.class);
			
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			
			int selection = filechooser.showOpenDialog(null);
			if(selection == filechooser.APPROVE_OPTION){
				File JFC = filechooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton_user.admin = (ArrayList<admin_class>)xstream.fromXML(new FileReader(PATH));
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	
	public static void savexml_client(){
		String PATH = null;
		
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
			
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			
            int selection = filechooser.showSaveDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
            	File JFC = filechooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH+".xml";
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void openxml_client() {
		String PATH = null;
		
		try {
			
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, client_class.class);
			
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			
			int selection = filechooser.showOpenDialog(null);
			if(selection == filechooser.APPROVE_OPTION){
				File JFC = filechooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton_user.client = (ArrayList<client_class>)xstream.fromXML(new FileReader(PATH));
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void savexml_reg(){
		String PATH = null;
		
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
			
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			
            int selection = filechooser.showSaveDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
            	File JFC = filechooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH+".xml";
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void openxml_reg() {
		String PATH = null;
		
		try {
			
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, reg_user_class.class);
			
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			
			int selection = filechooser.showOpenDialog(null);
			if(selection == filechooser.APPROVE_OPTION){
				File JFC = filechooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton_user.reg = (ArrayList<reg_user_class>)xstream.fromXML(new FileReader(PATH));
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
