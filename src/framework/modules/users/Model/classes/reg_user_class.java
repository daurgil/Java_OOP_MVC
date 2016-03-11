package framework.modules.users.Model.classes;

import framework.modules.users.Classes.user;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import framework.classes.class_date;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.Config.Model.classes.class_config;
import framework.utils.format;

@XStreamAlias("reg_user_class")
public class reg_user_class extends user implements Serializable{

	/**Attributes declaration*/
	@XStreamAlias("activity")
	private int activity;
	@XStreamAlias("karma")
	private String karma;
	
	
	
	/**Builder for all attributes*/
	public reg_user_class(String dni, String name, String surname, String mobile, String email, String user,
			String password, String avatar, String state, class_date birthday, int activity, String karma,
			float benefit) {
		
		super(dni, name, surname, mobile, email, user, password, avatar, state, birthday);
		
		this.activity = activity;
		this.karma = calc_karma();
		super.setBenefit(calc_benefit());
	}

	/**Void builder*/
	public reg_user_class() {
		super();
	}
	
	/**Builder for primary key*/
	public reg_user_class (String dni){
		
		super(dni);
	}
	
	/**Dinamic builder
	 * 
	 * 0-dni
	 * 1-name
	 * 2-surname
	 * 3-mobile
	 * 4-email
	 * 5-user
	 * 6-password
	 * 7-avatar
	 * 8-state
	 * 9-birthday
	 * 10-age
	 *
	 * -Daughter options:
	 * 11-Activity
	 * 12-Karma
	 * 
	 * */
	public reg_user_class(int i, Object param){
		
		super(i,param);
		
		switch (i) {
		case 11:
			this.activity=(int)param;
			break;
		case 12:
			this.karma=(String)param;
			break;	
		default:
			break;
		}//end of switch
		
	}

	//GETTERS & SETTERS
	
	public int getActivity() {
		return activity;
		
	}

	public void setActivity(int activity) {
		this.activity = activity;
		super.setBenefit(calc_benefit());
		this.setKarma(calc_karma());
	}

	public String getKarma() {
		return karma;
	}

	public void setKarma(String karma) {
		this.karma = karma;
	}
	
	/**Return all attributes, class: user and registered user*/
	public String toString(){
		
		StringBuffer info= new StringBuffer();
		
		info.append(super.toString()+"\n");
		info.append(class_language.getinstance().getProperty("activity_p")+this.getActivity()+"\n");
		info.append(class_language.getinstance().getProperty("karma_p")+this.getKarma()+"\n");
		return info.toString();
		
		
	}
	
	/**Return primary key, attribute of his mother*/
	public String toString(String dni){
		
		return super.toString(dni);
	}
	
	/**Dinamic toString
	 * 
	 * 0-dni
	 * 1-name
	 * 2-surname
	 * 3-mobile
	 * 4-email
	 * 5-user
	 * 6-password
	 * 7-avatar
	 * 8-state
	 * 9-birthday
	 * 10-age
	 * 11-Benefit(points)
	 *
	 * -Daughter options:
	 * 11-Activity
	 * 12-Karma
	 * 
	 * */
	public String toString(int i){
		
		String chain="";
		
		if(i<12)
			
			chain=chain+super.toString(i);
		
		else{
			
			switch (i) {
			case 12:
				chain=chain+this.getActivity()+"\n";
				break;
			default:
				break;
			}//end of switch
		}
		return chain;
	}
	
	public String calc_karma(){
		
		//String [] karma={"High","Normal","Low"};
		String s="";
		
		if((this.getActivity())>5000)
			s="High";
		if(((this.getActivity())<=5000) && ((this.getActivity())>=2000))
			s="Normal";
		if((this.getActivity())<2000)
			s="Low";
		
		return s;
	}
	
	public float calc_benefit(){
		
		float points=0.0f, calc_points=0.0f;
		
		if(getKarma().equals("High"))
			calc_points=5;
		if(getKarma().equals("Normal"))
			calc_points=3;
		if(getKarma().equals("Low"))
			calc_points=1;
		
		points= calc_points*getActivity();
		
		return points;
	}
}
