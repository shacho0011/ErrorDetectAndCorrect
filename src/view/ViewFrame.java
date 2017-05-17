/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import model.TestEmp;

/**
 *
 * @author Shadhin
 */
public class ViewFrame extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    CustomerPanel custP;
    EmployeePanel empP;
    MasterPanel mstP;
    MdPanel mdP;
    TaxPanel taxP;
    TreatmentsPanel treatP;
    TestEmpPanel testEmpPanel;
    InconsistencyPanel inconsistencyPanel;

    GridBagLayout gbLayout = new GridBagLayout();

    public ViewFrame() {
        super("EDC");
        initComponents();
        GridBagConstraints gbConstraints = new GridBagConstraints();
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 0;
        mainPanel.setLayout(gbLayout);

        custP = new CustomerPanel();
        empP = new EmployeePanel();
        mstP = new MasterPanel();
        mdP = new MdPanel();
        taxP = new TaxPanel();
        treatP = new TreatmentsPanel();
        testEmpPanel = new TestEmpPanel();
        inconsistencyPanel = new InconsistencyPanel();

        mainPanel.add(custP, gbConstraints);
        mainPanel.add(empP, gbConstraints);
        mainPanel.add(mstP, gbConstraints);
        mainPanel.add(mdP, gbConstraints);
        mainPanel.add(taxP, gbConstraints);
        mainPanel.add(treatP, gbConstraints);
        mainPanel.add(inconsistencyPanel, gbConstraints);
        mainPanel.add(testEmpPanel, gbConstraints);

        custP.setVisible(false);
        empP.setVisible(false);
        mstP.setVisible(false);
        mdP.setVisible(false);
        taxP.setVisible(false);
        treatP.setVisible(false);
        inconsistencyPanel.setVisible(false);
        testEmpPanel.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mainPanel = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        databaseMenu = new javax.swing.JMenu();
        customerMI = new javax.swing.JMenuItem();
        employeeMI = new javax.swing.JMenuItem();
        masterMI = new javax.swing.JMenuItem();
        mdMI = new javax.swing.JMenuItem();
        taxMI = new javax.swing.JMenuItem();
        treatmentsMI = new javax.swing.JMenuItem();
        testEmpMenuItem = new javax.swing.JMenuItem();
        jMenuExp = new javax.swing.JMenu();
        jMenuItemInconsistency = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );

        fileMenu.setText("File");
        jMenuBar.add(fileMenu);

        databaseMenu.setText("Database");

        customerMI.setText("Customer");
        customerMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMIActionPerformed(evt);
            }
        });
        databaseMenu.add(customerMI);

        employeeMI.setText("Employee");
        employeeMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeMIActionPerformed(evt);
            }
        });
        databaseMenu.add(employeeMI);

        masterMI.setText("Master");
        masterMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterMIActionPerformed(evt);
            }
        });
        databaseMenu.add(masterMI);

        mdMI.setText("Md");
        mdMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdMIActionPerformed(evt);
            }
        });
        databaseMenu.add(mdMI);

        taxMI.setText("Tax");
        taxMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxMIActionPerformed(evt);
            }
        });
        databaseMenu.add(taxMI);

        treatmentsMI.setText("Treatments");
        treatmentsMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treatmentsMIActionPerformed(evt);
            }
        });
        databaseMenu.add(treatmentsMI);

        testEmpMenuItem.setText("TestEmp");
        testEmpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testEmpMenuItemActionPerformed(evt);
            }
        });
        databaseMenu.add(testEmpMenuItem);

        jMenuBar.add(databaseMenu);

        jMenuExp.setText("Experiment");

        jMenuItemInconsistency.setText("Inconsistency");
        jMenuItemInconsistency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInconsistencyActionPerformed(evt);
            }
        });
        jMenuExp.add(jMenuItemInconsistency);

        jMenuBar.add(jMenuExp);

        exitMenu.setText("Exit");

        jMenu3.setText("jMenu3");
        exitMenu.add(jMenu3);

        jMenuBar.add(exitMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mdMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdMIActionPerformed
        // TODO add your handling code here:
        custP.setVisible(false);
        empP.setVisible(false);
        mstP.setVisible(false);
        mdP.setVisible(true);
        taxP.setVisible(false);
        treatP.setVisible(false);
        inconsistencyPanel.setVisible(false);
        testEmpPanel.setVisible(false);
        mdP.loadData();
    }//GEN-LAST:event_mdMIActionPerformed

    private void customerMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerMIActionPerformed
        // TODO add your handling code here:
        custP.setVisible(true);
        empP.setVisible(false);
        mstP.setVisible(false);
        mdP.setVisible(false);
        taxP.setVisible(false);
        treatP.setVisible(false);
        inconsistencyPanel.setVisible(false);
        testEmpPanel.setVisible(false);
        custP.loadData();
    }//GEN-LAST:event_customerMIActionPerformed

    private void employeeMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeMIActionPerformed
        // TODO add your handling code here:
        custP.setVisible(false);
        empP.setVisible(true);
        mstP.setVisible(false);
        mdP.setVisible(false);
        taxP.setVisible(false);
        treatP.setVisible(false);
        inconsistencyPanel.setVisible(false);
        testEmpPanel.setVisible(false);
        empP.loadData();
        
    }//GEN-LAST:event_employeeMIActionPerformed

    private void masterMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterMIActionPerformed
        // TODO add your handling code here:
        custP.setVisible(false);
        empP.setVisible(false);
        mstP.setVisible(true);
        mdP.setVisible(false);
        taxP.setVisible(false);
        treatP.setVisible(false);
        inconsistencyPanel.setVisible(false);
        testEmpPanel.setVisible(false);
        mstP.loadData();
    }//GEN-LAST:event_masterMIActionPerformed

    private void taxMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxMIActionPerformed
        // TODO add your handling code here:
        custP.setVisible(false);
        empP.setVisible(false);
        mstP.setVisible(false);
        mdP.setVisible(false);
        taxP.setVisible(true);
        treatP.setVisible(false);
        inconsistencyPanel.setVisible(false);
        testEmpPanel.setVisible(false);
        taxP.loadData();
    }//GEN-LAST:event_taxMIActionPerformed

    private void treatmentsMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treatmentsMIActionPerformed
        // TODO add your handling code here:
        custP.setVisible(false);
        empP.setVisible(false);
        mstP.setVisible(false);
        mdP.setVisible(false);
        taxP.setVisible(false);
        treatP.setVisible(true);
        inconsistencyPanel.setVisible(false);
        testEmpPanel.setVisible(false);
        treatP.loadData();
    }//GEN-LAST:event_treatmentsMIActionPerformed

    private void jMenuItemInconsistencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInconsistencyActionPerformed
        // TODO add your handling code here:
        custP.setVisible(false);
        empP.setVisible(false);
        mstP.setVisible(false);
        mdP.setVisible(false);
        taxP.setVisible(false);
        treatP.setVisible(false);
        inconsistencyPanel.setVisible(true);
        testEmpPanel.setVisible(false);
    }//GEN-LAST:event_jMenuItemInconsistencyActionPerformed

    private void testEmpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testEmpMenuItemActionPerformed
        // TODO add your handling code here:
        custP.setVisible(false);
        empP.setVisible(false);
        mstP.setVisible(false);
        mdP.setVisible(false);
        taxP.setVisible(false);
        treatP.setVisible(false);
        inconsistencyPanel.setVisible(false);
        testEmpPanel.setVisible(true);
    }//GEN-LAST:event_testEmpMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(ViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem customerMI;
    private javax.swing.JMenu databaseMenu;
    private javax.swing.JMenuItem employeeMI;
    private javax.swing.JMenu exitMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuExp;
    private javax.swing.JMenuItem jMenuItemInconsistency;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem masterMI;
    private javax.swing.JMenuItem mdMI;
    private javax.swing.JMenuItem taxMI;
    private javax.swing.JMenuItem testEmpMenuItem;
    private javax.swing.JMenuItem treatmentsMI;
    // End of variables declaration//GEN-END:variables
}
