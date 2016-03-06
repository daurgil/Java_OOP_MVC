package framework.modules.users.Model.utils_users.BLL.CRUD;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.utils_users.BLL.search_user;
import framework.utils.menus;



public class crud_print {
	
	/**Function to print all or any admin that are included in the arraylist
	 * 
	 * @param language
	 */
	public static void print_admin(){
		
		int menu=0, position=0;
		String[] menu_search={class_language.getinstance().getProperty("all"),
				class_language.getinstance().getProperty("one")};
		//String chain="";
		
		if(singleton_user.admin.isEmpty()){
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{ 
		
			menu=menus.menu_botton(menu_search,"","");
			switch(menu){
			case 0:
				for (int i=0; i<(singleton_user.admin.size()); i++){
					//chain=singleton.admin.get(i).toString();
					JOptionPane.showMessageDialog(null, singleton_user.admin.get(i).toString(),
							"", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 1:
				position=search_user.search_admin();
				if(position==-1){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user1"),
							class_language.getinstance().getProperty("error"), JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, singleton_user.admin.get(position).toString(),
						"", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
				
	}

	/**Function to print all or any client that are included in the arraylist
	 * 
	 * @param language
	 */
	public static void print_cli(){
		
		int menu=0, position=0;
		String[] menu_search={class_language.getinstance().getProperty("all"),
				class_language.getinstance().getProperty("one")};
		String chain="";
		
		if(singleton_user.client.isEmpty()){
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{ 
		
			menu=menus.menu_botton(menu_search,"","");
			switch(menu){
			case 0:
				for (int i=0; i<(singleton_user.client.size()); i++){
					chain=singleton_user.client.get(i).toString();
					JOptionPane.showMessageDialog(null, chain, "titulo", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 1:
				position=search_user.search_cli();
				if(position==-1){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user1"),
							class_language.getinstance().getProperty("error"), JOptionPane.INFORMATION_MESSAGE);
				}else{
				JOptionPane.showMessageDialog(null, singleton_user.client.get(position).toString(),
						"titulo", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		}
				
	}
	
	/**Function to print all or any reg_user that are included in the arraylist
	 * 
	 * @param language
	 */
	public static void print_reg(){
		
		int menu=0, position=0;
		String[] menu_search={class_language.getinstance().getProperty("all"),
				class_language.getinstance().getProperty("one")};
		String chain="";
		
		if(singleton_user.reg.isEmpty()){
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user2"),
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);
			
		}else{ 
		
			menu=menus.menu_botton(menu_search,"","");
			switch(menu){
			case 0:
				for (int i=0; i<(singleton_user.reg.size()); i++){
					chain=singleton_user.reg.get(i).toString();
					JOptionPane.showMessageDialog(null, chain, "titulo", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 1:
				position=search_user.search_reg();
				if(position==-1){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_user1"),
							class_language.getinstance().getProperty("error"), JOptionPane.INFORMATION_MESSAGE);
				}else{
				JOptionPane.showMessageDialog(null, singleton_user.reg.get(position).toString(),
						"titulo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
				
	}
	
}
