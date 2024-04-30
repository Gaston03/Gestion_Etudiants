package LoginPackage;
import AdminPackage.AdminPage;
import static ListeEtudiants.EtdPayementListTable.*;
import static ListeEtudiants.EtudiantsListTable.EtudiantsTableContents;
import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.gestion_etudiants.ConnectToBD;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginPage extends javax.swing.JFrame {

    public LoginPage() throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel( new FlatLightLaf() );
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AuthentLabel = new javax.swing.JLabel();
        Separator = new javax.swing.JSeparator();
        UserNameLabel = new javax.swing.JLabel();
        UserNameField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        PasswordField = new javax.swing.JPasswordField();
        sign_inBtn = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Système de Gestion des étudiants");
        setResizable(false);

        AuthentLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        AuthentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AuthentLabel.setText("Authentification");

        UserNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        UserNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UserNameLabel.setText("Nom d'utilisateur :");

        UserNameField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        PasswordLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PasswordLabel.setText("Mot de passe :");

        LoginBtn.setBackground(new java.awt.Color(0, 153, 51));
        LoginBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Connexion");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        sign_inBtn.setBackground(new java.awt.Color(0, 153, 51));
        sign_inBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sign_inBtn.setForeground(new java.awt.Color(255, 255, 255));
        sign_inBtn.setText("S'inscrire en tant qu'Admin");
        sign_inBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_inBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuthentLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Separator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UserNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(LoginBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sign_inBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(UserNameField)
                        .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AuthentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sign_inBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed

        try {
            ConnectToBD connexion = null;
            connexion = new ConnectToBD();
            
            String password = new String(PasswordField.getPassword());
            if (UserNameField.getText().isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
            } else {
                String requete = "SELECT * FROM administrateur WHERE A_username = ? AND A_password = ?";
                try ( PreparedStatement statement = connexion.BDconnexion.prepareStatement(requete);) {
                    
                    statement.setString(1, UserNameField.getText());
                    statement.setString(2, Sign_inPage.Passwordhashing(password));
                    try ( ResultSet result = statement.executeQuery()) {
                        if (result.isBeforeFirst()) {
                            if (result.next()) {
                                this.dispose();
                                try {
                                    String Nom = result.getString(2);
                                    String Prenom = result.getString(3);
                                    
                                    AdminPage admin = new AdminPage();
                                    AdminPage.AdminNameLabel.setText(Nom + " " + Prenom);
                                    AdminPage.ISI1EtdTotalResult.setText(AdminPage.NombreEtudiantsISI1() + "");
                                    AdminPage.ISI2EtdTotalResult.setText(AdminPage.NombreEtudiantsISI2() + "");
                                    AdminPage.ISI3EtdTotalResult.setText(AdminPage.NombreEtudiantsISI3() + "");
                                    AdminPage.ISI4EtdTotalResult.setText(AdminPage.NombreEtudiantsISI4() + "");
                                    AdminPage.ISI5EtdTotalResult.setText(AdminPage.NombreEtudiantsISI5() + "");
                                    AdminPage.MGE1EtdTotalResult.setText(AdminPage.NombreEtudiantsMGE1() + "");
                                    AdminPage.MGE2EtdTotalResult.setText(AdminPage.NombreEtudiantsMGE2() + "");
                                    AdminPage.MGE3EtdTotalResult.setText(AdminPage.NombreEtudiantsMGE3() + "");
                                    AdminPage.MGE4EtdTotalResult.setText(AdminPage.NombreEtudiantsMGE4() + "");
                                    AdminPage.MGE5EtdTotalResult.setText(AdminPage.NombreEtudiantsMGE5() + "");
                                    
                                    EtudiantsTableContents();
                                    
                                    ISIPayementListTable();
                                    MGEPayementListTable();
                                    
                                    admin.setVisible(true);
                                } catch (Exception ex) {
                                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Les données saisies sont incorrectes !");
                        }
                    } catch (SQLException ex) {}
                } catch (SQLException ex) {} 
                catch (NoSuchAlgorithmException ex) {}
            }
        } catch (IOException ex) {}
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void sign_inBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_inBtnActionPerformed
        try {
            Sign_inPage minscrire = new Sign_inPage();
            minscrire.setLocationRelativeTo(null);
            minscrire.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sign_inBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AuthentLabel;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JSeparator Separator;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton sign_inBtn;
    // End of variables declaration//GEN-END:variables

    private PreparedStatement prepareStatement(String requete) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
