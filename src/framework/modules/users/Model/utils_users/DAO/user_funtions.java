package framework.modules.users.Model.utils_users.DAO;
import java.util.Collections;

import javax.swing.JOptionPane;

import framework.classes.class_date;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.Config.Model.classes.class_config;
import framework.modules.users.Model.classes.admin_class;
import framework.modules.users.Model.classes.client_class;
import framework.modules.users.Model.classes.reg_user_class;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.classes.Order.order_age;
import framework.modules.users.Model.classes.Order.order_benefit;
import framework.modules.users.Model.classes.Order.order_birthday;
import framework.modules.users.Model.classes.Order.order_date_cont;
import framework.modules.users.Model.classes.Order.order_name;
import framework.modules.users.Model.classes.Order.order_salary;
import framework.modules.users.Model.classes.Order.order_surname;
import framework.modules.users.Model.utils_users.core_funtions;
import framework.modules.users.Model.utils_users.especials_funtions;
import framework.modules.users.Model.utils_users.BLL.search_user;
import framework.modules.users.Model.utils_users.core_date;
import framework.utils.menus;
public class user_funtions {
	
	
	/**Function to ask data of a admin user
	 * This create el the variables of the admin an give to user
	 * 
	 * @return new admin_class
	 */
	public static admin_class ask_admin(){
		//Variable initialize
				
		String dni="", name="", surname="", mobile="", email="", nick="", password="", avatar="", 
						 state=""; //age_chain="";
		class_date birthday=null;
		class_date date_cont=null;
				
		int age=0, antique=0, activity=0;
		
		float salary=0.0f,	incentive=0.0f;
		
		//boolean state=false;
		
		//User attribute
		if(singleton_user.DNI.equals(" ")){
			dni=core_funtions.give_Data("dni");
		}else{
			dni=singleton_user.DNI;
		}
		name=core_funtions.give_Data("name");
		surname=core_funtions.give_Data("surname");
		mobile=core_funtions.give_Data("mobile");
		email=core_funtions.give_Data("email");
		nick=core_funtions.give_Data("nick");
		password=core_funtions.give_Data("password");
		avatar=core_funtions.give_Data("avatar");
		state=especials_funtions.yes_no(class_language.getinstance().getProperty("state"),
				class_language.getinstance().getProperty("state_t"));
		birthday=core_date.restricted_date(class_language.getinstance().getProperty("birthday")+
				class_config.getinstance().getFormat_date(),
				class_language.getinstance().getProperty("birthday_t"),16);
		//age=Integer.parseInt(core_funtions.give_Data("age"));
		
		//admin attribute
		date_cont=core_date.contract_date(class_language.getinstance().getProperty("date_cont")+class_config.getinstance().getFormat_date(),
				class_language.getinstance().getProperty("date_cont_t"), birthday, 16, 65);
		//antique=Integer.parseInt(core_funtions.give_Data("antique"));
		//salary=Float.parseFloat(core_funtions.give_Data("salary"));
		//incentive=funciones.givefloat("introduce the incentive", "Incentive");
		activity=Integer.parseInt(core_funtions.give_Data("activity"));
		
		new admin_class(dni, name, surname, mobile, email, nick, password, avatar, state, birthday,
				 date_cont, activity);
		
		return new admin_class(dni, name, surname, mobile, email, nick, password, avatar, state, birthday,
				 date_cont, activity);
		
	}
	
