package framework.modules.users.client.Model.BLL;

import javax.swing.JOptionPane;

import org.apache.avalon.framework.configuration.Configurable;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.Config.Model.files_config.auto_config;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.utils_users.lib_files.auto_json;
import framework.modules.users.Model.utils_users.lib_files.auto_txt;
import framework.modules.users.Model.utils_users.lib_files.auto_xml;
import framework.modules.users.Model.utils_users.lib_files.json;
import framework.modules.users.Model.utils_users.lib_files.txt;
import framework.modules.users.Model.utils_users.lib_files.xml;
import framework.modules.users.admin.Model.classes.singleton_admin;
import framework.modules.users.client.Model.classes.singleton_client;


public class funtions_files {
	
	/**Function to select a type of file to save the data of the app
	 * ADMIN option
	 */
	public static void save_admin() {
		
		
		boolean ok=false;
		
		if(singleton_admin.admin.isEmpty()){
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"), JOptionPane.INFORMATION_MESSAGE);
		
		}else{
			do{
				
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.savejson_admin();
					ok=true;
					break;
				case "xml":
					xml.savexml_admin();
					ok=true;
					break;
				case "txt":
					txt.savetxt_admin();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);	
		}
	}
	/**Function to select a type of file to load and select the file to load on app
	 * ADMIN option
	 */
	public static void open_admin() {
		
		
		boolean ok=false;
		
		
		if(singleton_admin.admin.isEmpty()) {
			do{
				
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.openjson_admin();
					ok=true;
					break;
				case "xml":
					xml.openxml_admin();
					ok=true;
					break;
				case "txt":
					txt.opentxt_admin();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);	
		
		}else{
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("alert_msg"),
					class_language.getinstance().getProperty("alert"), JOptionPane.INFORMATION_MESSAGE);
			
			save_admin();
			
			do{
				
				ok=false;
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.openjson_admin();
					ok=true;
					break;
				case "xml":
					xml.openxml_admin();
					ok=true;
					break;
				case "txt":
					txt.opentxt_admin();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);
		}
		
	}
	
	
	/**Function to select a type of file to save the data of the app
	 * CLIENT option
	 */
	public static void save_client() {
		
		
		boolean ok=false;
		
		if(singleton_client.client.isEmpty()){
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"), JOptionPane.INFORMATION_MESSAGE);
		
		}else{
			do{
				
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.savejson_client();
					ok=true;
					break;
				case "xml":
					xml.savexml_client();
					ok=true;
					break;
				case "txt":
					txt.savetxt_client();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);	
		}
	}
	/**Function to select a type of file to load and select the file to load on app
	 * CLIENT option
	 */
	public static void open_client() {
		
		
		boolean ok=false;
		
		
		if(singleton_client.client.isEmpty()) {
			do{
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.openjson_client();
					ok=true;
					break;
				case "xml":
					xml.openxml_client();
					ok=true;
					break;
				case "txt":
					txt.opentxt_client();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);	
		
		}else{
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("alert_msg"),
					class_language.getinstance().getProperty("alert"), JOptionPane.INFORMATION_MESSAGE);
			
			save_client();
			
			do{
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.openjson_client();
					ok=true;
					break;
				case "xml":
					xml.openxml_client();
					ok=true;
					break;
				case "txt":
					txt.opentxt_client();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);
		}
		
	}
	
	
	/**Function to select a type of file to save the data of the app
	 * REG_USER option
	 */
	public static void save_reg() {
		
		boolean ok=false;
		
		if(singleton_user.reg.isEmpty()){
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"), JOptionPane.INFORMATION_MESSAGE);
		
		}else{
			do{
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.savejson_reg();
					ok=true;
					break;
				case "xml":
					xml.savexml_reg();
					ok=true;
					break;
				case "txt":
					txt.savetxt_reg();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);	
		}
	}
	/**Function to select a type of file to load and select the file to load on app
	 * REG_USER option
	 */
	public static void open_reg() {
		
		
		boolean ok=false;
		
		
		if(singleton_user.reg.isEmpty()) {
			do{
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.openjson_reg();
					ok=true;
					break;
				case "xml":
					xml.openxml_reg();
					ok=true;
					break;
				case "txt":
					txt.opentxt_reg();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);	
		
		}else{
			
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("alert_msg"),
					class_language.getinstance().getProperty("alert"), JOptionPane.INFORMATION_MESSAGE);
			
			save_reg();
			
			do{
				
				switch (class_config.getinstance().getFile_format()) {
				case "json":
					json.openjson_reg();
					ok=true;
					break;
				case "xlm":
					xml.openxml_reg();
					ok=true;
					break;
				case "txt":
					txt.opentxt_reg();
					ok=true;
					break;
				default:
					ok=true;
					break;
				}
			}while(ok==false);
		}
		
	}


	public static void auto_open(){
		
		auto_config.auto_openconfig();
		//Admin
		auto_json.auto_openjson_admin();
		//auto_xml.auto_openxml_admin();
		//auto_txt.auto_opentxt_admin();
		
		//Client
		auto_json.auto_openjson_client();
		//auto_xml.auto_openxml_client();
		//auto_txt.auto_opentxt_client();
		
		//Reg user
		auto_json.auto_openjson_reg();
		//auto_xml.auto_openxml_reg();
		//auto_txt.auto_opentxt_reg();
		
	}
	
	public static void auto_save(){
		
		auto_config.auto_saveconfig();
		//Admin
		auto_json.auto_savejson_admin();
		auto_xml.auto_savexml_admin();
		auto_txt.auto_savetxt_admin();
		
		//Client
		auto_json.auto_savejson_client();
		auto_xml.auto_savexml_client();
		auto_txt.auto_savetxt_client();
		
		//Reg user
		auto_json.auto_savejson_reg();
		auto_xml.auto_savexml_reg();
		auto_txt.auto_savetxt_reg();
		
	}
}
