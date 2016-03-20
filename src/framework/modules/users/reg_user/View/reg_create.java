/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.reg_user.View;



import framework.modules.users.reg_user.Model.BLL.BLL_reg;
import framework.modules.users.reg_user.Model.classes.singleton_reg;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Timer;

/**
 *
 * @author pelu
 */
public class reg_create extends javax.swing.JFrame {

    private void pause(){
        Timer delay=new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new reg_table().setVisible(true);
            }
        });
        
        delay.setRepeats(false);
        delay.start();
        reg_create.jt_alert.setText("User created correctly");
    }
    /**
     * Creates new form admin_form
     */
    public reg_create() {
        initComponents();
        this.setTitle("Create Reg. User");
        Image icono=Toolkit.getDefaultToolkit().getImage(singleton_reg.icon_reg);
	this.setIconImage(icono);
	this.setLocationRelativeTo(null);
	this.setSize(550,400);//ancho x alto
	this.setResizable(false);
        jdc_birthday.getDateEditor().setEnabled(false);
	
	//this.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //JOptionPane.showMessageDialog(null,"Saliendo de la aplicación");
                dispose();
                new reg_table().setVisible(true);
            }
        });
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField10 = new javax.swing.JTextField();
        bgr_state = new javax.swing.ButtonGroup();
        jfc_avatar = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jsc_form = new javax.swing.JScrollPane();
        create_form = new javax.swing.JPanel();
        lb_dni = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_surname = new javax.swing.JLabel();
        lb_mobile = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        lb_nick = new javax.swing.JLabel();
        lb_password = new javax.swing.JLabel();
        lb_avatar = new javax.swing.JLabel();
        lb_birthday = new javax.swing.JLabel();
        lb_activity = new javax.swing.JLabel();
        jt_dni = new javax.swing.JTextField();
        jt_name = new javax.swing.JTextField();
        jt_surname = new javax.swing.JTextField();
        jt_mobile = new javax.swing.JTextField();
        jt_email = new javax.swing.JTextField();
        jt_nick = new javax.swing.JTextField();
        jt_avatar = new javax.swing.JTextField();
        jt_activity = new javax.swing.JTextField();
        lb_state = new javax.swing.JLabel();
        jrb_conected = new javax.swing.JRadioButton();
        jrb_disconected = new javax.swing.JRadioButton();
        jdc_birthday = new com.toedter.calendar.JDateChooser();
        check_dni = new javax.swing.JLabel();
        check_name = new javax.swing.JLabel();
        check_surname = new javax.swing.JLabel();
        check_mobile = new javax.swing.JLabel();
        check_email = new javax.swing.JLabel();
        check_nick = new javax.swing.JLabel();
        check_password = new javax.swing.JLabel();
        check_avatar = new javax.swing.JLabel();
        check_birthday = new javax.swing.JLabel();
        check_activity = new javax.swing.JLabel();
        jb_avatar = new javax.swing.JButton();
        jt_password = new javax.swing.JPasswordField();
        chb_password = new javax.swing.JCheckBox();
        jl_back = new javax.swing.JLabel();
        jb_save = new javax.swing.JButton();
        jb_clean = new javax.swing.JButton();
        jt_alert = new javax.swing.JTextField();

        jTextField10.setText("jTextField10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Mono", 1, 24)); // NOI18N
        jLabel1.setText("Create Reg. User ");

        jsc_form.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jsc_form.setHorizontalScrollBar(null);
        jsc_form.setPreferredSize(new java.awt.Dimension(470, 632));
        this.jsc_form.getVerticalScrollBar().setUnitIncrement(10);

        lb_dni.setText("ID Card:");

        lb_name.setText("Name:");

        lb_surname.setText("Surmane/s:");

        lb_mobile.setText("Mobile:");

        lb_email.setText("Email:");

        lb_nick.setText("Nick Name:");

        lb_password.setText("Password:");

        lb_avatar.setText("Avatar:");

        lb_birthday.setText("Bithday date:");

        lb_activity.setText("Activity:");

        jt_dni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt_dniFocusLost(evt);
            }
        });
        jt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_dniKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_dniKeyReleased(evt);
            }
        });

        jt_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt_nameFocusLost(evt);
            }
        });
        jt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_nameKeyReleased(evt);
            }
        });

        jt_surname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt_surnameFocusLost(evt);
            }
        });
        jt_surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_surnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_surnameKeyReleased(evt);
            }
        });

        jt_mobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt_mobileFocusLost(evt);
            }
        });
        jt_mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_mobileKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_mobileKeyReleased(evt);
            }
        });

        jt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt_emailFocusLost(evt);
            }
        });
        jt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_emailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_emailKeyReleased(evt);
            }
        });

        jt_nick.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt_nickFocusLost(evt);
            }
        });
        jt_nick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_nickKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_nickKeyReleased(evt);
            }
        });

        jt_avatar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_avatarKeyPressed(evt);
            }
        });

        jt_activity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt_activityFocusLost(evt);
            }
        });
        jt_activity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_activityKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_activityKeyReleased(evt);
            }
        });

        lb_state.setText("State:");

        bgr_state.add(jrb_conected);
        jrb_conected.setSelected(true);
        jrb_conected.setText("Connected");
        jrb_conected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_conectedActionPerformed(evt);
            }
        });

        bgr_state.add(jrb_disconected);
        jrb_disconected.setText("Disconnected");

        jdc_birthday.setDateFormatString("dd/MM/yyyy");
        jdc_birthday.setMinSelectableDate(new java.util.Date(-631151908000L));
        jdc_birthday.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdc_birthdayPropertyChange(evt);
            }
        });

        jb_avatar.setText("Select");
        jb_avatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_avatarActionPerformed(evt);
            }
        });

        jt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt_passwordFocusLost(evt);
            }
        });
        jt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_passwordKeyReleased(evt);
            }
        });

        chb_password.setText("See the password");
        chb_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout create_formLayout = new javax.swing.GroupLayout(create_form);
        create_form.setLayout(create_formLayout);
        create_formLayout.setHorizontalGroup(
            create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_dni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lb_surname)
                    .addComponent(lb_mobile)
                    .addComponent(lb_email)
                    .addComponent(lb_nick)
                    .addComponent(lb_password)
                    .addComponent(lb_avatar)
                    .addComponent(lb_state)
                    .addComponent(lb_birthday)
                    .addComponent(lb_activity))
                .addGap(40, 40, 40)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(create_formLayout.createSequentialGroup()
                        .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(create_formLayout.createSequentialGroup()
                                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jt_dni)
                                    .addComponent(jt_name)
                                    .addComponent(jt_surname)
                                    .addComponent(jt_mobile)
                                    .addComponent(jt_email)
                                    .addComponent(jt_nick)
                                    .addComponent(jt_password)
                                    .addGroup(create_formLayout.createSequentialGroup()
                                        .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chb_password)
                                            .addComponent(jt_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 3, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(check_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(check_name, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(check_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(check_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(check_email, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(check_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(check_password, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(create_formLayout.createSequentialGroup()
                                        .addComponent(jb_avatar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(check_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(create_formLayout.createSequentialGroup()
                                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(create_formLayout.createSequentialGroup()
                                        .addComponent(jdc_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(check_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(create_formLayout.createSequentialGroup()
                                        .addComponent(jrb_conected)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrb_disconected)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(57, 57, 57))
                    .addGroup(create_formLayout.createSequentialGroup()
                        .addComponent(jt_activity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_activity, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))))
        );
        create_formLayout.setVerticalGroup(
            create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_formLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_dni)
                    .addComponent(jt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_name)
                    .addComponent(jt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_name, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_surname)
                    .addComponent(jt_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_mobile)
                    .addComponent(jt_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_email)
                    .addComponent(jt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_email, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nick)
                    .addComponent(jt_nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_password)
                    .addComponent(check_password, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(create_formLayout.createSequentialGroup()
                        .addComponent(jt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chb_password)))
                .addGap(18, 18, 18)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_avatar)
                    .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jt_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_avatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(check_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_state)
                    .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrb_conected)
                        .addComponent(jrb_disconected)))
                .addGap(18, 18, 18)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_birthday)
                    .addComponent(jdc_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(create_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_activity)
                    .addComponent(jt_activity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_activity, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jsc_form.setViewportView(create_form);

        jl_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framework/img/back.png"))); // NOI18N
        jl_back.setText("Back");
        jl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_backMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl_backMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl_backMouseEntered(evt);
            }
        });

        jb_save.setText("Save");
        jb_save.setPreferredSize(new java.awt.Dimension(42, 31));
        jb_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_saveActionPerformed(evt);
            }
        });

        jb_clean.setText("Clean");
        jb_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jsc_form, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jb_save, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_clean, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jt_alert, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addComponent(jsc_form, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jb_save, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_clean, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jt_alert))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrb_conectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_conectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_conectedActionPerformed
    
    private void jt_dniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_dniKeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          BLL_reg.give_data("dni");
          reg_create.jt_name.requestFocus();
      }
    }//GEN-LAST:event_jt_dniKeyPressed

    private void jt_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_nameKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           BLL_reg.give_data("name");
           reg_create.jt_surname.requestFocus();
       }
    }//GEN-LAST:event_jt_nameKeyPressed

    private void jt_surnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_surnameKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BLL_reg.give_data("surname");
            reg_create.jt_mobile.requestFocus();
       }
    }//GEN-LAST:event_jt_surnameKeyPressed

    private void jt_mobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_mobileKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BLL_reg.give_data("mobile");
            reg_create.jt_email.requestFocus();
       }
    }//GEN-LAST:event_jt_mobileKeyPressed

    private void jt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_emailKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BLL_reg.give_data("email");
            reg_create.jt_nick.requestFocus();
       }
    }//GEN-LAST:event_jt_emailKeyPressed

    private void jt_nickKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_nickKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           BLL_reg.give_data("nick");
           reg_create.jt_password.requestFocus();
       }
    }//GEN-LAST:event_jt_nickKeyPressed

    private void jt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_passwordKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
           BLL_reg.give_data("password");
    }//GEN-LAST:event_jt_passwordKeyPressed

    private void jt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_passwordKeyReleased
        
        if(chb_password.isSelected()){
            jt_password.setEchoChar((char)0);
            BLL_reg.give_data("password");
        }else{
            jt_password.setEchoChar('*');
            BLL_reg.give_data("password");
        }
    }//GEN-LAST:event_jt_passwordKeyReleased

    private void chb_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_passwordActionPerformed
        
        if(chb_password.isSelected()==false){
           jt_password.setEchoChar('*'); 
        }
        jt_password.requestFocus();
    }//GEN-LAST:event_chb_passwordActionPerformed

    private void jl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_backMouseClicked
        new reg_table().setVisible(true);
        dispose();
    }//GEN-LAST:event_jl_backMouseClicked

    private void jt_activityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_activityKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            BLL_reg.give_data("activity");
    }//GEN-LAST:event_jt_activityKeyPressed

    private void jb_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cleanActionPerformed
        BLL_reg.clean();
    }//GEN-LAST:event_jb_cleanActionPerformed

    private void jdc_birthdayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdc_birthdayPropertyChange
        BLL_reg.give_data("birthday");
    }//GEN-LAST:event_jdc_birthdayPropertyChange

    private void jt_avatarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_avatarKeyPressed
        
    }//GEN-LAST:event_jt_avatarKeyPressed

    private void jb_avatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_avatarActionPerformed
        int select;
        
        select=jfc_avatar.showOpenDialog(this);
        if(select==jfc_avatar.APPROVE_OPTION){
            jt_avatar.setText(jfc_avatar.getSelectedFile().toString());
        }else{
            
        }
        
    }//GEN-LAST:event_jb_avatarActionPerformed

    private void jb_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_saveActionPerformed
        BLL_reg.create();
        if(BLL_reg.ok==true){
            pause();
        }else{
            jt_alert.setText("Change the Id card");
        }    
    }//GEN-LAST:event_jb_saveActionPerformed

    private void jt_dniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_dniKeyReleased
         BLL_reg.give_data("dni");
    }//GEN-LAST:event_jt_dniKeyReleased

    private void jt_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_nameKeyReleased
         BLL_reg.give_data("name");
    }//GEN-LAST:event_jt_nameKeyReleased

    private void jt_surnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_surnameKeyReleased
         BLL_reg.give_data("surname");
    }//GEN-LAST:event_jt_surnameKeyReleased

    private void jt_mobileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_mobileKeyReleased
         BLL_reg.give_data("mobile");
    }//GEN-LAST:event_jt_mobileKeyReleased

    private void jt_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_emailKeyReleased
         BLL_reg.give_data("email");
    }//GEN-LAST:event_jt_emailKeyReleased

    private void jt_nickKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_nickKeyReleased
         BLL_reg.give_data("nick");
    }//GEN-LAST:event_jt_nickKeyReleased

    private void jt_activityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_activityKeyReleased
        BLL_reg.give_data("activity");
    }//GEN-LAST:event_jt_activityKeyReleased

    private void jt_dniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_dniFocusLost
        BLL_reg.give_data("dni");
    }//GEN-LAST:event_jt_dniFocusLost

    private void jt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_nameFocusLost
        BLL_reg.give_data("name");
    }//GEN-LAST:event_jt_nameFocusLost

    private void jt_surnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_surnameFocusLost
        BLL_reg.give_data("surname");
    }//GEN-LAST:event_jt_surnameFocusLost

    private void jt_mobileFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_mobileFocusLost
        BLL_reg.give_data("mobile");
    }//GEN-LAST:event_jt_mobileFocusLost

    private void jt_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_emailFocusLost
        BLL_reg.give_data("email");
    }//GEN-LAST:event_jt_emailFocusLost

    private void jt_nickFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_nickFocusLost
        BLL_reg.give_data("nick");
    }//GEN-LAST:event_jt_nickFocusLost

    private void jt_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_passwordFocusLost
        BLL_reg.give_data("password");
    }//GEN-LAST:event_jt_passwordFocusLost

    private void jt_activityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_activityFocusLost
        BLL_reg.give_data("activity");
    }//GEN-LAST:event_jt_activityFocusLost

    private void jl_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_backMouseEntered
        jl_back.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
    }//GEN-LAST:event_jl_backMouseEntered

    private void jl_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_backMouseExited
       jl_back.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
    }//GEN-LAST:event_jl_backMouseExited

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(admin_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(admin_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(admin_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(admin_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new admin_form().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgr_state;
    public static javax.swing.JCheckBox chb_password;
    public static javax.swing.JLabel check_activity;
    public static javax.swing.JLabel check_avatar;
    public static javax.swing.JLabel check_birthday;
    public static javax.swing.JLabel check_dni;
    public static javax.swing.JLabel check_email;
    public static javax.swing.JLabel check_mobile;
    public static javax.swing.JLabel check_name;
    public static javax.swing.JLabel check_nick;
    public static javax.swing.JLabel check_password;
    public static javax.swing.JLabel check_surname;
    private javax.swing.JPanel create_form;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JButton jb_avatar;
    public static javax.swing.JButton jb_clean;
    public static javax.swing.JButton jb_save;
    public static com.toedter.calendar.JDateChooser jdc_birthday;
    private javax.swing.JFileChooser jfc_avatar;
    public static javax.swing.JLabel jl_back;
    public static javax.swing.JRadioButton jrb_conected;
    public static javax.swing.JRadioButton jrb_disconected;
    private javax.swing.JScrollPane jsc_form;
    public static javax.swing.JTextField jt_activity;
    public static javax.swing.JTextField jt_alert;
    public static javax.swing.JTextField jt_avatar;
    public static javax.swing.JTextField jt_dni;
    public static javax.swing.JTextField jt_email;
    public static javax.swing.JTextField jt_mobile;
    public static javax.swing.JTextField jt_name;
    public static javax.swing.JTextField jt_nick;
    public static javax.swing.JPasswordField jt_password;
    public static javax.swing.JTextField jt_surname;
    private javax.swing.JLabel lb_activity;
    private javax.swing.JLabel lb_avatar;
    private javax.swing.JLabel lb_birthday;
    private javax.swing.JLabel lb_dni;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_mobile;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_nick;
    private javax.swing.JLabel lb_password;
    private javax.swing.JLabel lb_state;
    private javax.swing.JLabel lb_surname;
    // End of variables declaration//GEN-END:variables
}
