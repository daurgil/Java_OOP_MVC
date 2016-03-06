package framework.modules.users.Model.utils_users.BLL;

import java.util.Collections;

import framework.modules.Config.Model.classes.class_config;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.users.Model.classes.singleton_user;
import framework.modules.users.Model.classes.Order.order_age;
import framework.modules.users.Model.classes.Order.order_benefit;
import framework.modules.users.Model.classes.Order.order_birthday;
import framework.modules.users.Model.classes.Order.order_date_cont;
import framework.modules.users.Model.classes.Order.order_name;
import framework.modules.users.Model.classes.Order.order_salary;
import framework.modules.users.Model.classes.Order.order_shopping;
import framework.modules.users.Model.classes.Order.order_surname;
import framework.modules.users.Model.classes.Order.order_up_date;
import framework.utils.menus;

public class order_users {
	
	public static void order_admin(){
		
		String [] menu={class_language.getinstance().getProperty("dni_t"),
				class_language.getinstance().getProperty("name_t"),class_language.getinstance().getProperty("surname_t")
				,class_language.getinstance().getProperty("birthday_t"),
				class_language.getinstance().getProperty("age_t"),class_language.getinstance().getProperty("date_cont")
				,class_language.getinstance().getProperty("salary_t"),
				class_language.getinstance().getProperty("incentive_t")};
		String option="";
		boolean rep=false;
		
		
		do {
			option=(String)menus.combobox(menu, class_language.getinstance().getProperty("choose"), 
					class_language.getinstance().getProperty("order"));
			
			if(option==menu[0]){
				Collections.sort(singleton_user.admin);
				rep=true;
			}
			if(option==menu[1]){
				Collections.sort(singleton_user.admin, new order_name());
				rep=true;
			}
			if(option==menu[2]){
				Collections.sort(singleton_user.admin, new order_surname());
				rep=true;
			}
			if(option==menu[3]){
				Collections.sort(singleton_user.admin, new order_birthday());
				rep=true;
			}
			if(option==menu[4]){
				Collections.sort(singleton_user.admin, new order_date_cont());
				rep=true;
			}
			if(option==menu[5]){
				Collections.sort(singleton_user.admin, new order_age());
				rep=true;
			}
			if(option==menu[6]){
				Collections.sort(singleton_user.admin, new order_salary());
				rep=true;
			}
			if(option==menu[7]){
				Collections.sort(singleton_user.admin, new order_benefit());
				rep=true;
			}
		} while (rep==false);
		
		
	}
	
	
	public static void order_client(){
		
		String [] menu={class_language.getinstance().getProperty("dni_t"),
				class_language.getinstance().getProperty("name_t"),class_language.getinstance().getProperty("surname_t")
				,class_language.getinstance().getProperty("birthday_t"),
				class_language.getinstance().getProperty("age_t"),class_language.getinstance().getProperty("up_date_t")
				,class_language.getinstance().getProperty("shopping_t"),
				class_language.getinstance().getProperty("disconunt_t")};
		String option="";
		boolean rep=false;
		
		
		do {
			option=(String)menus.combobox(menu, class_language.getinstance().getProperty("choose"), 
					class_language.getinstance().getProperty("order"));
			
			if(option==menu[0]){
				Collections.sort(singleton_user.client);
				rep=true;
			}
			if(option==menu[1]){
				Collections.sort(singleton_user.client, new order_name());
				rep=true;
			}
			if(option==menu[2]){
				Collections.sort(singleton_user.client, new order_surname());
				rep=true;
			}
			if(option==menu[3]){
				Collections.sort(singleton_user.client, new order_birthday());
				rep=true;
			}
			if(option==menu[4]){
				Collections.sort(singleton_user.client, new order_up_date());
				rep=true;
			}
			if(option==menu[5]){
				Collections.sort(singleton_user.client, new order_age());
				rep=true;
			}
			if(option==menu[6]){
				Collections.sort(singleton_user.client, new order_shopping());
				rep=true;
			}
			if(option==menu[7]){
				Collections.sort(singleton_user.client, new order_benefit());
				rep=true;
			}
		} while (rep==false);
		
		
	}
	
	
	public static void order_reg(){
		
		String [] menu={class_language.getinstance().getProperty("dni_t"),
				class_language.getinstance().getProperty("name_t"),class_language.getinstance().getProperty("surname_t")
				,class_language.getinstance().getProperty("birthday_t"),
				class_language.getinstance().getProperty("age_t"),class_language.getinstance().getProperty("points_t")};
		String option="";
		boolean rep=false;
		
		
		
		do {
			option=(String)menus.combobox(menu, class_language.getinstance().getProperty("choose"), 
					class_language.getinstance().getProperty("order"));
			
			if(option==menu[0]){
				Collections.sort(singleton_user.reg);
				rep=true;
			}
			if(option==menu[1]){
				Collections.sort(singleton_user.reg, new order_name());;
				rep=true;
			}
			if(option==menu[2]){
				Collections.sort(singleton_user.reg, new order_surname());
				rep=true;
			}
			if(option==menu[3]){
				Collections.sort(singleton_user.reg, new order_birthday());;
				rep=true;
			}
			if(option==menu[4]){
				Collections.sort(singleton_user.reg, new order_birthday());;
				rep=true;
			}
			if(option==menu[5]){
				Collections.sort(singleton_user.reg, new order_benefit());
				rep=true;
			}
		} while (rep==false);
		
		
	}

}
