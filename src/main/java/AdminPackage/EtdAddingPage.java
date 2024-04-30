package AdminPackage;

import static ListeEtudiants.EtudiantsListTable.EtudiantsTableContents;
import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.gestion_etudiants.ConnectToBD;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EtdAddingPage extends javax.swing.JFrame {

    ConnectToBD connexion;
    private int Bourse = 20;

    /*
     * @throws Exception
     */
    public EtdAddingPage() throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        LevelLabel = new javax.swing.JLabel();
        FiliereLabel = new javax.swing.JLabel();
        MailLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        FirstNameField = new javax.swing.JTextField();
        FiliereComboBox = new javax.swing.JComboBox<>();
        LevelComboBox = new javax.swing.JComboBox<>();
        MailField = new javax.swing.JTextField();
        AddingBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        AddPayementBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BourseSlider = new javax.swing.JSlider();
        BourseLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Système de Gestion des étudiants");
        setResizable(false);

        NameLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        NameLabel.setText("Nom");

        LastNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LastNameLabel.setText("Prénom");

        LevelLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LevelLabel.setText("Niveau");

        FiliereLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        FiliereLabel.setText("Filiere");

        MailLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MailLabel.setText("Adresse mail");

        NameField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        FirstNameField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        FiliereComboBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        FiliereComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< -- Selectionnez une filiere -- >", "ISI", "ISRT", "MGE", "MSTIC", "FACG" }));

        LevelComboBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LevelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< -- Selectionnez un niveau -- >", "Bac+1", "Bac+2", "Bac+3", "Bac+4", "Bac+5" }));

        MailField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        AddingBtn.setBackground(new java.awt.Color(0, 153, 51));
        AddingBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        AddingBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddingBtn.setText("Ajouter");
        AddingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddingBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setText("Champ obligatoire !");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ajout d'un étudiant");

        AddPayementBtn.setBackground(new java.awt.Color(0, 153, 51));
        AddPayementBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        AddPayementBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddPayementBtn.setText("Paiement");
        AddPayementBtn.setEnabled(false);
        AddPayementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPayementBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Bourse");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        BourseSlider.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BourseSlider.setMajorTickSpacing(10);
        BourseSlider.setMinimum(20);
        BourseSlider.setMinorTickSpacing(5);
        BourseSlider.setPaintLabels(true);
        BourseSlider.setPaintTicks(true);
        BourseSlider.setSnapToTicks(true);
        BourseSlider.setValue(20);
        BourseSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BourseSliderStateChanged(evt);
            }
        });

        BourseLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BourseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(320, 320, 320)
                        .addComponent(LastNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MailField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LevelLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(MailLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(AddingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FirstNameField)
                            .addComponent(FiliereComboBox, 0, 312, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FiliereLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AddPayementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(BourseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BourseSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastNameLabel)
                    .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LevelLabel)
                    .addComponent(FiliereLabel)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiliereComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BourseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MailField)
                    .addComponent(BourseSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddPayementBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isMatch(){
        
        String EtdLevel = (String) LevelComboBox.getSelectedItem();
        String EtdOption = (String) FiliereComboBox.getSelectedItem();
        
        if( (EtdLevel.equals("Bac+1") || EtdLevel.equals("Bac+2") || EtdLevel.equals("Bac+3")) &&
            (EtdOption.equals("ISRT") || EtdOption.equals("MSTIC") || EtdOption.equals("FACG")) ){
            return false;
        }
        else if( (EtdLevel.equals("Bac+4") || EtdLevel.equals("Bac+5")) && EtdOption.equals("MGE") ){
            return false;
        }
        return true;
    }
    
    private void AddingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddingBtnActionPerformed

        try {
            connexion = new ConnectToBD();
        } catch (IOException ex) {
            Logger.getLogger(EtdAddingPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        String EtdLastName = NameField.getText();
        String EtdFirstName = FirstNameField.getText();
        String EtdLevel = (String) LevelComboBox.getSelectedItem();
        String EtdOption = (String) FiliereComboBox.getSelectedItem();
        int EtdBourse = getBourse();
        
        if (EtdLastName.isEmpty() || EtdFirstName.isEmpty() || !isMatch() || getBourse() == 20) {
            if(getBourse() == 20){
                JOptionPane.showMessageDialog(null, "Bourse non choisie !", "Attention", JOptionPane.OK_OPTION);
            }
            else{
                JOptionPane.showMessageDialog(null, "Les données sont invalides !");
            }
            
        }else {
            String requete = "INSERT INTO etudiants (E_nom, E_prenom, E_niveau, E_filiere, E_mail, E_bourse) VALUES (?, ?, ?, ?, ?, ?)";
            try ( PreparedStatement statement = connexion.BDconnexion.prepareStatement(requete, ResultSet.TYPE_SCROLL_SENSITIVE)) {

                statement.setString(1, EtdLastName);
                statement.setString(2, EtdFirstName);
                statement.setString(3, EtdLevel);
                statement.setString(4, EtdOption);
                statement.setString(5, MailField.getText());
                statement.setFloat(6, EtdBourse);
                statement.executeUpdate();

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
                
                AddPayementBtn.setEnabled(true);
                
                NameField.setText("");
                FirstNameField.setText("");
                MailField.setText("");
                LevelComboBox.setSelectedIndex(0);
                FiliereComboBox.setSelectedIndex(0);
                BourseSlider.setValue(20);
                BourseLabel.setText("");
                
                JOptionPane.showMessageDialog(null, "Etudiant ajouté avec succes !", "Confirmation", JOptionPane.OK_OPTION);

            } catch (Exception ex) {}

        }
    }//GEN-LAST:event_AddingBtnActionPerformed

    private void AddPayementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPayementBtnActionPerformed
        AddPayementBtn.setEnabled(false);
        try {
            Payement paiement = new Payement();
            connexion = new ConnectToBD();
            String requete = "SELECT E_ID, E_nom, E_prenom, E_niveau, E_filiere FROM etudiants ORDER BY E_ID DESC LIMIT 1";
            try ( Statement statement =  connexion.BDconnexion.createStatement()){
                try ( ResultSet result = statement.executeQuery(requete) ){
                    if(result.next()){
                        Payement.PayementEtdIDField.setText(result.getInt(1) + "");
                        Payement.PayementEtdNameField.setText(result.getString(2));
                        Payement.PayementEtdPrenomField.setText(result.getString(3));
                        Payement.PayementLevelField.setText(result.getString(4));
                        Payement.PayementOptionField.setText(result.getString(5));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(EtdAddingPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            paiement.setVisible(true);
        } catch (IOException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EtdAddingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddPayementBtnActionPerformed

    private void BourseSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BourseSliderStateChanged
        Bourse = BourseSlider.getValue();
        BourseLabel.setText(Bourse + "%");
    }//GEN-LAST:event_BourseSliderStateChanged

    private int getBourse(){
        return Bourse;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton AddPayementBtn;
    private javax.swing.JButton AddingBtn;
    private javax.swing.JLabel BourseLabel;
    private javax.swing.JSlider BourseSlider;
    private javax.swing.JComboBox<String> FiliereComboBox;
    private javax.swing.JLabel FiliereLabel;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JComboBox<String> LevelComboBox;
    private javax.swing.JLabel LevelLabel;
    private javax.swing.JTextField MailField;
    private javax.swing.JLabel MailLabel;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
