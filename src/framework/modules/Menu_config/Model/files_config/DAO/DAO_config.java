/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.Menu_config.Model.files_config.DAO;

import framework.modules.Menu_config.Model.classes.class_config;
import framework.modules.Menu_config.Model.classes.singleton_config;
import framework.modules.Menu_config.Model.files_config.auto_config;
import framework.modules.Menu_config.View.Config;
import framework.utils.singleton;

/**
 *
 * @author pelu
 */
public class DAO_config {
    
    public static void save(){
        String date, lang, theme;
        int decimals;
        char currency;
        class_config config=null;
        
        date=DAO_config.save_date();
        System.out.println(date);
        class_config.getinstance().setFormat_date(date);
        
        currency=DAO_config.save_currency();
        class_config.getinstance().setCurrency(currency);
        
        decimals=DAO_config.save_decimals();
        class_config.getinstance().setDecimals(decimals);
        
        lang=DAO_config.save_lang();
        class_config.getinstance().setLanguage(lang);
        singleton_config.lang.setLanguage();
        
        theme=DAO_config.save_theme();
        class_config.getinstance().setTheme(theme);
        
        
    }
    
    public static void open_config(){
        
        DAO_config.date();
        DAO_config.currency();
        DAO_config.decimals();
        DAO_config.lang();
        DAO_config.theme();
        
    }
    
    public static String save_date(){
        String date="";
        
        if(Config.jrb_date1.isSelected()){
            date="dd/MM/yyyy";
        }
        if(Config.jrb_date2.isSelected()){
            date="dd-MM-yyyy";
        }
        if(Config.jrb_date3.isSelected()){
            date="yyyy/MM/dd";
        }
        if(Config.jrb_date4.isSelected()){
            date="yyyy-MM-dd";
        }
        
        return date;
    }
    
    public static char save_currency(){
        char currency=' ';
        
        if(Config.jrb_euro.isSelected()){
            currency='€';
        }
        if(Config.jrb_dolar.isSelected()){
            currency='$';
        }
        if(Config.jrb_libra.isSelected()){
            currency='£';
        }
        
        return currency;
    }
    
    public static int save_decimals(){
        int decimals='2';
        
        if(Config.jrb_decimals1.isSelected()){
            decimals='1';
        }
        if(Config.jrb_decimals2.isSelected()){
            decimals='2';
        }
        if(Config.jrb_decimals3.isSelected()){
            decimals='3';
        }
        
        return decimals;
    }
    
    public static String save_lang(){
        String lang="";
        
        if(Config.jrb_eng.isSelected()){
            lang="eng";
        }
        if(Config.jrb_esp.isSelected()){
            lang="esp";
        }
        if(Config.jrb_val.isSelected()){
            lang="val";
        }
        
        return lang;
    }
    
    public static String save_theme(){
        String theme="";
        
        if(Config.jrb_theme1.isSelected()){
            theme="Metal";
        }
        if(Config.jrb_theme2.isSelected()){
            theme="Windows";
        }
        if(Config.jrb_theme3.isSelected()){
            theme="Motif";
        }
        if(Config.jrb_theme4.isSelected()){
            theme="Nimbus";
        }
        
        return theme;
    }
    
        
    public static void date(){
        
        switch(class_config.getinstance().getFormat_date()){
            case "dd/MM/yyyy":
                Config.jrb_date1.setSelected(true);
                break;
            case "dd-MM-yyyy":
                Config.jrb_date2.setSelected(true);
                break;
            case "yyyy/MM/dd":
                Config.jrb_date3.setSelected(true);
                break;
            case "yyyy-MM-dd":
                Config.jrb_date4.setSelected(true);
                break;
        }
    }
        
    public static void currency(){
        
        switch(class_config.getinstance().getCurrency()){
            case '€':
                Config.jrb_euro.setSelected(true);
                break;
            case '$':
                Config.jrb_dolar.setSelected(true);
                break;
            case '£':
                Config.jrb_libra.setSelected(true);
                break; 
            default:
                Config.jrb_euro.setSelected(true);
                break;
        }
    }
    
    public static void decimals(){
        
        switch(class_config.getinstance().getDecimals()){
            case 1:
                Config.jrb_decimals1.setSelected(true);
                break;
            case 2:
                Config.jrb_decimals2.setSelected(true);
                break;
            case 3:
                Config.jrb_decimals3.setSelected(true);
                break;
            default:
                Config.jrb_decimals1.setSelected(true);
                break;
        }
    }
    
    public static void lang(){
        
        switch(class_config.getinstance().getLanguage()){
            case "eng":
                Config.jrb_eng.setSelected(true);
                break;
            case "esp":
                Config.jrb_esp.setSelected(true);
                break;
            case "val":
                Config.jrb_val.setSelected(true);
                break;
            default:
                Config.jrb_eng.setSelected(true);
                break;
        }
    }
    
    public static void theme(){
        
        switch(class_config.getinstance().getTheme()){
            case "Metal":
                Config.jrb_theme1.setSelected(true);
                break;
            case "Windows":
                Config.jrb_theme2.setSelected(true);
                break;
            case "Motif":
                Config.jrb_theme3.setSelected(true);
                break;
            case "Nimbus":
                Config.jrb_theme4.setSelected(true);
                break;
            default:
                Config.jrb_theme4.setSelected(true);
                break;
        }
    }
    
}
