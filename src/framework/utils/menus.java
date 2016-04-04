package framework.utils;

import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;

import framework.modules.Menu_config.Model.classes.language.class_language;

public class menus {
	
	public static int menu_botton(String[] menu, String message, String titulo){
		int opcion=0;
		
		opcion=JOptionPane.showOptionDialog(null, message, titulo, 0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
		
		return opcion;
		
	}
	
	public static String combobox(String[] menubox, String message, String titulo){
		
		String chain="";
		boolean correct=false;
		do{
			Object eleccion= JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE, null, menubox, 0);
			
			if ((eleccion != null)) {
				try {
					chain=eleccion.toString();
				} catch (Exception e) {
					chain=null;
				}
				
				correct=true;
			}else{
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_unk"),
						class_language.getinstance().getProperty("error_t"),JOptionPane.INFORMATION_MESSAGE);
				correct=false;
			}
				
		}while(correct==false);
		
		return chain;
	}
	
	
}
