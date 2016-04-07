package framework.modules.users.client.Model.classes;

import static framework.modules.users.client.Controler.client_controler.combo_client;
import framework.modules.users.client.Model.utils.lib_Cfiles.C_auto_json;
import framework.modules.users.client.Model.utils.pagina;
import framework.modules.users.client.View.client_table;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;


public class miniSimpleTableModel_client extends AbstractTableModel {
    public static ArrayList<client_class> datos = new ArrayList<client_class>();
    public static ArrayList<client_class> datosaux = new ArrayList<client_class>();
    String[] columnas = {"ID card", "name", "surname"};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        client_class fila = (client_class) datos.get(row);
        
        switch (col) {
            case 0:
                dev = fila.getDni();
                break;

            case 1:
                dev = fila.getName();
                break;

            case 2:
                dev = fila.getSurname();
                break;

//            case 3:
//                dev=fila.getDate_cont().getDate_s();
//                //dev = class_date.date_to_String(fila.getDate_cont());
//                break;
//                
//            case 4:
//                dev = fila.getSalary();
//                break;

        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        client_class fila = (client_class) datos.get(row);

        switch (col) {
            case 0:
                fila.setDni(value.toString());
                break;

            case 1:
                fila.setName(value.toString());
                break;

            case 2:
                fila.setSurname(value.toString());
                break;
            
//            case 3:
//                fila.setDate_cont(((class_date)value));
//                break;
//                
//            case 4:
//                fila.setSalary((float)value);
//                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(client_class usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        singleton_client.client.clear();
        
        C_auto_json.auto_openjson_client();
        
        client_class client = null;
        java.util.Date date= new java.util.Date();
        for(int i=0;i<=(singleton_client.client.size()-1);i++) {
            //admin = new admin_class(i, getCadenaAleatoria1(4), getCadenaAleatoria2(8), new Timestamp(date.getTime()));
            client=singleton_client.client.get(i);
            addRow(client);
            datosaux.add(client);
            //singleton_user.admin.add(admin);
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    }

    public void filtrar() {
        datos.clear();
        int cont=0;
        
        String nom=(String) ((JComboBox)combo_client).getSelectedItem();   
        if(nom!=null){
            for(int i=0;i<datosaux.size();i++) {
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if(datosaux.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())){
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            client_table.jLabel3.setText(String.valueOf(cont));
            pagina.initLinkBox();
        }
    }

    public client_class buscar(String u) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(u)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(client_class u) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
        client_table.jLabel3.setText(String.valueOf(datos.size()));
        pagina.initLinkBox();
    }
}
