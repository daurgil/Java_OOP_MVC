package framework.modules.users.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import framework.classes.class_date;
import framework.modules.Config.Model.classes.language.class_language;
import framework.modules.Config.Model.classes.class_config;
import framework.utils.format;

/**
 * Declaration of mother class of user types 
 * @author pelu
 *
 */
@XStreamAlias("user")
public abstract class user implements Comparable<user>, Serializable {
	
	/**Attributes declaration*/
	@XStreamAlias("dni")
	private String dni;
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("surname")
	private String surname;
	@XStreamAlias("mobile")
	private String mobile;
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("nick")
	private String nick;
	@XStreamAlias("password")
	private String password;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("state")
	private String state;
	@XStreamAlias("birthday")
	private class_date birthday;
	@XStreamAlias("age")
	private int age;
	@XStreamAlias("benifit")
	private float benefit;
	
	/** Builder for all attributes*/
 	public user (String dni,String name,String surname,String mobile,String email,String nick,String password,String avatar,
			String state,class_date birthday){
		
		this.dni=dni;
		this.name=name;
		this.surname=surname;
		this.mobile=mobile;
		this.email=email;
		this.nick=nick;
		this.password=password;
		this.avatar=avatar;
		this.state=state;
		this.birthday=birthday;
		this.setAge(calc_age());
		
		
	}
	
	/**Void builder*/
	public user (){
		
	}
	
	/**Builder for primary key*/
	public user (String dni){
		this.dni=dni;
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
	 * */
	public user(int i, Object param){
		
		switch (i) {
		case 0:
			this.dni=(String)param;
			break;
		case 1:
			this.name=(String)param;
			break;
		case 2:
			this.surname=(String)param;
			break;
		case 3:
			this.mobile=(String)param;
			break;
		case 4:
			this.email=(String)param;
			break;
		case 5:
			this.nick=(String)param;
			break;
		case 6:
			this.password=(String)param;
			break;
		case 7:
			this.avatar=(String)param;
			break;
		case 8:
			this.state=(String)param;
			break;
		case 9:
			this.birthday=(class_date)param;
			break;
		}//end of switch
		
	}

	//Getters y Setters
	/**dni user getter*/
	public String getDni() {
		return dni;
	}
	
	/**dni user setter*/
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**name user getter*/
	public String getName() {
		return name;
	}
	
	/**name user setter*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**surname user getter*/
	public String getSurname() {
		return surname;
	}
	
	/**surname user setter*/
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**mobile user getter*/
	public String getMobile() {
		return mobile;
	}
	
	/**mobile user setter*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**email user getter*/
	public String getEmail() {
		return email;
	}
	
	/**email user setter*/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**user(attribute) user getter*/
	public String getNick() {
		return nick;
	}

	/**user(attribute) user setter*/
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	/**password user getter*/
	public String getPassword() {
		return password;
	}

	/**password user setter*/
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**avatar user getter*/
	public String getAvatar() {
		return avatar;
	}

	/**avatar user setter*/
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	/**state user getter*/
	public String getState() {
		return state;
	}

	/**state user setter*/
	public void setState(String state) {
		this.state = state;
	}
	
	/**birthday user getter*/
	public class_date getBirthday() {
		return birthday;
	}

	/**birthday user setter*/
	public void setBirthday(class_date birthday) {
		this.birthday = birthday;
		this.setAge(calc_age());
	}
	
	/**age user getter*/
	public int getAge() {
		return age;
	}

	/**age user setter*/
	public void setAge(int age) {
		this.age = age;
	}
	
	/**benefits user getter*/
	public float getBenefit() {
		return benefit;
	}
	
	/**Benefits user setter*/
	public void setBenefit(float benefit) {
		this.benefit = benefit;
	}
	
	/**To order on A.list by dni*/
	
	public int compareTo(user E) {//para ordenar los empleados por nombre
		if(this.getDni().compareTo(E.getDni())>0)
			return 1;
		if(this.getDni().compareTo(E.getDni())<0)
			return -1;
		return 0;
	}
	
	/**to compare 2 objects by dni*/
	
	public boolean equals(Object c){
		return getDni().equals(((user)c).getDni());
	}	
	
	/**show all the attribute in one chain*/
	
	public String toString(){
		
		StringBuffer info= new StringBuffer();
		
		
		info.append(class_language.getinstance().getProperty("dni_p")+this.getDni()+"\n");
		info.append(class_language.getinstance().getProperty("name_p")+this.getName()+"\n");
		info.append(class_language.getinstance().getProperty("surname_p")+this.getSurname()+"\n");
		info.append(class_language.getinstance().getProperty("mobile_p")+this.getMobile()+"\n");
		info.append(class_language.getinstance().getProperty("email_p")+this.getEmail()+"\n");
		info.append(class_language.getinstance().getProperty("user_p")+this.getNick()+"\n");
		info.append(class_language.getinstance().getProperty("password_p")+this.getPassword()+"\n");
		info.append(class_language.getinstance().getProperty("avatar_p")+this.getAvatar()+"\n");
		info.append(class_language.getinstance().getProperty("state_p")+this.getState()+"\n");
		info.append(class_language.getinstance().getProperty("birthday_p")+this.getBirthday().toString()+"\n");
		info.append(class_language.getinstance().getProperty("age_p")+this.getAge()+"\n");
		info.append(class_language.getinstance().getProperty("benefit_p")+format.currency(this.getBenefit())+"\n");
		
		return info.toString();
	}
	
	/**return only one primary key*/
	public String toString(String dni){
		
		return this.getDni()+"\n";
	}
	
	/**Dinamic toString to return values
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
	 * 11-benefit
	 * */
	public String toString(int i){
		String chain="";
		
		switch (i) {
		case 0:
			chain=chain+this.getDni()+"\n";
			break;
		case 1:
			chain=chain+this.getName()+"\n";
			break;
		case 2:
			chain=chain+this.getSurname()+"\n";
			break;
		case 3:
			chain=chain+this.getMobile()+"\n";
			break;
		case 4:
			chain=chain+this.getEmail()+"\n";
			break;
		case 5:
			chain=chain+this.getNick()+"\n";
			break;
		case 6:
			chain=chain+this.getPassword()+"\n";
			break;
		case 7:
			chain=chain+this.getAvatar()+"\n";
			break;
		case 8:
			chain=chain+this.getState()+"\n";
			break;
		case 9:
			chain=chain+this.getBirthday().toString()+"\n";
			break;
		case 10:
			chain=chain+this.getAge()+"\n";
			break;
		case 11:
			chain=chain+format.currency(this.getBenefit())+"\n";
			break;
		default:
			break;
		}//end of switch
		
		return chain;
	}
	
	public abstract float calc_benefit();
	
	public int calc_age(){
		int age=0;
		
		class_date birthday=null;
		
		birthday=this.birthday;
		
		age=birthday.date_to_actualdate();
		
		return age;
	}
}
