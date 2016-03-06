package framework.modules.users.Model.classes.Order;

import java.util.Comparator;


import framework.modules.users.Model.classes.*;

public class order_up_date implements Comparator<user>{
	
	public int compare(user u1, user u2){
		if(  ((client_class)u1).getUp_date().compare_2dates(((client_class)u2).getUp_date())==-1   )
			return 1;
		if(  ((client_class)u1).getUp_date().compare_2dates(((client_class)u2).getUp_date())==-1   )
			return -1;
		return 0;
		}
}


