package framework.modules.users.Model.classes.Order;

import java.util.Comparator;

import framework.modules.users.Model.classes.*;

public class order_date_cont implements Comparator<user>{
	
	public int compare(user u1, user u2){
		if(  ((admin_class)u1).getDate_cont().compare_2dates(((admin_class)u2).getDate_cont())==-1   )
			return 1;
		if(  ((admin_class)u1).getDate_cont().compare_2dates(((admin_class)u2).getDate_cont())==-1   )
			return -1;
		return 0;
		}
}
