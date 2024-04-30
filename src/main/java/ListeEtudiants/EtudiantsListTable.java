/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListeEtudiants;

import AdminPackage.AdminPage;
import com.mycompany.gestion_etudiants.ConnectToBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AdMin
 */
public class EtudiantsListTable {

    static ConnectToBD connect;
    private static int ID;
    private static int bourse;
    private static String nom = null;
    private static String prenom = null;
    private static String email = null;
    private static String niveau = null;
    private static String filiere = null;
    private static ArrayList<JTable> TableList = new ArrayList<>();
    private static String requete;
    private static String requete1 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+1' AND E_filiere = 'ISI'";
    private static String requete2 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+2' AND E_filiere = 'ISI'";
    private static String requete3 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+3' AND E_filiere = 'ISI'";
    private static String requete4 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+4' AND E_filiere IN ('ISI', 'ISRT')";
    private static String requete5 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+5' AND E_filiere IN ('ISI', 'ISRT')";
    private static String requete6 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+1' AND E_filiere = 'MGE'";
    private static String requete7 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+2' AND E_filiere = 'MGE'";
    private static String requete8 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+3' AND E_filiere = 'MGE'";
    private static String requete9 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+4' AND E_filiere IN ('MSTIC', 'FACG')";
    private static String requete10 = "SELECT * FROM etudiants WHERE E_niveau = 'Bac+5' AND E_filiere IN ('MSTIC', 'FACG')";

    public static void EtudiantsTableContents() throws Exception {
        TableList.add(AdminPage.ISI1EtdListTable);
        TableList.add(AdminPage.ISI2EtdListTable);
        TableList.add(AdminPage.ISI3EtdListTable);
        TableList.add(AdminPage.ISI4EtdListTable);
        TableList.add(AdminPage.ISI5EtdListTable);
        TableList.add(AdminPage.MGE1EtdListTable);
        TableList.add(AdminPage.MGE2EtdListTable);
        TableList.add(AdminPage.MGE3EtdListTable);
        TableList.add(AdminPage.MGE4EtdListTable);
        TableList.add(AdminPage.MGE5EtdListTable);

        for (JTable table : TableList) {

            connect = new ConnectToBD();
            DefaultTableModel model = new DefaultTableModel(null, new String[]{"ID étudiant", "Nom", "Prénom", "Adresse mail", "Niveau", "Filiere", "Bourse"});

            switch (TableList.indexOf(table)) {
                case 0 ->
                    requete = requete1;
                case 1 ->
                    requete = requete2;
                case 2 ->
                    requete = requete3;
                case 3 ->
                    requete = requete4;
                case 4 ->
                    requete = requete5;
                case 5 ->
                    requete = requete6;
                case 6 ->
                    requete = requete7;
                case 7 ->
                    requete = requete8;
                case 8 ->
                    requete = requete9;
                case 9 ->
                    requete = requete10;
                default -> {
                    break;
                }
            }

            try ( PreparedStatement statement = connect.BDconnexion.prepareStatement(requete)) {
                try ( ResultSet result = statement.executeQuery()) {

                    while (result.next()) {
                        ID = result.getInt("E_ID");
                        nom = result.getString("E_nom");
                        prenom = result.getString("E_prenom");
                        email = result.getString("E_mail");
                        niveau = result.getString("E_niveau");
                        filiere = result.getString("E_filiere");
                        bourse = result.getInt("E_bourse");

                        model.addRow(new Object[]{ID, nom, prenom, email, niveau, filiere, bourse + "%"});
                        table.setDefaultRenderer(Object.class, new TableCelleRenderer());
                        table.setModel(model);

                    }

                }
            }

        }
    }

}
