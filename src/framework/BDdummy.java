/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;


import framework.classes.class_date;
import framework.classes.connectionDB;
import framework.modules.users.admin.Model.classes.admin_class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pelu
 */
public class BDdummy {
    
    public static void cargarBD() throws SQLException{
        
        Connection con = null;
        connectionDB connection_DB = new connectionDB();
        PreparedStatement stmt = null;
        int resultado = 0;
        
        String dni= "48288956l";
        String name="Sandra";
        String surname="Ureña";
        String mobile="321654987";
        String email="san@gmail.com";
        String nick="China";
        String avatar="default";
        String password="2Zxcvbnm";
        String state="Conected";
        class_date date_b=new class_date("21/06/1989");
        int age= 26;
        class_date date_c= new class_date("10/10/2010");
        int antique=5;
        int activity=2000;
        float salary=1120f;
        float benefit=120f;
        
        con= connection_DB.openConection();
        
        admin_class admin= new admin_class(dni, name, surname, mobile, email, nick, password, 
                avatar, state, date_b, date_c, activity);
        
        stmt= con.prepareStatement("INSERT INTO app.admin"
            +"(dni,name,surname,mobile,email,nick,avatar,password,state,date_birthday,age,date_contract,antique,"
                + "activity,salary,benefit)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        stmt.setString(1, admin.getDni());
        stmt.setString(2, admin.getName());
        stmt.setString(3, admin.getSurname());
        stmt.setString(4, admin.getMobile());
        stmt.setString(5, admin.getEmail());
        stmt.setString(6, admin.getNick());
        stmt.setString(7, admin.getAvatar());
        stmt.setString(8, admin.getPassword());
        stmt.setString(9, admin.getState());
        stmt.setString(10, admin.getBirthday().toString());
        stmt.setInt(11, admin.getAge());
        stmt.setString(12, admin.getDate_cont().toString());
        stmt.setInt(13, admin.getAntique());
        stmt.setInt(14, admin.getActivity());
        stmt.setFloat(15, admin.getSalary());
        stmt.setFloat(16, admin.getBenefit());
        
        int correcte=stmt.executeUpdate();
        System.out.println(correcte);
        
        connection_DB.closeConnection(con);
    }
}
