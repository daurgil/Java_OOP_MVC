/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.reg_user.Model.DAO;

import com.toedter.calendar.JTextFieldDateEditor;
import framework.classes.class_date;
import framework.modules.users.reg_user.Model.classes.reg_user_class;
import framework.modules.users.reg_user.Model.utils.core_date;
import framework.modules.users.reg_user.View.reg_create;
import framework.modules.users.reg_user.View.reg_table;
import framework.modules.users.reg_user.View.reg_update;
import static framework.utils.singleton.apply;
import static framework.utils.singleton.cancel;
import static framework.utils.singleton.empty;
import framework.utils.validate;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.util.Calendar;
import java.util.Date;



/**
 *
 * @author pelu
 */
public class DAO_reg {
    
    public static reg_user_class create(){
        String dni,name,surname,mobile,email,nick,
                password,avatar, state,birthday,contract;
        int activity;
        reg_user_class reg=null;
        class_date birth=null;
        
        boolean prove1, prove2, prove3, prove4, prove5, prove6, prove7, 
                prove9, prove10, prove11;
        
        prove1=DAO_reg.dni();
        prove2=DAO_reg.name();
        prove3=DAO_reg.surname();
        prove4=DAO_reg.mobile();
        prove5=DAO_reg.email();
        prove6=DAO_reg.nick();
        prove7=DAO_reg.password();
        //prove8=DAO_admin.avatar();
        prove9=DAO_reg.birthday();
        prove10=DAO_reg.activity();

        
        if (prove1 == true && prove2 == true && prove3 == true && 
                prove4 == true && prove5 == true && prove6 == true &&
                prove7 == true && prove9 == true && prove10 == true){
            dni=reg_create.jt_dni.getText();
            name=reg_create.jt_name.getText();
            surname=reg_create.jt_surname.getText();
            mobile=reg_create.jt_mobile.getText();
            email=reg_create.jt_email.getText();
            nick=reg_create.jt_nick.getText();
            password=reg_create.jt_password.getText();
            avatar=reg_create.jt_avatar.getText();
            state=DAO_reg.state();
            birthday=((JTextFieldDateEditor) reg_create.jdc_birthday.getDateEditor()).getText();
            birth=new class_date(birthday);
            activity=Integer.parseInt(reg_create.jt_activity.getText());
            
        reg=new reg_user_class(dni, name, surname, mobile, email, nick, password, avatar, state, birth, activity);
        
        }else{
            reg=null;
        }
        return reg;
    }
    
    public static void show_admin(reg_user_class reg){
        
        int position;
        String administrator;
        class_date birth=null, cont=null;
        Calendar calendarbirth=Calendar.getInstance();
        Calendar calendarcont=Calendar.getInstance();
        String birthday, contract;
        
        reg_update.jt_dni.setText(reg.getDni());
        reg_update.jt_name.setText(reg.getName());
        reg_update.jt_surname.setText(reg.getSurname());
        reg_update.jt_mobile.setText(reg.getMobile());
        reg_update.jt_email.setText(reg.getEmail());
        reg_update.jt_nick.setText(reg.getNick());
        reg_update.jt_password.setText(reg.getPassword());
        reg_update.jt_avatar.setText(reg.getAvatar());
        
        if(reg.getState()=="Conected")
            reg_update.jrb_conected.setSelected(true);
        else
            reg_update.jrb_disconected.setSelected(true);
        
        birth=reg.getBirthday();
        Date datebirth=new Date();
        calendarbirth.set(birth.getYear(), birth.getMonth()-1, birth.getDay());
        datebirth.setTime(calendarbirth.getTimeInMillis());
        reg_update.jdc_birthday.setDate(datebirth);
                             
        reg_update.jt_activity.setText(""+reg.getActivity());
        
    }
    
