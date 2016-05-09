/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.reg_user.Model.BLL;

import framework.modules.Menu_config.View.log_in;
import framework.modules.users.reg_user.Controler.reg_controler;
import framework.modules.users.reg_user.Model.DAO.DAO_reg;
import framework.modules.users.reg_user.Model.classes.miniSimpleTableModel_reg;
import static framework.modules.users.reg_user.Model.classes.miniSimpleTableModel_reg.datosaux;
import framework.modules.users.reg_user.Model.classes.reg_user_class;
import framework.modules.users.reg_user.Model.classes.singleton_reg;
import static framework.modules.users.reg_user.Model.classes.singleton_reg.reg_u;
import framework.modules.users.reg_user.Model.utils.lib_Rfiles.R_auto_json;
import framework.modules.users.reg_user.Model.utils.lib_Rfiles.json;
import framework.modules.users.reg_user.Model.utils.lib_Rfiles.txt;
import framework.modules.users.reg_user.Model.utils.lib_Rfiles.xml;
import framework.modules.users.reg_user.Model.utils.pagina;
import framework.modules.users.reg_user.View.reg_create;
import static framework.modules.users.reg_user.View.reg_table.TABLA;
import framework.modules.users.reg_user.View.reg_update;
import javax.swing.JOptionPane;





/**
 *
 * @author pelu
 */
public class BLL_reg {
    public static boolean ok;
    
    /**
     * Funtion to create a admin
     */
    public static void create(){
        
        reg_user_class reg=null;
        
        reg =DAO_reg.create();
        if(reg==null){
            reg_create.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
            if(search_reg()!=-1){
                JOptionPane.showMessageDialog(null, "This Id card already exist");
                ok=false;
            }else{
                singleton_reg.reg.add(reg);
                R_auto_json.auto_savejson_reg();
                JOptionPane.showMessageDialog(null, "The user was created succesfuly"); 
                ok=true;
            }
            
            //admin_form.jl_alert.setText("The user was created succesfuly");
            
        }
    }
    
    /**
     * Funtion to show an reg user
     * @param DNI 
     */
    public static void show_reg(String DNI){
        int position;
        
        reg_user_class reg= new reg_user_class(DNI);
        position=BLL_reg.search_reg(reg);
        
        reg=singleton_reg.reg.get(position);
        
        DAO_reg.show_reg(reg);
        
        
    }
    
    /**
     * funtion to modify an existent reg user
     */
    public static void modify(){
        int position;
        String dni;
        
        dni=reg_update.DNI;
        reg_user_class reg= new reg_user_class(dni);
        position=BLL_reg.search_reg(reg);
        
        reg=DAO_reg.modify();
        
        if(reg==null){
            reg_update.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
          singleton_reg.reg.set(position, reg);
          R_auto_json.auto_savejson_reg();
          reg_update.jt_alert.setText("The user was created succesfuly"); 
          ok=true;
        }
          
        
    }
    
    public static void clean(){
        DAO_reg.clean();
    }
    
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_reg(){

		reg_user_class r=null;
		String dni="";
		
		dni=reg_create.jt_dni.getText();
		r= new reg_user_class(dni);
		
		for(int i=0; i<=(singleton_reg.reg.size()-1);i++){
			if(singleton_reg.reg.get(i).equals(r))
				return i;
		}
		return -1;
			
	}
        
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_reg_log(){

		reg_user_class r=null;
		String dni="";
		
		dni=log_in.jt_dni.getText();
		r= new reg_user_class(dni);
		
		for(int i=0; i<=(singleton_reg.reg.size()-1);i++){
			if(singleton_reg.reg.get(i).equals(r)){
                                singleton_reg.r=singleton_reg.reg.get(i);
				return i;
                        }
		}
		return -1;
			
	}
        
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_reg(reg_user_class reg){

//		admin_class a=admin;
//		String dni="";
//                
//                dni=admin_update.DNI;
//		a= new admin_class(dni);
		
		for(int i=0; i<=(singleton_reg.reg.size()-1);i++){
			if(singleton_reg.reg.get(i).equals(reg))
				return i;
		}
		return -1;
			
	}
    
