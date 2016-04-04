/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.modules.Menu_config.Model.files_config.BLL;

import framework.modules.Menu_config.Model.files_config.DAO.DAO_config;
import framework.modules.Menu_config.Model.files_config.auto_config;

/**
 *
 * @author pelu
 */
public class BLL_config {
    
    public static void save_config(){
        DAO_config.save();
        
        auto_config.auto_saveconfig();
    }
    
    public static void open_config(){
        DAO_config.open_config();
    }
}
