/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.Menu_config.Controler;

import framework.modules.Menu_config.Model.classes.class_config;
import framework.modules.Menu_config.Model.classes.singleton_config;
import framework.modules.Menu_config.Model.files_config.BLL.BLL_config;
import framework.modules.Menu_config.Model.files_config.BLL.BLL_log_in;
import framework.modules.Menu_config.View.Config;
import framework.modules.Menu_config.View.log_in;
import framework.modules.Menu_config.View.menu;
import framework.modules.users.admin.Controler.admin_controler;
import framework.modules.users.admin.View.admin_table;
import framework.modules.users.client.Controler.client_controler;
import framework.modules.users.client.View.client_table;
import framework.modules.users.client.View.client_update;
import framework.modules.users.reg_user.Controler.reg_controler;
import framework.modules.users.reg_user.View.reg_table;
import framework.modules.users.reg_user.View.reg_update;
import framework.utils.singleton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author pelu
 */
public class controler_menu implements ActionListener, MouseListener, KeyListener{
    
    public static menu menu;
    public static Config config;
    public static log_in login;
    
    public controler_menu(JFrame frame, int i){
        
        if(i==0){
            menu= (menu) frame;
        }
        if(i==1){
           config= (Config) frame; 
        }
        if(i==2){
            login= (log_in) frame;
        }
    }

    
    public enum Action{
        
        /////Buttons Menu/////
        
        jb_admin,
        jb_client,
        jb_reg_user,
        jl_config,
        
        //////Buttons config/////
        
        jb_save,
        jb_back,
        
        //////Buttons log in/////
        
        log_in,
        exit,
        jt_dni,
        jt_password,
        jcb_password,
        jl_eng,
        jl_esp,
        jl_val,
        
    }
    
