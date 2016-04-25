/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.client.Model.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.toedter.calendar.JTextFieldDateEditor;
import framework.classes.class_date;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.client.Model.classes.singleton_client;
import framework.modules.users.client.Model.utils.core_date;
import framework.modules.users.client.View.client_create;
import static framework.modules.users.client.View.client_create.jt_dni;
import framework.modules.users.client.View.client_table;
import framework.modules.users.client.View.client_update;
import framework.utils.singleton;
import static framework.utils.singleton.*;
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
public class DAO_client {
    
   
       
    /**
     * function to create a new client
     * @return 
     */
    public static client_class create(){
        String dni,name,surname,mobile,email,nick,
                password,avatar, state,birthday,
                update,type;
        boolean premium=false;
        float shopping;
        client_class client=null;
        class_date birth, up=null;
        
        boolean prove1, prove2, prove3, prove4, prove5, prove6, prove7, 
                prove9, prove10, prove11, prove12;
        
        prove1=DAO_client.dni();
        prove2=DAO_client.name();
        prove3=DAO_client.surname();
        prove4=DAO_client.mobile();
        prove5=DAO_client.email();
        prove6=DAO_client.nick();
        prove7=DAO_client.password();
        //prove8=DAO_admin.avatar();
        prove9=DAO_client.birthday();
        prove10=DAO_client.up_date();
        prove11=DAO_client.shopping();
        prove12=DAO_client.type();

        
        if (prove1 == true && prove2 == true && prove3 == true && 
                prove4 == true && prove5 == true && prove6 == true &&
                prove7 == true && prove9 == true && prove10 == true 
                && prove11 == true && prove12){
            dni=client_create.jt_dni.getText();
            name=client_create.jt_name.getText();
            surname=client_create.jt_surname.getText();
            mobile=client_create.jt_mobile.getText();
            email=client_create.jt_email.getText();
            nick=client_create.jt_nick.getText();
            password=client_create.jt_password.getText();
            avatar=client_create.jt_avatar.getText();
            state=DAO_client.state();
            birthday=((JTextFieldDateEditor) client_create.jdc_birthday.getDateEditor()).getText();
            birth=new class_date(birthday);
            update=((JTextFieldDateEditor) client_create.jdc_update.getDateEditor()).getText();
            up=new class_date(update);
            shopping=Float.parseFloat(client_create.jt_shopping.getText());
            premium=DAO_client.premium();
            type=client_create.jt_type.getText();
            
        client=new client_class(dni, name, surname, mobile, email, nick, password, avatar, state, birth, up,
                shopping, premium, type);
        
        }else{
            client=null;
        }
        return client;
    }
    
    public static void show_client(client_class client){
        
        int position;
        String administrator;
        class_date birth=null, up=null;
        Calendar calendarbirth=Calendar.getInstance();
        Calendar calendarup=Calendar.getInstance();
        String birthday, update;
        
        client_update.jt_dni.setText(client.getDni());
        client_update.jt_name.setText(client.getName());
        client_update.jt_surname.setText(client.getSurname());
        client_update.jt_mobile.setText(client.getMobile());
        client_update.jt_email.setText(client.getEmail());
        client_update.jt_nick.setText(client.getNick());
        client_update.jt_password.setText(client.getPassword());
        client_update.jt_avatar.setText(client.getAvatar());
        
        if(client.getState()=="Conected")
            client_update.jrb_conected.setSelected(true);
        else
            client_update.jrb_disconected.setSelected(true);
        
        birth=client.getBirthday();
        Date datebirth=new Date();
        calendarbirth.set(birth.getYear(), birth.getMonth()-1, birth.getDay());
        datebirth.setTime(calendarbirth.getTimeInMillis());
        client_update.jdc_birthday.setDate(datebirth);
        
        up=client.getUp_date();
        Date dateup=new Date();
        calendarup.set(up.getYear(), up.getMonth()-1, up.getDay());
        dateup.setTime(calendarup.getTimeInMillis());
        client_update.jdc_update.setDate(dateup);
        
        client_update.jt_shopping.setText(""+client.getShopping());
        if(client.isPremium()==true)
            client_update.jrb_yes.setSelected(true);
        else
            client_update.jrb_no.setSelected(true);
        
        client_update.jt_type.setText(client.getType());
        
        
    }
    
