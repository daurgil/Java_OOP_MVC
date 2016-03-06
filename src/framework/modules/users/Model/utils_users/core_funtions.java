package framework.modules.users.Model.utils_users;

import javax.swing.JOptionPane;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;
import framework.utils.funciones;
import framework.utils.validate;

public class core_funtions {
	
	/**
	 * Function to give the different String in the process of create a user
	 * @param types, Is a String which select the option in the switch
	 * @param language
	 * @return
	 */
	public static String give_Data(String types) {
		String s = "";
		boolean val = false;

		switch (types) {

		case "dni":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("dni"),
						class_language.getinstance().getProperty("dni_t"));
				val = validate.validate_dni(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;// dni

		case "name":
				do {
					s = funciones.give_s(class_language.getinstance().getProperty("name"),
							class_language.getinstance().getProperty("name_t"));
					val = validate.validate_name(s);
					if (val == false)
						JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
								class_language.getinstance().getProperty("error"),
								JOptionPane.INFORMATION_MESSAGE);
				} while (val == false);
				break;// name
				
		case "surname":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("surname"),
						class_language.getinstance().getProperty("surname_t"));
				val = validate.validate_surname(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;// surname

		case "mobile":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("mobile"),
						class_language.getinstance().getProperty("mobile_t"));
				val = validate.validate_mobile(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;// mobile

		case "email":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("email"),
						class_language.getinstance().getProperty("email_t"));
				val = validate.validate_email(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;// email

		case "user":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("user"),
						class_language.getinstance().getProperty("user_t"));
				val = validate.validate_nick(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value"), 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break; //user

		case "password":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("password"),
						class_language.getinstance().getProperty("password_t"));
				val = validate.validate_password(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break;// password

		case "avatar":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("avatar"),
						class_language.getinstance().getProperty("avatar_t"));
				val = validate.validate_avatar(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break; // avatar


		case "activity":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("activity"),
						class_language.getinstance().getProperty("activity_t"));
				val = validate.validate_activity(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break; //activity
			
			
		case "shopping":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("shopping"),
						class_language.getinstance().getProperty("shopping_t"));
				val = validate.validate_shopping(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break; //shopping
			
		case "type":
			do {
				s = funciones.give_s(class_language.getinstance().getProperty("type"),
						class_language.getinstance().getProperty("type_t"));
				val = validate.validate_type(s);
				if (val == false)
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
							class_language.getinstance().getProperty("error"),
							JOptionPane.INFORMATION_MESSAGE);
			} while (val == false);
			break; 

		default:
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_value") , 
					class_language.getinstance().getProperty("error"),
					JOptionPane.INFORMATION_MESSAGE);

		}

		return s;

	}

}