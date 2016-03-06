package framework.modules.users.Model.classes.Order;

import java.util.Comparator;

import framework.modules.users.Model.classes.*;

public class order_salary implements Comparator<user>{

	public int compare(user u1, user u2){
		
		if(((admin_class)u1).getSalary() > (((admin_class)u2).getSalary()))
			return 1;
		if(((admin_class)u1).getSalary() < (((admin_class)u2).getSalary()))
			return -1;
		return 0;
		
	}
}