    public static client_class modify(){
        String dni,name,surname,mobile,email,nick,
                password,avatar, state,birthday,
                update,type;
        boolean premium=false;
        float shopping;
        client_class client=null;
        class_date birth, up=null;
        
        boolean prove1, prove2, prove3, prove4, prove5, prove6, prove7, 
                prove9, prove10, prove11, prove12;
        
        prove1=DAO_client.up_dni();
        prove2=DAO_client.up_name();
        prove3=DAO_client.up_surname();
        prove4=DAO_client.up_mobile();
        prove5=DAO_client.up_email();
        prove6=DAO_client.up_nick();
        prove7=DAO_client.up_password();
        //prove8=DAO_admin.avatar();
        prove9=DAO_client.up_birthday();
        prove10=DAO_client.up_up_date();
        prove11=DAO_client.up_shopping();
        prove12=DAO_client.up_type();

        
        if (prove1 == true && prove2 == true && prove3 == true && 
                prove4 == true && prove5 == true && prove6 == true &&
                prove7 == true && prove9 == true && prove10 == true 
                && prove11 == true && prove12){
            dni=client_update.jt_dni.getText();
            name=client_update.jt_name.getText();
            surname=client_update.jt_surname.getText();
            mobile=client_update.jt_mobile.getText();
            email=client_update.jt_email.getText();
            nick=client_update.jt_nick.getText();
            password=client_update.jt_password.getText();
            avatar=client_update.jt_avatar.getText();
            state=DAO_client.up_state();
            birthday=((JTextFieldDateEditor) client_update.jdc_birthday.getDateEditor()).getText();
            birth=new class_date(birthday);
            update=((JTextFieldDateEditor) client_update.jdc_update.getDateEditor()).getText();
            up=new class_date(update);
            shopping=Float.parseFloat(client_update.jt_shopping.getText());
            premium=DAO_client.up_premium();
            type=client_update.jt_type.getText();
            
        client=new client_class(dni, name, surname, mobile, email, nick, password, avatar, state, birth, up,
                shopping, premium, type);
        
        }else{
            client=null;
        }
        return client;
    }
    
