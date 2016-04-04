/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.Menu_config.Controler;

import framework.modules.Menu_config.Model.classes.class_config;
import framework.modules.Menu_config.Model.files_config.BLL.BLL_config;
import framework.modules.Menu_config.View.Config;
import framework.modules.Menu_config.View.menu;
import framework.modules.users.admin.Controler.admin_controler;
import framework.modules.users.admin.View.admin_table;
import framework.modules.users.client.Controler.client_controler;
import framework.modules.users.client.View.client_table;
import framework.modules.users.reg_user.Controler.reg_controler;
import framework.modules.users.reg_user.View.reg_table;
import framework.utils.appearance;
import framework.utils.singleton;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author pelu
 */
public class controler_menu implements ActionListener, MouseListener{
    
    public static menu menu;
    public static Config config;
    
    public controler_menu(JFrame frame, int i){
        
        if(i==0){
            menu= (menu) frame;
        }
        if(i==1){
           config= (Config) frame; 
        }
    }

    
    public enum Action{
        
        /////Botones Menu/////
        jb_admin,
        jb_client,
        jb_reg_user,
        jl_config,
        
        //////Botones config/////
        
        jb_save,
        jb_back,
    }
    
    
    public void Init(int i){
       
        //class_config.getinstance().getTheme();
        
        if(i==0){
            class_config.getinstance().getTheme();
            menu.setVisible(true);

    //        menu.setContentPane(new JLabel(new ImageIcon(singleton.fondo_menu)));
    //        menu.setLayout(new FlowLayout());

            menu.setTitle("APP");
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
            
            config.setVisible(true);
            
            config.setTitle("APP");
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
        }
    }
    
    public void mouseClicked(MouseEvent mc){
        
        switch(Action.valueOf(mc.getComponent().getName())){
            
            case jl_config:
                
                new controler_menu(new Config(), 1).Init(1);
                BLL_config.open_config();
                menu.dispose();
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

    
}
