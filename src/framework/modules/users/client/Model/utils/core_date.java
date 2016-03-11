package framework.modules.users.client.Model.utils;


import javax.swing.JOptionPane;

import framework.classes.class_date;
import framework.modules.Config.Model.classes.language.class_language;
import framework.utils.funciones;
import framework.utils.validate;

public class core_date {
	/*funtion to give a date to introduce like new information*/
	public static class_date give_date(String message, String title){
		
		String introduce_date="";
		boolean correct1=false, correct2=false;
		
		class_date date=null;
		
		do {
			do {
				introduce_date=funciones.give_s(message, title);
				correct2=validate.validate_date(introduce_date);
				
				if(correct2==false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value")+"\nFormat: dd/MM/yyyy",
							title, JOptionPane.INFORMATION_MESSAGE);
				
			} while (correct2==false);
			
			date= new class_date(introduce_date);
			correct1=date.validate_date();
			
			if(correct1==false)
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value")+"\nFormat: dd/MM/yyyy",
						title, JOptionPane.INFORMATION_MESSAGE);
			
		} while (correct1==false);
		
		return date;
	}
	
	/*Function to known if user have 18 years or more
	 * 
	 */
	public static boolean restricted_years(class_date date, int years){
		boolean correct=false;
		int value=0;
		
		value=date.date_to_actualdate();
		
		if(value>=years)
			correct=true;
		else
			correct=false;
		
		
		return correct;
	}
	
	/**
	 * Function to give a date(String), check the format and if have passed more than x years
	 * @param message 
	 * @param title
	 * @param years number of years that the date have passed
	 * @param format 
	 * @param language
	 * @return
	 */
	public static class_date restricted_date(String message, String title, int years){
		boolean correct=false;
		
		
		class_date date=null;
		do{
			
			date=give_date(message, title);
			correct=restricted_years(date, years);
			if(correct==false)
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("resticted_date")+years,
						class_language.getinstance().getProperty("alert"), JOptionPane.INFORMATION_MESSAGE);
		
		}while(correct==false);
		
		return date;
	}
	
	/**
	 * Function to give a date(String), check the format and if have passed more than x years between 
	 * the date and other previous date introduced
	 * @param message
	 * @param title
	 * @param birthday
	 * @param years
	 * @param format
	 * @param language
	 * @return
	 */
	public static class_date registred_date(String message, String title, class_date birthday,int years
			){
		int value=0, test=0;
		boolean correct=true, correct2=true;
		class_date date=null;
		
		do{
			do{
				date=give_date(message, title);
				test=date.compare_date_to_System();
				if(test==2){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_date"),
							title, JOptionPane.INFORMATION_MESSAGE);
					correct=false;
				}
			}while(correct==false);

			value=birthday.subtraction_dates(date);
			
			if(value<years){
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("resticted_date"),
						title, JOptionPane.INFORMATION_MESSAGE);
				correct2=false;
			}
		}while(correct2==false);
	
		
		return date;
	}
	
	
	/**
	 * Function to sum years a specific date
	 * @param contract
	 * @param years
	 * @return
	 */
	public static class_date sum_years(class_date birthday, int years){
		
		class_date date=null;
		
		date=new class_date(birthday.getDay()+"/"+birthday.getMonth()+"/"+(years+birthday.getYear()));
		
		
		return date;
	}
	
	
	/**
	 * Function to check if is possible contract someone
	 * @param message
	 * @param title
	 * @param birthday
	 * @param years
	 * @param years2
	 * @return contract date
	 */
	public static class_date contract_date(String message, String title, class_date birthday, int years, int years2){
		class_date date=null;
		class_date contract_date=null;
		boolean correct=false;
		int value=0;
		
		do{
			do {
				contract_date=give_date(message, title);
				correct=restricted_years(birthday, years);
				if(correct==false){
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("contract_date1")+years,
							"Error", JOptionPane.INFORMATION_MESSAGE);
				}	
			} while (correct==false);
			
			date=sum_years(birthday, years2);
			value=birthday.subtraction_dates(date);
			
			if(value>years2){
				correct=false;
				JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("contract_date2")+years,
						"Error", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}while(correct==false);
		
		return contract_date;
	}
	

}
