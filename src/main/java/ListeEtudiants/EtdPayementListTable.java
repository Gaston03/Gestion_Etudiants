package ListeEtudiants;
import AdminPackage.AdminPage;
import com.mycompany.gestion_etudiants.ConnectToBD;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AdMin
 */
public class EtdPayementListTable {

    private static int ID ;
    private static String nom = null;
    private static String prenom = null;
    private static String niveau = null;
    private static String filiere = null;
    private static String periode = null;
    private static String montant = null; 
    private static String devise = " dh";
    private static Date date;
    private static ConnectToBD connect;
    
    public static void ISIPayementListTable() throws Exception{
        
        connect = new ConnectToBD();
        DefaultTableModel model = new DefaultTableModel(null, new String[] { "Date de payement", "ID étudiant", "Nom", "Prénom", "Niveau", "Filiere", "Période payée", "Montant" });
        String requete = "SELECT etudiants.E_ID, E_nom, E_prenom, E_niveau, E_filiere, Periode, Montant, Date "
                       + "FROM payement NATURAL JOIN etudiants "
                       + "WHERE E_niveau LIKE 'Bac+_' AND E_filiere IN ('ISI', 'ISRT')";
        
        try ( PreparedStatement statement = connect.BDconnexion.prepareStatement(requete) ){
            try ( ResultSet result = statement.executeQuery() ){
                
                while(result.next()){
                    ID = result.getInt(1);
                    nom = result.getString(2);
                    prenom = result.getString(3);
                    niveau = result.getString(4);
                    filiere = result.getString(5);
                    periode = result.getString(6);
                    montant = result.getFloat(7) + devise;
                    date = result.getDate(8);
                    
                    model.addRow(new Object[] {date, ID, nom, prenom, niveau, filiere, periode, montant});
                    AdminPage.ISIPaymentHistTable.setDefaultRenderer(Object.class, new TableCelleRenderer());
                    AdminPage.ISIPaymentHistTable.setModel(model);
                }
                
            }
        }
    }
    public static void MGEPayementListTable() throws Exception{
        
        connect = new ConnectToBD();
        DefaultTableModel model = new DefaultTableModel(null, new String[] { "Date de payement", "ID étudiant", "Nom", "Prénom", "Niveau", "Filiere", "Période payée", "Montant" });
        String requete = "SELECT etudiants.E_ID, E_nom, E_prenom, E_niveau, E_filiere, Periode, Montant, Date " 
                       + "FROM payement NATURAL JOIN etudiants "
                       + "WHERE E_niveau LIKE 'Bac+_' AND E_filiere IN ('MGE', 'MSTIC', 'FACG')";
        
        try ( PreparedStatement statement = connect.BDconnexion.prepareStatement(requete) ){
            try ( ResultSet result = statement.executeQuery() ){
                
                while(result.next()){
                    ID = result.getInt(1);
                    nom = result.getString(2);
                    prenom = result.getString(3);
                    niveau = result.getString(4);
                    filiere = result.getString(5);
                    periode = result.getString(6);
                    montant = result.getFloat(7) + devise;
                    date = result.getDate(8);
                    
                    model.addRow(new Object[] {date, ID, nom, prenom, niveau, filiere, periode, montant});
                    AdminPage.MGEPaymentHistTable.setDefaultRenderer(Object.class, new TableCelleRenderer());
                    AdminPage.MGEPaymentHistTable.setModel(model);
                }
                
            }
        }
    }
}
