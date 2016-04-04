package framework.utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import framework.modules.Menu_config.Model.classes.language.class_language;

public class appearance {

	/**
     * Cambia la apariencia de la aplicación.
     *
     * @param apariencia : un int que indica la apariencia seleccionada.
     */
	public static void theme_selected(String theme){
		try {
			switch (theme){
			case "Metal":// Metal
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				break;

			case "Windows":// GTK - WINDOWS
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;

			case "Motif":// CDE/Motif
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;

			case "Nimbus":// Nimbus
				
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;

			
			case "Mac": //Obtener lista look&feel disponibles en el SO
					//http://www.codigofantasma.com/blog/java-look-feel-parte-1/
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
				break;
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, class_language.getinstance().getProperty("error_theme"), 
														"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
