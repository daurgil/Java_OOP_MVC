/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.client.Model.DAO;

import com.toedter.calendar.JTextFieldDateEditor;
import framework.classes.class_date;
import framework.modules.users.Model.utils_users.core_date;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.client.View.client_create;
import static framework.modules.users.client.View.client_create.jt_dni;
import framework.modules.users.client.View.client_table;
import framework.modules.users.client.View.client_update;
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
    
    public static client_class create(){
        String dni,name,surname,mobile,email,nick,
                password,avatar, state,birthday,contract;
        int activity;
        client_class client=null;
        class_date birth, cont=null;
        
        boolean prove1, prove2, prove3, prove4, prove5, prove6, prove7, 
                prove9, prove10, prove11;
        
        prove1=DAO_client.dni();
        prove2=DAO_client.name();
        prove3=DAO_client.surname();
        prove4=DAO_client.mobile();
        prove5=DAO_client.email();
        prove6=DAO_client.nick();
        prove7=DAO_client.password();
        //prove8=DAO_admin.avatar();
        prove9=DAO_client.birthday();
        prove10=DAO_client.contract();
        prove11=DAO_client.activity();

        
        if (prove1 == true && prove2 == true && prove3 == true && 
                prove4 == true && prove5 == true && prove6 == true &&
                prove7 == true && prove9 == true && prove10 == true 
                && prove11 == true){
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
            contract=((JTextFieldDateEditor) client_create.jdc_contract.getDateEditor()).getText();
            cont=new class_date(contract);
            activity=Integer.parseInt(client_create.jt_activity.getText());
            
        //client=new client_class(dni, name, surname, mobile, email, nick, password, avatar, state, birth, cont, activity);
        
        }else{
            client=null;
        }
        return client;
    }
    
    public static void show_client(client_class client){
        
        int position;
        String administrator;
        class_date birth=null, cont=null;
        Calendar calendarbirth=Calendar.getInstance();
        Calendar calendarcont=Calendar.getInstance();
        String birthday, contract;
        
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
        
//        cont=client.getDate_cont();
//        Date datecont=new Date();
//        calendarcont.set(cont.getYear(), cont.getMonth()-1, cont.getDay());
//        datecont.setTime(calendarcont.getTimeInMillis());
//        client_update.jdc_contract.setDate(datecont);
//                     
//        client_update.jt_activity.setText(""+client.getActivity());
        
    }
    
    public static client_class modify(){
        String dni,name,surname,mobile,email,nick,
                password,avatar, state,birthday,contract;
        int activity;
        class_date birth, cont=null;
        client_class client=null;
        
        boolean prove1, prove2, prove3, prove4, prove5, prove6, prove7, 
                prove9, prove10, prove11;
        
        prove1=DAO_client.up_dni();
        prove2=DAO_client.up_name();
        prove3=DAO_client.up_surname();
        prove4=DAO_client.up_mobile();
        prove5=DAO_client.up_email();
        prove6=DAO_client.up_nick();
        prove7=DAO_client.up_password();
        //prove8=DAO_admin.avatar();
        prove9=DAO_client.up_birthday();
        prove10=DAO_client.up_contract();
        prove11=DAO_client.up_activity();

        
        if (prove1 == true && prove2 == true && prove3 == true && 
                prove4 == true && prove5 == true && prove6 == true &&
                prove7 == true && prove9 == true && prove10 == true 
                && prove11 == true){
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
//            contract=((JTextFieldDateEditor) client_update.jdc_contract.getDateEditor()).getText();
//            cont=new class_date(contract);
//            activity=Integer.parseInt(client_update.jt_activity.getText());
            
            
        //client=new client_class(dni, name, surname, mobile, email, nick, password, avatar, state, birth, cont, activity);
        
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
        
        client_create.jt_activity.setText("");
        client_create.jt_activity.setBackground(WHITE);
        client_create.check_activity.setIcon(empty);
        
        client_create.jt_avatar.setText("");
        client_create.jt_avatar.setBackground(WHITE);
        client_create.check_avatar.setIcon(empty);
        
        client_create.jrb_conected.setSelected(true);
        client_create.chb_password.setSelected(false);
        
        client_create.jdc_birthday.setDate(null);
        client_create.check_birthday.setIcon(empty);
        
        client_create.jdc_contract.setDate(null);
        client_create.check_contract.setIcon(empty);
        
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
    
    public static boolean activity(){
        boolean check =false;
            
        if(client_create.jt_activity.getText().equals("")){
                client_create.check_activity.setIcon(cancel);
                client_create.jt_activity.setBackground(RED);
                client_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_activity(client_create.jt_activity.getText());
     
                if(check==true){
                    client_create.check_activity.setIcon(apply);
                    client_create.jt_activity.setBackground(GREEN);
                    client_create.jt_alert.setText("");
                    check = true;
                }else{
                    client_create.check_activity.setIcon(cancel);
                    client_create.jt_activity.setBackground(RED);
                    client_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }  
    
    public static boolean up_activity(){
        boolean check=false;
        if((client_update.jt_activity.getText()).isEmpty()){
            client_update.check_activity.setIcon(cancel);
            client_update.jt_activity.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_activity((client_update.jt_activity.getText()))==false){
               client_update.check_activity.setIcon(cancel);
               client_update.jt_activity.setBackground(RED); 
               check=false;
            }else{
                client_update.check_activity.setIcon(apply);
                client_update.jt_activity.setBackground(GREEN);
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
    
    public static boolean contract(){
        String birthday, contract;
        class_date birth, cont;
        boolean check=false, confirm=false;
        int dates=0;
        
        try{
            confirm=validate.validate_date(((JTextFieldDateEditor) client_create.jdc_contract.getDateEditor()).getText());
            if (confirm==false) {
                check=false;
                
            }else{
                birthday=(((JTextFieldDateEditor) client_create.jdc_birthday.getDateEditor()).getText());
                contract=(((JTextFieldDateEditor) client_create.jdc_contract.getDateEditor()).getText());
                birth= new class_date(birthday);
                cont= new class_date(contract);
                birth=core_date.sum_years(birth, 16);
                dates=cont.compare_2dates(birth);
                if(dates<1){
                   // admin_form.jdc_contract.setBackground(RED); 
                    client_create.check_contract.setIcon(cancel);
                    client_create.jt_alert.setText("<html>The date isn't valid,<br/>"
                            + " the date need be afer date birthday</html>");
                    check=false;
                }else{
                    dates=cont.compare_date_to_System();
                    if(dates==1){
                        //admin_form.jdc_contract.setBackground(RED); 
                        client_create.check_contract.setIcon(cancel);
                        client_create.jt_alert.setText("<html>The date isn't valid,<br/>"
                                + " the date need be before actual date</html>");
                        check=false;
                    }else{
                        //admin_form.jdc_contract.setBackground(GREEN);
                        client_create.check_contract.setIcon(apply);
                        client_create.jt_alert.setText("");
                        check=true;
                    }
                    
                }
                
            }
        }catch(Exception e){
            
        }
        return check;
    }
    
    public static boolean up_contract(){
        boolean check=false, confirm=false;
        String birthday, contract;
        class_date birth, cont;
        int dates;
        if((client_update.jdc_birthday.getDate())==null){
            client_update.check_birthday.setIcon(cancel);
            //admin_update.jdc_birthday.setBackground(RED);
        }else{
            birthday=(((JTextFieldDateEditor) client_update.jdc_birthday.getDateEditor()).getText());
            contract=(((JTextFieldDateEditor) client_update.jdc_contract.getDateEditor()).getText());
            birth= new class_date(birthday);
            cont= new class_date(contract);
            dates=cont.compare_2dates(birth);
            if(dates<1){
                   // admin_form.jdc_contract.setBackground(RED); 
                    client_update.check_contract.setIcon(cancel);
                    client_update.jt_alert.setText("The date isn't valid, the date need be afer date birthday");
                    check=false;
                }else{
                    dates=cont.compare_date_to_System();
                    if(dates==1){
                        //admin_form.jdc_contract.setBackground(RED); 
                        client_update.check_contract.setIcon(cancel);
                        client_update.jt_alert.setText("The date isn't valid, the date need be before actual date");
                        check=false;
                    }else{
                        //admin_form.jdc_contract.setBackground(GREEN);
                        client_update.check_contract.setIcon(apply);
                        client_update.jt_alert.setText("");
                        check=true;
                    }
                    
                }
        }
        return check;
    }
    
     
}
