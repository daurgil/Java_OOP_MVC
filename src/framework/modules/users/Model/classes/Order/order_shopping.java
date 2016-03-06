package framework.modules.users.Model.classes.Order;

import java.util.Comparator;

import framework.modules.users.Model.classes.*;

public class order_shopping implements Comparator<user>{

	public int compare(user u1, user u2){
		
		if(((client_class)u1).getShopping() > (((client_class)u2).getShopping()))
			return 1;
		if(((client_class)u1).getShopping() < (((client_class)u2).getShopping()))
			return -1;
		return 0;
		
	}
}
