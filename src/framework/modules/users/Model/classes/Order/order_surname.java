package framework.modules.users.Model.classes.Order;

import java.util.Comparator;

import framework.modules.users.Model.classes.user;

public class order_surname implements Comparator<user>{
	
	public int compare(user u1, user u2){
		
		if(u1.getSurname().compareTo(u2.getSurname())>0)
			return 1;
		if(u1.getSurname().compareTo(u2.getSurname())<0)
			return -1;
		
		return 0;
		
	}

}
