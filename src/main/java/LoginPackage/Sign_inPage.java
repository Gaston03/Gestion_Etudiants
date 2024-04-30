package LoginPackage;
import com.mycompany.gestion_etudiants.ConnectToBD;

import com.formdev.flatlaf.FlatLightLaf;
import java.sql.PreparedStatement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Sign_inPage extends javax.swing.JFrame {
    
    ConnectToBD connexion;
    
    
    public Sign_inPage() throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel( new FlatLightLaf() );
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sign_inLabel = new javax.swing.JLabel();
        Separator1 = new javax.swing.JSeparator();
        sign_inNameLabel = new javax.swing.JLabel();
        sign_inNameField = new javax.swing.JTextField();
        sign_inPrenomLabel = new javax.swing.JLabel();
        sign_inPrenomField = new javax.swing.JTextField();
        sign_inUserNameLabel = new javax.swing.JLabel();
        sign_inUserNameField = new javax.swing.JTextField();
        sign_inPasswordLabel = new javax.swing.JLabel();
        sign_inPasswordField = new javax.swing.JPasswordField();
        sign_inPConfirmLabel = new javax.swing.JLabel();
        sign_inPConfirmField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sign_inValidateBtn1 = new javax.swing.JButton();
        confirmmsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Système de Gestion des étudiants");
        setResizable(false);

        Sign_inLabel.setBackground(new java.awt.Color(0, 0, 255));
        Sign_inLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Sign_inLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Sign_inLabel.setText("Inscription");

        sign_inNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sign_inNameLabel.setText("Nom");

        sign_inNameField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        sign_inPrenomLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sign_inPrenomLabel.setText("Prénom");

        sign_inPrenomField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        sign_inUserNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sign_inUserNameLabel.setText("Nom d'utilisateur");

        sign_inUserNameField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        sign_inPasswordLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sign_inPasswordLabel.setText("Mot de passe");

        sign_inPasswordField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        sign_inPConfirmLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sign_inPConfirmLabel.setText("Confirmer votre mot de passe");

        sign_inPConfirmField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 0, 0));
        jLabel1.setText("*");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(246, 0, 0));
        jLabel2.setText("*");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(246, 0, 0));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(246, 0, 0));
        jLabel4.setText("*");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(246, 0, 0));
        jLabel5.setText("*");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel7.setText("Champ obligatoire !");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        sign_inValidateBtn1.setBackground(new java.awt.Color(0, 153, 51));
        sign_inValidateBtn1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sign_inValidateBtn1.setForeground(new java.awt.Color(255, 255, 255));
        sign_inValidateBtn1.setText("Valider");
        sign_inValidateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_inValidateBtn1ActionPerformed(evt);
            }
        });

        confirmmsLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Separator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Sign_inLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sign_inNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(345, 345, 345)
                                .addComponent(sign_inPrenomLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sign_inNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sign_inUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sign_inUserNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)))
                                .addGap(66, 66, 66)
                                .addComponent(sign_inPrenomField, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sign_inPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sign_inPasswordLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sign_inPConfirmField, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sign_inPConfirmLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(confirmmsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sign_inValidateBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Sign_inLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sign_inNameLabel)
                    .addComponent(sign_inPrenomLabel)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sign_inNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sign_inPrenomField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sign_inUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sign_inUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sign_inPConfirmLabel)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sign_inPConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sign_inPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sign_inPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmmsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sign_inValidateBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String Passwordhashing(String password) throws NoSuchAlgorithmException{
        
        MessageDigest message = MessageDigest.getInstance("SHA-256");
        message.reset();
        
        byte[] resultByte = message.digest(password.getBytes());
        
        StringBuilder sb = new StringBuilder();
        
        for(byte b: resultByte){
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
        
    }
    
    private void sign_inValidateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_inValidateBtn1ActionPerformed
        
        try {
            connexion = new ConnectToBD();
            String LastName = sign_inNameField.getText();
            String FirstName = sign_inPrenomField.getText();
            String UserName = sign_inUserNameField.getText();
            String password = new String(sign_inPasswordField.getPassword());
            String PConfirm = new String(sign_inPConfirmField.getPassword());
            if(LastName.isEmpty() || FirstName.isEmpty() || UserName.isEmpty() || password.isEmpty() || PConfirm.isEmpty()){
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs !");
            }
            else{
                String requete = "INSERT INTO administrateur (A_username, A_nom, A_prenom, A_password) VALUES (?, ?, ?, ?)";
                try ( PreparedStatement statement = connexion.BDconnexion.prepareStatement(requete)) {
                    
                    statement.setString(1, sign_inUserNameField.getText());
                    statement.setString(2, sign_inNameField.getText());
                    statement.setString(3, sign_inPrenomField.getText());
                    
                    if (password.equals(PConfirm)) {
                        statement.setString(4, Passwordhashing(password));
                        confirmmsLabel.setText("");
                    } else {
                        confirmmsLabel.setText("Les deux mots de passe ne correspondent pas !");
                        return;
                    }
                    statement.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Administrateur ajouté avec succes !", "Confirmation", JOptionPane.OK_OPTION);
                    
                } catch (SQLException ex) {}
                catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Sign_inPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {}
        
    }//GEN-LAST:event_sign_inValidateBtn1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separator1;
    private javax.swing.JLabel Sign_inLabel;
    private javax.swing.JLabel confirmmsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField sign_inNameField;
    private javax.swing.JLabel sign_inNameLabel;
    private javax.swing.JPasswordField sign_inPConfirmField;
    private javax.swing.JLabel sign_inPConfirmLabel;
    private javax.swing.JPasswordField sign_inPasswordField;
    private javax.swing.JLabel sign_inPasswordLabel;
    private javax.swing.JTextField sign_inPrenomField;
    private javax.swing.JLabel sign_inPrenomLabel;
    private javax.swing.JTextField sign_inUserNameField;
    private javax.swing.JLabel sign_inUserNameLabel;
    private javax.swing.JButton sign_inValidateBtn1;
    // End of variables declaration//GEN-END:variables
}
