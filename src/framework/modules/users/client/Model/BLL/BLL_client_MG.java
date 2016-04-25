/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.client.Model.BLL;

import framework.modules.users.client.Model.DAO.DAO_client_MG;
import framework.modules.users.client.Model.classes.client_class;

/**
 *
 * @author pelu
 */
public class BLL_client_MG {
    
    /**
     * Insert a client in the DB
     * @param client 
     */
    public static void insert_client(client_class client){
        DAO_client_MG.insert_client(client);
    }
    
    /**
     * To load the users by DB
     */
    public static void load_client(){
        DAO_client_MG.load_clients();
    }
    
    /**
     * Funtion to modify a client and update in DB
     * @param client 
     */
    public static void update_client(client_class client){
        DAO_client_MG.update_client(client);
    }
    
    /**
     * Function to delete client in db
     * @param client 
     */
    public static void delete_client(client_class client){
        DAO_client_MG.delete_client(client);
    }
}
