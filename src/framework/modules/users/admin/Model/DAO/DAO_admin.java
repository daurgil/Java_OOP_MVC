/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.admin.Model.DAO;

import com.toedter.calendar.JTextFieldDateEditor;
import framework.classes.class_date;
import framework.modules.users.Model.utils_users.core_date;
import framework.modules.users.admin.Model.classes.admin_class;
import framework.modules.users.admin.View.admin_create;
import framework.modules.users.admin.View.admin_table;
import framework.modules.users.admin.View.admin_update;
import static framework.modules.users.admin.View.admin_update.jt_dni;
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
public class DAO_admin {
    
    public static admin_class create(){
        String dni,name,surname,mobile,email,nick,
                password,avatar, state,birthday,contract;
        int activity;
        admin_class admin=null;
        class_date birth, cont=null;
        
        boolean prove1, prove2, prove3, prove4, prove5, prove6, prove7, 
                prove9, prove10, prove11;
        
        prove1=DAO_admin.dni();
        prove2=DAO_admin.name();
        prove3=DAO_admin.surname();
        prove4=DAO_admin.mobile();
        prove5=DAO_admin.email();
        prove6=DAO_admin.nick();
        prove7=DAO_admin.password();
        //prove8=DAO_admin.avatar();
        prove9=DAO_admin.birthday();
        prove10=DAO_admin.contract();
        prove11=DAO_admin.activity();

        
        if (prove1 == true && prove2 == true && prove3 == true && 
                prove4 == true && prove5 == true && prove6 == true &&
                prove7 == true && prove9 == true && prove10 == true 
                && prove11 == true){
            dni=admin_create.jt_dni.getText();
            name=admin_create.jt_name.getText();
            surname=admin_create.jt_surname.getText();
            mobile=admin_create.jt_mobile.getText();
            email=admin_create.jt_email.getText();
            nick=admin_create.jt_nick.getText();
            password=admin_create.jt_password.getText();
            avatar=admin_create.jt_avatar.getText();
            state=DAO_admin.state();
            birthday=((JTextFieldDateEditor) admin_create.jdc_birthday.getDateEditor()).getText();
            birth=new class_date(birthday);
            contract=((JTextFieldDateEditor) admin_create.jdc_contract.getDateEditor()).getText();
            cont=new class_date(contract);
            activity=Integer.parseInt(admin_create.jt_activity.getText());
            
        admin=new admin_class(dni, name, surname, mobile, email, nick, password, avatar, state, birth, cont, activity);
        
        }else{
            admin=null;
        }
        return admin;
    }
    
    public static void show_admin(admin_class admin){
        
        int position;
        String administrator;
        class_date birth=null, cont=null;
        Calendar calendarbirth=Calendar.getInstance();
        Calendar calendarcont=Calendar.getInstance();
        String birthday, contract;
        
        admin_update.jt_dni.setText(admin.getDni());
        admin_update.jt_name.setText(admin.getName());
        admin_update.jt_surname.setText(admin.getSurname());
        admin_update.jt_mobile.setText(admin.getMobile());
        admin_update.jt_email.setText(admin.getEmail());
        admin_update.jt_nick.setText(admin.getNick());
        admin_update.jt_password.setText(admin.getPassword());
        admin_update.jt_avatar.setText(admin.getAvatar());
        
        if(admin.getState()=="Conected")
            admin_update.jrb_conected.setSelected(true);
        else
            admin_update.jrb_disconected.setSelected(true);
        
        birth=admin.getBirthday();
        Date datebirth=new Date();
        calendarbirth.set(birth.getYear(), birth.getMonth()-1, birth.getDay());
        datebirth.setTime(calendarbirth.getTimeInMillis());
        admin_update.jdc_birthday.setDate(datebirth);
        
        cont=admin.getDate_cont();
        Date datecont=new Date();
        calendarcont.set(cont.getYear(), cont.getMonth()-1, cont.getDay());
        datecont.setTime(calendarcont.getTimeInMillis());
        admin_update.jdc_contract.setDate(datecont);
                     
        admin_update.jt_activity.setText(""+admin.getActivity());
        
    }
    
