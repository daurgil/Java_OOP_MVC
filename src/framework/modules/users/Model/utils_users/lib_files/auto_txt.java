package framework.modules.users.Model.utils_users.lib_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.client.admin_class;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.Model.classes.reg_user_class;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.client.singleton_admin;

public class auto_txt {


	//	TXT		//
	//			//
	public static void auto_savetxt_admin(){
		String PATH = null;
		
		
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/admin_files/txt/auto_txt.txt";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_admin.admin.size()>0){
			try {
				File f;
				
				f = new File(PATH);	
				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton_admin.admin);
				o.close();
				
			} catch (Exception e) {
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_save_txt"),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			File path = new File(PATH);
			
			path.delete();
			
		}
	}
	
	public static void auto_opentxt_admin(){
		String PATH;

        try {

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/admin_files/txt/auto_txt.txt";

            File f = new File(PATH);

            FileInputStream fi=new FileInputStream(f);
			ObjectInputStream oi=new ObjectInputStream(fi);
			singleton_admin.admin = (ArrayList<admin_class>)oi.readObject();
			oi.close();

        } catch (Exception e) {
        	e.printStackTrace();
           JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_txt"),
             "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public static void auto_savetxt_client(){
		String PATH = null;
		
		
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/client_files/txt/auto_txt.txt";
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		if(singleton_user.client.size()>0){
			try {
				File f;
				
				f = new File(PATH);	
				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton_user.client);
				o.close();
				
			} catch (Exception e) {
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_save_txt"),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			File path = new File(PATH);
			
			path.delete();
		}
	}
	
	public static void auto_opentxt_client(){
		String PATH;

        try {

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/client_files/txt/auto_txt.txt";

            File f = new File(PATH);

            FileInputStream fi=new FileInputStream(f);
			ObjectInputStream oi=new ObjectInputStream(fi);
			singleton_user.client = (ArrayList<client_class>)oi.readObject();
			oi.close();

        } catch (Exception e) {
        	e.printStackTrace();
             JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_txt"),
             "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public static void auto_savetxt_reg(){
		String PATH = null;
		
		
		try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/reg_files/txt/auto_txt.txt";
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		if(singleton_user.reg.size()>0){
			try {
				File f;
				
				f = new File(PATH);	
				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton_user.reg);
				o.close();
				
			} catch (Exception e) {
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_save_txt"),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			File path = new File(PATH);
			
			path.delete();
		}
	}
	
	public static void auto_opentxt_reg() {
		String PATH;

        try {

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/framework/modules/users/Model/files/reg_files/txt/auto_txt.txt";

            File f = new File(PATH);

            FileInputStream fi=new FileInputStream(f);
			ObjectInputStream oi=new ObjectInputStream(fi);
			singleton_user.reg = (ArrayList<reg_user_class>)oi.readObject();
			oi.close();

        } catch (Exception e) {
        	e.printStackTrace();
             JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_open_txt"),
             "Error", JOptionPane.ERROR_MESSAGE);
        }
	}


}
