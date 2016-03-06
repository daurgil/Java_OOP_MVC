package framework.modules.users.Model.utils_users.BLL.CRUD;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.Model.classes.admin_class;
import framework.modules.users.Model.classes.client_class;
import framework.modules.users.Model.classes.reg_user_class;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.utils_users.BLL.search_user;
import framework.modules.users.Model.utils_users.DAO.user_funtions;



public class crud_create {
	
	
	public static void create_admin(){
		
		int position=-1;
		admin_class a=null;
		
		position=search_user.search_admin();
		
		if(position!=-1)
			JOptionPane.showMessageDialog(null,class_language.getinstance().getProperty("error_user3") , 
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
		else
			a=user_funtions.ask_admin();
			singleton_user.admin.add(a);
	}
	
	
	public static void create_cli(){
		
		int position=-1;
		client_class c=null;
		
		position=search_user.search_cli();
		
		if(position!=-1)
			JOptionPane.showMessageDialog(null,class_language.getinstance().getProperty("error_user3") , 
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
		else
			c=user_funtions.ask_cli();
			singleton_user.client.add(c);
	}
	
	
	public static void create_reg_user(){
		
		int position=-1;
		reg_user_class u=null;
		
		position=search_user.search_reg();
		
		if(position!=-1)
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user3") , 
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
		else
			u=user_funtions.ask_reg();
			singleton_user.reg.add(u);
	}
}