    public static admin_class modify(){
        String dni,name,surname,mobile,email,nick,
                password,avatar, state,birthday,contract;
        int activity;
        class_date birth, cont=null;
        admin_class admin=null;
        
        boolean prove1, prove2, prove3, prove4, prove5, prove6, prove7, 
                prove9, prove10, prove11;
        
        prove1=DAO_admin.up_dni();
        prove2=DAO_admin.up_name();
        prove3=DAO_admin.up_surname();
        prove4=DAO_admin.up_mobile();
        prove5=DAO_admin.up_email();
        prove6=DAO_admin.up_nick();
        prove7=DAO_admin.up_password();
        //prove8=DAO_admin.avatar();
        prove9=DAO_admin.up_birthday();
        prove10=DAO_admin.up_contract();
        prove11=DAO_admin.up_activity();

        
        if (prove1 == true && prove2 == true && prove3 == true && 
                prove4 == true && prove5 == true && prove6 == true &&
                prove7 == true && prove9 == true && prove10 == true 
                && prove11 == true){
            dni=admin_update.jt_dni.getText();
            name=admin_update.jt_name.getText();
            surname=admin_update.jt_surname.getText();
            mobile=admin_update.jt_mobile.getText();
            email=admin_update.jt_email.getText();
            nick=admin_update.jt_nick.getText();
            password=admin_update.jt_password.getText();
            avatar=admin_update.jt_avatar.getText();
            state=DAO_admin.up_state();
            birthday=((JTextFieldDateEditor) admin_update.jdc_birthday.getDateEditor()).getText();
            birth=new class_date(birthday);
            contract=((JTextFieldDateEditor) admin_update.jdc_contract.getDateEditor()).getText();
            cont=new class_date(contract);
            activity=Integer.parseInt(admin_update.jt_activity.getText());
            
            
        admin=new admin_class(dni, name, surname, mobile, email, nick, password, avatar, state, birth, cont, activity);
        
        }else{
            admin=null;
        }
        
        return admin;
    }
    