	/** Function to modify an admin user, choose what variable want change
	 * @param a
	 * @param format_date
	 * @param class_config
	 */
	public static void modif_admin(admin_class a){
			
		
		String menu="";
		boolean rep=false;
		int position=-1;
		String [] opt={class_language.getinstance().getProperty("dni_t"),class_language.getinstance().getProperty("name_t"),
				class_language.getinstance().getProperty("surname_t"),class_language.getinstance().getProperty("mobile_t"),
				class_language.getinstance().getProperty("email_t"),class_language.getinstance().getProperty("user_t"),
				class_language.getinstance().getProperty("password_t"),class_language.getinstance().getProperty("avatar_t"),
				class_language.getinstance().getProperty("state_t"),class_language.getinstance().getProperty("birthday_t"),
				class_language.getinstance().getProperty("date_cont_t"),
				class_language.getinstance().getProperty("activity")};
		
		menu=menus.combobox(opt, class_language.getinstance().getProperty("choose"),
				class_language.getinstance().getProperty("change_data"));
		
		
			do {
				menu=menus.combobox(opt, class_language.getinstance().getProperty("choose"),
						class_language.getinstance().getProperty("change_data"));
				
				
				if(menu.equals(opt[0])){
					position=search_user.search_reg();
					if(position==-1)
						a.setDni(singleton_user.DNI);
					else
						JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_dni"),
								"Error", JOptionPane.INFORMATION_MESSAGE);
					rep=true;
				}
				if(menu.equals(opt[1])){
					a.setName(core_funtions.give_Data("name"));
					rep=true;
				}
				if(menu.equals(opt[2])){
					a.setSurname(core_funtions.give_Data("surname"));
					rep=true;
				}
				if(menu.equals(opt[3])){
					a.setMobile(core_funtions.give_Data("mobile"));
					rep=true;
				}
				if(menu.equals(opt[4])){
					a.setEmail(core_funtions.give_Data("email"));
					rep=true;
				}
				if(menu.equals(opt[5])){
					a.setNick(core_funtions.give_Data("nick"));
					rep=true;
				}
				if(menu.equals(opt[6])){
					a.setPassword(core_funtions.give_Data("password"));
					rep=true;
				}
				if(menu.equals(opt[7])){
					a.setAvatar(core_funtions.give_Data("avatar"));
					rep=true;
				}
				if(menu.equals(opt[8])){
					a.setState(especials_funtions.yes_no(class_language.getinstance().getProperty("state"),
							class_language.getinstance().getProperty("state_t")));
					rep=true;
				}
				if(menu.equals(opt[9])){
					a.setBirthday(core_date.restricted_date(class_language.getinstance().getProperty("birthday")+class_config.getinstance().getFormat_date(),
							class_language.getinstance().getProperty("birthday_t"),16));
					rep=true;
				}
				if(menu.equals(opt[10])){
					a.setDate_cont(core_date.contract_date(class_language.getinstance().getProperty("date_cont")+class_config.getinstance().getFormat_date(),
							class_language.getinstance().getProperty("date_cont_t"), a.getBirthday(), 16, 65));
					rep=true;
				}
				if(menu.equals(opt[11])){
					a.setActivity(Integer.parseInt(core_funtions.give_Data("activity")));
					rep=true;
				}
			} while (rep==false);
	}
	
	
	
	/**Function to create a new client user
	 *  This create el the variables of the client an give to user
	 * 
	 * @return new client_class
	 */
 	public static client_class ask_cli(){
		
		String dni="", name="", surname="", mobile="", email="", nick="", password="", avatar="", 
			 type="", state="";
		class_date birthday=null;
		class_date up_date=null;
		
		int age=0, antique=0, discount=0;
		
		float shopping=0.0f;
		
		boolean premium=false;
		
		
		//User attribute
		if(singleton_user.DNI.equals(" ")){
			dni=core_funtions.give_Data("dni");
		}else{
			dni=singleton_user.DNI;
		}
		name=core_funtions.give_Data("name");
		surname=core_funtions.give_Data("surname");
		mobile=core_funtions.give_Data("mobile");
		email=core_funtions.give_Data("email");
		nick=core_funtions.give_Data("nick");
		password=core_funtions.give_Data("password");
		avatar=core_funtions.give_Data("avatar");
		state=especials_funtions.yes_no(class_language.getinstance().getProperty("state"),
				class_language.getinstance().getProperty("state_t"));
		birthday=core_date.restricted_date(class_language.getinstance().getProperty("birthday")+class_config.getinstance().getFormat_date(),
				class_language.getinstance().getProperty("birthday_t"),18);
		
		
		//Client attribute
		up_date=core_date.registred_date(class_language.getinstance().getProperty("up_date")+class_config.getinstance().getFormat_date(),
				class_language.getinstance().getProperty("up_date_t"),birthday,18);
		shopping=Float.parseFloat(core_funtions.give_Data("shopping"));
		premium=especials_funtions.premium(class_language.getinstance().getProperty("premium"),
				class_language.getinstance().getProperty("premium_t"));
		type=core_funtions.give_Data("type");
		
		new client_class(dni, name, surname, mobile, email, nick, password, avatar, state, birthday,
				up_date, shopping, discount, premium, type);
		
		return new client_class(dni, name, surname, mobile, email, nick, password, avatar, state, birthday,
				up_date, shopping, discount, premium, type);
	}
		
	/**
	 * Function to modify an client user, , choose what variable want change
	 * @param c
	 * @param format_date
	 * @param class_config
	 */
	public static void modif_client(client_class c){
		
		
		int position=-1;
		String menu="";
		boolean rep=false;
		String [] opt={class_language.getinstance().getProperty("dni_t"),class_language.getinstance().getProperty("name_t"),
				class_language.getinstance().getProperty("surname_t"),class_language.getinstance().getProperty("mobile_t"),
				class_language.getinstance().getProperty("email_t"),class_language.getinstance().getProperty("user_t"),
				class_language.getinstance().getProperty("password_t"),class_language.getinstance().getProperty("avatar_t"),
				class_language.getinstance().getProperty("state_t"),class_language.getinstance().getProperty("birthday_t"),
				class_language.getinstance().getProperty("up_date_t"),
				class_language.getinstance().getProperty("shopping_t"), 
				class_language.getinstance().getProperty("premium_t"),
				class_language.getinstance().getProperty("type_t")};
		
		
		do {
			menu=menus.combobox(opt, class_language.getinstance().getProperty("choose"),
					class_language.getinstance().getProperty("change_data"));
			
			
			if(menu.equals(opt[0])){
				position=search_user.search_reg();
				if(position==-1)
					c.setDni(singleton_user.DNI);
				else
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_dni"),
							"Error", JOptionPane.INFORMATION_MESSAGE);
				rep=true;
			}
			if(menu.equals(opt[1])){
				c.setName(core_funtions.give_Data("name"));
				rep=true;
			}
			if(menu.equals(opt[2])){
				c.setSurname(core_funtions.give_Data("surname"));
				rep=true;
			}
			if(menu.equals(opt[3])){
				c.setMobile(core_funtions.give_Data("mobile"));
				rep=true;
			}
			if(menu.equals(opt[4])){
				c.setEmail(core_funtions.give_Data("email"));
				rep=true;
			}
			if(menu.equals(opt[5])){
				c.setNick(core_funtions.give_Data("nick"));
				rep=true;
			}
			if(menu.equals(opt[6])){
				c.setPassword(core_funtions.give_Data("password"));
				rep=true;
			}
			if(menu.equals(opt[7])){
				c.setAvatar(core_funtions.give_Data("avatar"));
				rep=true;
			}
			if(menu.equals(opt[8])){
				c.setState(especials_funtions.yes_no(class_language.getinstance().getProperty("state"),
						class_language.getinstance().getProperty("state_t")));
				rep=true;
			}
			if(menu.equals(opt[9])){
				c.setBirthday(core_date.restricted_date(class_language.getinstance().getProperty("birthday")+class_config.getinstance().getFormat_date(),
						class_language.getinstance().getProperty("birthday_t"),16));
				rep=true;
			}
			if(menu.equals(opt[10])){
				c.setUp_date(core_date.registred_date(class_language.getinstance().getProperty("up_date")+
						class_config.getinstance().getFormat_date(),
						class_language.getinstance().getProperty("up_date_t"),c.getBirthday(),18));
				rep=true;
			}
			if(menu.equals(opt[11])){
				c.setShopping(Float.parseFloat(core_funtions.give_Data("shopping")));
				rep=true;
			}
			if(menu.equals(opt[12])){
				c.setPremium(especials_funtions.premium(class_language.getinstance().getProperty("premium"),
						class_language.getinstance().getProperty("premium_t")));
				rep=true;
			}
			if(menu.equals(opt[13])){
				c.setType(core_funtions.give_Data("type"));
				rep=true;
			}
		} while (rep==false);
	}
	
	
	
	/**Function to create a registred_user
	 *  This create el the variables of the reg_user an give to user
	 * 
	 * @return new reg_user_class
	 */
	public static reg_user_class ask_reg(){
		String dni="", name="", surname="", mobile="", email="", nick="", password="", avatar="", 
				karma="", state="";
		class_date birthday=null;
		
		int age=0, activity=0, points=0;
		
		
		
		//User attribute
		if(singleton_user.DNI.equals(" ")){
			dni=core_funtions.give_Data("dni");
		}else{
			dni=singleton_user.DNI;
		}
		name=core_funtions.give_Data("name");
		surname=core_funtions.give_Data("surname");
		mobile=core_funtions.give_Data("mobile");
		email=core_funtions.give_Data("email");
		nick=core_funtions.give_Data("nick");
		password=core_funtions.give_Data("password");
		avatar=core_funtions.give_Data("avatar");
		state=especials_funtions.yes_no(class_language.getinstance().getProperty("state"),
				class_language.getinstance().getProperty("state_t"));
		birthday=core_date.restricted_date(class_language.getinstance().getProperty("birthday")+class_config.getinstance().getFormat_date(),
				class_language.getinstance().getProperty("birthday_t"),16);
		//age=Integer.parseInt(core_funtions.give_Data("age"));
		
		//reg_user attribute
		activity=Integer.parseInt(core_funtions.give_Data("activity"));
		//karma=(String)menus.combobox(karma, "What type of karma have you?", "Karma");		
		//points=funciones.giveint("How points have you?", "Points");
		
		new reg_user_class(dni, name, surname, mobile, email, nick, password, avatar, state, birthday,
				activity, karma, points);
		
		return new reg_user_class(dni, name, surname, mobile, email, nick, password, avatar, state, birthday,
				activity, karma, points);
	}
		
	/**Function to modify an reg_user user, , choose what variable want change
	 * 
	 * @param u
	 * @param format_date
	 * @param class_config
	 */
	public static void modif_reg_user(reg_user_class u){
		
		int position=-1;
		boolean rep=false;
		String menu="";
		String [] opt={class_language.getinstance().getProperty("dni_t"),class_language.getinstance().getProperty("name_t"),
				class_language.getinstance().getProperty("surname_t"),class_language.getinstance().getProperty("mobile_t"),
				class_language.getinstance().getProperty("email_t"),class_language.getinstance().getProperty("user_t"),
				class_language.getinstance().getProperty("password_t"),class_language.getinstance().getProperty("avatar_t"),
				class_language.getinstance().getProperty("state_t"),class_language.getinstance().getProperty("birthday_t"),
				class_language.getinstance().getProperty("activity_t")};
		
		
		
		do {
			menu=menus.combobox(opt, class_language.getinstance().getProperty("choose"),
					class_language.getinstance().getProperty("change_data"));
			
			
			if(menu.equals(opt[0])){
				position=search_user.search_reg();
				if(position==-1)
					u.setDni(singleton_user.DNI);
				else
					JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_dni"),
							"Error", JOptionPane.INFORMATION_MESSAGE);
				rep=true;
			}
			if(menu.equals(opt[1])){
				u.setName(core_funtions.give_Data("name"));
				rep=true;
			}
			if(menu.equals(opt[2])){
				u.setSurname(core_funtions.give_Data("surname"));
				rep=true;
			}
			if(menu.equals(opt[3])){
				u.setMobile(core_funtions.give_Data("mobile"));
				rep=true;
			}
			if(menu.equals(opt[4])){
				u.setEmail(core_funtions.give_Data("email"));
				rep=true;
			}
			if(menu.equals(opt[5])){
				u.setNick(core_funtions.give_Data("nick"));
				rep=true;
			}
			if(menu.equals(opt[6])){
				u.setPassword(core_funtions.give_Data("password"));
				rep=true;
			}
			if(menu.equals(opt[7])){
				u.setAvatar(core_funtions.give_Data("avatar"));
				rep=true;
			}
			if(menu.equals(opt[8])){
				u.setState(especials_funtions.yes_no(class_language.getinstance().getProperty("state"),
						class_language.getinstance().getProperty("state_t")));
				rep=true;
			}
			if(menu.equals(opt[9])){
				u.setBirthday(core_date.restricted_date(class_language.getinstance().getProperty("birthday")+class_config.getinstance().getFormat_date(),
						class_language.getinstance().getProperty("birthday_t"),16));
				rep=true;
			}
			if(menu.equals(opt[10])){
				u.setActivity(Integer.parseInt(core_funtions.give_Data("activity")));;
				rep=true;
			}
		} while (rep==false);
		
	}
	
	
	
}
