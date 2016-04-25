/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.admin.Model.DAO;

import framework.classes.class_date;
import framework.modules.Menu_config.Model.classes.singleton_config;
import framework.modules.users.admin.Model.classes.admin_class;
import framework.modules.users.admin.Model.classes.singleton_admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;





/**
 *
 * @author pelu
 */
public class DAO_DB_admin {
    
    /**
     * Function to add a new user in the DB
     * @param con
     * @return correct, to know if it does well
     */
    public static int create_admin(Connection con) {
       
        PreparedStatement stmt = null;
        int correct = 0;
        
        try {
           
          stmt= con.prepareStatement("INSERT INTO app.admin"
            +"(dni,name,surname,mobile,email,nick,avatar,password,state,date_birthday,age,date_contract,antique,"
                + "activity,salary,benefit)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           
            stmt.setString(1, singleton_admin.a.getDni());
            stmt.setString(2, singleton_admin.a.getName());
            stmt.setString(3, singleton_admin.a.getSurname());
            stmt.setString(4, singleton_admin.a.getMobile());
            stmt.setString(5, singleton_admin.a.getEmail());
            stmt.setString(6, singleton_admin.a.getNick());
            stmt.setString(7, singleton_admin.a.getAvatar());
            stmt.setString(8, singleton_admin.a.getPassword());
            stmt.setString(9, singleton_admin.a.getState());
            stmt.setString(10, singleton_admin.a.getBirthday().toString_DB());
            stmt.setInt(11, singleton_admin.a.getAge());
            stmt.setString(12, singleton_admin.a.getDate_cont().toString_DB());
            stmt.setInt(13, singleton_admin.a.getAntique());
            stmt.setInt(14, singleton_admin.a.getActivity());
            stmt.setFloat(15, singleton_admin.a.getSalary());
            stmt.setFloat(16, singleton_admin.a.getBenefit());

            correct = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_dao_cre"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_dao_cre2"));
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_error"));
                }
            }
        }
        return correct;
    }
    
    /**
     * Function to load the users on the table 
     * @param con 
     */
    public static void show_admin(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
       
        singleton_admin.admin.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM app.admin");
            rs = stmt.executeQuery();

            admin_class admin = null;
            
            while (rs.next()) {
                
                admin = new admin_class();
                admin.setDni(rs.getString("dni"));
                admin.setName(rs.getString("name"));
                admin.setSurname(rs.getString("surname"));
                admin.setMobile(rs.getString("mobile"));
                admin.setEmail(rs.getString("email"));
                admin.setNick(rs.getString("nick"));
                admin.setAvatar(rs.getString("avatar"));
                admin.setPassword(rs.getString("password"));
                admin.setState(rs.getString("state"));
                admin.setBirthday(new class_date(rs.getString("date_birthday")));
                admin.setAge(rs.getInt("age"));
                admin.setDate_cont(new class_date(rs.getString("date_contract")));
                admin.setAntique(rs.getInt("antique"));
                admin.setActivity(rs.getInt("activity"));
                admin.setSalary(rs.getFloat("salary"));
                admin.setBenefit(rs.getFloat("benefit"));
                singleton_admin.admin.add(admin);
                

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_dao_show"));
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_error"));
                }
            }
        }
    }
    
    /**
     * Function to save a modified user
     * @param con 
     */
    public static void modify_admin(Connection con) {
        PreparedStatement stmt = null;
       
        try {
            stmt = con.prepareStatement("UPDATE app.admin SET dni=?,name=?, "
                    + "surname=?, mobile=?, email=?, nick=?, avatar=?, password=?, state=?, date_birthday=?,"
                    + "age=?, date_contract=?, antique=?, activity=?, salary=?, "
                    + "benefit=? WHERE dni=?");

            stmt.setString(1, singleton_admin.a.getDni());
            stmt.setString(2, singleton_admin.a.getName());
            stmt.setString(3, singleton_admin.a.getSurname());
            stmt.setString(4, singleton_admin.a.getMobile());
            stmt.setString(5, singleton_admin.a.getEmail());
            stmt.setString(6, singleton_admin.a.getNick());
            stmt.setString(7, singleton_admin.a.getAvatar());
            stmt.setString(8, singleton_admin.a.getPassword());
            stmt.setString(9, singleton_admin.a.getState());
            stmt.setString(10, singleton_admin.a.getBirthday().toString());
            stmt.setInt(11, singleton_admin.a.getAge());
            stmt.setString(12, singleton_admin.a.getDate_cont().toString());
            stmt.setInt(13, singleton_admin.a.getAntique());
            stmt.setInt(14, singleton_admin.a.getActivity());
            stmt.setFloat(15, singleton_admin.a.getSalary());
            stmt.setFloat(16, singleton_admin.a.getBenefit());
            
            stmt.setString(17, singleton_admin.a.getDni());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_dao_mod"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_dao_mod2"));
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_error"));
                }
            }
        }

    }
    
    /**
     * Function to delete a user to DB
     * @param con
     * @return correct, to know if it does well
     */
    public static boolean delete_admin(Connection con) {

        PreparedStatement stmt = null;
        boolean correct = false;

        try {
            stmt = con.prepareStatement("DELETE FROM app.admin WHERE dni=?");
            stmt.setString(1, singleton_admin.a.getDni());
            stmt.executeUpdate();
            correct = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_dao_del"));
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_error"));
                }
            }
        }
        return correct;
    }
    
    /**
     * Funtion to search a user in DB for dni
     * @param con
     * @return correct, to know if it does well
     */
    public boolean search_admin(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean correct = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM app.admin WHERE dni=?");
            stmt.setString(1, singleton_admin.a.getDni());
            rs = stmt.executeQuery();
            while (rs.next()) {

                take_admin(rs);
            }
            correct = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_"));
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_error"));
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_error"));
                }
            }
        }
        return correct;
    }
    
    /**
     * Function to load a user by DB
     * @param rs 
     */
    private void take_admin(ResultSet rs) {

        try {

            singleton_admin.a.setDni(rs.getString("dni"));
            singleton_admin.a.setName(rs.getString("name"));
            singleton_admin.a.setSurname(rs.getString("surname"));
            singleton_admin.a.setMobile(rs.getString("mobile"));
            singleton_admin.a.setEmail(rs.getString("email"));
            singleton_admin.a.setNick(rs.getString("nick"));
            singleton_admin.a.setAvatar(rs.getString("avatar"));
            singleton_admin.a.setPassword(rs.getString("password"));
            singleton_admin.a.setState(rs.getString("state"));
            singleton_admin.a.setBirthday(new class_date(rs.getString("date_birthday")));
            singleton_admin.a.setAge(rs.getInt("age"));
            singleton_admin.a.setDate_cont(new class_date(rs.getString("date_contract")));
            singleton_admin.a.setAntique(rs.getInt("antique"));
            singleton_admin.a.setActivity(rs.getInt("activity"));
            singleton_admin.a.setSalary(rs.getFloat("salary"));
            singleton_admin.a.setBenefit(rs.getFloat("benefit"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, singleton_config.lang.getProperty("db_error"));
        }
    }
}