    public static reg_user_class modify(){
        String dni,name,surname,mobile,email,nick,
                password,avatar, state,birthday,contract;
        int activity;
        class_date birth, cont=null;
        reg_user_class reg=null;
        
        boolean prove1, prove2, prove3, prove4, prove5, prove6, prove7, 
                prove9, prove10, prove11;
        
        prove1=DAO_reg.up_dni();
        prove2=DAO_reg.up_name();
        prove3=DAO_reg.up_surname();
        prove4=DAO_reg.up_mobile();
        prove5=DAO_reg.up_email();
        prove6=DAO_reg.up_nick();
        prove7=DAO_reg.up_password();
        //prove8=DAO_admin.avatar();
        prove9=DAO_reg.up_birthday();
        prove10=DAO_reg.up_activity();

        
        if (prove1 == true && prove2 == true && prove3 == true && 
                prove4 == true && prove5 == true && prove6 == true &&
                prove7 == true && prove9 == true && prove10 == true){
            dni=reg_update.jt_dni.getText();
            name=reg_update.jt_name.getText();
            surname=reg_update.jt_surname.getText();
            mobile=reg_update.jt_mobile.getText();
            email=reg_update.jt_email.getText();
            nick=reg_update.jt_nick.getText();
            password=reg_update.jt_password.getText();
            avatar=reg_update.jt_avatar.getText();
            state=DAO_reg.up_state();
            birthday=((JTextFieldDateEditor) reg_update.jdc_birthday.getDateEditor()).getText();
            birth=new class_date(birthday);
            activity=Integer.parseInt(reg_update.jt_activity.getText());
            
            
        reg=new reg_user_class(dni, name, surname, mobile, email, nick, password, avatar, state, birth, activity);
        
        }else{
            reg=null;
        }
        
        return reg;
    }
    
