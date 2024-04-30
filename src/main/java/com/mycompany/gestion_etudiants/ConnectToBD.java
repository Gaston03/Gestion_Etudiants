package com.mycompany.gestion_etudiants;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * @author AdMin
 */
public class ConnectToBD {
    
    public Connection BDconnexion;
    
    /*
     * @throws IOException
     */
    public ConnectToBD() throws IOException{
        /* Chargement du fichier de Configuration */
        Properties properties = new Properties();
        try( FileInputStream file = new FileInputStream("Config.properties") ) {
            properties.load(file);
        }
        
        /* Etablissement de la connection */
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        
        try{
            Class.forName(properties.getProperty("jdbc.driver.class"));
            BDconnexion = DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Erreur de connexion !");
        }
        
    }
}
