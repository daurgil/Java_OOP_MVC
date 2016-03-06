package framework.classes;

import framework.modules.Config.Model.classes.class_config;
import java.io.ObjectInputStream.GetField;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import framework.utils.format;

@XStreamAlias("date_class")
public class class_date implements Serializable{
	
	@XStreamAlias("day")
	private int day;
	@XStreamAlias("month")
	private int month;
	@XStreamAlias("year")
	private int year;
	@XStreamAlias("date_s")
	private String date_s;
	@XStreamAlias("date")
	private Calendar date;
	
	private static SimpleDateFormat format_date= new SimpleDateFormat("dd/MM/yyyy");
	
	
	/**
	 * Date builder with multiple formats
	 * @param introduced_date date introduced by user
	 * @param format choose by user
	 */
	public class_date(String introduced_date){
		
		String[] part_date = new String[3];
		
		switch (class_config.getinstance().getFormat_date()) {

		case "dd/MM/yyyy":
			part_date=introduced_date.split("/");
			
			this.day=Integer.parseInt(part_date[0]);
			this.month=Integer.parseInt(part_date[1]);
			this.year=Integer.parseInt(part_date[2]);
			
			this.date_s=this.day+"/"+this.month+"/"+this.year;
			break;
			
		case "dd-MM-yyyy":
			part_date=introduced_date.split("-");
			
			this.day=Integer.parseInt(part_date[0]);
			this.month=Integer.parseInt(part_date[1]);
			this.year=Integer.parseInt(part_date[2]);
			
			this.date_s=this.day+"-"+this.month+"-"+this.year;
			break;
			
		case "yyyy/MM/dd":
			part_date=introduced_date.split("/");
			
			this.year=Integer.parseInt(part_date[0]);
			this.month=Integer.parseInt(part_date[1]);
			this.day=Integer.parseInt(part_date[2]);
			
			this.date_s=this.year+"/"+this.month+"/"+this.day;
			break;
		
		case "yyyy-MM-dd":
			part_date=introduced_date.split("/");
			
			this.year=Integer.parseInt(part_date[0]);
			this.month=Integer.parseInt(part_date[1]);
			this.day=Integer.parseInt(part_date[2]);
			
			this.date_s=this.year+"/"+this.month+"/"+this.day;
			break;	
		default:
			break;
		}
			
	}
	
	
	public class_date(){
		Calendar actual_date= Calendar.getInstance();
		String date=this.Calendar_toString(actual_date);
		String[] part_date = date.split("/");
			
			this.day=Integer.parseInt(part_date[0]);
			this.month=Integer.parseInt(part_date[1]);
			this.year=Integer.parseInt(part_date[2]);
			
			this.date_s=this.day+"/"+this.month+"/"+this.year;
			
	}
	
	/*Date builder
	 * Builder that recive 3 values(day,month,year), to give value to the variables of class
	 */
	public class_date(int day, int month, int year){
		
		this.day=day;
		this.month=month;
		this.year=year;
		
		this.date_s=this.day+"/"+this.month+"/"+this.year;
				
	}

	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDate_s() {
		return date_s;
	}

	public void setDate_s(String date_s) {
		this.date_s = date_s;
	}