    public static void clean(){
        reg_create.jt_dni.setText("");
        reg_create.jt_dni.setBackground(WHITE);
        reg_create.check_dni.setIcon(empty);
        
        reg_create.jt_name.setText("");
        reg_create.jt_name.setBackground(WHITE);
        reg_create.check_name.setIcon(empty);
        
        reg_create.jt_surname.setText("");
        reg_create.jt_surname.setBackground(WHITE);
        reg_create.check_surname.setIcon(empty);
        
        reg_create.jt_mobile.setText("");
        reg_create.jt_mobile.setBackground(WHITE);
        reg_create.check_mobile.setIcon(empty);
        
        reg_create.jt_email.setText("");
        reg_create.jt_email.setBackground(WHITE);
        reg_create.check_email.setIcon(empty);
        
        reg_create.jt_nick.setText("");
        reg_create.jt_nick.setBackground(WHITE);
        reg_create.check_nick.setIcon(empty);
        
        reg_create.jt_password.setText("");
        reg_create.jt_password.setBackground(WHITE);
        reg_create.check_password.setIcon(empty);
        
        reg_create.jt_avatar.setText("");
        reg_create.jt_avatar.setBackground(WHITE);
        reg_create.check_avatar.setIcon(empty);
        
        reg_create.jt_activity.setText("");
        reg_create.jt_activity.setBackground(WHITE);
        reg_create.check_activity.setIcon(empty);
        
        reg_create.jt_avatar.setText("");
        reg_create.jt_avatar.setBackground(WHITE);
        reg_create.check_avatar.setIcon(empty);
        
        reg_create.jrb_conected.setSelected(true);
        reg_create.chb_password.setSelected(false);
        
        reg_create.jdc_birthday.setDate(null);
        reg_create.check_birthday.setIcon(empty);
        
        
    }
    
    
    public static boolean dni(){
        boolean check =false;
        if(reg_create.jt_dni.getText().equals("")){
                reg_create.check_dni.setIcon(cancel);
                reg_create.jt_dni.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_dni(reg_create.jt_dni.getText());
     
                if(check==true){
                    reg_create.check_dni.setIcon(apply);
                    reg_create.jt_dni.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    //admin_form.jt_name.setText("");
                    //admin_form.jt_name.requestFocus();
                    check = true;
                }else{
                    reg_create.check_dni.setIcon(cancel);
                    reg_create.jt_dni.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
        }
    
    public static boolean dni_search(){
        boolean check =false;
        if(reg_table.jt_dni.getText().equals("")){
                reg_table.check_dni.setIcon(cancel);
                reg_table.jt_dni.setBackground(RED);
                //admin_menu.jl_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_dni(reg_table.jt_dni.getText());
     
                if(check==true){
                    reg_table.check_dni.setIcon(apply);
                    reg_table.jt_dni.setBackground(GREEN);
                    //admin_create.jl_alert.setText("");
                    //admin_form.jt_name.setText("");
                    //admin_form.jt_name.requestFocus();
                    check = true;
                }else{
                    reg_table.check_dni.setIcon(cancel);
                    reg_table.jt_dni.setBackground(RED);
                    //admin_create.jl_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
        }
    
    public static boolean up_dni(){
        boolean check=false;
        if((reg_update.jt_dni.getText()).isEmpty()){
            reg_update.check_dni.setIcon(cancel);
            reg_update.jt_dni.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_dni((reg_update.jt_dni.getText()))==false){
               reg_update.check_dni.setIcon(cancel);
               reg_update.jt_dni.setBackground(RED); 
               check=false;
            }else{
                reg_update.check_dni.setIcon(apply);
                reg_update.jt_dni.setBackground(GREEN);
                check = true;

            }
        }
        
        return check;
    }
    
    public static boolean name(){
        boolean check, check2=false;
            
           if(reg_create.jt_name.getText().equals("")){
                reg_create.check_name.setIcon(cancel);
                reg_create.jt_name.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check2 = false;
            }else{
                check=validate.validate_name(reg_create.jt_name.getText());
     
                if(check==true){
                    reg_create.check_name.setIcon(apply);
                    reg_create.jt_name.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    //admin_form.jt_surname.setText("");
                   //admin_form.jt_surname.requestFocus();
                    check2 = true;
                }else{
                    reg_create.check_name.setIcon(cancel);
                    reg_create.jt_name.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check2 = false;
                }
            }
        return check2;
    }
    
    public static boolean up_name(){
        boolean check=false;
        if((reg_update.jt_name.getText()).isEmpty()){
            reg_update.check_name.setIcon(cancel);
            reg_update.jt_name.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_name((reg_update.jt_name.getText()))==false){
               reg_update.check_name.setIcon(cancel);
               reg_update.jt_name.setBackground(RED); 
               check=false;
            }else{
                reg_update.check_name.setIcon(apply);
                reg_update.jt_name.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean surname(){
        boolean check =false;
            
        if(reg_create.jt_surname.getText().equals("")){
                reg_create.check_surname.setIcon(cancel);
                reg_create.jt_surname.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_surname(reg_create.jt_surname.getText());
     
                if(check==true){
                    reg_create.check_surname.setIcon(apply);
                    reg_create.jt_surname.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    //admin_form.jt_mobile.setText("");
                    //admin_form.jt_mobile.requestFocus();
                    check = true;
                }else{
                    reg_create.check_surname.setIcon(cancel);
                    reg_create.jt_surname.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_surname(){
        boolean check=false;
        if((reg_update.jt_surname.getText()).isEmpty()){
            reg_update.check_surname.setIcon(cancel);
            reg_update.jt_surname.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_surname((reg_update.jt_surname.getText()))==false){
               reg_update.check_surname.setIcon(cancel);
               reg_update.jt_surname.setBackground(RED);
               check=false;
            }else{
                reg_update.check_surname.setIcon(apply);
                reg_update.jt_surname.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean mobile(){
        boolean check, check2 =false;
            
        if(reg_create.jt_mobile.getText().equals("")){
            
                reg_create.check_mobile.setIcon(cancel);
                reg_create.jt_mobile.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check2 = false;
            }else{
                
                check=validate.validate_mobile(reg_create.jt_mobile.getText());
     
                if(check==true){
                    reg_create.check_mobile.setIcon(apply);
                    reg_create.jt_mobile.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    //admin_form.jt_email.setText("");
                    //admin_form.jt_email.requestFocus();
                    check2 = true;
                }else{
                    reg_create.check_mobile.setIcon(cancel);
                    reg_create.jt_mobile.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check2 = false;
                }
            }
            return check2;
    }
    
    public static boolean up_mobile(){
        boolean check=false;
        if((reg_update.jt_mobile.getText()).isEmpty()){
            reg_update.check_mobile.setIcon(cancel);
            reg_update.jt_mobile.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_mobile((reg_update.jt_mobile.getText()))==false){
               reg_update.check_mobile.setIcon(cancel);
               reg_update.jt_mobile.setBackground(RED); 
               check=false;
            }else{
                reg_update.check_mobile.setIcon(apply);
                reg_update.jt_mobile.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean email(){
        boolean check =false;
            
        if(reg_create.jt_email.getText().equals("")){
                reg_create.check_email.setIcon(cancel);
                reg_create.jt_email.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_email(reg_create.jt_email.getText());
     
                if(check==true){
                    reg_create.check_email.setIcon(apply);
                    reg_create.jt_email.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    //admin_form.jt_nick.setText("");
                    //admin_form.jt_nick.requestFocus();
                    check = true;
                }else{
                    reg_create.check_email.setIcon(cancel);
                    reg_create.jt_email.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_email(){
        boolean check=false;
        if((reg_update.jt_email.getText()).isEmpty()){
            reg_update.check_email.setIcon(cancel);
            reg_update.jt_email.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_email((reg_update.jt_email.getText()))==false){
               reg_update.check_email.setIcon(cancel);
               reg_update.jt_email.setBackground(RED);
               check=false;
            }else{
                reg_update.check_email.setIcon(apply);
                reg_update.jt_email.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean nick(){
        boolean check =false;
            
        if(reg_create.jt_nick.getText().equals("")){
                reg_create.check_nick.setIcon(cancel);
                reg_create.jt_nick.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_nick(reg_create.jt_nick.getText());
     
                if(check==true){
                    reg_create.check_nick.setIcon(apply);
                    reg_create.jt_nick.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    //admin_form.jt_password.setTextdni("");
                    //admin_form.jt_password.requestFocus();
                    check = true;
                }else{
                    reg_create.check_nick.setIcon(cancel);
                    reg_create.jt_nick.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }
    
    public static boolean up_nick(){
        boolean check=false;
        if((reg_update.jt_nick.getText()).isEmpty()){
            reg_update.check_nick.setIcon(cancel);
            reg_update.jt_nick.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_nick((reg_update.jt_nick.getText()))==false){
               reg_update.check_nick.setIcon(cancel);
               reg_update.jt_nick.setBackground(RED); 
               check=false;
            }else{
                reg_update.check_nick.setIcon(apply);
                reg_update.jt_nick.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean password(){
        boolean check =false;
            
        if(reg_create.jt_password.getText().equals("")){
                reg_create.check_password.setIcon(cancel);
                reg_create.jt_password.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_password(reg_create.jt_password.getText());
     
                if(check==true){
                    reg_create.check_password.setIcon(apply);
                    reg_create.jt_password.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    //admin_form.jt_avatar.setText("");
                    //admin_form.jt_avatar.requestFocus();
                    check = true;
                }else{
                    reg_create.check_password.setIcon(cancel);
                    reg_create.jt_password.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_password(){
        boolean check=false;
        if((reg_update.jt_password.getText()).isEmpty()){
            reg_update.check_password.setIcon(cancel);
            reg_update.jt_password.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_password((reg_update.jt_password.getText()))==false){
               reg_update.check_password.setIcon(cancel);
               reg_update.jt_password.setBackground(RED);
               check=false;
            }else{
                reg_update.check_password.setIcon(apply);
                reg_update.jt_password.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean avatar(){
        boolean check =false;
            
        if(reg_create.jt_avatar.getText().equals("")){
                reg_create.check_avatar.setIcon(cancel);
                reg_create.jt_avatar.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_avatar(reg_create.jt_avatar.getText());
     
                if(check==true){
                    reg_create.check_avatar.setIcon(apply);
                    reg_create.jt_avatar.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    check = true;
                }else{
                    reg_create.check_avatar.setIcon(cancel);
                    reg_create.jt_avatar.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }
    
    public static String state(){
        String state="";
        
        if(reg_create.jrb_conected.isSelected())
            state="Conected";
        if(reg_create.jrb_disconected.isSelected())
            state="Disconected";
        
        return state;
    }
    
    public static String up_state(){
        String state="";
        
        if(reg_update.jrb_conected.isSelected())
            state="Conected";
        if(reg_update.jrb_disconected.isSelected())
            state="Disconected";
        
        return state;
    }
    
    public static boolean activity(){
        boolean check =false;
            
        if(reg_create.jt_activity.getText().equals("")){
                reg_create.check_activity.setIcon(cancel);
                reg_create.jt_activity.setBackground(RED);
                reg_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_activity(reg_create.jt_activity.getText());
     
                if(check==true){
                    reg_create.check_activity.setIcon(apply);
                    reg_create.jt_activity.setBackground(GREEN);
                    reg_create.jt_alert.setText("");
                    check = true;
                }else{
                    reg_create.check_activity.setIcon(cancel);
                    reg_create.jt_activity.setBackground(RED);
                    reg_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }  
    
    public static boolean up_activity(){
        boolean check=false;
        if((reg_update.jt_activity.getText()).isEmpty()){
            reg_update.check_activity.setIcon(cancel);
            reg_update.jt_activity.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_activity((reg_update.jt_activity.getText()))==false){
               reg_update.check_activity.setIcon(cancel);
               reg_update.jt_activity.setBackground(RED); 
               check=false;
            }else{
                reg_update.check_activity.setIcon(apply);
                reg_update.jt_activity.setBackground(GREEN);
                check = true;
            }
        }
        return check;
    }

    public static boolean birthday(){                                            
        String birthday;
        class_date birth;
        boolean check=false, confirm=false;
        
        try{
            confirm=validate.validate_date(((JTextFieldDateEditor) reg_create.jdc_birthday.getDateEditor()).getText());
            if (confirm==false) {
                check = false;
                
            }else{
                birthday=(((JTextFieldDateEditor) reg_create.jdc_birthday.getDateEditor()).getText());
                birth= new class_date(birthday);
                confirm=core_date.restricted_years(birth, 16);
                if(confirm==false){
                    //admin_form.jdc_birthday.setBackground(RED); 
                    reg_create.check_birthday.setIcon(cancel);
                    reg_create.jt_alert.setText("The date isn't valid, you need 16 years");
                    check = false;
                }else{
                    //admin_form.jdc_birthday.setBackground(GREEN);
                    reg_create.check_birthday.setIcon(apply);
                    reg_create.jt_alert.setText("");
                    check=true;
                }
                
            }
        }catch(Exception e){
            
        }
        return check;
    }
    
    public static boolean up_birthday(){
        boolean check=false, confirm=false;
        String birthday;
        class_date birth;
        if((reg_update.jdc_birthday.getDate())==null){
            //admin_update.check_birthday.setIcon(cancel);
            //admin_update.jdc_birthday.setBackground(RED);
            check=false;
        }else{
            birthday=(((JTextFieldDateEditor) reg_update.jdc_birthday.getDateEditor()).getText());
            birth= new class_date(birthday);
            confirm=core_date.restricted_years(birth, 16);
            if(confirm==false){
               reg_update.check_birthday.setIcon(cancel);
               //admin_update.jdc_birthday.setBackground(RED);
               reg_update.jt_alert.setText("<html>The date isn't valid,<br/>"
                       + " you need 16 years</html>");
               check=false;
            }else{
                reg_update.check_birthday.setIcon(apply);
                reg_update.jt_alert.setText("");
                check = true;
                
            }
        }
        return check;
    }
    
}
