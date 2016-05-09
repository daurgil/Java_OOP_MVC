/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.admin.Controler;

import framework.modules.Menu_config.Controler.controler_menu;
import framework.modules.Menu_config.Model.classes.class_config;
import framework.modules.Menu_config.Model.classes.singleton_config;
import framework.modules.Menu_config.View.menu;
import static framework.modules.users.admin.Controler.admin_controler.table;
import framework.modules.users.admin.Model.BLL.BLL_admin;
import framework.modules.users.admin.Model.classes.miniSimpleTableModel_admin;
import framework.modules.users.admin.Model.classes.singleton_admin;
import framework.modules.users.admin.Model.utils.autocomplete.AutocompleteJComboBox;
import framework.modules.users.admin.Model.utils.autocomplete.StringSearchable;
import framework.modules.users.admin.Model.utils.pagina;
import framework.modules.users.admin.View.admin_create;
import framework.modules.users.admin.View.admin_table;
import static framework.modules.users.admin.View.admin_table.TABLA;
import framework.modules.users.admin.View.admin_update;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author pelu
 */
public class admin_controler implements ActionListener, MouseListener, KeyListener, FocusListener{
    
    public static JTable tabla = null;
    public static int e = 0;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_admin());
    public static admin_table table;
    public static admin_update Update;
    public static admin_create Create;
    public static AutocompleteJComboBox combo_admin = null;
    
    /**
     * Funtion to iniciate de frame controler
     * @param frame
     * @param i 
     */
    public admin_controler(JFrame frame, int i){
        
        if(i==0){
            table= (admin_table) frame;
        }
        if(i==1){
            Create= (admin_create) frame;
        }
        if(i==2){
            Update= (admin_update) frame;
        }
        
    }
    
    
    public enum Action{
        
        /////Admin table/////
        
        //botons//
            t_jl_back,
            t_jl_create,
            t_jl_update,
            t_jl_delete,
            t_jl_json,
            t_jl_xml,
            t_jl_txt,
            t_jb_search,
            t_jb_cancel,
            t_jt_dni,
        //table//
            tableSocio,
            primero,
            ANTERIOR,
            SIGUIENTE,
            ultimo,
            ComboPager,
            Combofiltrar,
            
        /////Admin create/////
            
            c_jb_save,
            c_jb_clean,
            c_jl_back,
            c_jt_dni,
            c_jt_name,
            c_jt_surname,
            c_jt_mobile,
            c_jt_email,
            c_jt_nick,
            c_jt_password,
            c_chb_password,
            c_jb_avatar,
            c_jdc_birthday,
            c_jdc_contract,
            c_jt_activity,
        
        /////Admin update/////
            
            u_jb_save,
            u_jl_back,
            u_jt_name,
            u_jt_surname,
            u_jt_mobile,
            u_jt_email,
            u_jt_nick,
            u_jt_password,
            u_chb_password,
            u_jb_avatar,
            u_jdc_birthday,
            u_jdc_contract,
            u_jt_activity,
        
    }
    
    /**
     * options to charge part of the views an control them
     * @param op 
     */
    public void Init(int op){
        
        class_config.getinstance();
        
        if(op==0){
            
            table.setTitle(singleton_config.lang.getProperty("t_admin"));
            table.jl_back.setText(singleton_config.lang.getProperty("t_back"));
            table.jLabel5.setText(singleton_config.lang.getProperty("t_entries"));
            table.jLabel4.setText(singleton_config.lang.getProperty("t_filter"));
            
            table.setVisible(true);
            
            //table.setTitle("Administrator Menu");

            Image icono=Toolkit.getDefaultToolkit().getImage(singleton_admin.icon_admin);
            table.setIconImage(icono);
            table.setLocationRelativeTo(null);
            //table.setSize(700,500);//ancho x alto
            table.setResizable(false);
            //this.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

            table.TABLA.setModel( new miniSimpleTableModel_admin() );
            ((miniSimpleTableModel_admin)TABLA.getModel()).cargar();
            table.TABLA.setFillsViewportHeight(true);
            table.TABLA.setRowSorter(sorter);

            pagina.inicializa();
            pagina.initLinkBox();

            pagina.itemsPerPage=Integer.parseInt(table.jComboBox1.getSelectedItem().toString());
            pagina.currentPageIndex = 1;
            pagina.initLinkBox();

            table.jLabel3.setText(String.valueOf(singleton_admin.admin.size()));

            table.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    table.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //JOptionPane.showMessageDialog(null,"Saliendo de la aplicación");
                    new controler_menu(new menu(), 0).Init(0);
                    table.dispose();
                    
                }
            });

            List<String> myWords = new ArrayList<String>();
            for(int i=0;i<=singleton_admin.admin.size()-1;i++) {
                myWords.add(singleton_admin.admin.get(i).getName());
            }

            StringSearchable searchable = new StringSearchable(myWords);
            combo_admin = new AutocompleteJComboBox(searchable);
            //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
            table.jPanel3.setLayout(new java.awt.BorderLayout());
            table.jPanel3.add(combo_admin);

            combo_admin.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //comboActionPerformed(evt);
                }
            });

            table.jl_back.setName("t_jl_back");
            table.jl_back.addMouseListener(this);

            table.jl_json.setName("t_jl_json");
            table.jl_json.addMouseListener(this);

            table.jl_xml.setName("t_jl_xml");
            table.jl_xml.addMouseListener(this);

            table.jl_txt.setName("t_jl_txt");
            table.jl_txt.addMouseListener(this);

            table.jl_create.setName("t_jl_create");
            table.jl_create.addMouseListener(this);

            table.jl_modify.setName("t_jl_update");
            table.jl_modify.addMouseListener(this);

            table.jl_delete.setName("t_jl_delete");
            table.jl_delete.addMouseListener(this);

            table.primero.setActionCommand("primero");
            table.primero.addActionListener(this);

            table.ANTERIOR.setActionCommand("ANTERIOR");
            table.ANTERIOR.addActionListener(this);

            table.SIGUIENTE.setActionCommand("SIGUIENTE");
            table.SIGUIENTE.addActionListener(this);

            table.ultimo.setActionCommand("ultimo");
            table.ultimo.addActionListener(this);

            table.jComboBox1.setActionCommand("ComboPager");
            table.jComboBox1.addActionListener(this);

            combo_admin.setActionCommand("Combofiltrar");
            combo_admin.addActionListener(this);

            table.TABLA.setName("tableSocio");
            table.TABLA.addMouseListener(this);
            
            table.bt_search.setActionCommand("t_jb_search");
            table.bt_search.addActionListener(this);
            
            table.bt_cancel.setActionCommand("t_jb_cancel");
            table.bt_cancel.addActionListener(this);
            
            table.jt_dni.setName("t_jt_dni");
            table.jt_dni.addKeyListener(this);
        
        }
        
        if(op==1){
            
            Create.jl_back.setText(singleton_config.lang.getProperty("lb_back"));
            Create.jb_save.setText(singleton_config.lang.getProperty("bt_save"));
            Create.jb_clean.setText(singleton_config.lang.getProperty("bt_clean"));
            Create.jLabel1.setText(singleton_config.lang.getProperty("c_admin"));
            Create.lb_dni.setText(singleton_config.lang.getProperty("lb_dni"));
            Create.lb_name.setText(singleton_config.lang.getProperty("lb_name"));
            Create.lb_surname.setText(singleton_config.lang.getProperty("lb_surname"));
            Create.lb_mobile.setText(singleton_config.lang.getProperty("lb_mobile"));
            Create.lb_email.setText(singleton_config.lang.getProperty("lb_email"));
            Create.lb_nick.setText(singleton_config.lang.getProperty("lb_nick"));
            Create.lb_password.setText(singleton_config.lang.getProperty("lb_password"));
            Create.lb_avatar.setText(singleton_config.lang.getProperty("lb_avatar"));
            Create.lb_state.setText(singleton_config.lang.getProperty("lb_state"));
            Create.lb_birthday.setText(singleton_config.lang.getProperty("lb_birth"));
            Create.lb_contract.setText(singleton_config.lang.getProperty("lb_contract"));
            Create.lb_activity.setText(singleton_config.lang.getProperty("lb_activity"));
            
            
            Create.setVisible(true);
            
            Create.setTitle(singleton_config.lang.getProperty("t_admin"));
            Image icono=Toolkit.getDefaultToolkit().getImage(singleton_admin.icon_admin);
            Create.setIconImage(icono);
            Create.setLocationRelativeTo(null);
            //Create.setSize(550,400);//ancho x alto
            Create.setResizable(false);
            Create.jdc_birthday.getDateEditor().setEnabled(false);
            Create.jdc_contract.getDateEditor().setEnabled(false);

            //this.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

            Create.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    Create.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //JOptionPane.showMessageDialog(null,"Saliendo de la aplicación");
                    new admin_controler(new admin_table(), 0).Init(0);
                    Create.dispose();
                }
            });

            Create.jb_save.setActionCommand("c_jb_save");
            Create.jb_save.addActionListener(this);

            Create.jb_clean.setActionCommand("c_jb_clean");
            Create.jb_clean.addActionListener(this);

            Create.jl_back.setName("c_jl_back");
            Create.jl_back.addMouseListener(this);

            Create.jt_dni.setName("c_jt_dni");
            Create.jt_dni.addKeyListener(this);
            Create.jt_dni.addFocusListener(this);

            Create.jt_name.setName("c_jt_name");
            Create.jt_name.addKeyListener(this);
            Create.jt_name.addFocusListener(this);

            Create.jt_surname.setName("c_jt_surname");
            Create.jt_surname.addKeyListener(this);
            Create.jt_surname.addFocusListener(this);

            Create.jt_mobile.setName("c_jt_mobile");
            Create.jt_mobile.addKeyListener(this);
            Create.jt_mobile.addFocusListener(this);

            Create.jt_email.setName("c_jt_email");
            Create.jt_email.addKeyListener(this);
            Create.jt_email.addFocusListener(this);

            Create.jt_nick.setName("c_jt_nick");
            Create.jt_nick.addKeyListener(this);
            Create.jt_nick.addFocusListener(this);

            Create.jt_password.setName("c_jt_password");
            Create.jt_password.addKeyListener(this);
            Create.jt_password.addFocusListener(this);

            Create.chb_password.setActionCommand("c_chb_password");
            Create.chb_password.addActionListener(this);

            Create.jb_avatar.setActionCommand("c_jb_avatar");
            Create.jb_avatar.addActionListener(this);

            Create.jt_activity.setName("c_jt_activity");
            Create.jt_activity.addKeyListener(this);
            Create.jt_activity.addFocusListener(this);

            //**property change**// 

    //        Create.jdc_birthday.setActionMap(am);
    //        Create.jdc_birthday.addPropertyChangeListener(listener);

        
        }
        
        if(op==2){
            
            Update.jl_back.setText(singleton_config.lang.getProperty("lb_back"));
            Update.jb_save.setText(singleton_config.lang.getProperty("bt_save"));
            Update.jLabel1.setText(singleton_config.lang.getProperty("c_admin"));
            Update.lb_dni.setText(singleton_config.lang.getProperty("lb_dni"));
            Update.lb_name.setText(singleton_config.lang.getProperty("lb_name"));
            Update.lb_surname.setText(singleton_config.lang.getProperty("lb_surname"));
            Update.lb_mobile.setText(singleton_config.lang.getProperty("lb_mobile"));
            Update.lb_email.setText(singleton_config.lang.getProperty("lb_email"));
            Update.lb_nick.setText(singleton_config.lang.getProperty("lb_nick"));
            Update.lb_password.setText(singleton_config.lang.getProperty("lb_password"));
            Update.lb_avatar.setText(singleton_config.lang.getProperty("lb_avatar"));
            Update.lb_state.setText(singleton_config.lang.getProperty("lb_state"));
            Update.lb_birthday.setText(singleton_config.lang.getProperty("lb_birth"));
            Update.lb_contract.setText(singleton_config.lang.getProperty("lb_contract"));
            Update.lb_activity.setText(singleton_config.lang.getProperty("lb_activity"));
            
            Update.setVisible(true);
            
            BLL_admin.show_admin(Update.DNI);
        
            Update.setTitle("Modify admin");
            Image icono=Toolkit.getDefaultToolkit().getImage(singleton_admin.icon_admin);
            Update.setIconImage(icono);
            Update.setLocationRelativeTo(null);
            //Update.setSize(550,400);//ancho x alto
            Update.setResizable(false);
            //this.jsc_form.getVerticalScrollBar().setUnitIncrement(10);
            Update.jdc_birthday.getDateEditor().setEnabled(false);
            Update.jdc_contract.getDateEditor().setEnabled(false);
            //Image icono=Toolkit.getDefaultToolkit().getImage("p1.jpg");
            //this.setIconImage(icono);
            //this.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

            Update.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                    Update.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //JOptionPane.showMessageDialog(null,"Saliendo de la aplicación");
                    new admin_controler(new admin_table(), 0).Init(0);
                    Update.dispose();
                    
                }
            });
                    
            Update.jb_save.setActionCommand("u_jb_save");
            Update.jb_save.addActionListener(this);

            Update.jl_back.setName("u_jl_back");
            Update.jl_back.addMouseListener(this);

            Update.jt_name.setName("u_jt_name");
            Update.jt_name.addKeyListener(this);
            Update.jt_name.addFocusListener(this);

            Update.jt_surname.setName("u_jt_surname");
            Update.jt_surname.addKeyListener(this);
            Update.jt_surname.addFocusListener(this);

            Update.jt_mobile.setName("u_jt_mobile");
            Update.jt_mobile.addKeyListener(this);
            Update.jt_mobile.addFocusListener(this);

            Update.jt_email.setName("u_jt_email");
            Update.jt_email.addKeyListener(this);
            Update.jt_email.addFocusListener(this);

            Update.jt_nick.setName("u_jt_nick");
            Update.jt_nick.addKeyListener(this);
            Update.jt_nick.addFocusListener(this);

            Update.jt_password.setName("u_jt_password");
            Update.jt_password.addKeyListener(this);
            Update.jt_password.addFocusListener(this);

            Update.chb_password.setActionCommand("u_chb_password");
            Update.chb_password.addActionListener(this);

            Update.jb_avatar.setActionCommand("u_jb_avatar");
            Update.jb_avatar.addActionListener(this);

            Update.jt_activity.setName("u_jt_activity");
            Update.jt_activity.addKeyListener(this);
            Update.jt_activity.addFocusListener(this);
        }
        
    }
    
    /**
     * funtion to detect action changes in views
     * @param adm 
     */
    public void actionPerformed(ActionEvent adm) {
        
        switch(Action.valueOf(adm.getActionCommand())){
            
            case primero:
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;
            case ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;
            case SIGUIENTE:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                break;
            case ultimo:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                break;
            case ComboPager:
                pagina.itemsPerPage=Integer.parseInt(table.jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;
            case Combofiltrar:
                pagina.currentPageIndex = 1;
                ((miniSimpleTableModel_admin)table.TABLA.getModel()).filtrar();
                ((JComboBox)combo_admin).requestFocus();
                break;
            case t_jb_search:
                if(BLL_admin.give_data("dni_search")==true){
                    if(BLL_admin.search_admin_t()==-1){
                        JOptionPane.showMessageDialog(null, "Error");
                    }else{
                        admin_update.DNI=table.jt_dni.getText();
                        new admin_controler(new admin_update(), 2).Init(2);

                        table.ask_dni.dispose();
                        table.dispose();
                    }
                }
                break;
            case t_jb_cancel:
                table.ask_dni.dispose();
                break;
            case c_jb_save:
                BLL_admin.create();
                if(BLL_admin.ok==true){
                    
                    Timer delay=new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Create.dispose();
                            new admin_controler(new admin_table(), 0).Init(0);
                        }
                    });

                    delay.setRepeats(false);
                    delay.start();
                    Create.jt_alert.setText(singleton_config.lang.getProperty("create_ok"));

                    break;
                }else{
                    Create.jt_alert.setText(singleton_config.lang.getProperty("dni_error"));
                    break;
                }
            case c_jb_clean:
                BLL_admin.clean();
                break;
            case c_chb_password:
                if(Create.chb_password.isSelected()==false){
                    Create.jt_password.setEchoChar('*'); 
                 }
                 Create.jt_password.requestFocus();
                 break;
            case c_jb_avatar:
                int select;
        
                select=Create.jfc_avatar.showOpenDialog(Create);
                if(select==Create.jfc_avatar.APPROVE_OPTION){
                    Create.jt_avatar.setText(Create.jfc_avatar.getSelectedFile().toString());
                    break;
                }else{

                }
                break;
            case u_jb_save:
                BLL_admin.modify();
                if(BLL_admin.ok==true){
                    
                    Timer delay=new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Update.dispose();
                            new admin_controler(new admin_table(), 0).Init(0);
                        }
                    });

                    delay.setRepeats(false);
                    delay.start();
                    Update.jt_alert.setText(singleton_config.lang.getProperty("create_ok"));
                    break;
                }else{
                    Update.jt_alert.setText(singleton_config.lang.getProperty("error_save"));
                    break;
                }
            case u_chb_password:
                if(Update.chb_password.isSelected()==false){
                    Update.jt_password.setEchoChar('*'); 
                 }
                 Update.jt_password.requestFocus();
                 break;
            case u_jb_avatar:
                int select2;
        
                select2=Update.jfc_avatar.showOpenDialog(Update);
                if(select2==Update.jfc_avatar.APPROVE_OPTION){
                    Update.jt_avatar.setText(Update.jfc_avatar.getSelectedFile().toString());
                    break;
                }else{

                }
                break;
        }
    }
    
    /**
     * funtion to detect mouse changes in views
     * @param adm 
     */
    @Override
    public void mouseClicked(MouseEvent adm) {
        
        switch(Action.valueOf(adm.getComponent().getName())){
            case t_jl_back:
                new controler_menu(new menu(),0).Init(0);
                table.dispose();
                break;
            case t_jl_create:
                new admin_controler(new admin_create(), 1).Init(1);
                table.dispose();
                break;
            case t_jl_update:
                table.ask_dni.setSize(400,150);
                table.ask_dni.setLocation(100, 100);
                table.ask_dni.setVisible(true);
                break;
            case t_jl_delete:
                BLL_admin.delete_line();
                break;
            case t_jl_json:
                BLL_admin.save_json();
                break;
            case t_jl_xml:
                BLL_admin.save_xml();
                break;
            case t_jl_txt:
                BLL_admin.save_txt();
                break;
            case c_jl_back:
                new admin_controler(new admin_table(), 0).Init(0);
                Create.dispose();
                break;
            case u_jl_back:
                new admin_controler(new admin_table(), 0).Init(0);
                Update.dispose();
                break;
            case tableSocio:
                if (adm.getClickCount() == 2) {
                    boolean modificar;

                    modificar = BLL_admin.modifiy_line();
                    if (modificar == false) {
                        break;
                    } else {
                        table.dispose();
                        break;
                    }

                }
                break;
                            
        }
    }
    
    /**
     * funtion to detect mouse changes in views
     * @param adm 
     */
    @Override
    public void mouseEntered(MouseEvent adm) {
        
        switch(Action.valueOf(adm.getComponent().getName())){
            case t_jl_back:
                table.jl_back.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
                break;
            case t_jl_json:
                table.jl_json.setBorder(BorderFactory.createLineBorder(Color.black));
                break;
            case t_jl_xml:
                table.jl_xml.setBorder(BorderFactory.createLineBorder(Color.black));
                break;
            case t_jl_txt:
                table.jl_txt.setBorder(BorderFactory.createLineBorder(Color.black));
                break;
            case c_jl_back:
                Create.jl_back.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
                break;
            case u_jl_back:
                Update.jl_back.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
                break;
        }
    }

    /**
     * funtion to detect mouse changes in views
     * @param adm 
     */
    @Override
    public void mouseExited(MouseEvent adm) {
        
        switch(Action.valueOf(adm.getComponent().getName())){
            case t_jl_back:
                table.jl_back.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
                break;
            case t_jl_json:
                table.jl_json.setBorder(null);
                break;
            case t_jl_xml:
                table.jl_xml.setBorder(null);
                break;
            case t_jl_txt:
                table.jl_txt.setBorder(null);
                break;
            case c_jl_back:
                Create.jl_back.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
                break;
            case u_jl_back:
                Update.jl_back.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
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

    /**
     * funtion to detect key actions in views
     * @param adm 
     */
    @Override
    public void keyPressed(KeyEvent adm) {
        
        switch(Action.valueOf(adm.getComponent().getName())){
            case t_jt_dni:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("dni_search");
                    table.bt_search.requestFocus();
                  }
                break;
            case c_jt_dni:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("dni");
                    Create.jt_name.requestFocus();
                }
                break;
            case c_jt_name:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("name");
                    Create.jt_surname.requestFocus();
                }
                break;
            case c_jt_surname:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("surname");
                    Create.jt_mobile.requestFocus();
                }
                break;
            case c_jt_mobile:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("mobile");
                    Create.jt_email.requestFocus();
                }
                break;
            case c_jt_email:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("email");
                    Create.jt_nick.requestFocus();
                }
                break;
            case c_jt_nick:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("nick");
                    Create.jt_password.requestFocus();
                }
                break;
            case c_jt_password:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("password");
                }
                break;
            case c_jt_activity:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.give_data("activity");
                }
                break;
            case u_jt_name:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.update_data("name");
                    Update.jt_surname.requestFocus();
                }
                break;
            case u_jt_surname:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.update_data("surname");
                    Update.jt_mobile.requestFocus();
                }
                break;
            case u_jt_mobile:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.update_data("mobile");
                    Update.jt_email.requestFocus();
                }
                break;
            case u_jt_email:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.update_data("email");
                    Update.jt_nick.requestFocus();
                }
                break;
            case u_jt_nick:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.update_data("nick");
                    Update.jt_password.requestFocus();
                }
                break;
            case u_jt_password:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.update_data("password");
                }
                break;
            case u_jt_activity:
                if(adm.getKeyCode()==KeyEvent.VK_ENTER){
                    BLL_admin.update_data("activity");
                }
                break;
        }
    }

    /**
     * funtion to detect key actions in views
     * @param adm 
     */
    @Override
    public void keyReleased(KeyEvent adm) {
        
        switch(Action.valueOf(adm.getComponent().getName())){
            case t_jt_dni:
                BLL_admin.give_data("dni_search");
                break;
            case c_jt_dni:
                BLL_admin.give_data("dni");
                break;
            case c_jt_name:
                BLL_admin.give_data("name");
                break;
            case c_jt_surname:
                BLL_admin.give_data("surname");
                break;
            case c_jt_mobile:
                BLL_admin.give_data("mobile");
                break;
            case c_jt_email:
                BLL_admin.give_data("email");
                break;
            case c_jt_nick:
                BLL_admin.give_data("nick");
                break;
            case c_jt_password:
                if(Create.chb_password.isSelected()){
                    Create.jt_password.setEchoChar((char)0);
                    BLL_admin.give_data("password");
                }else{
                    Create.jt_password.setEchoChar('*');
                    BLL_admin.give_data("password");
                }
                break;
            case c_jt_activity:
                BLL_admin.give_data("activity");
                break;
            case u_jt_name:
                BLL_admin.update_data("name");
                break;
            case u_jt_surname:
                BLL_admin.update_data("surname");
                break;
            case u_jt_mobile:
                BLL_admin.update_data("mobile");
                break;
            case u_jt_email:
                BLL_admin.update_data("email");
                break;
            case u_jt_nick:
                BLL_admin.update_data("nick");
                break;
            case u_jt_password:
                if(Update.chb_password.isSelected()){
                    Update.jt_password.setEchoChar((char)0);
                    BLL_admin.update_data("password");
                }else{
                    Update.jt_password.setEchoChar('*');
                    BLL_admin.update_data("password");
                }
                break;
            case u_jt_activity:
                BLL_admin.update_data("activity");
                break;
        }
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    /**
     * funtion to detect focus changes in views
     * @param adm 
     */
    @Override
    public void focusLost(FocusEvent adm) {
        
        switch(Action.valueOf(adm.getComponent().getName())){
            case c_jt_dni:
                BLL_admin.give_data("dni");
                break;
            case c_jt_name:
                BLL_admin.give_data("name");
                break;
            case c_jt_surname:
                BLL_admin.give_data("surname");
                break;
            case c_jt_mobile:
                BLL_admin.give_data("mobile");
                break;
            case c_jt_email:
                BLL_admin.give_data("email");
                break;
            case c_jt_nick:
                BLL_admin.give_data("nick");
                break;
            case c_jt_password:
                BLL_admin.give_data("password");
                break;
            case c_jt_activity:
                BLL_admin.give_data("activity");
                break;
            case u_jt_name:
                BLL_admin.update_data("name");
                break;
            case u_jt_surname:
                BLL_admin.update_data("surname");
                break;
            case u_jt_mobile:
                BLL_admin.update_data("mobile");
                break;
            case u_jt_email:
                BLL_admin.update_data("email");
                break;
            case u_jt_nick:
                BLL_admin.update_data("nick");
                break;
            case u_jt_password:
                BLL_admin.update_data("password");
                break;
            case u_jt_activity:
                BLL_admin.update_data("activity");
                break;
        }
    }
}
