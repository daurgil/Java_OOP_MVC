package framework.modules.users.Model.utils_users.BLL.CRUD;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.users.Model.classes.admin_class;
import framework.modules.users.Model.classes.client_class;
import framework.modules.users.Model.classes.reg_user_class;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.utils_users.BLL.search_user;
import framework.modules.users.Model.utils_users.DAO.user_funtions;



public class crud_upload {
	
	public static void upload_admin(){
		
		int position=0;
		admin_class a=null;
		
		if(singleton_user.admin.isEmpty()){
			JOptionPane.showMessageDialog(null, "Don't exist any user", "titulo",
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{
		
			position=search_user.search_admin();
			
			a=singleton_user.admin.get(position);
			user_funtions.modif_admin(a);
			singleton_user.admin.set(position, a);
		}
	}
	
	public static void upload_cli(){
		
		int position=0;
		client_class c=null;
		
		if(singleton_user.client.isEmpty()){
			JOptionPane.showMessageDialog(null, "Don't exist any user", "titulo",
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{
		
			position=search_user.search_cli();
			
			c=singleton_user.client.get(position);
			user_funtions.modif_client(c);
			singleton_user.client.set(position, c);
		}
	}
	
	public static void upload_reg(){
		
		int position=0;
		reg_user_class u=null;
		
		if(singleton_user.reg.isEmpty()){
			JOptionPane.showMessageDialog(null, "Don't exist any user", "titulo",
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{
		
			position=search_user.search_reg();
			
			u=singleton_user.reg.get(position);
			user_funtions.modif_reg_user(u);
			singleton_user.reg.set(position, u);
		}
	}

}