    public static void clean(){
        admin_create.jt_dni.setText("");
        admin_create.jt_dni.setBackground(WHITE);
        admin_create.check_dni.setIcon(empty);
        
        admin_create.jt_name.setText("");
        admin_create.jt_name.setBackground(WHITE);
        admin_create.check_name.setIcon(empty);
        
        admin_create.jt_surname.setText("");
        admin_create.jt_surname.setBackground(WHITE);
        admin_create.check_surname.setIcon(empty);
        
        admin_create.jt_mobile.setText("");
        admin_create.jt_mobile.setBackground(WHITE);
        admin_create.check_mobile.setIcon(empty);
        
        admin_create.jt_email.setText("");
        admin_create.jt_email.setBackground(WHITE);
        admin_create.check_email.setIcon(empty);
        
        admin_create.jt_nick.setText("");
        admin_create.jt_nick.setBackground(WHITE);
        admin_create.check_nick.setIcon(empty);
        
        admin_create.jt_password.setText("");
        admin_create.jt_password.setBackground(WHITE);
        admin_create.check_password.setIcon(empty);
        
        admin_create.jt_avatar.setText("");
        admin_create.jt_avatar.setBackground(WHITE);
        admin_create.check_avatar.setIcon(empty);
        
        admin_create.jt_activity.setText("");
        admin_create.jt_activity.setBackground(WHITE);
        admin_create.check_activity.setIcon(empty);
        
        admin_create.jt_avatar.setText("");
        admin_create.jt_avatar.setBackground(WHITE);
        admin_create.check_avatar.setIcon(empty);
        
        admin_create.jrb_conected.setSelected(true);
        admin_create.chb_password.setSelected(false);
        
        admin_create.jdc_birthday.setDate(null);
        admin_create.check_birthday.setIcon(empty);
        
        admin_create.jdc_contract.setDate(null);
        admin_create.check_contract.setIcon(empty);
        
    }
    
    
    public static boolean dni(){
        boolean check =false;
        if(admin_create.jt_dni.getText().equals("")){
                admin_create.check_dni.setIcon(cancel);
                admin_create.jt_dni.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_dni(admin_create.jt_dni.getText());
     
                if(check==true){
                    admin_create.check_dni.setIcon(apply);
                    jt_dni.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    //admin_form.jt_name.setText("");
                    //admin_form.jt_name.requestFocus();
                    check = true;
                }else{
                    admin_create.check_dni.setIcon(cancel);
                    admin_create.jt_dni.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
        }
    
    public static boolean dni_search(){
        boolean check =false;
        if(admin_table.jt_dni.getText().equals("")){
                admin_table.check_dni.setIcon(cancel);
                admin_table.jt_dni.setBackground(RED);
                //admin_menu.jl_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_dni(admin_table.jt_dni.getText());
     
                if(check==true){
                    admin_table.check_dni.setIcon(apply);
                    admin_table.jt_dni.setBackground(GREEN);
                    //admin_create.jl_alert.setText("");
                    //admin_form.jt_name.setText("");
                    //admin_form.jt_name.requestFocus();
                    check = true;
                }else{
                    admin_table.check_dni.setIcon(cancel);
                    admin_table.jt_dni.setBackground(RED);
                    //admin_create.jl_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
        }
    
    public static boolean up_dni(){
        boolean check=false;
        if((admin_update.jt_dni.getText()).isEmpty()){
            admin_update.check_dni.setIcon(cancel);
            admin_update.jt_dni.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_dni((admin_update.jt_dni.getText()))==false){
               admin_update.check_dni.setIcon(cancel);
               admin_update.jt_dni.setBackground(RED); 
               check=false;
            }else{
                admin_update.check_dni.setIcon(apply);
                admin_update.jt_dni.setBackground(GREEN);
                check = true;

            }
        }
        
        return check;
    }
    
    public static boolean name(){
        boolean check, check2=false;
            
           if(admin_create.jt_name.getText().equals("")){
                admin_create.check_name.setIcon(cancel);
                admin_create.jt_name.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check2 = false;
            }else{
                check=validate.validate_name(admin_create.jt_name.getText());
     
                if(check==true){
                    admin_create.check_name.setIcon(apply);
                    admin_create.jt_name.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    //admin_form.jt_surname.setText("");
                   //admin_form.jt_surname.requestFocus();
                    check2 = true;
                }else{
                    admin_create.check_name.setIcon(cancel);
                    admin_create.jt_name.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check2 = false;
                }
            }
        return check2;
    }
    
    public static boolean up_name(){
        boolean check=false;
        if((admin_update.jt_name.getText()).isEmpty()){
            admin_update.check_name.setIcon(cancel);
            admin_update.jt_name.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_name((admin_update.jt_name.getText()))==false){
               admin_update.check_name.setIcon(cancel);
               admin_update.jt_name.setBackground(RED); 
               check=false;
            }else{
                admin_update.check_name.setIcon(apply);
                admin_update.jt_name.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean surname(){
        boolean check =false;
            
        if(admin_create.jt_surname.getText().equals("")){
                admin_create.check_surname.setIcon(cancel);
                admin_create.jt_surname.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_surname(admin_create.jt_surname.getText());
     
                if(check==true){
                    admin_create.check_surname.setIcon(apply);
                    admin_create.jt_surname.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    //admin_form.jt_mobile.setText("");
                    //admin_form.jt_mobile.requestFocus();
                    check = true;
                }else{
                    admin_create.check_surname.setIcon(cancel);
                    admin_create.jt_surname.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_surname(){
        boolean check=false;
        if((admin_update.jt_surname.getText()).isEmpty()){
            admin_update.check_surname.setIcon(cancel);
            admin_update.jt_surname.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_surname((admin_update.jt_surname.getText()))==false){
               admin_update.check_surname.setIcon(cancel);
               admin_update.jt_surname.setBackground(RED);
               check=false;
            }else{
                admin_update.check_surname.setIcon(apply);
                admin_update.jt_surname.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean mobile(){
        boolean check, check2 =false;
            
        if(admin_create.jt_mobile.getText().equals("")){
            
                admin_create.check_mobile.setIcon(cancel);
                admin_create.jt_mobile.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check2 = false;
            }else{
                
                check=validate.validate_mobile(admin_create.jt_mobile.getText());
     
                if(check==true){
                    admin_create.check_mobile.setIcon(apply);
                    admin_create.jt_mobile.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    //admin_form.jt_email.setText("");
                    //admin_form.jt_email.requestFocus();
                    check2 = true;
                }else{
                    admin_create.check_mobile.setIcon(cancel);
                    admin_create.jt_mobile.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check2 = false;
                }
            }
            return check2;
    }
    
    public static boolean up_mobile(){
        boolean check=false;
        if((admin_update.jt_mobile.getText()).isEmpty()){
            admin_update.check_mobile.setIcon(cancel);
            admin_update.jt_mobile.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_mobile((admin_update.jt_mobile.getText()))==false){
               admin_update.check_mobile.setIcon(cancel);
               admin_update.jt_mobile.setBackground(RED); 
               check=false;
            }else{
                admin_update.check_mobile.setIcon(apply);
                admin_update.jt_mobile.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean email(){
        boolean check =false;
            
        if(admin_create.jt_email.getText().equals("")){
                admin_create.check_email.setIcon(cancel);
                admin_create.jt_email.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_email(admin_create.jt_email.getText());
     
                if(check==true){
                    admin_create.check_email.setIcon(apply);
                    admin_create.jt_email.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    //admin_form.jt_nick.setText("");
                    //admin_form.jt_nick.requestFocus();
                    check = true;
                }else{
                    admin_create.check_email.setIcon(cancel);
                    admin_create.jt_email.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_email(){
        boolean check=false;
        if((admin_update.jt_email.getText()).isEmpty()){
            admin_update.check_email.setIcon(cancel);
            admin_update.jt_email.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_email((admin_update.jt_email.getText()))==false){
               admin_update.check_email.setIcon(cancel);
               admin_update.jt_email.setBackground(RED);
               check=false;
            }else{
                admin_update.check_email.setIcon(apply);
                admin_update.jt_email.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean nick(){
        boolean check =false;
            
        if(admin_create.jt_nick.getText().equals("")){
                admin_create.check_nick.setIcon(cancel);
                admin_create.jt_nick.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_nick(admin_create.jt_nick.getText());
     
                if(check==true){
                    admin_create.check_nick.setIcon(apply);
                    admin_create.jt_nick.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    //admin_form.jt_password.setTextdni("");
                    //admin_form.jt_password.requestFocus();
                    check = true;
                }else{
                    admin_create.check_email.setIcon(cancel);
                    admin_create.jt_nick.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }
    
    public static boolean up_nick(){
        boolean check=false;
        if((admin_update.jt_nick.getText()).isEmpty()){
            admin_update.check_nick.setIcon(cancel);
            admin_update.jt_nick.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_nick((admin_update.jt_nick.getText()))==false){
               admin_update.check_nick.setIcon(cancel);
               admin_update.jt_nick.setBackground(RED); 
               check=false;
            }else{
                admin_update.check_nick.setIcon(apply);
                admin_update.jt_nick.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean password(){
        boolean check =false;
            
        if(admin_create.jt_password.getText().equals("")){
                admin_create.check_password.setIcon(cancel);
                admin_create.jt_password.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_password(admin_create.jt_password.getText());
     
                if(check==true){
                    admin_create.check_password.setIcon(apply);
                    admin_create.jt_password.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    //admin_form.jt_avatar.setText("");
                    //admin_form.jt_avatar.requestFocus();
                    check = true;
                }else{
                    admin_create.check_password.setIcon(cancel);
                    admin_create.jt_password.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
            return check;
    }
    
    public static boolean up_password(){
        boolean check=false;
        if((admin_update.jt_password.getText()).isEmpty()){
            admin_update.check_password.setIcon(cancel);
            admin_update.jt_password.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_password((admin_update.jt_password.getText()))==false){
               admin_update.check_password.setIcon(cancel);
               admin_update.jt_password.setBackground(RED);
               check=false;
            }else{
                admin_update.check_password.setIcon(apply);
                admin_update.jt_password.setBackground(GREEN);
                check = true;
            }
        }
        
        return check;
    }
    
    public static boolean avatar(){
        boolean check =false;
            
        if(admin_create.jt_avatar.getText().equals("")){
                admin_create.check_avatar.setIcon(cancel);
                admin_create.jt_avatar.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_avatar(admin_create.jt_avatar.getText());
     
                if(check==true){
                    admin_create.check_avatar.setIcon(apply);
                    admin_create.jt_avatar.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    check = true;
                }else{
                    admin_create.check_avatar.setIcon(cancel);
                    admin_create.jt_avatar.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }
    
    public static String state(){
        String state="";
        
        if(admin_create.jrb_conected.isSelected())
            state="Conected";
        if(admin_create.jrb_disconected.isSelected())
            state="Disconected";
        
        return state;
    }
    
    public static String up_state(){
        String state="";
        
        if(admin_update.jrb_conected.isSelected())
            state="Conected";
        if(admin_update.jrb_disconected.isSelected())
            state="Disconected";
        
        return state;
    }
    
    public static boolean activity(){
        boolean check =false;
            
        if(admin_create.jt_activity.getText().equals("")){
                admin_create.check_activity.setIcon(cancel);
                admin_create.jt_activity.setBackground(RED);
                admin_create.jt_alert.setText("The value isn't valid");
                check = false;
            }else{
                check=validate.validate_activity(admin_create.jt_activity.getText());
     
                if(check==true){
                    admin_create.check_activity.setIcon(apply);
                    admin_create.jt_activity.setBackground(GREEN);
                    admin_create.jt_alert.setText("");
                    check = true;
                }else{
                    admin_create.check_activity.setIcon(cancel);
                    admin_create.jt_activity.setBackground(RED);
                    admin_create.jt_alert.setText("The value isn't valid");
                    check = false;
                }
            }
        return check;
    }  
    
    public static boolean up_activity(){
        boolean check=false;
        if((admin_update.jt_activity.getText()).isEmpty()){
            admin_update.check_activity.setIcon(cancel);
            admin_update.jt_activity.setBackground(RED);
            check=false;
        }else{
            if(validate.validate_activity((admin_update.jt_activity.getText()))==false){
               admin_update.check_activity.setIcon(cancel);
               admin_update.jt_activity.setBackground(RED); 
               check=false;
            }else{
                admin_update.check_activity.setIcon(apply);
                admin_update.jt_activity.setBackground(GREEN);
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
            confirm=validate.validate_date(((JTextFieldDateEditor) admin_create.jdc_birthday.getDateEditor()).getText());
            if (confirm==false) {
                check = false;
                
            }else{
                birthday=(((JTextFieldDateEditor) admin_create.jdc_birthday.getDateEditor()).getText());
                birth= new class_date(birthday);
                confirm=core_date.restricted_years(birth, 16);
                if(confirm==false){
                    //admin_form.jdc_birthday.setBackground(RED); 
                    admin_create.check_birthday.setIcon(cancel);
                    admin_create.jt_alert.setText("The date isn't valid, you need 16 years");
                    check = false;
                }else{
                    //admin_form.jdc_birthday.setBackground(GREEN);
                    admin_create.check_birthday.setIcon(apply);
                    admin_create.jt_alert.setText("");
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
        if((admin_update.jdc_birthday.getDate())==null){
            //admin_update.check_birthday.setIcon(cancel);
            //admin_update.jdc_birthday.setBackground(RED);
            check=false;
        }else{
            birthday=(((JTextFieldDateEditor) admin_update.jdc_birthday.getDateEditor()).getText());
            birth= new class_date(birthday);
            confirm=core_date.restricted_years(birth, 16);
            if(confirm==false){
               admin_update.check_birthday.setIcon(cancel);
               //admin_update.jdc_birthday.setBackground(RED);
               admin_update.jt_alert.setText("<html>The date isn't valid,<br/>"
                       + " you need 16 years</html>");
               check=false;
            }else{
                admin_update.check_birthday.setIcon(apply);
                admin_update.jt_alert.setText("");
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
            confirm=validate.validate_date(((JTextFieldDateEditor) admin_create.jdc_contract.getDateEditor()).getText());
            if (confirm==false) {
                check=false;
                
            }else{
                birthday=(((JTextFieldDateEditor) admin_create.jdc_birthday.getDateEditor()).getText());
                contract=(((JTextFieldDateEditor) admin_create.jdc_contract.getDateEditor()).getText());
                birth= new class_date(birthday);
                cont= new class_date(contract);
                birth=core_date.sum_years(birth, 16);
                dates=cont.compare_2dates(birth);
                if(dates<1){
                   // admin_form.jdc_contract.setBackground(RED); 
                    admin_create.check_contract.setIcon(cancel);
                    admin_create.jt_alert.setText("<html>The date isn't valid,<br/>"
                            + " the date need be afer date birthday</html>");
                    check=false;
                }else{
                    dates=cont.compare_date_to_System();
                    if(dates==1){
                        //admin_form.jdc_contract.setBackground(RED); 
                        admin_create.check_contract.setIcon(cancel);
                        admin_create.jt_alert.setText("<html>The date isn't valid,<br/>"
                                + " the date need be before actual date</html>");
                        check=false;
                    }else{
                        //admin_form.jdc_contract.setBackground(GREEN);
                        admin_create.check_contract.setIcon(apply);
                        admin_create.jt_alert.setText("");
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
        if((admin_update.jdc_birthday.getDate())==null){
            admin_update.check_birthday.setIcon(cancel);
            //admin_update.jdc_birthday.setBackground(RED);
        }else{
            birthday=(((JTextFieldDateEditor) admin_update.jdc_birthday.getDateEditor()).getText());
            contract=(((JTextFieldDateEditor) admin_update.jdc_contract.getDateEditor()).getText());
            birth= new class_date(birthday);
            cont= new class_date(contract);
            dates=cont.compare_2dates(birth);
            if(dates<1){
                   // admin_form.jdc_contract.setBackground(RED); 
                    admin_update.check_contract.setIcon(cancel);
                    admin_update.jt_alert.setText("The date isn't valid, the date need be afer date birthday");
                    check=false;
                }else{
                    dates=cont.compare_date_to_System();
                    if(dates==1){
                        //admin_form.jdc_contract.setBackground(RED); 
                        admin_update.check_contract.setIcon(cancel);
                        admin_update.jt_alert.setText("The date isn't valid, the date need be before actual date");
                        check=false;
                    }else{
                        //admin_form.jdc_contract.setBackground(GREEN);
                        admin_update.check_contract.setIcon(apply);
                        admin_update.jt_alert.setText("");
                        check=true;
                    }
                    
                }
        }
        return check;
    }
    
     
}
