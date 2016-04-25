package framework.modules.users.client.Model.classes;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import framework.modules.users.Classes.user;
import java.io.Serializable;
import java.text.Format;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import framework.classes.class_date;
import framework.modules.Menu_config.Model.classes.language.class_language;
import framework.utils.format;

@XStreamAlias("client_class")
public class client_class extends user implements Serializable{

	/**Attributes declaration*/
	@XStreamAlias("up_date")
	private class_date up_date; //fecha de alta
	@XStreamAlias("antique")
	private int antique;
	@XStreamAlias("shopping")
	private float shopping;
	@XStreamAlias("premium")
	private boolean premium;
	@XStreamAlias("type")
	private String type;
	
	/**Builder for all attributes*/
	public client_class(String dni, String name, String surname, String mobile, String email, String nick,
			String password, String avatar, String state, class_date birthday, class_date up_date,
			float shopping, boolean premium, String type) {
		
		super(dni, name, surname, mobile, email, nick, password, avatar, state, birthday);
		
		this.up_date = up_date;
		//this.antique = antique;
		this.shopping = shopping;
		this.premium = premium;
		this.type = type;
		super.setBenefit(calc_benefit());
		this.setAntique(calc_antique());
	}

	/**Void builder*/
	public client_class() {
		super();
	}
	
	
	/**Builder for primary key*/
	public client_class (String dni){
		
		super(dni);
	}
	
        /**
         * funtion to charge a user by DB
         */
        public client_class DB_to_client(DBObject DBclient){
            
            this.setDni((String)DBclient.get("dni"));
            this.setName((String)DBclient.get("name"));
            this.setSurname((String)DBclient.get("surname"));
            this.setMobile((String)DBclient.get("mobile"));
            this.setEmail((String)DBclient.get("email"));
            this.setNick((String)DBclient.get("nick"));
            this.setPassword((String)DBclient.get("password"));
            this.setAvatar((String)DBclient.get("avatar"));
            this.setState((String)DBclient.get("state"));
            this.setBirthday(new class_date((String)DBclient.get("birthday")));
            this.up_date=(new class_date((String) DBclient.get("up_date")));
            this.shopping=Float.parseFloat(DBclient.get("shopping").toString());
            this.premium=(boolean) DBclient.get("premium");
            this.type=(String) DBclient.get("type");
            
            
            
            return new client_class(this.getDni(), this.getName(), this.getSurname(), this.getMobile(), 
                    this.getEmail(), this.getNick(), this.getPassword(), this.getAvatar(),
                    this.getState(), this.getBirthday(), this.up_date, this.shopping, this.premium, 
                    this.type);
        }
        
        /**
         * funtion to charge a user to DB
         * @return 
         */
        public BasicDBObject client_to_DB() {
	
            BasicDBObject dBObjectclient = new BasicDBObject();
            dBObjectclient.append("dni", this.getDni());
            dBObjectclient.append("name", this.getName());
            dBObjectclient.append("surname", this.getSurname());
            dBObjectclient.append("mobile", this.getMobile());
            dBObjectclient.append("email", this.getEmail());
            dBObjectclient.append("nick", this.getNick());
            dBObjectclient.append("password", this.getPassword());
            dBObjectclient.append("avatar", this.getAvatar());
            dBObjectclient.append("state", this.getState());
            dBObjectclient.append("birthday", this.getBirthday().toString_DB());
            dBObjectclient.append("age", this.getAge());
            dBObjectclient.append("up_date", this.getUp_date().toString_DB());
            dBObjectclient.append("antique", this.getAntique());
            dBObjectclient.append("shopping", this.getShopping());
            dBObjectclient.append("benefit", this.getBenefit());
            dBObjectclient.append("premium", this.isPremium());
            dBObjectclient.append("type", this.getType());
	
	return dBObjectclient;
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
	 * 11-Discharge date
	 * 12-Antique
	 * 13-Shopping
	 * 14-Premium
	 * 15-Type
	 * */
	public client_class(int i, Object param){
		
		super(i,param);
		
		switch (i) {
			case 11:
				this.up_date=(class_date)param;
				break;
			case 12:
				this.antique=(int)param;
				break;
			case 13:
				this.shopping=(float)param;
				break;
			case 14:
				this.premium=(boolean)param;
				break;
			case 15:
				this.type=(String)param;
				break;
			default:
				break;
		}//end of switch
		
	}

	//GETTERS & SETTERS
	
	public class_date getUp_date() {
		return up_date;
	}

	public void setUp_date(class_date up_date) {
		this.up_date = up_date;
		this.setAntique(calc_antique());
	}

	public int getAntique() {
		return antique;
	}

	public void setAntique(int antique) {
		this.antique = antique;
	}

	public float getShopping() {
		return shopping;
	}

	public void setShopping(float shopping) {
		this.shopping = shopping;
		super.setBenefit(calc_benefit());
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	/**Return all attributes, class: user and client*/
	public String toString(){
		
		StringBuffer info= new StringBuffer();
		
		info.append(super.toString()+"\n");
		info.append(class_language.getinstance().getProperty("up_date_p")+this.getUp_date().toString()+"\n");
		info.append(class_language.getinstance().getProperty("antique_p")+this.getAntique()+"\n");
		info.append(class_language.getinstance().getProperty("shopping_p")+format.Format_Euro(this.getShopping())+"\n");
		info.append(class_language.getinstance().getProperty("premium_p")+this.isPremium()+"\n");
		info.append(class_language.getinstance().getProperty("type_p")+this.getType()+"\n");
		
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
	 * 11-benefit
	 *
	 * -Daughter options:
	 * 11-Discharge date
	 * 12-Antique
	 * 14-Premium
	 * 15-Type
	 * */
	public String toString(int i){
		
		String chain="";
		
		if(i<12)
			
			chain=chain+super.toString(i);
		
		else{

		
			switch (i) {
			
			case 12:
				chain=chain+this.getUp_date()+"\n";
				break;
			case 13:
				chain=chain+this.getAntique()+"\n";
				break;
			case 14:
				chain=chain+this.getShopping()+"\n";
				break;
			case 15:
				chain=chain+this.isPremium()+"\n";
				break;
			case 16:
				chain=chain+this.getType()+"\n";
				break;
			default:
				break;
			}//end of switch
		}
		return chain;
	}
        
        /**
         * funtion to recalculate the benefit of client
         * @return 
         */
	public float calc_benefit(){
		
		float discount=0.0f;
		
		if(isPremium()==true){
			
			discount=(0.1f*getShopping());
			
		}else{
			
			discount=(0.01f*getShopping());
			
		}
		
		return discount;
	}
	
        /**
         * funtion to recalculate the antique
         * @return 
         */
	public int calc_antique(){
		int antique=0;
		
		class_date up_date=null;
		up_date=this.up_date;
		
		antique=up_date.date_to_actualdate();
		
		
		return antique;
	}
}
