/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.admin.Model.BLL;



import framework.modules.users.admin.Controler.admin_controler;
import framework.modules.users.admin.Model.DAO.DAO_admin;
import framework.modules.users.admin.Model.classes.admin_class;
import framework.modules.users.admin.Model.classes.miniSimpleTableModel_admin;
import static framework.modules.users.admin.Model.classes.miniSimpleTableModel_admin.datosaux;
import framework.modules.users.admin.Model.classes.singleton_admin;
import static framework.modules.users.admin.Model.classes.singleton_admin.adm;
import framework.modules.users.admin.Model.utils.lib_Afiles.A_auto_json;
import framework.modules.users.admin.Model.utils.lib_Afiles.json;
import framework.modules.users.admin.Model.utils.lib_Afiles.txt;
import framework.modules.users.admin.Model.utils.lib_Afiles.xml;
import framework.modules.users.admin.Model.utils.pagina;
import framework.modules.users.admin.View.admin_create;
import static framework.modules.users.admin.View.admin_table.TABLA;
import framework.modules.users.admin.View.admin_update;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class BLL_admin {
    public static boolean ok;
    
    public static void create(){
        
        admin_class admin=null;
        
        admin=DAO_admin.create();
        if(admin==null){
            admin_create.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
            if(search_admin()!=-1){
                JOptionPane.showMessageDialog(null, "This Id card already exist");
                ok=false;
            }else{
                singleton_admin.a = admin;
                BLL_DB_admin.create_adminBLL();
                //A_auto_json.auto_savejson_admin();
                JOptionPane.showMessageDialog(null, "The user was created succesfuly"); 
                ok=true;
            }
            
            //admin_form.jl_alert.setText("The user was created succesfuly");
            
        }
    }
    
    public static void show_admin(String DNI){
        int position;
        
        admin_class admin= new admin_class(DNI);
        position=BLL_admin.search_admin(admin);
        
        admin=singleton_admin.admin.get(position);
        
        DAO_admin.show_admin(admin);
        
        
    }
    
    public static void modify(){
        int position;
        String dni;
        
        dni=admin_update.DNI;
        admin_class admin= new admin_class(dni);
        position=BLL_admin.search_admin(admin);
        
        admin=DAO_admin.modify();
        
        if(admin==null){
            admin_update.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
          singleton_admin.a=admin;
          BLL_DB_admin.modify_adminBLL();
          //A_auto_json.auto_savejson_admin();
          admin_update.jt_alert.setText("The user was created succesfuly"); 
          ok=true;
        }
          
        
    }
    
    public static void clean(){
        DAO_admin.clean();
    }
    
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_admin(){

		admin_class a=null;
		String dni="";
		
		dni=admin_create.jt_dni.getText();
		a= new admin_class(dni);
		
		for(int i=0; i<=(singleton_admin.admin.size()-1);i++){
			if(singleton_admin.admin.get(i).equals(a))
				return i;
		}
		return -1;
			
	}
        
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_admin(admin_class admin){

//		admin_class a=admin;
//		String dni="";
//                
//                dni=admin_update.DNI;
//		a= new admin_class(dni);
		
		for(int i=0; i<=(singleton_admin.admin.size()-1);i++){
			if(singleton_admin.admin.get(i).equals(admin))
				return i;
		}
		return -1;
			
	}
        
    public static void delete_line() {
        String dni;
        int pos, selection, inicio, selection1;

        int n = ((miniSimpleTableModel_admin) TABLA.getModel()).getRowCount();
        if (n != 0) {
            //int selec = TABLA.getSelectedRow();
            inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            selection=TABLA.getSelectedRow(); //nos situamos en la fila
            selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
            } else {
                dni = (String) TABLA.getModel().getValueAt(selection1, 0);
                singleton_admin.adm = new admin_class(dni);
                
                pos = BLL_admin.search_admin((admin_class) adm);
                int opc = JOptionPane.showConfirmDialog(null, "Deseas borrar a la persona con DNI: " + dni,
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_admin) TABLA.getModel()).removeRow(selection1);
                    adm = singleton_admin.admin.get(pos);

                    //singleton_admin.admin.remove(adm);
                    datosaux.remove(adm);
                    singleton_admin.a=adm;
                    BLL_DB_admin.delete_adminBLL();
                    //A_auto_json.auto_savejson_admin();
                    
                }

                if (((miniSimpleTableModel_admin) TABLA.getModel()).getRowCount() == 0) {
                    if (((miniSimpleTableModel_admin) TABLA.getModel()).getRowCount() != 0) {

                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
        }
    }
    
    public static boolean modifiy_line() {
        String dni;
        boolean correcto;
        if (((miniSimpleTableModel_admin) TABLA.getModel()).getRowCount() != 0) {
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
                                
                admin_update.DNI=dni;
                new admin_controler(new admin_update(), 2).Init(2);
                        
                
                
                correcto = true;

            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);
            correcto = false;
        }
        return correcto;
    }
    
    public static void give_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_admin.dni();
                break;
            case "dni_search":
                correct = DAO_admin.dni_search();
                break;
            case "name":
                correct = DAO_admin.name();
                break;
            case "surname":
                correct = DAO_admin.surname();
                break;
            case "mobile":
                correct = DAO_admin.mobile();
                break;
            case "email":
                correct = DAO_admin.email();
                break;
            case "nick":
                correct = DAO_admin.nick();
                break;
            case "password":
                correct = DAO_admin.password();
                break;
            case "avatar":
                correct = DAO_admin.avatar();
                break;
            case "activity":
                correct = DAO_admin.activity();
                break;
            case "birthday":
                correct = DAO_admin.birthday();
                break;
            case "contract":
                correct = DAO_admin.contract();
                break;
        }
    }
    
    public static void update_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_admin.up_dni();
                break;
            case "name":
                correct = DAO_admin.up_name();
                break;
            case "surname":
                correct = DAO_admin.up_surname();
                break;
            case "mobile":
                correct = DAO_admin.up_mobile();
                break;
            case "email":
                correct = DAO_admin.up_email();
                break;
            case "nick":
                correct = DAO_admin.up_nick();
                break;
            case "password":
                correct = DAO_admin.up_password();
                break;
//            case "avatar":
//                correct = DAO_admin.up_avatar();
//                break;
            case "activity":
                correct = DAO_admin.up_activity();
                break;
            case "birthday":
                correct = DAO_admin.up_birthday();
                break;
            case "contract":
                correct = DAO_admin.up_contract();
                break;
        }
    }
    
    public static void save_json(){   
        json.savejson_admin();
    }
    
    public static void save_xml(){   
        xml.savexml_admin();
    }
    
    public static void save_txt(){   
        txt.savetxt_admin();
    }
}
