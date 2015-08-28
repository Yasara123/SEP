/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Logic.Drug;
import Logic.InventoryController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nandula
 */
public class Inventory extends javax.swing.JFrame {

    /**
     * Creates new form Inventory
     */
    InventoryController manage = new InventoryController();
    List<Drug> data = new ArrayList();

    public Inventory() {
        initComponents();
    }

    public Inventory(List<Drug> temp) {
        initComponents();
        this.reorder.setVisible(false);
        data = temp;

        DefaultTableModel inventorytable = new DefaultTableModel();
        Object[] columnNames = new Object[6];
        Object[] fieldValues = new Object[6];
        Drug adrug = null;

        columnNames[0] = "DrugId";
        columnNames[1] = "Name";
        columnNames[2] = "UnitPrice";
        columnNames[3] = "Quantity Avialable";
        columnNames[4] = "MOQ";
        columnNames[5] = "ReOrder";

        inventorytable.setColumnIdentifiers(columnNames);

        if (data.size() > 0) {

            for (int i = 0; i < data.size(); i++) {

                adrug = data.get(i);
                fieldValues[0] = adrug.getDrugId();
                fieldValues[1] = adrug.getName();
                fieldValues[2] = adrug.getPrice();
                fieldValues[3] = adrug.getQuantity();
                fieldValues[4] = adrug.getMOQ();

                if (adrug.getQuantity() < adrug.getMOQ()) {
                    fieldValues[5] = "Yes";
                } else {
                    fieldValues[5] = "No";
                }

                inventorytable.addRow(fieldValues);
            }

            this.inventory.setModel(inventorytable);
        }
        data.clear();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inventory = new javax.swing.JTable();
        reorder = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enable(evt);
            }
        });
        jScrollPane1.setViewportView(inventory);

        reorder.setText("Reorder");
        reorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reorderActionPerformed(evt);
            }
        });

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Inventory Level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(reorder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(close)
                .addGap(137, 137, 137))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(close)
                    .addComponent(reorder))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        this.dispose();
        manage.openHome();

    }//GEN-LAST:event_closeActionPerformed

    private void enable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enable
        // TODO add your handling code here:
        int selectedColumn = inventory.getSelectedColumn();
        if(selectedColumn==0){
            reorder.setVisible(true);
        }
        else{
            reorder.setVisible(false);
        }
    }//GEN-LAST:event_enable

    private void reorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reorderActionPerformed
        // TODO add your handling code here:
        int id = (int) inventory.getValueAt(inventory.getSelectedRow(), inventory.getSelectedColumn());
        String name = (String) inventory.getValueAt(inventory.getSelectedRow(), (inventory.getSelectedColumn()+1));
        manage.purchaseOrder(id, name);
    }//GEN-LAST:event_reorderActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JTable inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reorder;
    // End of variables declaration//GEN-END:variables
}