	public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	/**
	 * To show the date as a String
	 */
	public String toString(){
		
		StringBuffer info =new StringBuffer();
		String date="";
		
		switch (class_config.getinstance().getFormat_date()) {
		case "dd/mm/yyyy":
			info.append(String.format("%02d", this.getDay())+"/"+String.format("%02d", this.getMonth())+"/"+this.getYear());
			break;
			
		case "dd-mm-yyyy":
			info.append(String.format("%02d", this.getDay())+"-"+String.format("%02d", this.getMonth())+"-"+this.getYear());
			break;
			
		case "yyyy/mm/dd":
			info.append(this.getYear()+"/"+String.format("%02d", this.getMonth())+"/"+String.format("%02d", this.getDay()));
			break;
		
		case "yyyy-mm-dd":
			info.append(this.getYear()+"-"+String.format("%02d", this.getMonth())+"-"+String.format("%02d", this.getDay()));
			break;
		default:
			break;
		}
		return date;
	}
	
	
	/**
	 * To convert a String date to a object of class_date
	 * @return object of class_date
	 */
	public Calendar String_toCalendar(){
		
		Calendar date2= Calendar.getInstance();
		//Date date= new Date();
		
		try {
			//SimpleDateFormat format_date= new SimpleDateFormat("dd/MM/yyyy");
			
			//date=format_date.parse(getDate_s());
			date2.set(this.getYear(), this.getMonth()-1, this.getDay());
                        System.out.println("HHH"+date2);
			
		} catch (Exception e) {
			return date2;
		}
		
		return date2;
	}
	
	
	/**
	 * To convert a object of class_date to a String date
	 * @param date object of type calendar
	 * @return s_date String for a date
	 */
	public String Calendar_toString(Calendar date){
		
		int day=0, month=0, year=0;
		String s_date="xx/xx/xxxx";
		
		try {
			day=date.get(Calendar.DATE);
			month=date.get(Calendar.MONTH);
			year=date.get(Calendar.YEAR);
			
			s_date=day+"/"+month+"/"+year;
		} catch (Exception e) {
			return s_date;
		}
		
		return s_date;
		
	}
	
	
	/**
	 * To check a day introduced in object class_date
	 * @return correct boolean
	 */
	public boolean validate_day(){
		
		GregorianCalendar calendar_date= new GregorianCalendar();
		int days[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
		boolean correct=false;
		
		if(calendar_date.isLeapYear(getYear()))
			days[2]=29;
		
		if(((this.getDay())>=1)&&((this.getDay()<=days[this.getMonth()])))
			correct=true;
		else
			correct=false;
			
		return correct;
	}
	
	
	/**
	 * To check a month introduced in object class_date
	 * @return correct boolean
	 */
	public boolean validate_month(){
		
		boolean correct=false;
		
		if((this.getMonth()>=1) &&(this.getMonth()<=12))
			correct=true;
		
		return correct;
	}
	
	
	/**
	 * To check a year introduced in object class_date
	 * @return correct boolean
	 */
	public boolean validate_year(){
		
		boolean correct=false;
		
		if ((this.getYear() >= 1900) && (this.getYear() <= 2100)) 
			correct=true;
		
		return correct;
	}
	
	/**
	 * To check a complete date, checking his parts, introduced in object class_date
	 * @return correct boolean
	 */
	public boolean validate_date(){
		
		boolean correct=true;
		
		if(this.validate_day()==false)
			correct=false;
    
		if(this.validate_month()==false)
			correct=false;
                
		if(this.validate_year()==false)
			correct=false;
                
		
		return correct;
	}
        
        public static String date_to_String(class_date date){
            String s=date.toString();
            return s;
        }

	
	/**
	 * To know if a date is previous, equal or later than the system date
	 * @return result the value depend of the condition
	 */
	public int compare_date_to_System(){
		
		int result=0;
	
		Calendar system= Calendar.getInstance();
		Calendar date= this.String_toCalendar();
		
		if(date.before(system))
			result=-1;
		if(date.equals(system))
			result=0;
		if(date.after(system))
			result=1;
		
		return result;
	}
	
	
	/**
	 * To know if a date is previous, equal or later than other date
	 * @return result the value depend of the condition
	 */
	public int compare_2dates(class_date date){
		int result=0;
		
		Calendar date_one=this.String_toCalendar();
		Calendar date_two=date.String_toCalendar();
		
		if(date_one.before(date_two))
			result=-1;
		if(date_one.equals(date_two))
			result=0;
		if(date_one.after(date_two))
			result=1;
		
		return result;
	}

	
	/**
	 * To keep the years between 2 dates
	 * @param date later date passed as object
	 * @return value years between 2 dates
	 */
	public int subtraction_dates(class_date date){
		int value=0, bis_days=0, cont=0;
		
		GregorianCalendar date1=new GregorianCalendar();
		GregorianCalendar date2=new GregorianCalendar();
		
		date1.set(this.getYear(), this.getMonth()-1, this.getDay());
		date2.set(date.getYear(), date.getMonth()-1, date.getDay());
		
		long time= date2.getTimeInMillis() - date1.getTimeInMillis();
		
		value= (int)(time/ (1000*60*60*24));
		
		for(int i=date1.get(Calendar.YEAR); i<= date2.get(Calendar.YEAR); i++){
			
			if((i%4)==0)
				cont++;
			
		}
		
		bis_days=cont*366; //nº of days by leap-years
		value=value-bis_days; //keep out days of the leap-years to the total days
		value=value / 365; //nº years of normal years
		value= value + cont;// sum of total years
		
		return value;
	}
	
	/**
	 * To keep the years between a date and the system date
	 * 
	 * @return value years between the 2 dates
	 */
	public int date_to_actualdate(){
		int years=0, bis_days=0, cont=0;
		
		GregorianCalendar date1=new GregorianCalendar();
		GregorianCalendar date2=new GregorianCalendar();
		
		date1.set(this.getYear(), this.getMonth()-1, this.getDay());
		
		long time= date2.getTimeInMillis() - date1.getTimeInMillis();
		
		years= (int)(time/ (1000*60*60*24));
		
		for(int i=date1.get(Calendar.YEAR); i<= date2.get(Calendar.YEAR); i++){
			
			if((i%4)==0)
				cont++;
			
		}
		
		bis_days=cont*366; //nº of days by leap-years
		years=years-bis_days; //keep out days of the leap-years to the total days
		years=years / 365; //nº years of normal years
		years= years + cont;// sum of total years
		
		return years;
	}
	

}
