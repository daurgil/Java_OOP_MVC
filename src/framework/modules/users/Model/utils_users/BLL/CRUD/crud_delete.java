package framework.modules.users.Model.utils_users.BLL.CRUD;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.utils_users.BLL.search_user;



public class crud_delete {
	
	/**Function to remove an admin include in the array list
	 * 
	 * @param language
	 */
	public static void remove_admin(){
		
		int position=0;
		
		if(singleton_user.admin.isEmpty()){
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{ 
			position=search_user.search_admin();
			singleton_user.admin.remove(position);
		}
	}
	
	/**Function to remove an client include in the array list
	 * 
	 * @param language
	 */
	public static void remove_cli(){
		
		int position=0;
		
		if(singleton_user.client.isEmpty()){
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{ 
		
			position=search_user.search_cli();
			singleton_user.client.remove(position);
		}
	}
	
	/**Function to remove an reg_user include in the array list
	 * 
	 * @param language
	 */
	public static void remove_reg(){
		
		int position=0;
		
		if(singleton_user.reg.isEmpty()){
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{ 
		
			position=search_user.search_reg();
			singleton_user.reg.remove(position);
		}
	}

}