    /**
     * funtion to delete a line in table admin, and in DB
     */
    public static void delete_line() {
        String dni;
        int pos, selection, inicio, selection1;

        int n = ((miniSimpleTableModel_reg) TABLA.getModel()).getRowCount();
        if (n != 0) {
            //int selec = TABLA.getSelectedRow();
            inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            selection=TABLA.getSelectedRow(); //nos situamos en la fila
            selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
            } else {
                dni = (String) TABLA.getModel().getValueAt(selection1, 0);
                singleton_reg.reg_u = new reg_user_class(dni);
                
                pos = BLL_reg.search_reg((reg_user_class) reg_u);
                int opc = JOptionPane.showConfirmDialog(null, "Deseas borrar a la persona con DNI: " + dni,
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_reg) TABLA.getModel()).removeRow(selection1);
                    reg_u = singleton_reg.reg.get(pos);

                    singleton_reg.reg.remove(reg_u);
                    datosaux.remove(reg_u);
                    R_auto_json.auto_savejson_reg();
                    
//                    Ordenar(0);
//                    EFBLLgrafico.Guardar(0);
                }

                if (((miniSimpleTableModel_reg) TABLA.getModel()).getRowCount() == 0) {
                    if (((miniSimpleTableModel_reg) TABLA.getModel()).getRowCount() != 0) {

                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
        }
    }
    
    /**
     * funtion to modify a line in table admin, and in DB
     */
    public static boolean modifiy_line() {
        String dni;
        boolean correcto;
        if (((miniSimpleTableModel_reg) TABLA.getModel()).getRowCount() != 0) {
            //int selec = TABLA.getSelectedRow();
            int inicio = (pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            int selection = TABLA.getSelectedRow(); //nos situamos en la fila
            int selection1 = inicio+selection; 
            if (selection1 == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
                correcto = false;

            } else {

                dni = (String) TABLA.getModel().getValueAt(selection1, 0);

                //singleton_admin.adm = new admin_class(dni);
                                
                reg_update.DNI=dni;
                new reg_controler(new reg_update(), 2).Init(2);
                
                
                correcto = true;

            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
            correcto = false;
        }
        return correcto;
    }
    
    /**
     * funtion to check the introduced date in create view
     * @param type
     * @return 
     */
    public static void give_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_reg.dni();
                break;
            case "dni_search":
                correct = DAO_reg.dni_search();
                break;
            case "name":
                correct = DAO_reg.name();
                break;
            case "surname":
                correct = DAO_reg.surname();
                break;
            case "mobile":
                correct = DAO_reg.mobile();
                break;
            case "email":
                correct = DAO_reg.email();
                break;
            case "nick":
                correct = DAO_reg.nick();
                break;
            case "password":
                correct = DAO_reg.password();
                break;
            case "activity":
                correct = DAO_reg.activity();
                break;
            case "birthday":
                correct = DAO_reg.birthday();
                break;
        }
    }
    
    /**
     * funtion to check the introduced date in update view
     * @param type
     * @return 
     */
    public static void update_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_reg.up_dni();
                break;
            case "name":
                correct = DAO_reg.up_name();
                break;
            case "surname":
                correct = DAO_reg.up_surname();
                break;
            case "mobile":
                correct = DAO_reg.up_mobile();
                break;
            case "email":
                correct = DAO_reg.up_email();
                break;
            case "nick":
                correct = DAO_reg.up_nick();
                break;
            case "password":
                correct = DAO_reg.up_password();
                break;
            case "activity":
                correct = DAO_reg.up_activity();
                break;
            case "birthday":
                correct = DAO_reg.up_birthday();
                break;
        }
    }
    
    public static void save_json(){   
        json.savejson_reg();
    }
    
    public static void save_xml(){   
        xml.savexml_reg();
    }
    
    public static void save_txt(){   
        txt.savetxt_reg();
    }
}
