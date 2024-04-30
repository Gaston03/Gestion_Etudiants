package AdminPackage;

import static ListeEtudiants.EtdPayementListTable.ISIPayementListTable;
import static ListeEtudiants.EtdPayementListTable.MGEPayementListTable;
import static ListeEtudiants.EtudiantsListTable.EtudiantsTableContents;
import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.gestion_etudiants.ConnectToBD;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AdMin
 */
public class EtudiantInformation extends javax.swing.JFrame {

    private static ConnectToBD connexion;
    private static String devise = " dh";
    private static Float Inscription = 3000f;
    private static Float NAnnuel = 30000f;
    private static int Bourse;
    private static Float Annuel;
    private static Float Mensuel;

    /**
     * Creates new form EtudiantInformation
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public EtudiantInformation() throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private static void RemplirEtdPaiementInfo(String text, Float total){
        
        switch (text) {
            case "Inscription" -> {
                InsPaid.setText(total + devise);
                InsRest.setText((Inscription - total) + devise);
            }
            case "Octobre" -> {
                OctPaid.setText(total + devise);
                OctRest.setText((Mensuel - total) + devise);
            }

            case "Novembre" -> {
                NovPaid.setText(total + devise);
                NovRest.setText((Mensuel - total) + devise);
            }
            case "Décembre" -> {
                DecPaid.setText(total + devise);
                DecRest.setText((Mensuel - total) + devise);
            }
            case "Janvier" -> {
                JanvPaid.setText(total + devise);
                JanvRest.setText((Mensuel - total) + devise);
            }
            case "Février" -> {
                FevPaid.setText(total + devise);
                FevRest.setText((Mensuel - total) + devise);
            }
            case "Mars" -> {
                MarsPaid.setText(total + devise);
                MarsRest.setText((Mensuel - total) + devise);
            }
            case "Avril" -> {
                AprilPaid.setText(total + devise);
                AprilRest.setText((Mensuel - total) + devise);
            }
            case "Mai" -> {
                MayPaid.setText(total + devise);
                MayRest.setText((Mensuel - total) + devise);
            }
            case "Juin" -> {
                JunePaid.setText(total + devise);
                JuneRest.setText((Mensuel - total) + devise);
            }
            case "Juillet" -> {
                JulPaid.setText(total + devise);
                JulRest.setText((Mensuel - total) + devise);
            }
            default -> {
                break;
            }
        }
        
    }
    public static void InfoEtudiant(int RowNum, JTable table) throws Exception{
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        connexion = new ConnectToBD();
        String requete1 = "SELECT * FROM etudiants where E_ID = ?";
        String requete2 = "SELECT Periode, SUM(Montant) FROM payement where E_ID = ? group by E_ID, Periode";
        String EtdID = model.getValueAt(RowNum, 0).toString();
        try ( PreparedStatement statement1 = connexion.BDconnexion.prepareStatement(requete1); PreparedStatement statement2 = connexion.BDconnexion.prepareStatement(requete2) ){
            statement1.setInt(1, Integer.parseInt(EtdID));
            statement2.setInt(1, Integer.parseInt(EtdID));
            try ( ResultSet result1 = statement1.executeQuery(); ResultSet result2 = statement2.executeQuery() ){
                if(result1.next()){
                    Bourse = result1.getInt(7);
                    Annuel = NAnnuel * (1 - (Bourse/100f));
                    Mensuel = Annuel / 10;
                    InfoIDField.setText(result1.getInt(1) + "");
                    InfoLastNameField.setText(result1.getString(2));
                    InfoFirstNameField.setText(result1.getString(3));
                    InfomailField.setText(result1.getString(4));
                    InfoLevelField.setText(result1.getString(5));
                    InfoOptionField.setText(result1.getString(6));
                    BourseLabel.setText(Bourse + "%");
                    MensualLabel.setText(Mensuel + devise);
                    AnnualLabel.setText(Annuel + devise);
                }
                while(result2.next()){
                    String Periode = result2.getString(1);
                    Float Total = result2.getFloat(2);
                    RemplirEtdPaiementInfo(Periode, Total);
                }
            }
        }
    }
    public static void RemoveEtudiant(JTable table){
        int RowNum = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(RowNum);
    }
    private static void RemoveEtdISIPayementData(int EtdID){
        DefaultTableModel model = (DefaultTableModel) AdminPage.ISIPaymentHistTable.getModel();
        if(model.getRowCount() > 0){
            for (int i = 0; i < model.getRowCount();) {
                String CellValue = model.getValueAt(i, 1).toString();
                if (CellValue.equals(EtdID + "")) {
                    model.removeRow(i);
                    if (model.getRowCount() == 0) {
                        return;
                    }
                } else {
                    i++;
                }
            }
        }
        
    }
    private static void RemoveEtdMGEPayementData(int EtdID){
        DefaultTableModel model = (DefaultTableModel) AdminPage.MGEPaymentHistTable.getModel();
        if(model.getRowCount() > 0){
            for (int i = 0; i < model.getRowCount();) {
                String CellValue = model.getValueAt(i, 1).toString();
                if (CellValue.equals(EtdID + "")) {
                    model.removeRow(i);
                    if (model.getRowCount() == 0) {
                        return;
                    }
                } else {
                    i++;
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        InfoIDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        InfoLastNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        InfoLevelField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        InfomailField = new javax.swing.JTextField();
        InfoFirstNameField = new javax.swing.JTextField();
        InfoOptionField = new javax.swing.JTextField();
        InfoValidateBtn = new javax.swing.JButton();
        FiliereList = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        InsPaid = new javax.swing.JTextField();
        InsRest = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        OctPaid = new javax.swing.JTextField();
        OctRest = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        NovPaid = new javax.swing.JTextField();
        NovRest = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        DecPaid = new javax.swing.JTextField();
        DecRest = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        JanvPaid = new javax.swing.JTextField();
        JanvRest = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        FevPaid = new javax.swing.JTextField();
        FevRest = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        MarsPaid = new javax.swing.JTextField();
        MarsRest = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        AprilPaid = new javax.swing.JTextField();
        AprilRest = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        MayPaid = new javax.swing.JTextField();
        MayRest = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        JunePaid = new javax.swing.JTextField();
        JuneRest = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        JulPaid = new javax.swing.JTextField();
        JulRest = new javax.swing.JTextField();
        JPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        BourseLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        MensualLabel = new javax.swing.JLabel();
        AnnualLabel = new javax.swing.JLabel();
        Jlabel = new javax.swing.JLabel();
        EditEtdInfoBtn = new javax.swing.JButton();
        DeleteEtdInfoBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        AddPaiementBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Système de Gestion des étudiants");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("ID de l'étudiant");

        InfoIDField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InfoIDField.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Adresse mail");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Nom");

        InfoLastNameField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InfoLastNameField.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Prénom");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Niveau");

        InfoLevelField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InfoLevelField.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Filière");

        InfomailField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InfomailField.setEnabled(false);

        InfoFirstNameField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InfoFirstNameField.setEnabled(false);

        InfoOptionField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InfoOptionField.setEnabled(false);

        InfoValidateBtn.setBackground(new java.awt.Color(0, 153, 51));
        InfoValidateBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        InfoValidateBtn.setForeground(new java.awt.Color(255, 255, 255));
        InfoValidateBtn.setText("Valider les modifications");
        InfoValidateBtn.setEnabled(false);
        InfoValidateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoValidateBtnActionPerformed(evt);
            }
        });

        FiliereList.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(InfoValidateBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InfoLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InfoLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InfoFirstNameField)
                            .addComponent(InfoOptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(InfoIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InfomailField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(FiliereList, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InfoIDField)
                    .addComponent(InfomailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InfoFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(InfoLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InfoOptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InfoLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FiliereList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(InfoValidateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Informations Générales", jPanel2);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Inscription :");

        InsPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InsPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        InsPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        InsPaid.setEnabled(false);

        InsRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InsRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        InsRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        InsRest.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Octobre :");

        OctPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        OctPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        OctPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        OctPaid.setEnabled(false);

        OctRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        OctRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        OctRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        OctRest.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Novembre :");

        NovPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NovPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NovPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        NovPaid.setEnabled(false);

        NovRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NovRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NovRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        NovRest.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Décembre :");

        DecPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DecPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DecPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        DecPaid.setEnabled(false);

        DecRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DecRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DecRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        DecRest.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Janvier :");

        JanvPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JanvPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JanvPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        JanvPaid.setEnabled(false);

        JanvRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JanvRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JanvRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        JanvRest.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Février :");

        FevPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        FevPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FevPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        FevPaid.setEnabled(false);

        FevRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        FevRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FevRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        FevRest.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Mars :");

        MarsPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        MarsPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MarsPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        MarsPaid.setEnabled(false);

        MarsRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        MarsRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MarsRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        MarsRest.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Avril :");

        AprilPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AprilPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AprilPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        AprilPaid.setEnabled(false);

        AprilRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AprilRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AprilRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        AprilRest.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Mai :");

        MayPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        MayPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MayPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        MayPaid.setEnabled(false);

        MayRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        MayRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MayRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        MayRest.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Juin :");

        JunePaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JunePaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JunePaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        JunePaid.setEnabled(false);

        JuneRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JuneRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JuneRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        JuneRest.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Juillet :");

        JulPaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JulPaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JulPaid.setBorder(javax.swing.BorderFactory.createTitledBorder("Payé"));
        JulPaid.setEnabled(false);

        JulRest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JulRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JulRest.setBorder(javax.swing.BorderFactory.createTitledBorder("Reste"));
        JulRest.setEnabled(false);

        JPanel.setBackground(new java.awt.Color(0, 153, 51));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Bourse :");

        BourseLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BourseLabel.setForeground(new java.awt.Color(255, 255, 255));
        BourseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Mensualité :");

        MensualLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        MensualLabel.setForeground(new java.awt.Color(255, 255, 255));
        MensualLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        AnnualLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        AnnualLabel.setForeground(new java.awt.Color(255, 255, 255));
        AnnualLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Jlabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Jlabel.setForeground(new java.awt.Color(255, 255, 255));
        Jlabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Jlabel.setText("Annuel :");

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BourseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MensualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnnualLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addComponent(BourseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MensualLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AnnualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DecPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DecRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JunePaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JuneRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OctPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OctRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AprilPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AprilRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NovPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NovRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MayPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MayRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JanvPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JanvRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JulPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JulRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FevPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FevRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InsPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InsRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MarsPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MarsRest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(JPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InsPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InsRest)
                    .addComponent(MarsPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MarsRest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OctPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OctRest)
                    .addComponent(AprilPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AprilRest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NovRest)
                    .addComponent(MayPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MayRest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DecPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DecRest)
                    .addComponent(JunePaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JuneRest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JanvPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JanvRest)
                    .addComponent(JulPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JulRest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FevPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FevRest))
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Informations Financières", jPanel1);

        EditEtdInfoBtn.setBackground(new java.awt.Color(242, 242, 242));
        EditEtdInfoBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\AdMin\\OneDrive\\Documents\\NetBeansProjects\\Gestion_Etudiants\\src\\main\\java\\Images\\edit_user.png")); // NOI18N
        EditEtdInfoBtn.setToolTipText("Modifier les données de l'étudiant");
        EditEtdInfoBtn.setBorder(null);
        EditEtdInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditEtdInfoBtnActionPerformed(evt);
            }
        });

        DeleteEtdInfoBtn.setBackground(new java.awt.Color(242, 242, 242));
        DeleteEtdInfoBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\AdMin\\OneDrive\\Documents\\NetBeansProjects\\Gestion_Etudiants\\src\\main\\java\\Images\\Delete.png")); // NOI18N
        DeleteEtdInfoBtn.setToolTipText("Supprimer les données de l'étudiant");
        DeleteEtdInfoBtn.setBorder(null);
        DeleteEtdInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEtdInfoBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        AddPaiementBtn.setBackground(new java.awt.Color(242, 242, 242));
        AddPaiementBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\AdMin\\OneDrive\\Documents\\NetBeansProjects\\Gestion_Etudiants\\src\\main\\java\\Images\\ajouter_payement.png")); // NOI18N
        AddPaiementBtn.setToolTipText("Ajouter un paiement de l'étudiant");
        AddPaiementBtn.setBorder(null);
        AddPaiementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPaiementBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EditEtdInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteEtdInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddPaiementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(DeleteEtdInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EditEtdInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(AddPaiementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditEtdInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditEtdInfoBtnActionPerformed
        InfomailField.setEnabled(true);
        InfoLastNameField.setEnabled(true);
        InfoFirstNameField.setEnabled(true);
        InfoLevelField.setEnabled(true);
        InfoOptionField.setEnabled(true);
        InfoValidateBtn.setEnabled(true);
        FiliereList.setText("ISI, ISRT, MGE, MSTIC, FACG");
    }//GEN-LAST:event_EditEtdInfoBtnActionPerformed

    private void DeleteEtdInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEtdInfoBtnActionPerformed

        try {
            connexion = new ConnectToBD();
        } catch (IOException ex) {
            Logger.getLogger(EtdAddingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String EtdLastName = InfoLastNameField.getText();
        String EtdFirstName = InfoFirstNameField.getText();
        String EtdOption = InfoOptionField.getText();
        int EtdID = Integer.parseInt(InfoIDField.getText());

        int rep = JOptionPane.showConfirmDialog(null, "Souhaitez-vous vraiment supprimer " + EtdFirstName + " " + EtdLastName + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(rep == JOptionPane.YES_OPTION){
            
            String requete1 = "DELETE FROM etudiants where E_ID = ?";
            String requete2 = "DELETE FROM payement where E_ID = ?";
            try ( PreparedStatement statement1 = connexion.BDconnexion.prepareStatement(requete1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  PreparedStatement statement2 = connexion.BDconnexion.prepareStatement(requete2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

                statement1.setInt(1, EtdID);
                statement2.setInt(1, EtdID);
                statement1.executeUpdate();
                statement2.executeUpdate();

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

                RemoveEtudiant(AdminPage.getTableClicked());
                DeleteEtdPaymentTableRow(EtdOption, EtdID);

                dispose();

                JOptionPane.showMessageDialog(null, "Etudiant supprimé avec succes !", "Confirmation", JOptionPane.OK_OPTION);

            } catch (SQLException ex) {} catch (Exception ex) {}
            
        }
    }//GEN-LAST:event_DeleteEtdInfoBtnActionPerformed

    private void InfoValidateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoValidateBtnActionPerformed

        try {
            connexion = new ConnectToBD();
        } catch (IOException ex) {
            Logger.getLogger(EtdAddingPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        String EtdLastName = InfoLastNameField.getText();
        String EtdFirstName = InfoFirstNameField.getText();
        String EtdLevel = InfoLevelField.getText();
        String EtdOption = InfoOptionField.getText();
        int EtdID = Integer.parseInt(InfoIDField.getText());

        if (EtdLastName.isEmpty() || EtdFirstName.isEmpty() || EtdLevel.isEmpty() || EtdOption.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir tous les champs obligatoires !");
        } else {
            String requete = "UPDATE etudiants "
                    + "SET E_nom = ?, E_prenom = ?, E_niveau = ?, E_filiere = ?, E_mail = ? "
                    + "where E_ID = ?";
            try ( PreparedStatement statement = connexion.BDconnexion.prepareStatement(requete, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

                statement.setString(1, EtdLastName);
                statement.setString(2, EtdFirstName);
                statement.setString(3, EtdLevel);
                statement.setString(4, EtdOption);
                statement.setString(5, InfomailField.getText());
                statement.setInt(6, Integer.parseInt(InfoIDField.getText()));
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

                ISIPayementListTable();
                MGEPayementListTable();
                EtudiantsTableContents();

                InfomailField.setEnabled(false);
                InfoLastNameField.setEnabled(false);
                InfoFirstNameField.setEnabled(false);
                InfoLevelField.setEnabled(false);
                InfoOptionField.setEnabled(false);
                InfoValidateBtn.setEnabled(false);
                FiliereList.setText("");

                JOptionPane.showMessageDialog(null, "Données modifiées avec succes !", "Confirmation", JOptionPane.OK_OPTION);

            } catch (Exception ex) {
            }

        }

    }//GEN-LAST:event_InfoValidateBtnActionPerformed

    private void AddPaiementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPaiementBtnActionPerformed
        try {
            Payement paiement = new Payement();
            connexion = new ConnectToBD();
            String requete = "SELECT E_ID, E_nom, E_prenom, E_niveau, E_filiere FROM etudiants WHERE E_ID = ?";
            try ( PreparedStatement statement =  connexion.BDconnexion.prepareStatement(requete)){
                statement.setInt(1, Integer.parseInt(InfoIDField.getText()));
                try ( ResultSet result = statement.executeQuery() ){
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
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EtdAddingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddPaiementBtnActionPerformed

    public static void DeleteEtdPaymentTableRow(String option, int EtdID){
        
        switch (option) {
            case "ISI" -> {
                RemoveEtdISIPayementData(EtdID);
                break;
            }
            case "MGE" -> {
                RemoveEtdMGEPayementData(EtdID);
                break;
            }
            case "ISRT" -> {
                RemoveEtdISIPayementData(EtdID);
                break;
            }
            case "MSTIC" -> {
                RemoveEtdMGEPayementData(EtdID);
                break;
            }
            case "FACG" -> {
                RemoveEtdMGEPayementData(EtdID);
                break;
            }
            default -> {
                break;
            }
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPaiementBtn;
    private static javax.swing.JLabel AnnualLabel;
    private static javax.swing.JTextField AprilPaid;
    private static javax.swing.JTextField AprilRest;
    private static javax.swing.JLabel BourseLabel;
    private static javax.swing.JTextField DecPaid;
    private static javax.swing.JTextField DecRest;
    private javax.swing.JButton DeleteEtdInfoBtn;
    private javax.swing.JButton EditEtdInfoBtn;
    private static javax.swing.JTextField FevPaid;
    private static javax.swing.JTextField FevRest;
    private javax.swing.JLabel FiliereList;
    private static javax.swing.JTextField InfoFirstNameField;
    private static javax.swing.JTextField InfoIDField;
    private static javax.swing.JTextField InfoLastNameField;
    private static javax.swing.JTextField InfoLevelField;
    private static javax.swing.JTextField InfoOptionField;
    private javax.swing.JButton InfoValidateBtn;
    private static javax.swing.JTextField InfomailField;
    private static javax.swing.JTextField InsPaid;
    private static javax.swing.JTextField InsRest;
    private javax.swing.JPanel JPanel;
    private static javax.swing.JTextField JanvPaid;
    private static javax.swing.JTextField JanvRest;
    private javax.swing.JLabel Jlabel;
    private static javax.swing.JTextField JulPaid;
    private static javax.swing.JTextField JulRest;
    private static javax.swing.JTextField JunePaid;
    private static javax.swing.JTextField JuneRest;
    private static javax.swing.JTextField MarsPaid;
    private static javax.swing.JTextField MarsRest;
    private static javax.swing.JTextField MayPaid;
    private static javax.swing.JTextField MayRest;
    private static javax.swing.JLabel MensualLabel;
    private static javax.swing.JTextField NovPaid;
    private static javax.swing.JTextField NovRest;
    private static javax.swing.JTextField OctPaid;
    private static javax.swing.JTextField OctRest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
