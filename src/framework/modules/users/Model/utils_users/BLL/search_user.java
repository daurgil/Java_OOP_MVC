package framework.modules.users.Model.utils_users.BLL;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.users.Model.classes.admin_class;
import framework.modules.users.Model.classes.client_class;
import framework.modules.users.Model.utils_users.core_funtions;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.View.Admin.admin_create;

public class search_user {

	
	/**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_admin(){

		admin_class a=null;
		String dni="";
		
		dni=admin_create.jt_dni.getText();
		a= new admin_class(dni);
		singleton_user.DNI=dni;
		
		for(int i=0; i<=(singleton_user.admin.size()-1);i++){
			if(singleton_user.admin.get(i).equals(a))
				return i;
		}
		return -1;
			
	}
	
	
	/**Function to ask a dni to search if this client user exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_cli(){

		client_class c=null;
		String dni="";
		
		dni=core_funtions.give_Data("dni");
		c= new client_class(dni);
		singleton_user.DNI=dni;
		
		for(int i=0; i<=(singleton_user.client.size()-1);i++){
			if(singleton_user.client.get(i).equals(c))
				return i;
		}
		return -1;
			
	}
	
	
	/**Function to ask a dni to search if this reg_user exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_reg(){

		client_class u=null;
		String dni="";
		
		dni=core_funtions.give_Data("dni");
		u= new client_class(dni);
		singleton_user.DNI=dni;
		
		for(int i=0; i<=(singleton_user.reg.size()-1);i++){
			if(singleton_user.reg.get(i).equals(u))
				return i;
		}
		return -1;
			
	}
}