    /**
     * Funtion with the differents especifications of every view
     * @param i type of view
     */
    public void Init(int i){
       
        //class_config.getinstance().getTheme();
        
        if(i==0){
            
            menu.setTitle(singleton_config.lang.getProperty("t_menu"));
            menu.jb_admin.setText(singleton_config.lang.getProperty("bt_admin"));
            menu.jb_client.setText(singleton_config.lang.getProperty("bt_client"));
            menu.jb_reg_user.setText(singleton_config.lang.getProperty("bt_reg"));
            
            menu.setVisible(true);

            //menu.setContentPane(new JLabel(new ImageIcon(singleton.fondo_menu)));
            //menu.setLayout(new FlowLayout());

            
            //Image bacground=singleton.fondo_menu.getImage();
            Image icono=Toolkit.getDefaultToolkit().getImage(singleton.icon_app);
            menu.setIconImage(icono);
            menu.setLocationRelativeTo(null);
            //menu.setSize(680,450);//ancho x alto
            menu.setResizable(false);

            
            //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

            menu.jb_admin.setActionCommand("jb_admin");
            menu.jb_admin.setName("jb_admin");
            menu.jb_admin.addActionListener(this);
            menu.jb_admin.addMouseListener(this);

            menu.jb_client.setActionCommand("jb_client");
            menu.jb_client.setName("jb_client");
            menu.jb_client.addActionListener(this);
            menu.jb_client.addMouseListener(this);

            menu.jb_reg_user.setActionCommand("jb_reg_user");
            menu.jb_reg_user.setName("jb_reg_user");
            menu.jb_reg_user.addActionListener(this);
            menu.jb_reg_user.addMouseListener(this);

            menu.jl_config.setName("jl_config");
            menu.jl_config.addMouseListener(this);

            menu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    menu.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null,"Saliendo de la aplicación");
                    menu.dispose();
                    System.exit(0);
                }
            });
        }
        
        if(i==1){
            
            config.setTitle(singleton_config.lang.getProperty("t_config"));
            config.jb_back.setText(singleton_config.lang.getProperty("c_back"));
            config.jb_save.setText(singleton_config.lang.getProperty("c_save"));
            //config.jt_options.sett(singleton_config.lang.getProperty("c_back"));
            config.jrb_decimals1.setText(singleton_config.lang.getProperty("cf_1dec"));
            config.jrb_decimals2.setText(singleton_config.lang.getProperty("cf_2dec"));
            config.jrb_decimals3.setText(singleton_config.lang.getProperty("cf_3dec"));
            config.jrb_eng.setText(singleton_config.lang.getProperty("cf_eng"));
            config.jrb_esp.setText(singleton_config.lang.getProperty("cf_esp"));
            config.jrb_val.setText(singleton_config.lang.getProperty("cf_val"));
            
            config.setVisible(true);
            
            //config.setTitle("APP");
            Image icono=Toolkit.getDefaultToolkit().getImage(singleton.icon_app);
            config.setIconImage(icono);
            config.setLocationRelativeTo(null);
            //config.setSize(400, 350);//ancho x alto
            config.setResizable(false);
            
            config.jb_save.setActionCommand("jb_save");
            config.jb_save.addActionListener(this);
                    
            config.jb_back.setActionCommand("jb_back");
            config.jb_back.addActionListener(this);
            
            config.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    config.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null,"Saliendo de la aplicación");
                    config.dispose();
                    System.exit(0);
                }
            });
        }     
        
        if(i==2){
            
            login.jl_title.setText(singleton_config.lang.getProperty("log_title"));
            login.jl_dni.setText(singleton_config.lang.getProperty("log_dni"));
            login.jl_password.setText(singleton_config.lang.getProperty("log_password"));
            login.jcb_password.setText(singleton_config.lang.getProperty("log_see_pass"));
            login.jb_login.setText(singleton_config.lang.getProperty("log_login"));
            login.jb_exit.setText(singleton_config.lang.getProperty("log_exit"));
            
            Image icono=Toolkit.getDefaultToolkit().getImage(singleton.icon_app);
            login.setIconImage(icono);
            login.setLocationRelativeTo(null);
            //login.setSize(680,450);//ancho x alto
            login.setResizable(false);
            
            login.setVisible(true);
            
            login.jb_login.setActionCommand("log_in");
            login.jb_login.addActionListener(this);
            
            login.jb_exit.setActionCommand("exit");
            login.jb_exit.addActionListener(this);
            
            login.jt_dni.setName("jt_dni");
            login.jt_dni.addKeyListener(this);
            
            login.jt_password.setName("jt_password");
            login.jt_password.addKeyListener(this);
            
            login.jcb_password.setName("jcb_password");
            login.jcb_password.addMouseListener(this);
            
            login.jl_eng.setName("jl_eng");
            login.jl_eng.addMouseListener(this);
            
            login.jl_esp.setName("jl_esp");
            login.jl_esp.addMouseListener(this);
            
            login.jl_val.setName("jl_val");
            login.jl_val.addMouseListener(this);
            
            login.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    login.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null,"Saliendo de la aplicación");
                    login.dispose();
                    System.exit(0);
                }
            });
        }
    }       
    
    
    public void actionPerformed(ActionEvent ae){
        
        switch(Action.valueOf(ae.getActionCommand())){
            
            case jb_admin:
                new admin_controler(new admin_table(),0).Init(0);
                menu.dispose();
                break;
            case jb_client:                
                new client_controler(new client_table(),0).Init(0);
                menu.dispose();
                break;
            case jb_reg_user:                
                new reg_controler(new reg_table(), 0).Init(0);
                menu.dispose();
                break;
            case jb_save:
                BLL_config.save_config();
                Timer delay=new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new controler_menu(new menu(), 0).Init(0);
                            config.dispose();
                        }
                    });

                    delay.setRepeats(false);
                    delay.start();
                break;
            case jb_back:
                new controler_menu(new menu(),0).Init(0);
                config.dispose();
                break;
            case log_in:
                BLL_log_in.search_in_DB();
                if(singleton.type_login==null){
                    break;
                }else{
                    switch(singleton.type_login){
                        case "admin":
                            new controler_menu(new menu(), 0).Init(0);
                            login.dispose();
                            break;
                        case "client":
                            client_update.DNI=login.jt_dni.getText();
                            new client_controler(new client_update(), 2).Init(2);
                            login.dispose();
                            break;
                        case "reg":
                            reg_update.DNI=login.jt_dni.getText();
                            new reg_controler(new reg_update(), 2).Init(2);
                            login.dispose();
                            break;
                    }
                }
                break;
            case exit:
                JOptionPane.showMessageDialog(null,"Saliendo de la aplicación");
                login.dispose();
                System.exit(0);
                break;
        }
    }
    
    public void mouseClicked(MouseEvent mc){
        
        switch(Action.valueOf(mc.getComponent().getName())){
            
            case jl_config:
                
                new controler_menu(new Config(), 1).Init(1);
                BLL_config.open_config();
                menu.dispose();
                break;
            case jcb_password:
                BLL_log_in.password_show();
                break;
            case jl_eng:
                class_config.getinstance().setLanguage("eng");
                singleton_config.lang.setLanguage();
                BLL_log_in.translate();
                break;
            case jl_esp:
                class_config.getinstance().setLanguage("esp");
                singleton_config.lang.setLanguage();
                BLL_log_in.translate();
                break;
            case jl_val:
                class_config.getinstance().setLanguage("val");
                singleton_config.lang.setLanguage();
                BLL_log_in.translate();
                break;
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent men) {
        
        switch(Action.valueOf(men.getComponent().getName())){
            
            case jb_admin:
                
                menu.jb_admin.setIcon(singleton.icon_u_admin);
                break;
            case jb_client:
                
                menu.jb_client.setIcon(singleton.icon_u_client);
                break;
            case jb_reg_user:
                
                menu.jb_reg_user.setIcon(singleton.icon_u_reg);
                break;
            case jl_config:
                
                menu.jl_config.setIcon(singleton.setting2);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent mex) {
        
        switch(Action.valueOf(mex.getComponent().getName())){
            
            case jb_admin:
                menu.jb_admin.setIcon(singleton.icon_user);
                break;
            case jb_client:                
                menu.jb_client.setIcon(singleton.icon_user);
                break;
            case jb_reg_user:                
                menu.jb_reg_user.setIcon(singleton.icon_user);
                break;
            case jl_config:                
                menu.jl_config.setIcon(singleton.setting);
                break;
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(Action.valueOf(e.getComponent().getName())){
            case jt_dni:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_log_in.give_data("dni");
                  }
                break;
            case jt_password:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_log_in.give_data("password");
                  }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(Action.valueOf(e.getComponent().getName())){
            case jt_dni:
                BLL_log_in.give_data("dni");
                break;
            case jt_password:
                BLL_log_in.give_data("password");
                break;
        }
    }
}
