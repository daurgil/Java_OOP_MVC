/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.client.Model.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import framework.modules.Menu_config.View.log_in;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.client.Model.classes.singleton_client;
import framework.utils.singleton;

/**
 *
 * @author pelu
 */
public class DAO_client_MG {
    
     /**
     * Insert a client in the DB
     * @param table
     * @param w 
     */
    public static void insert_client(client_class client) {
        DBCollection table= singleton.collection;
        table.insert(client.client_to_DB());
    }
    
    /**
     * To load the users by DB
     * @param db
     * @param table 
     */
    public static void load_clients() {
        
        DBCollection table= singleton.collection;
        DBCursor cursor = null;
        client_class client = new client_class();
        try {
            cursor = table.find();
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    singleton_client.client.add(client.DB_to_client(document));
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}	
    }

    /**
     * Funtion to modify a client and update in DB
     * @param db
     * @param table
     * @param nombre
     * @param nuevosAnyos 
     */
    public static void update_client(client_class client) {
        DBCollection table=singleton.collection;
        
        BasicDBObject data=new BasicDBObject();
        data.append("dni", client.getDni());
        data.append("Name", client.getName());
        data.append("surname", client.getSurname());
        data.append("mobile", client.getMobile());
        data.append("email", client.getEmail());
        data.append("nick", client.getNick());
        data.append("password", client.getPassword());
        data.append("avatar", client.getAvatar());
        data.append("state", client.getNick());
        data.append("birthday", client.getBirthday().toString_DB());
        data.append("age", client.getAge());
        data.append("up_date", client.getUp_date().toString_DB());
        data.append("antique", client.getAntique());
        data.append("shopping", client.getShopping());
        data.append("benefit", client.getBenefit());
        data.append("premium", client.isPremium());
        data.append("type", client.getType());
        
        //Prepara para insertar un nuevo campo
        BasicDBObject updateclient = new BasicDBObject();
        updateclient.append("$set", data);
 
        //Busca el/los registro/s con el nombre indicado
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", client.getDni());
 
        //Realiza la actualización
        table.updateMulti(searchById, updateclient);
    }
    
    public static boolean search_client(){
       
        DBCollection table= singleton.collection;
        DBCursor cursor = null;
        client_class client = new client_class();
        boolean correct=false;
        try {
            
            BasicDBObject searchById = new BasicDBObject();
            searchById.put("dni", log_in.jt_dni.getText());
            //singleton_client.c=new client_class(log_in.jt_dni.getText());
            
            cursor=table.find(searchById);
            if(cursor.count()!=0){
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    singleton_client.c= client.DB_to_client(document);
                    //System.out.println(singleton_client.c);
                    correct=true;
                    //singleton_client.c.add(client.DB_to_client(document));
                }
            }else{
                System.out.println("NOT DATA"); 
                correct=false;
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}	
       return correct;
        
    }
    
    /**
     * Function to delete client in db
     * @param db
     * @param table
     * @param nombre 
     */
    public static void delete_client(client_class client) {
        DBCollection table= singleton.collection;
        table.remove(new BasicDBObject().append("dni", client.getDni()));
    }
}
