package framework.modules.users.Model.classes.Order;

import java.util.Comparator;

import framework.modules.users.Model.classes.user;

public class order_birthday implements Comparator<user>{
	
	public int compare(user u1, user u2){
		
		if(u1.getBirthday().compare_2dates(u2.getBirthday())>0)
			return 1;
		if(u1.getBirthday().compare_2dates(u2.getBirthday())<0)
			return -1;
		return 0;
		
	}

}
