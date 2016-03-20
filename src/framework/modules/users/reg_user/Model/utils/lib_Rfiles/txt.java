/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.reg_user.Model.utils.lib_Rfiles;

import framework.modules.users.admin.Model.classes.admin_class;
import framework.modules.users.admin.Model.classes.singleton_admin;
import framework.modules.users.reg_user.Model.classes.reg_user_class;
import framework.modules.users.reg_user.Model.classes.singleton_reg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pelu
 */
public class txt {
    
    public static void savetxt_reg(){
		
		String PATH = null;
		FileWriter fichero;
		PrintWriter print;
		
		try {
			
			File f;
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt"));
			
			int selection = filechooser.showSaveDialog(null);
			if (selection == JFileChooser.APPROVE_OPTION) {
				File JFC = filechooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH = PATH +".txt";
				f = new File(PATH);
			
				
				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				System.out.println("i hate you x3");
				o.writeObject(singleton_reg.reg);
				System.out.println("hola");
				o.close();
				JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito",
						"Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el TXT",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void opentxt_reg() {
		String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt"));
            
            int selection = fileChooser.showOpenDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                f = new File(PATH);
                
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			singleton_reg.reg = (ArrayList<reg_user_class>)oi.readObject();
    			oi.close();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
