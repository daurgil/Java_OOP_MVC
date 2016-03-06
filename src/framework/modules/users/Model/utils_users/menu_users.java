package framework.modules.users.Model.utils_users;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.Model.utils_users.BLL.funtions_files;
import framework.modules.users.Model.utils_users.BLL.order_users;
import framework.modules.users.Model.utils_users.BLL.CRUD.crud_create;
import framework.modules.users.Model.utils_users.BLL.CRUD.crud_delete;
import framework.modules.users.Model.utils_users.BLL.CRUD.crud_print;
import framework.modules.users.Model.utils_users.BLL.CRUD.crud_upload;
import framework.utils.menus;

public class menu_users {

	public static void admin_menu() {
		
		int op=0;
		boolean repeat= false;
		
		do{
			String[] menu_sec={class_language.getinstance().getProperty("create"),class_language.getinstance().getProperty("change_data"),
					class_language.getinstance().getProperty("order"),class_language.getinstance().getProperty("print") ,
					class_language.getinstance().getProperty("delete"),class_language.getinstance().getProperty("open"),
					class_language.getinstance().getProperty("save"),
					class_language.getinstance().getProperty("back"),class_language.getinstance().getProperty("exit")};
			
			op=menus.menu_botton(menu_sec, class_language.getinstance().getProperty("secon_msg"),
					class_language.getinstance().getProperty("admin_t"));
			repeat=false;
			switch (op) { //posibilities of secundary menu
			
			case 0://create option
				crud_create.create_admin();
				break;
			case 1://upload option
				crud_upload.upload_admin();
				break;
			case 2://order option
				order_users.order_admin();
				break;
			case 3://print option
				crud_print.print_admin();
				break;
			case 4://delete option
				crud_delete.remove_admin();
				break;
			case 5://load a file option
				funtions_files.open_admin();
				break;
			case 6://save a file option
				funtions_files.save_admin();
				break;
			case 7:
				repeat=true;
				break;
			case 8:
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("bye"), 
						class_language.getinstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
				funtions_files.auto_save();
				System.exit(0);
				repeat=true;
				break;
			default:
				JOptionPane.showMessageDialog(null,class_language.getinstance().getProperty("bye"), 
						class_language.getinstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
				funtions_files.auto_save();
				System.exit(0);
				repeat=true;
				//correct=true;
			}
		}while(repeat==false);
	}
	
	public static void client_menu(){
		
		int op=0;
		boolean repeat= false;
		
		do{
			String[] menu_sec={class_language.getinstance().getProperty("create"),class_language.getinstance().getProperty("change_data"),
					class_language.getinstance().getProperty("order"),class_language.getinstance().getProperty("print") ,
					class_language.getinstance().getProperty("delete"),class_language.getinstance().getProperty("open"),
					class_language.getinstance().getProperty("save"),
					class_language.getinstance().getProperty("back"),class_language.getinstance().getProperty("exit")};
			
			op=menus.menu_botton(menu_sec, class_language.getinstance().getProperty("secon_msg"),
					class_language.getinstance().getProperty("client_t"));
			repeat=false;
			switch (op) {
			
			case 0://create option
				crud_create.create_cli();
				break;
			case 1://Upload option
				crud_upload.upload_cli();
				break;
			case 2://Order option
				order_users.order_client();
				break;
			case 3://print option
				crud_print.print_cli();
				break;
			case 4://Delete option
				crud_delete.remove_cli();
				break;
			case 5://load file option
				funtions_files.open_client();
				break;
			case 6://save a file option
				funtions_files.save_client();
				break;
			case 7:
				repeat=true;
				break;
			case 8:
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("bye"), 
						class_language.getinstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
				funtions_files.auto_save();
				System.exit(0);
				repeat=true;
				break;
			default:
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("bye"), 
						class_language.getinstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
				funtions_files.auto_save();
				System.exit(0);
				repeat=true;
				//correct=true;
			}
		}while(repeat==false);
	}
	
	public static void reg_user_menu(){
		
		int op=0;
		boolean repeat= false;
		
		do{
			String[] menu_sec={class_language.getinstance().getProperty("create"),class_language.getinstance().getProperty("change_data"),
					class_language.getinstance().getProperty("order"),class_language.getinstance().getProperty("print") ,
					class_language.getinstance().getProperty("delete"),class_language.getinstance().getProperty("open"),
					class_language.getinstance().getProperty("save"),
					class_language.getinstance().getProperty("back"),class_language.getinstance().getProperty("exit")};
			
			op=menus.menu_botton(menu_sec, class_language.getinstance().getProperty("secon_msg"),
					class_language.getinstance().getProperty("reg_t"));
			repeat=false;
			switch (op) {
			
			case 0://Create option
				crud_create.create_reg_user();
				break;
			case 1://modify option
				crud_upload.upload_reg();
				break;
			case 2://order option
				order_users.order_reg();
				break;
			case 3://print option
				crud_print.print_reg();
				break;
			case 4://Delete option
				crud_delete.remove_reg();
				break;
			case 5://load file option
				funtions_files.open_reg();
				break;
			case 6://save a file option
				funtions_files.save_reg();
				break;
			case 7:
				repeat=true;
				break;
			case 8:
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("bye"), 
						class_language.getinstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
				funtions_files.auto_save();
				System.exit(0);
				repeat=true;
				break;
			default:
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("bye"), 
						class_language.getinstance().getProperty("exit"), JOptionPane.INFORMATION_MESSAGE);
				funtions_files.auto_save();
				System.exit(0);
				repeat=true;
				//correct=true;
			}
		}while(repeat==false);
	}
	
	
}
