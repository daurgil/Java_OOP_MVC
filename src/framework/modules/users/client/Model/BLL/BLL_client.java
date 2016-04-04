/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.users.client.Model.BLL;



import framework.modules.users.client.Controler.client_controler;
import framework.modules.users.client.Model.DAO.DAO_client;
import framework.modules.users.client.Model.classes.client_class;
import framework.modules.users.client.Model.classes.miniSimpleTableModel_client;
import static framework.modules.users.client.Model.classes.miniSimpleTableModel_client.datosaux;
import framework.modules.users.client.Model.classes.singleton_client;
import static framework.modules.users.client.Model.classes.singleton_client.cli;
import framework.modules.users.client.Model.utils.lib_Cfiles.C_auto_json;
import framework.modules.users.client.Model.utils.lib_Cfiles.json;
import framework.modules.users.client.Model.utils.lib_Cfiles.txt;
import framework.modules.users.client.Model.utils.lib_Cfiles.xml;
import framework.modules.users.client.Model.utils.pagina;
import framework.modules.users.client.View.client_create;
import static framework.modules.users.client.View.client_table.TABLA;
import framework.modules.users.client.View.client_update;
import javax.swing.JOptionPane;

/**
 *
 * @author pelu
 */
public class BLL_client {
    public static boolean ok;
    
    public static void create(){
        
        client_class client=null;
        
        client=DAO_client.create();
        if(client==null){
            client_create.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
            if(search_client()!=-1){
                JOptionPane.showMessageDialog(null, "This Id card already exist");
                ok=false;
            }else{
                singleton_client.client.add(client);
                C_auto_json.auto_savejson_client();
                JOptionPane.showMessageDialog(null, "The user was created succesfuly"); 
                ok=true;
            }
            
            //admin_form.jl_alert.setText("The user was created succesfuly");
            
        }
    }
    
    public static void show_client(String DNI){
        int position;
        
        client_class client= new client_class(DNI);
        position=BLL_client.search_client(client);
        
        client=singleton_client.client.get(position);
        
        DAO_client.show_client(client);
        
        
    }
    
    public static void modify(){
        int position;
        String dni;
        
        dni=client_update.DNI;
        client_class client= new client_class(dni);
        position=BLL_client.search_client(client);
        
        client=DAO_client.modify();
        
        if(client==null){
            client_update.jt_alert.setText("ERROR, Any problem to save de user");
            ok=false;
        }else{
          singleton_client.client.set(position, client);
          C_auto_json.auto_savejson_client();
          client_update.jt_alert.setText("The user was created succesfuly"); 
          ok=true;
        }
          
        
    }
    
    public static void clean(){
        DAO_client.clean();
    }
    
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_client(){

		client_class client=null;
		String dni="";
		
		dni=client_create.jt_dni.getText();
		client= new client_class(dni);
		
		for(int i=0; i<=(singleton_client.client.size()-1);i++){
			if(singleton_client.client.get(i).equals(client))
				return i;
		}
		return -1;
			
	}
        
    /**Function to ask a dni to search if this admin exist in the arraylist
	 * 
	 * @param language
	 * @return int, if any user in arraylist have the introduced dni or not
	 */
	public static int search_client(client_class client){
		
		for(int i=0; i<=(singleton_client.client.size()-1);i++){
			if(singleton_client.client.get(i).equals(client))
				return i;
		}
		return -1;
			
	}
        
    public static void delete_line() {
        String dni;
        int pos, selection, inicio, selection1;

        int n = ((miniSimpleTableModel_client) TABLA.getModel()).getRowCount();
        if (n != 0) {
            //int selec = TABLA.getSelectedRow();
            inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            selection=TABLA.getSelectedRow(); //nos situamos en la fila
            selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
            } else {
                dni = (String) TABLA.getModel().getValueAt(selection1, 0);
                singleton_client.cli = new client_class(dni);
                
                pos = BLL_client.search_client((client_class) cli);
                int opc = JOptionPane.showConfirmDialog(null, "Deseas borrar a la persona con DNI: " + dni,
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_client) TABLA.getModel()).removeRow(selection1);
                    cli = singleton_client.client.get(pos);

                    singleton_client.client.remove(cli);
                    datosaux.remove(cli);
                    C_auto_json.auto_savejson_client();
                    
//                    Ordenar(0);
//                    EFBLLgrafico.Guardar(0);
                }

                if (((miniSimpleTableModel_client) TABLA.getModel()).getRowCount() == 0) {
                    if (((miniSimpleTableModel_client) TABLA.getModel()).getRowCount() != 0) {

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
        if (((miniSimpleTableModel_client) TABLA.getModel()).getRowCount() != 0) {
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
                                
                client_update.DNI=dni;
                new client_controler(new client_update(), 2).Init(2);
                
                
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
                correct = DAO_client.dni();
                break;
            case "dni_search":
                correct = DAO_client.dni_search();
                break;
            case "name":
                correct = DAO_client.name();
                break;
            case "surname":
                correct = DAO_client.surname();
                break;
            case "mobile":
                correct = DAO_client.mobile();
                break;
            case "email":
                correct = DAO_client.email();
                break;
            case "nick":
                correct = DAO_client.nick();
                break;
            case "password":
                correct = DAO_client.password();
                break;
            case "avatar":
                correct = DAO_client.avatar();
                break;
            case "birthday":
                correct = DAO_client.birthday();
                break;
            case "update":
                correct = DAO_client.up_date();
                break;
            case "type":
                correct = DAO_client.type();
                break;
            case "shopping":
                correct = DAO_client.shopping();
                break;
        }
    }
    
    public static void update_data(String type){
        boolean correct = false;
        switch (type) {
            case "dni":
                correct = DAO_client.up_dni();
                break;
            case "name":
                correct = DAO_client.up_name();
                break;
            case "surname":
                correct = DAO_client.up_surname();
                break;
            case "mobile":
                correct = DAO_client.up_mobile();
                break;
            case "email":
                correct = DAO_client.up_email();
                break;
            case "nick":
                correct = DAO_client.up_nick();
                break;
            case "password":
                correct = DAO_client.up_password();
                break;
            case "birthday":
                correct = DAO_client.up_birthday();
                break;
            case "update":
                correct = DAO_client.up_up_date();
                break;
            case "type":
                correct = DAO_client.up_type();
                break;
            case "shopping":
                correct = DAO_client.up_shopping();
                break;
        }
    }
    
    public static void save_json(){   
        json.savejson_client();
    }
    
    public static void save_xml(){   
        xml.savexml_client();
    }
    
    public static void save_txt(){   
        txt.savetxt_client();
    }
}
