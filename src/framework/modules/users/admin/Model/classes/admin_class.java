package framework.modules.users.admin.Model.classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import framework.classes.class_date;
import framework.modules.Menu_config.Model.classes.language.class_language;
import framework.modules.Menu_config.Model.classes.class_config;
import framework.modules.users.Classes.user;
import framework.modules.users.Classes.user;
import framework.utils.format;

@XStreamAlias("admin_class")
public class admin_class extends user implements Serializable{
	
	/**Attributes declaration*/
	@XStreamAlias("date_cont")
	private class_date date_cont;
	@XStreamAlias("antique")
	private int antique;
	@XStreamAlias("salary")
	private float salary;
	@XStreamAlias("activity")
	private int activity;
	
	/** Builder for all attributes*/
	public admin_class(String dni,String name,String surname,String mobile,String email,String nick,String password,String avatar,
			String state,class_date birthday, class_date date_cont, int activity) {
		
		super(dni,name,surname,mobile,email,nick,password,avatar,state,birthday);
		
		this.date_cont=date_cont;
		//this.antique=antique;
		//this.salary=salary;
		this.activity=activity;
		this.setAntique(calc_antique());
		super.setBenefit(calc_benefit());
		this.setSalary(calc_salary());
	
	}
	
	/** Void builder*/
	public admin_class() {
		
		super();
	
	}
	
	/**Builder for primary key*/
	public admin_class (String dni){
		
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
	 *
	 * -Daughter options:
	 * 11-Date of contract
	 * 12-Antique
	 * 13-Salary
	 * 14-Activity
	 * */
	public admin_class(int i, Object param){
		
		
		super(i,param);
				
		
		switch (i) {
		case 11:
			this.date_cont=(class_date)param;
			break;
		case 12:
			this.antique=(int)param;
			break;
		case 13:
			this.activity=(int)param;
			break;
		default:
			break;
		}//end of switch
		
	}

	//Getters & Setters
	
	public class_date getDate_cont() {
		return date_cont;
	}

	public void setDate_cont(class_date date_cont) {
		this.date_cont = date_cont;
		this.setAntique(calc_antique());
	}

	public int getAntique() {
		return antique;
	}

	public void setAntique(int antique) {
		this.antique = antique;
		super.setBenefit(calc_benefit());
		this.setSalary(calc_salary());
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getActivity() {
		return activity;
	}

	public void setActivity(int activity) {
		this.activity = activity;
		super.setBenefit(calc_benefit());
		this.setSalary(calc_salary());
	}
	
	/**Return all attributes, class: user and admin*/
	public String toString(){
		
		StringBuffer info= new StringBuffer();
		
		info.append(super.toString()+"\n");
		info.append(class_language.getinstance().getProperty("date_cont_p")+this.getDate_cont().toString()+"\n");
		info.append(class_language.getinstance().getProperty("antique_p")+this.getAntique()+"\n");
		info.append(class_language.getinstance().getProperty("salary_p")+format.currency(this.getSalary())+"\n");
		info.append(class_language.getinstance().getProperty("activity_p")+this.getActivity()+"\n");
		
		return info.toString();
		
		/*String chain="";
		
		chain=chain+super.toString(format_date, decimal, format_currency, language)+"\n";
		chain=chain+languages.create_user_date_cont(language,1)+": "+this.getDate_cont().toString(format_date)+"\n";
		chain=chain+languages.create_user_antique(language)+": "+this.getAntique()+"\n";
		chain=chain+languages.create_user_salary(language)+": "+format.currency(format_currency, this.getSalary(), decimal)+"\n";
		chain=chain+languages.create_user_activity(language,1)+": "+this.getActivity()+"\n";
		
		return chain;*/
		
	}
	
	/**Return primary key, attribute of his mother*/
	public String toString(String dni){
		
		return super.toString(dni);
	}
	
	/**Dinamic toString to return values
	 * -Mother options:
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
	 * 11-Date of contract
	 * 12-Antique
	 * 13-Salary
	 * 14-Benefit(incentive)
	 * 15-Activity
	 * */
	public String toString(int i){
		
		String chain="";
		
		if(i<12)
			
			chain=chain+super.toString(i);
		
		else{
	
			switch (i) {
			case 12:
				chain=chain+this.getDate_cont().toString()+"\n";
				break;
			case 13:
				chain=chain+this.getAntique()+"\n";
				break;
			case 14:
				chain=chain+format.currency(this.getBenefit())+"\n";
				break;
			case 15:
				chain=chain+this.getActivity()+"\n";
				break;
			default:
				break;
			}//end of switch
		}
		
		return chain;
	}
	
	
	/**
	 * To recalculate the value of incentive
	 * @return incentive float that depend of activity and antique
	 */
	public float calc_benefit(){
		
		float incentive= ((0.05f * getActivity()) + (10 * getAntique()));
		
		return incentive;
	}
	
	
	/**
	 * To recalculate the value of salary
	 * @return total
	 */
	public float calc_salary(){
		
		float total=0f;
		
		total=(this.calc_benefit() + 1000);
		
		return total;
	}
	
	
	/**
	 * To recalculate the value of antique
	 * @return antique
	 */
	public int calc_antique(){
		int antique=0;
		
		class_date date_cont=null;
		date_cont=this.date_cont;
		
		antique=date_cont.date_to_actualdate();
		
		
		return antique;
	}
}
