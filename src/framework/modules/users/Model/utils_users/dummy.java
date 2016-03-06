package framework.modules.users.Model.utils_users;

import java.util.Random;

import framework.classes.class_date;

public class dummy {
	
	
	public static String dni(int number_dni) {
		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
        return String.valueOf(number_dni) + NIF_STRING_ASOCIATION.charAt(number_dni % 23);
    }
	
	public static String randomDni() {
        String random_chain = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        while (random_chain.length() < 8) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9')) {
            	random_chain += c;
            }

        }
        int number_dni= Integer.parseInt(random_chain);
        return dni(number_dni);
    }
	
	public static String RandomName() {// Take a random name

        String name = "";
        String[] name_opt = {"VICENT", "WALTER", "JOAN", "MARIA", "DANIEL", "JOSEP", "SARA", "PEPA", "FELIPE",
            "JAUME", "SERGIO", "PACO", "EMILIO", "NANDO", "ALFONS", "EDUARD", "ATALIA", "VERONICA", "FINA", "PEPE",
            "OSCAR", "LORELAY", "JIM", "LOLA", "LAIA", "ISMAEL", "JORDI", "RAMON", "JAVIER", "NURIA", "ELENA", "BELTRAN", "PABLO", "JUANJO"};

        int posicio0 = (int) (Math.random() * 222) % 10;

        return name = name_opt[posicio0];
    }
	
	public static String RandomSurname() {// Take a random surname

        String surname = "";
        String[] sur_opt = {"VICENT", "WALTER", "JOAN", "MARIA", "DANIEL", "JOSEP", "SARA", "PEPA", "FELIPE",
            "JAUME", "SERGIO", "PACO", "EMILIO", "NANDO", "ALFONS", "EDUARD", "ATALIA", "VERONICA", "FINA", "PEPE",
            "OSCAR", "LORELAY", "JIM", "LOLA", "LAIA", "ISMAEL", "JORDI", "RAMON", "JAVIER", "NURIA", "ELENA", "BELTRAN", "PABLO", "JUANJO"};

        int posicio0 = (int) (Math.random() * 222) % 10;

        return surname = sur_opt[posicio0];
    }
	
	public static String RandomMobile() {// Take a random surname

		String random_chain = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        while (random_chain.length() < 9) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9')) {
            	random_chain += c;
            }
        }
        return random_chain;
    }
	
	public static String RandomEmail() {// Take a random surname

        String email = "";
        String[] opt = {"VICENT@gmail.com", "WALTER@gmail.com", "JOAN@gmail.com", "MARIA@gmail.com", "DANIEL@gmail.com", "JOSEP@gmail.com", "SARA@gmail.com", "PEPA@gmail.com", "FELIPE@gmail.com",
            "JAUME@gmail.com", "SERGIO@gmail.com", "PACO@gmail.com", "EMILIO@gmail.com", "NANDO@gmail.com", "ALFONS@gmail.com", "EDUARD@gmail.com", "ATALIA@gmail.com", "VERONICA@gmail.com", "FINA@gmail.com", "PEPE@gmail.com",
            "OSCAR@gmail.com", "LORELAY@gmail.com", "JIM@gmail.com", "LOLA@gmail.com", "LAIA@gmail.com", "ISMAEL@gmail.com", "JORDI@gmail.com", "RAMON@gmail.com", "JAVIER@gmail.com", "NURIA@gmail.com",
            "ELENA@gmail.com", "BELTRAN@gmail.com", "PABLO@gmail.com", "JUANJO@gmail.com"};

        int posicio0 = (int) (Math.random() * 222) % 10;

        return email = opt[posicio0];
    }
	
	public static String RandomUser() {// Take a random surname

        String user = "";
        String[] opt = {"VICENT", "WALTER", "JOAN", "MARIA", "DANIEL", "JOSEP", "SARA", "PEPA", "FELIPE",
                "JAUME", "SERGIO", "PACO", "EMILIO", "NANDO", "ALFONS", "EDUARD", "ATALIA", "VERONICA", "FINA", "PEPE",
                "OSCAR", "LORELAY", "JIM", "LOLA", "LAIA", "ISMAEL", "JORDI", "RAMON", "JAVIER", "NURIA", "ELENA", "BELTRAN", "PABLO", "JUANJO"};

        int posicio0 = (int) (Math.random() * 222) % 10;

        return user = opt[posicio0];
    }
	
	public static String RandomPassw() {// Take a random surname

        String passw = "";
        String[] opt = {"VICENT@gmail.com", "WALTER@gmail.com", "JOAN@gmail.com", "MARIA@gmail.com", "DANIEL@gmail.com", "JOSEP@gmail.com", "SARA@gmail.com", "PEPA@gmail.com", "FELIPE@gmail.com",
            "JAUME@gmail.com", "SERGIO@gmail.com", "PACO@gmail.com", "EMILIO@gmail.com", "NANDO@gmail.com", "ALFONS@gmail.com", "EDUARD@gmail.com", "ATALIA@gmail.com", "VERONICA@gmail.com", "FINA@gmail.com", "PEPE@gmail.com",
            "OSCAR@gmail.com", "LORELAY@gmail.com", "JIM@gmail.com", "LOLA@gmail.com", "LAIA@gmail.com", "ISMAEL@gmail.com", "JORDI@gmail.com", "RAMON@gmail.com", "JAVIER@gmail.com", "NURIA@gmail.com", "ELENA@gmail.com", "BELTRAN@gmail.com", "PABLO@gmail.com", "JUANJO@gmail.com"};

        int posicio0 = (int) (Math.random() * 222) % 10;

        return passw = opt[posicio0];
    }
	
	public static String Randomavatar() {// Take a random surname

        String passw = "";
        String[] opt = {"VICENT", "WALTER", "JOAN", "MARIA", "DANIEL", "JOSEP", "SARA", "PEPA", "FELIPE",
                "JAUME", "SERGIO", "PACO", "EMILIO", "NANDO", "ALFONS", "EDUARD", "ATALIA", "VERONICA", "FINA", "PEPE",
                "OSCAR", "LORELAY", "JIM", "LOLA", "LAIA", "ISMAEL", "JORDI", "RAMON", "JAVIER", "NURIA", "ELENA", "BELTRAN", "PABLO", "JUANJO"};
        
        int posicio0 = (int) (Math.random() * 222) % 10;

        return passw = opt[posicio0];
    }
	
	/**
	 * Dummy created to prove the framework
	 * @param format_date format of the date in this case not work but is necessary
	 * @param language format of the date in this case not work but is necessary
	 * @return object admin created with specific parameters
	 */
	/*public static admin_class create_admin_dummy(String format_date, String language){
		//Variable initialize
				
		String dni="", name="", surname="", mobile="", email="", user="", password="", avatar="", 
						 state=""; //age_chain="";
		class_date birthday=null;
		class_date date_cont=null;
				
		int age=0, antique=0, activity=0;
		
		float salary=0.0f,	incentive=0.0f;
		
		//boolean state=false;
		
		//User attribute
		dni="48288955h";
		name="David";
		surname="Ureña";
		mobile="653303947";
		email="daurgil@gamil.com";
		user="Pelu";
		password="1Asdf-asD";
		avatar="https://url.com";
		state="Conected";
		birthday= new class_date("21/06/1989", format_date);
		
		//admin attribute
		date_cont=new class_date("02/05/2010", format_date);
		activity=Integer.parseInt("2000");
		
		new admin_class(dni, name, surname, mobile, email, user, password, avatar, state, birthday,
				 date_cont, activity);
		
		return new admin_class(dni, name, surname, mobile, email, user, password, avatar, state, birthday,
				 date_cont, activity);
	}
	
	/**
	 * Dummy created to prove the framework
	 * @param format_date format of the date in this case not work but is necessary
	 * @param language format of the date in this case not work but is necessary
	 * @return object client created with specific parameters
	 */
	/*public static client_class create_cli_dummy(String format_date, String language){
		
		String dni="", name="", surname="", mobile="", email="", user="", password="", avatar="", 
			 type="", state="";
		class_date birthday=null;
		class_date up_date=null;
		
		int age=0, antique=0, discount=0;
		
		float shopping=0.0f;
		
		boolean premium=false;
		
		
		//User attribute
		dni="48288955h";
		name="David";
		surname="Ureña";
		mobile="653303947";
		email="daurgil@gamil.com";
		user="Pelu";
		password="1Asdf-asD";
		avatar="https://url.com";
		state="Conected";
		birthday= new class_date("21/06/1989", format_date);
		
		
		//Client attribute
		up_date=new class_date("02/06/2009", format_date);
		shopping=Float.parseFloat("1000");
		premium=false;
		type="Normal";
		
		new client_class(dni, name, surname, mobile, email, user, password, avatar, state, birthday,
				up_date, shopping, discount, premium, type);
		
		return new client_class(dni, name, surname, mobile, email, user, password, avatar, state, birthday,
				up_date, shopping, discount, premium, type);
	}
	
	/**
	 * Dummy created to prove the framework
	 * @param format_date format of the date in this case not work but is necessary
	 * @param language format of the date in this case not work but is necessary
	 * @return object reg_user created with specific parameters
	 */
	/*public static reg_user_class create_reg_dummy(String format_date, String language){
		String dni="", name="", surname="", mobile="", email="", user="", password="", avatar="", 
				karma="", state="";
		class_date birthday=null;
		
		int age=0, activity=0, points=0;
		
		
		
		//User attribute
		dni="48288955h";
		name="David";
		surname="Ureña";
		mobile="653303947";
		email="daurgil@gamil.com";
		user="Pelu";
		password="1Asdf-asD";
		avatar="https://url.com";
		state="Conected";
		birthday= new class_date("21/06/1989", format_date);
		
		//reg_user attribute
		activity=Integer.parseInt("2000");
		
		
		new reg_user_class(dni, name, surname, mobile, email, user, password, avatar, state, birthday,
				activity, karma, points);
		
		return new reg_user_class(dni, name, surname, mobile, email, user, password, avatar, state, birthday,
				activity, karma, points);
	}*/
	
	
	
}
