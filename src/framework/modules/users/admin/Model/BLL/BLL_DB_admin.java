/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.admin.Model.BLL;

import framework.classes.connectionDB;
import framework.modules.users.admin.Model.DAO.DAO_DB_admin;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class BLL_DB_admin {
    
    /**
     * Funtion BLL to add a new user
     * @return correct, to know if it does well
     */
    public static int create_adminBLL() {

        int correct;
        Connection con = null;

        con = connectionDB.gettingConnection();

        correct = DAO_DB_admin.create_admin(con);

        connectionDB.leaveConnection(con);

        return correct;
    }
    
    /**
     * Function BLL to load the users on the table 
     */
    public static void show_adminBLL() {

        Connection con = null;

        con = connectionDB.gettingConnection();
        
        try {
            DAO_DB_admin.show_admin(con);//Recuperamos los empleados 
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2!");
        }
        connectionDB.leaveConnection(con);

    }

    /**
     * Function BLL to save a modified user
     */
    public static void modify_adminBLL() {

        Connection con;

        con = connectionDB.gettingConnection();

        DAO_DB_admin.modify_admin(con);
        connectionDB.leaveConnection(con);

    }

    /**
     * Function BLL to delete a user to DB
     * @return correct, to know if it does well
     */
    public static boolean delete_adminBLL() {

        Connection con;
        boolean correct;

        con = connectionDB.gettingConnection();

        correct = DAO_DB_admin.delete_admin(con);
        connectionDB.leaveConnection(con);

        return correct;
    }

    /**
     * Function BLL to search a user in DB for dni
     * @return correct, to know if it does well
     */
    public static boolean search_adminBLL() {

        Connection con;
        boolean correct;
        
        con = connectionDB.gettingConnection();
        DAO_DB_admin DAO_user = new DAO_DB_admin();

        correct = DAO_user.search_admin(con);
        connectionDB.leaveConnection(con);

        return correct;
    }
}
