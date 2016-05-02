/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.Menu_config.Model.files_config.BLL;

import framework.modules.Menu_config.Model.classes.class_config;
import framework.modules.Menu_config.Model.classes.singleton_config;
import framework.modules.Menu_config.Model.files_config.DAO.DAO_log_in;
import framework.modules.Menu_config.View.log_in;
import framework.modules.users.admin.Model.BLL.BLL_DB_admin;
import framework.modules.users.admin.Model.BLL.BLL_admin;
import framework.modules.users.client.Model.BLL.BLL_client_MG;
import framework.modules.users.reg_user.Model.BLL.BLL_reg;
import framework.utils.singleton;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class BLL_log_in {
    
    /**
     * Funtion to search user in Log in 
     */
    public static void search_in_DB(){
      boolean correct=false;
        
       correct= DAO_log_in.search_admin();
       
       if(correct==false){
           correct=DAO_log_in.search_client();
           
           if (correct==false){
               correct=DAO_log_in.search_reg();
               
               if(correct==false){
                   JOptionPane.showMessageDialog(null, "el usuario no existe");
               }
           }
               
        }
    }
    
    /**
     * funtion to redirect to dao and check if value fields are good
     * @param type
     * @return boolean 
     */
    public static boolean give_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_log_in.dni();
                break;
            case "password":
                correct = DAO_log_in.password();
                break;
        }
        return correct;
    }
    
    /**
     * funtion to see the password in login view
     */
    public static void password_show(){
        DAO_log_in.show_pass();
    }
    
    /**
     * funtion to change the language in login
     */
    public static void translate(){
        class_config.getinstance();
        DAO_log_in.translate();
    }
}       
