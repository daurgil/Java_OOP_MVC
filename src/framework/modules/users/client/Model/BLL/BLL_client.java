/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.client.Model.BLL;


import framework.modules.users.client.Model.DAO.DAO_client;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.client.Model.classes.singleton_client;
import framework.modules.users.client.View.client_create;
import framework.modules.users.client.View.client_update;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class BLL_client {
    public static boolean ok;
    
    public static void create(){
        
        client_class admin=null;
        
        admin=DAO_client.create();
        if(admin==null){
            client_create.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
            if(search_admin()!=-1){
                JOptionPane.showMessageDialog(null, "This Id card already exist");
                ok=false;
            }else{
                singleton_client.client.add(admin);
                JOptionPane.showMessageDialog(null, "The user was created succesfuly"); 
                ok=true;
            }
            
            //admin_form.jl_alert.setText("The user was created succesfuly");
            
        }
    }
    
    public static void show_admin(String DNI){
        int position;
        
        client_class client= new client_class(DNI);
        position=BLL_client.search_admin(client);
        
        client=singleton_client.client.get(position);
        
        DAO_client.show_client(client);
        
        
    }
    
    public static void modify(){
        int position;
        String dni;
        
        dni=client_update.DNI;
        client_class admin= new client_class(dni);
        position=BLL_client.search_admin(admin);
        
        admin=DAO_client.modify();
        
        if(admin==null){
            client_update.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
          singleton_client.client.set(position, admin);
          client_update.jt_alert.setText("The user was created succesfuly"); 
          ok=true;
        }
          
        
    }
    
    public static void clean(){
        DAO_client.clean();
    }
    
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_admin(){

		client_class a=null;
		String dni="";
		
		dni=client_create.jt_dni.getText();
		a= new client_class(dni);
		
		for(int i=0; i<=(singleton_client.client.size()-1);i++){
			if(singleton_client.client.get(i).equals(a))
				return i;
		}
		return -1;
			
	}
        
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_admin(client_class client){

//		admin_class a=admin;
//		String dni="";
//                
//                dni=admin_update.DNI;
//		a= new admin_class(dni);
		
		for(int i=0; i<=(singleton_client.client.size()-1);i++){
			if(singleton_client.client.get(i).equals(client))
				return i;
		}
		return -1;
			
	}
    
    public static void give_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_client.dni();
                break;
            case "dni_search":
                correct = DAO_client.dni_search();
                break;
            case "name":
                correct = DAO_client.name();
                break;
            case "surname":
                correct = DAO_client.surname();
                break;
            case "mobile":
                correct = DAO_client.mobile();
                break;
            case "email":
                correct = DAO_client.email();
                break;
            case "nick":
                correct = DAO_client.nick();
                break;
            case "password":
                correct = DAO_client.password();
                break;
            case "avatar":
                correct = DAO_client.avatar();
                break;
            case "activity":
                correct = DAO_client.activity();
                break;
            case "birthday":
                correct = DAO_client.birthday();
                break;
            case "contract":
                correct = DAO_client.contract();
                break;
        }
    }
    
    public static void update_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_client.up_dni();
                break;
            case "name":
                correct = DAO_client.up_name();
                break;
            case "surname":
                correct = DAO_client.up_surname();
                break;
            case "mobile":
                correct = DAO_client.up_mobile();
                break;
            case "email":
                correct = DAO_client.up_email();
                break;
            case "nick":
                correct = DAO_client.up_nick();
                break;
            case "password":
                correct = DAO_client.up_password();
                break;
//            case "avatar":
//                correct = DAO_admin.up_avatar();
//                break;
            case "activity":
                correct = DAO_client.up_activity();
                break;
            case "birthday":
                correct = DAO_client.up_birthday();
                break;
            case "contract":
                correct = DAO_client.up_contract();
                break;
        }
    }
}
