package framework.utils;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.language.class_language;


public class funciones {
	
	public static int giveint(String message, String titulo){//validar numero
		int n=0;
		boolean correcto=false;
		String s="";
		
		do {
			try {
				s=JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);
				
				if(s==null){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_unk"),
							"Error", JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}else{
					n=Integer.parseInt(s);
					correcto=true;
					
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_int"), "Error",JOptionPane.ERROR_MESSAGE);
				correcto=false;
			}
		} while (correcto==false);
		
		return n;
		
	}
	
	public static int giveint0 (String message, String titulo){//validar numero para que no sea 0
		int n=0, interruptor=0;
		boolean correcto=false;
		String s="";
		
		while(interruptor==0){
		
			do {
				try {
					s=JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);
					
					if(s==null){
						JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_unk"),
								"Error", JOptionPane.ERROR_MESSAGE);
						correcto=false;
					}else{
						n=Integer.parseInt(s);
						correcto=true;
						
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_int"), "Error",JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}
			} while (correcto==false);
			
			if(n!=0){
				interruptor=1;
			}
		}
		
		return n;
	}
	
	public static float givefloat(String message, String titulo){//validar float
		float n=0;
		boolean correcto=false;
		String s="";
		
		
			do {
				try {
					s=JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);
					
					if(s==null){
						JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_unk"),
							"Error", JOptionPane.ERROR_MESSAGE);
						correcto=false;
					}else{
						n=Integer.parseInt(s);
						correcto=true;
						
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_int"), "Error",JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}
			} while (correcto==false);
			
		
		return n;
		
	}
	
	public static char givechar(String message, String titulo){
		char l=' ';
		boolean correcto=false;
		String s="";
		
		do {
			try {
				s=JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);
				
				if(s==null){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_unk"),
							"Error", JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}else{
					l=s.charAt(0);
					correcto=true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_char"), "Error", JOptionPane.ERROR_MESSAGE);
				correcto=false;
			}
		} while (correcto==false);
		
		return l;
		
	}
	
	public static String give_s(String message, String titulo){
		String s="";
		boolean correcto=false;
		
		do {
			try {
				s=JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);
				correcto=true;
				if (s==null){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_unk"),
							"Error", JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}
				if(s==" "){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value"), "Error", JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_chain"), "Error", JOptionPane.ERROR_MESSAGE);
				correcto=false;
			}
		} while (correcto==false);
		
		return s;
		
	}
	
	public static int digint(int n){
		int dig=0;
		
		while (n>0) {
			
			dig=n%10;
			n=n/10;

			
		}
		return dig;
	}
	
}
