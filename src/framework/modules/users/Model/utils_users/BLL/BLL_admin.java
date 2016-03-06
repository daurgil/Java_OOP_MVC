/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.Model.utils_users.BLL;

import framework.modules.users.Model.classes.admin_class;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.utils_users.DAO.DAO_admin;
import framework.modules.users.View.Admin.admin_create;
import framework.modules.users.View.Admin.admin_update;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class BLL_admin {
    public static boolean ok;
    
    public static void create(){
        
        admin_class admin=null;
        
        admin=DAO_admin.create();
        if(admin==null){
            admin_create.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
            if(search_admin()!=-1){
                JOptionPane.showMessageDialog(null, "This Id card already exist");
                ok=false;
            }else{
                singleton_user.admin.add(admin);
                JOptionPane.showMessageDialog(null, "The user was created succesfuly"); 
                ok=true;
            }
            
            //admin_form.jl_alert.setText("The user was created succesfuly");
            
        }
    }
    
    public static void show_admin(String DNI){
        int position;
        
        admin_class admin= new admin_class(DNI);
        position=BLL_admin.search_admin(admin);
        
        admin=singleton_user.admin.get(position);
        
        DAO_admin.show_admin(admin);
        
        
    }
    
    public static void modify(){
        int position;
        String dni;
        
        dni=admin_update.DNI;
        admin_class admin= new admin_class(dni);
        position=BLL_admin.search_admin(admin);
        
        admin=DAO_admin.modify();
        
        if(admin==null){
            admin_update.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
          singleton_user.admin.set(position, admin);
          admin_update.jt_alert.setText("The user was created succesfuly"); 
          ok=true;
        }
          
        
    }
    
    public static void clean(){
        DAO_admin.clean();
    }
    
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
		
		for(int i=0; i<=(singleton_user.admin.size()-1);i++){
			if(singleton_user.admin.get(i).equals(a))
				return i;
		}
		return -1;
			
	}
        
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_admin(admin_class admin){

//		admin_class a=admin;
//		String dni="";
//                
//                dni=admin_update.DNI;
//		a= new admin_class(dni);
		
		for(int i=0; i<=(singleton_user.admin.size()-1);i++){
			if(singleton_user.admin.get(i).equals(admin))
				return i;
		}
		return -1;
			
	}
    
    public static void give_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_admin.dni();
                break;
            case "dni_search":
                correct = DAO_admin.dni_search();
                break;
            case "name":
                correct = DAO_admin.name();
                break;
            case "surname":
                correct = DAO_admin.surname();
                break;
            case "mobile":
                correct = DAO_admin.mobile();
                break;
            case "email":
                correct = DAO_admin.email();
                break;
            case "nick":
                correct = DAO_admin.nick();
                break;
            case "password":
                correct = DAO_admin.password();
                break;
            case "avatar":
                correct = DAO_admin.avatar();
                break;
            case "activity":
                correct = DAO_admin.activity();
                break;
            case "birthday":
                correct = DAO_admin.birthday();
                break;
            case "contract":
                correct = DAO_admin.contract();
                break;
        }
    }
    
    public static void update_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_admin.up_dni();
                break;
            case "name":
                correct = DAO_admin.up_name();
                break;
            case "surname":
                correct = DAO_admin.up_surname();
                break;
            case "mobile":
                correct = DAO_admin.up_mobile();
                break;
            case "email":
                correct = DAO_admin.up_email();
                break;
            case "nick":
                correct = DAO_admin.up_nick();
                break;
            case "password":
                correct = DAO_admin.up_password();
                break;
//            case "avatar":
//                correct = DAO_admin.up_avatar();
//                break;
            case "activity":
                correct = DAO_admin.up_activity();
                break;
            case "birthday":
                correct = DAO_admin.up_birthday();
                break;
            case "contract":
                correct = DAO_admin.up_contract();
                break;
        }
    }
}
