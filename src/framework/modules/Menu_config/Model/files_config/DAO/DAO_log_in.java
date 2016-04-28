/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.Menu_config.Model.files_config.DAO;

import framework.modules.Menu_config.View.log_in;
import framework.modules.users.admin.Model.BLL.BLL_DB_admin;
import framework.modules.users.admin.Model.DAO.DAO_DB_admin;
import framework.modules.users.admin.Model.classes.admin_class;
import framework.modules.users.admin.Model.classes.singleton_admin;
import framework.modules.users.client.Model.BLL.BLL_client_MG;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.client.Model.classes.singleton_client;
import framework.modules.users.reg_user.Model.BLL.BLL_reg;
import framework.modules.users.reg_user.Model.classes.singleton_reg;
import framework.utils.singleton;
import static framework.utils.singleton.*;
import framework.utils.validate;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class DAO_log_in {
    
    public static boolean search_admin(){
        boolean correct= false;
        
        //singleton_admin.login_admin= new admin_class(log_in.jt_dni.getText());
        correct=BLL_DB_admin.search_adminBLL();
        
        if(correct==false){
            
        }else{
            if(singleton_admin.a.getPassword()==null){
                correct=false;
            }else{
            if(singleton_admin.a.getDni().equals(log_in.jt_dni.getText())){
                if(singleton_admin.a.getPassword().equals(log_in.jt_password.getText())){
                    correct=true;
                    singleton.type_login="admin";
                }else{
                    correct=false;
                }
            }else{
                correct=false;
            }
            }     
        }
        System.out.println(correct);
        return correct;
    }
    
    public static boolean search_client(){
        boolean correct= false;
        
        //singleton_client.c= new client_class(log_in.jt_dni.getText());
        correct=BLL_client_MG.search_client();
        
        if(correct==false){
            
        }else{
            if(singleton_client.c.getPassword()==null){
                correct=false;
            }else{
            if(singleton_client.c.getDni().equals(log_in.jt_dni.getText())){
                if(singleton_client.c.getPassword().equals(log_in.jt_password.getText())){
                    correct=true;
                    singleton.type_login="client";
                }else{
                    correct=false;
                }
            }else{
                correct=false;
            }
            }
                
        }
        System.out.println(correct);
        return correct;
    }
    
    public static boolean search_reg(){
        int pos= 0;
        boolean correct=false;
        
        pos=BLL_reg.search_reg_log();
        
        if(pos==-1){
            
        }else{
            if(singleton_reg.r.getDni().equals(log_in.jt_dni.getText())){
                if(singleton_reg.r.getPassword().equals(log_in.jt_password.getText())){
                    correct=true;
                    singleton.type_login="reg";
                }else{
                    correct=false;
                }
            }else{
                correct=false;
            }
                
        }
        return correct;
    }
    
    
    /**
     * Funtion to check the values of the field dni
     * @return the value is valid or not
     */
    public static boolean dni(){
        boolean check =false;
        if(log_in.jt_dni.getText().equals("")){
                log_in.check_dni.setIcon(cancel);
                log_in.jt_dni.setBackground(RED);
                check = false;
            }else{
                check=validate.validate_dni(log_in.jt_dni.getText());
     
                if(check==true){
                    log_in.check_dni.setIcon(apply);
                    log_in.jt_dni.setBackground(GREEN);
                    log_in.jt_password.requestFocus();
                    check = true;
                }else{
                    log_in.check_dni.setIcon(cancel);
                    log_in.jt_dni.setBackground(RED);
                    check = false;
                }
            }
        return check;
        }
    
    /**
     * Funtion to check the values of the field password
     * @return the value is valid or not
     */
    public static boolean password(){
        boolean check =false;
            
        if(log_in.jt_password.getText().equals("")){
                log_in.check_password.setIcon(cancel);
                log_in.jt_password.setBackground(RED);
                check = false;
            }else{
                check=validate.validate_password(log_in.jt_password.getText());
     
                if(check==true){
                    log_in.check_password.setIcon(apply);
                    log_in.jt_password.setBackground(GREEN);
                    log_in.jb_sing.requestFocus();
                    check = true;
                }else{
                    log_in.check_password.setIcon(cancel);
                    log_in.jt_password.setBackground(RED);
                    check = false;
                }
            }
            return check;
    }
    
    /**
     * Funtion to can show the password in field of password
     */
    public static void show_pass(){
        
        if(log_in.jcb_password.isSelected()==true){
            log_in.jt_password.setEchoChar((char)0);
        }else{
            log_in.jt_password.setEchoChar('*');
        }
    }
    
}