    public static void clean(){
        client_create.jt_dni.setText("");
        client_create.jt_dni.setBackground(WHITE);
        client_create.check_dni.setIcon(empty);
        
        client_create.jt_name.setText("");
        client_create.jt_name.setBackground(WHITE);
        client_create.check_name.setIcon(empty);
        
        client_create.jt_surname.setText("");
        client_create.jt_surname.setBackground(WHITE);
        client_create.check_surname.setIcon(empty);
        
        client_create.jt_mobile.setText("");
        client_create.jt_mobile.setBackground(WHITE);
        client_create.check_mobile.setIcon(empty);
        
        client_create.jt_email.setText("");
        client_create.jt_email.setBackground(WHITE);
        client_create.check_email.setIcon(empty);
        
        client_create.jt_nick.setText("");
        client_create.jt_nick.setBackground(WHITE);
        client_create.check_nick.setIcon(empty);
        
        client_create.jt_password.setText("");
        client_create.jt_password.setBackground(WHITE);
        client_create.check_password.setIcon(empty);
        
        client_create.jt_avatar.setText("");
        client_create.jt_avatar.setBackground(WHITE);
        client_create.check_avatar.setIcon(empty);
        
        client_create.jt_shopping.setText("");
        client_create.jt_shopping.setBackground(WHITE);
        client_create.check_activity.setIcon(empty);
        
        client_create.jt_avatar.setText("");
        client_create.jt_avatar.setBackground(WHITE);
        client_create.check_avatar.setIcon(empty);
        
        client_create.jrb_conected.setSelected(true);
        client_create.chb_password.setSelected(false);
        
        client_create.jdc_birthday.setDate(null);
        client_create.check_birthday.setIcon(empty);
        
        client_create.jdc_update.setDate(null);
        client_create.check_update.setIcon(empty);
        
    }
    
    
    public static boolean dni(){
        boolean check =false;
        if(client_create.jt_dni.getText().equals("")){
                client_create.check_dni.setIcon(cancel);
                client_create.jt_dni.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_dni(client_create.jt_dni.getText());
     
                if(check==true){
                    client_create.check_dni.setIcon(apply);
                    jt_dni.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    //admin_form.jt_name.setText("");
                    //admin_form.jt_name.requestFocus();
                    check = true;
                }else{
                    client_create.check_dni.setIcon(cancel);
                    client_create.jt_dni.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
        }
    
    public static boolean dni_search(){
        boolean check =false;
        if(client_table.jt_dni.getText().equals("")){
                client_table.check_dni.setIcon(cancel);
                client_table.jt_dni.setBackground(RED);
                //admin_menu.jl_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_dni(client_table.jt_dni.getText());
     
                if(check==true){
                    client_table.check_dni.setIcon(apply);
                    client_table.jt_dni.setBackground(GREEN);
                    //admin_create.jl_alert.setText("");
                    //admin_form.jt_name.setText("");
                    //admin_form.jt_name.requestFocus();
                    check = true;
                }else{
                    client_table.check_dni.setIcon(cancel);
                    client_table.jt_dni.setBackground(RED);
                    //admin_create.jl_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
        }
    
    public static boolean up_dni(){
        boolean check=false;
        if((client_update.jt_dni.getText()).isEmpty()){
            client_update.check_dni.setIcon(cancel);
            client_update.jt_dni.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_dni((client_update.jt_dni.getText()))==false){
               client_update.check_dni.setIcon(cancel);
               client_update.jt_dni.setBackground(RED); 
               check=false;
            }else{
                client_update.check_dni.setIcon(apply);
                client_update.jt_dni.setBackground(GREEN);
                check = true;

            }
        }
        
        return check;
    }
    
    public static boolean name(){
        boolean check, check2=false;
            
           if(client_create.jt_name.getText().equals("")){
                client_create.check_name.setIcon(cancel);
                client_create.jt_name.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check2 = false;
            }else{
                check=validate.validate_name(client_create.jt_name.getText());
     
                if(check==true){
                    client_create.check_name.setIcon(apply);
                    client_create.jt_name.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    //admin_form.jt_surname.setText("");
                   //admin_form.jt_surname.requestFocus();
                    check2 = true;
                }else{
                    client_create.check_name.setIcon(cancel);
                    client_create.jt_name.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check2 = false;
                }
            }
        return check2;
    }
    
    public static boolean up_name(){
        boolean check=false;
        if((client_update.jt_name.getText()).isEmpty()){
            client_update.check_name.setIcon(cancel);
            client_update.jt_name.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_name((client_update.jt_name.getText()))==false){
               client_update.check_name.setIcon(cancel);
               client_update.jt_name.setBackground(RED); 
               check=false;
            }else{
                client_update.check_name.setIcon(apply);
                client_update.jt_name.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean surname(){
        boolean check =false;
            
        if(client_create.jt_surname.getText().equals("")){
                client_create.check_surname.setIcon(cancel);
                client_create.jt_surname.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_surname(client_create.jt_surname.getText());
     
                if(check==true){
                    client_create.check_surname.setIcon(apply);
                    client_create.jt_surname.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    //admin_form.jt_mobile.setText("");
                    //admin_form.jt_mobile.requestFocus();
                    check = true;
                }else{
                    client_create.check_surname.setIcon(cancel);
                    client_create.jt_surname.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_surname(){
        boolean check=false;
        if((client_update.jt_surname.getText()).isEmpty()){
            client_update.check_surname.setIcon(cancel);
            client_update.jt_surname.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_surname((client_update.jt_surname.getText()))==false){
               client_update.check_surname.setIcon(cancel);
               client_update.jt_surname.setBackground(RED);
               check=false;
            }else{
                client_update.check_surname.setIcon(apply);
                client_update.jt_surname.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean mobile(){
        boolean check, check2 =false;
            
        if(client_create.jt_mobile.getText().equals("")){
            
                client_create.check_mobile.setIcon(cancel);
                client_create.jt_mobile.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check2 = false;
            }else{
                
                check=validate.validate_mobile(client_create.jt_mobile.getText());
     
                if(check==true){
                    client_create.check_mobile.setIcon(apply);
                    client_create.jt_mobile.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    //admin_form.jt_email.setText("");
                    //admin_form.jt_email.requestFocus();
                    check2 = true;
                }else{
                    client_create.check_mobile.setIcon(cancel);
                    client_create.jt_mobile.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check2 = false;
                }
            }
            return check2;
    }
    
    public static boolean up_mobile(){
        boolean check=false;
        if((client_update.jt_mobile.getText()).isEmpty()){
            client_update.check_mobile.setIcon(cancel);
            client_update.jt_mobile.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_mobile((client_update.jt_mobile.getText()))==false){
               client_update.check_mobile.setIcon(cancel);
               client_update.jt_mobile.setBackground(RED); 
               check=false;
            }else{
                client_update.check_mobile.setIcon(apply);
                client_update.jt_mobile.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean email(){
        boolean check =false;
            
        if(client_create.jt_email.getText().equals("")){
                client_create.check_email.setIcon(cancel);
                client_create.jt_email.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_email(client_create.jt_email.getText());
     
                if(check==true){
                    client_create.check_email.setIcon(apply);
                    client_create.jt_email.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    //admin_form.jt_nick.setText("");
                    //admin_form.jt_nick.requestFocus();
                    check = true;
                }else{
                    client_create.check_email.setIcon(cancel);
                    client_create.jt_email.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_email(){
        boolean check=false;
        if((client_update.jt_email.getText()).isEmpty()){
            client_update.check_email.setIcon(cancel);
            client_update.jt_email.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_email((client_update.jt_email.getText()))==false){
               client_update.check_email.setIcon(cancel);
               client_update.jt_email.setBackground(RED);
               check=false;
            }else{
                client_update.check_email.setIcon(apply);
                client_update.jt_email.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean nick(){
        boolean check =false;
            
        if(client_create.jt_nick.getText().equals("")){
                client_create.check_nick.setIcon(cancel);
                client_create.jt_nick.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_nick(client_create.jt_nick.getText());
     
                if(check==true){
                    client_create.check_nick.setIcon(apply);
                    client_create.jt_nick.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    //admin_form.jt_password.setTextdni("");
                    //admin_form.jt_password.requestFocus();
                    check = true;
                }else{
                    client_create.check_email.setIcon(cancel);
                    client_create.jt_nick.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }
    
    public static boolean up_nick(){
        boolean check=false;
        if((client_update.jt_nick.getText()).isEmpty()){
            client_update.check_nick.setIcon(cancel);
            client_update.jt_nick.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_nick((client_update.jt_nick.getText()))==false){
               client_update.check_nick.setIcon(cancel);
               client_update.jt_nick.setBackground(RED); 
               check=false;
            }else{
                client_update.check_nick.setIcon(apply);
                client_update.jt_nick.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean password(){
        boolean check =false;
            
        if(client_create.jt_password.getText().equals("")){
                client_create.check_password.setIcon(cancel);
                client_create.jt_password.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_password(client_create.jt_password.getText());
     
                if(check==true){
                    client_create.check_password.setIcon(apply);
                    client_create.jt_password.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    //admin_form.jt_avatar.setText("");
                    //admin_form.jt_avatar.requestFocus();
                    check = true;
                }else{
                    client_create.check_password.setIcon(cancel);
                    client_create.jt_password.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_password(){
        boolean check=false;
        if((client_update.jt_password.getText()).isEmpty()){
            client_update.check_password.setIcon(cancel);
            client_update.jt_password.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_password((client_update.jt_password.getText()))==false){
               client_update.check_password.setIcon(cancel);
               client_update.jt_password.setBackground(RED);
               check=false;
            }else{
                client_update.check_password.setIcon(apply);
                client_update.jt_password.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean avatar(){
        boolean check =false;
            
        if(client_create.jt_avatar.getText().equals("")){
                client_create.check_avatar.setIcon(cancel);
                client_create.jt_avatar.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_avatar(client_create.jt_avatar.getText());
     
                if(check==true){
                    client_create.check_avatar.setIcon(apply);
                    client_create.jt_avatar.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    check = true;
                }else{
                    client_create.check_avatar.setIcon(cancel);
                    client_create.jt_avatar.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }
    
    public static String state(){
        String state="";
        
        if(client_create.jrb_conected.isSelected())
            state="Conected";
        if(client_create.jrb_disconected.isSelected())
            state="Disconected";
        
        return state;
    }
    
    public static String up_state(){
        String state="";
        
        if(client_update.jrb_conected.isSelected())
            state="Conected";
        if(client_update.jrb_disconected.isSelected())
            state="Disconected";
        
        return state;
    }
    
    public static boolean shopping(){
        boolean check =false;
            
        if(client_create.jt_shopping.getText().equals("")){
                client_create.check_shopping.setIcon(cancel);
                client_create.jt_shopping.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_shopping(client_create.jt_shopping.getText());
     
                if(check==true){
                    client_create.check_shopping.setIcon(apply);
                    client_create.jt_shopping.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    check = true;
                }else{
                    client_create.check_shopping.setIcon(cancel);
                    client_create.jt_shopping.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }  
    
    public static boolean up_shopping(){
        boolean check=false;
        if((client_update.jt_shopping.getText()).isEmpty()){
            client_update.check_shopping.setIcon(cancel);
            client_update.jt_shopping.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_shopping((client_update.jt_shopping.getText()))==false){
               client_update.check_shopping.setIcon(cancel);
               client_update.jt_shopping.setBackground(RED); 
               check=false;
            }else{
                client_update.check_shopping.setIcon(apply);
                client_update.jt_shopping.setBackground(GREEN);
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
            confirm=validate.validate_date(((JTextFieldDateEditor) client_create.jdc_birthday.getDateEditor()).getText());
            if (confirm==false) {
                check = false;
                
            }else{
                birthday=(((JTextFieldDateEditor) client_create.jdc_birthday.getDateEditor()).getText());
                birth= new class_date(birthday);
                confirm=core_date.restricted_years(birth, 16);
                if(confirm==false){
                    //admin_form.jdc_birthday.setBackground(RED); 
                    client_create.check_birthday.setIcon(cancel);
                    client_create.jt_alert.setText("The date isn't valid, you need 16 years");
                    check = false;
                }else{
                    //admin_form.jdc_birthday.setBackground(GREEN);
                    client_create.check_birthday.setIcon(apply);
                    client_create.jt_alert.setText("");
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
        if((client_update.jdc_birthday.getDate())==null){
            //admin_update.check_birthday.setIcon(cancel);
            //admin_update.jdc_birthday.setBackground(RED);
            check=false;
        }else{
            birthday=(((JTextFieldDateEditor) client_update.jdc_birthday.getDateEditor()).getText());
            birth= new class_date(birthday);
            confirm=core_date.restricted_years(birth, 16);
            if(confirm==false){
               client_update.check_birthday.setIcon(cancel);
               //admin_update.jdc_birthday.setBackground(RED);
               client_update.jt_alert.setText("<html>The date isn't valid,<br/>"
                       + " you need 16 years</html>");
               check=false;
            }else{
                client_update.check_birthday.setIcon(apply);
                client_update.jt_alert.setText("");
                check = true;
                
            }
        }
        return check;
    }
    
    public static boolean up_date(){
        String birthday, update;
        class_date birth, up;
        boolean check=false, confirm=false;
        int dates=0;
        
        try{
            confirm=validate.validate_date(((JTextFieldDateEditor) client_create.jdc_update.getDateEditor()).getText());
            if (confirm==false) {
                check=false;
                
            }else{
                birthday=(((JTextFieldDateEditor) client_create.jdc_birthday.getDateEditor()).getText());
                update=(((JTextFieldDateEditor) client_create.jdc_update.getDateEditor()).getText());
                birth= new class_date(birthday);
                up= new class_date(update);
                birth=core_date.sum_years(birth, 18);
                dates=up.compare_2dates(birth);
                if(dates<1){
                   
                    client_create.check_update.setIcon(cancel);
                    client_create.jt_alert.setText("<html>The date isn't valid,<br/>"
                            + " the date need be afer date birthday</html>");
                    check=false;
                }else{
                    dates=up.compare_date_to_System();
                    if(dates==1){
                        //admin_form.jdc_contract.setBackground(RED); 
                        client_create.check_update.setIcon(cancel);
                        client_create.jt_alert.setText("<html>The date isn't valid,<br/>"
                                + " the date need be before actual date</html>");
                        check=false;
                    }else{
                        //admin_form.jdc_contract.setBackground(GREEN);
                        client_create.check_update.setIcon(apply);
                        client_create.jt_alert.setText("");
                        check=true;
                    }
                    
                }
                
            }
        }catch(Exception e){
            
        }
        return check;
    }
    
    public static boolean up_up_date(){
        boolean check=false, confirm=false;
        String birthday, contract;
        class_date birth, cont;
        int dates;
        if((client_update.jdc_birthday.getDate())==null){
            client_update.check_birthday.setIcon(cancel);
            //admin_update.jdc_birthday.setBackground(RED);
        }else{
            birthday=(((JTextFieldDateEditor) client_update.jdc_birthday.getDateEditor()).getText());
            contract=(((JTextFieldDateEditor) client_update.jdc_update.getDateEditor()).getText());
            birth= new class_date(birthday);
            cont= new class_date(contract);
            dates=cont.compare_2dates(birth);
            if(dates<1){
                   // admin_form.jdc_contract.setBackground(RED); 
                    client_update.check_update.setIcon(cancel);
                    client_update.jt_alert.setText("The date isn't valid, the date need be afer date birthday");
                    check=false;
                }else{
                    dates=cont.compare_date_to_System();
                    if(dates==1){
                        //admin_form.jdc_contract.setBackground(RED); 
                        client_update.check_update.setIcon(cancel);
                        client_update.jt_alert.setText("The date isn't valid, the date need be before actual date");
                        check=false;
                    }else{
                        //admin_form.jdc_contract.setBackground(GREEN);
                        client_update.check_update.setIcon(apply);
                        client_update.jt_alert.setText("");
                        check=true;
                    }
                    
                }
        }
        return check;
    }
    
    public static boolean premium(){
        boolean premium=false;
        
        if(client_create.jrb_yes.isSelected())
            premium=true;
        if(client_create.jrb_no.isSelected())
            premium=false;
        
        return premium;
    }
    
    public static boolean up_premium(){
        boolean premium=false;
        
        if(client_update.jrb_yes.isSelected())
            premium=true;
        if(client_update.jrb_no.isSelected())
            premium=false;
        
        return premium;
    }
    
    public static boolean type(){
        boolean check =false;
            
        if(client_create.jt_type.getText().equals("")){
                client_create.check_type.setIcon(cancel);
                client_create.jt_type.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_type(client_create.jt_type.getText());
     
                if(check==true){
                    client_create.check_type.setIcon(apply);
                    client_create.jt_type.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    check = true;
                }else{
                    client_create.check_type.setIcon(cancel);
                    client_create.jt_type.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }  
    
    public static boolean up_type(){
        boolean check=false;
        if((client_update.jt_type.getText()).isEmpty()){
            client_update.check_type.setIcon(cancel);
            client_update.jt_type.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_type((client_update.jt_type.getText()))==false){
               client_update.check_type.setIcon(cancel);
               client_update.jt_type.setBackground(RED); 
               check=false;
            }else{
                client_update.check_shopping.setIcon(apply);
                client_update.jt_type.setBackground(GREEN);
                check = true;
            }
        }
        return check;
    } 
}
