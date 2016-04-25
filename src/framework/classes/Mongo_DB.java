/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.classes;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import static framework.utils.singleton.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author pelu
 */
public class Mongo_DB {

    private static InputStream input = null;
    private static String machine = null;
    private static String port = null;
    private static DB db = null;
    private static String nom_bd = null;
    private static DBCollection collection = null;
    private static String nom_table = null;
    private static Properties prop = new Properties();
   
    public Mongo_DB() {
        try {
            input = new FileInputStream("src/framework/classes/mongo.properties"); 
            try {
                prop.load(input);
            } catch (Exception e) {
                System.out.println("Unable to open mongo.properties");
                e.printStackTrace();
            }
            machine = prop.getProperty("machine");
            port = prop.getProperty("port");
            nom_bd = prop.getProperty("db");
            nom_table = prop.getProperty("collection");      
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open mongo.properties");
            e.printStackTrace();
        }finally {
            if (input != null) {
		try {
                    input.close();
		} catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to close mongo.properties"); 
		}
            }
	}
    }
    
    public static Mongo connect() {
        try {
            client = new Mongo(getMachine(), Integer.parseInt(getPort()));
            db = client.getDB(getNom_bd());
            collection = db.getCollection(getNom_table());
        } catch (Exception e) {
            System.out.println("Unable to open client");
            e.printStackTrace();
            if (client != null) {
		try {
                    client.close();
		} catch (Exception ex) {
                    System.out.println("Unable to close client");
                    ex.printStackTrace();
		}
            }
	}
        return client;
    }
    
    public static void disconnect() {
	client.close();
    }
    
    public static void setProp(Properties prop) {
        Mongo_DB.prop = prop;
    }

    public static void setInput(InputStream input) {
        Mongo_DB.input = input;
    }

    public static void setMachine(String machine) {
        Mongo_DB.machine = machine;
    }

    public static void setPort(String port) {
        Mongo_DB.port = port;
    }

    public static void setDb(DB db) {
        Mongo_DB.db = db;
    }

    public static void setNom_bd(String nom_bd) {
        Mongo_DB.nom_bd = nom_bd;
    }

    public static void setCollection(DBCollection collection) {
        Mongo_DB.collection = collection;
    }

    public static void setNom_table(String nom_table) {
        Mongo_DB.nom_table = nom_table;
    }

    public static Properties getProp() {
        return prop;
    }

    public static InputStream getInput() {
        return input;
    }

    public static String getMachine() {
        return machine;
    }

    public static String getPort() {
        return port;
    }

    public static DB getDb() {
        return db;
    }

    public static String getNom_bd() {
        return nom_bd;
    }

    public static DBCollection getCollection() {
        return collection;
    }

    public static String getNom_table() {
        return nom_table;
    }
}
