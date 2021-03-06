/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.formdev.flatlaf.FlatLightLaf;
import dao.CardDAO;
import entity.Card;
import helper.AuthUser;
import helper.MsgHelper;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author balis
 */
public class addCardJDialog extends javax.swing.JDialog {

    CardDAO cardDAO = new CardDAO();
    MainJFrame main = new MainJFrame();
    Object[] cardNames = {"Agribank", "Sacombank", "Techcombank", "MBBank"};
    MainJFrame mainJFrame;

    /**
     * Creates new form addCardJDialog
     */
    public addCardJDialog(MainJFrame parent, boolean modal) {
        super(parent, modal);
        mainJFrame = parent;
        initComponents();
        fillCardComboBox();
        setLocationRelativeTo(parent);
        setTitle("Add card");
    }

    private void fillCardComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboBankName.getModel();
        model.removeAllElements();
        for (var e : cardNames) {
            model.addElement(e);
        }
    }

    private void insertCard() {
        Card card = getCardForm();
        String cardNumber = txtCardNumber.getText();
        String cardHolder = txtCardHolderName.getText();
        String PIN = new String(txtPIN.getPassword());
        String billingAddress = txtBillingAddress.getText();
        if (cardNumber.length() != 16) {
            MsgHelper.alert(this, "Card number must have length of 16!");
        } else if (cardHolder.length() == 0) {
            MsgHelper.alert(this, "Card holder name must not be empty!");
        } else if (PIN.length() != 6) {
            MsgHelper.alert(this, "PIN must have length of 6!");
        } else if (billingAddress.length() == 0) {
            MsgHelper.alert(this, "Billing address must not be empty!");
        } else if (txtExpirationDate.getDate() == null) {
            MsgHelper.alert(this, "Expiration date must not be empty!");
        } else {
            try {
                cardDAO.insert(card);
                mainJFrame.initCard();
                mainJFrame.initDashboard();
                MsgHelper.alert(this, "Add card successfully!");
                this.dispose();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Card getCardForm() {
        Card card = new Card();
        card.setPIN(new String(txtPIN.getPassword()));
        card.setCardName((String) cboBankName.getSelectedItem());
        card.setCardNumber(txtCardNumber.getText());
        card.setCardHolderName(txtCardHolderName.getText());
        card.setExpirationDate(txtExpirationDate.getDate());
        card.setOmegaAccount(AuthUser.user.getOmegaAccount());
        card.setBillingAddress(txtBillingAddress.getText());
        // cho so du tai khoan card mac dinh la 100.000.000 VND
        card.setCardBalance(100000000);
        return card;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        pnlMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtCardNumber = new javax.swing.JTextField();
        cboBankName = new javax.swing.JComboBox<>();
        txtCardHolderName = new javax.swing.JTextField();
        txtBillingAddress = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPIN = new javax.swing.JPasswordField();
        txtExpirationDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ADD NEW CARD");

        txtCardNumber.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        txtCardNumber.setText("4444555566667777");
        txtCardNumber.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Card Number", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        cboBankName.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        cboBankName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Techcombank", " " }));
        cboBankName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bank Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N
        cboBankName.setPreferredSize(new java.awt.Dimension(153, 40));

        txtCardHolderName.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        txtCardHolderName.setText("Nguyen Tuan Hai");
        txtCardHolderName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cardholder Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        txtBillingAddress.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        txtBillingAddress.setText("123123123123");
        txtBillingAddress.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Billing Address", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        jButton1.setBackground(new java.awt.Color(238, 0, 51));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add card");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Expiration Date");

        txtPIN.setText("123456");
        txtPIN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PIN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1)
                    .addComponent(txtCardNumber)
                    .addComponent(txtBillingAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCardHolderName, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpirationDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboBankName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPIN))))
                .addGap(33, 33, 33))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPIN)
                    .addComponent(txtCardHolderName, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(txtBillingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertCard();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addCardJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCardJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCardJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCardJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addCardJDialog dialog = new addCardJDialog(new MainJFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboBankName;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtBillingAddress;
    private javax.swing.JTextField txtCardHolderName;
    private javax.swing.JTextField txtCardNumber;
    private com.toedter.calendar.JDateChooser txtExpirationDate;
    private javax.swing.JPasswordField txtPIN;
    // End of variables declaration//GEN-END:variables
}
