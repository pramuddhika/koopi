/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package koopi;

import java.text.*;
import java.sql.*;
import javax.swing.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M C S
 */
public class MenuUpdate extends javax.swing.JFrame {

    private static final String username = "root";
    private static final String password = "Hashini@0730";
    private static final String dataConn = "jdbc:mysql://localhost:3306/koopi";
    
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q,i;
    Statement st;
    
    //variable for combo box
    String selectedvalue;
    /**
     * Creates new form MenuUpdate
     */
    public MenuUpdate() {
        initComponents();
        UpdateDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
        //==========================function========================================
    private void UpdateDB(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst =  sqlConn.prepareStatement("select * from updatemenu");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTableupdatemenu.getModel();
            RecordTable.setRowCount(0);
            
            while(rs.next()){
                Vector columnData = new Vector();
                
                for( i = 1; i <= q; i++){
                    columnData.add(rs.getString("name"));
                    columnData.add(rs.getString("code"));     
                    columnData.add(rs.getString("type")); 
                    columnData.add(rs.getString("quantity")); 
                    columnData.add(rs.getString("price")); 
                }
                RecordTable.addRow(columnData);
            }
            
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }finally {
          try {
            if (st != null) {
                st.close();
                }
            if (sqlConn != null) {
                sqlConn.close();
            }
          } catch (SQLException ex) {
            Logger.getLogger( MenuUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }
    
    public void Clear(){
        jtxtname.setText("");
        jtxtcode.setText("");
        jtxttype.setText("");
        jtxtquantity.setText("");
        jtxtprice.setText("");
    }
   
    //==========================End Function====================================
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtname = new javax.swing.JTextField();
        jtxtprice = new javax.swing.JTextField();
        jtxtcode = new javax.swing.JTextField();
        jbtnAdd = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jbtnRemove = new javax.swing.JButton();
        jtxtquantity = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxtype = new javax.swing.JComboBox<>();
        jtxttype = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableupdatemenu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jLabel4.setText("Manager");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 50, 131, 42));

        jButton1.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 690, 154, 50));

        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("update menu");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 607, 90));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 140, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Code");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 150, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Type");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 166, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Quantity");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 166, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel7.setText("Price");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 166, 30));

        jtxtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtnameActionPerformed(evt);
            }
        });
        getContentPane().add(jtxtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 150, 30));
        getContentPane().add(jtxtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 419, 150, 30));
        getContentPane().add(jtxtcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 150, 30));

        jbtnAdd.setText(" Add");
        jbtnAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 116, 51));

        jbtnReset.setText(" Reset");
        jbtnReset.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 570, 116, 51));

        jbtnUpdate.setText(" Update");
        jbtnUpdate.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, 116, 47));

        jbtnRemove.setText(" Remove");
        jbtnRemove.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 680, 116, 47));
        getContentPane().add(jtxtquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 150, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SetMenu", "ShortEats", "Cakes", "Beverages" }));
        jComboBoxtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxtypeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 150, 30));
        jPanel1.add(jtxttype, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 570, 410));

        jTableupdatemenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Code", "Type", "Quantity", "Price"
            }
        ));
        jTableupdatemenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableupdatemenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableupdatemenu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 117, 560, 550));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contollers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Felix Titling", 3, 18))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 410, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtnameActionPerformed

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
             
            
            pst =  sqlConn.prepareStatement("insert into updatemenu (name,code,type,quantity,price)value (?,?,?,?,?)");

            pst.setString(1,jtxtname.getText());
            pst.setString(2,jtxtcode.getText());
            pst.setString(3,  jtxttype.getText());
            pst.setString(4, jtxtquantity.getText());
            pst.setString(5, jtxtprice.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "record added");
            UpdateDB();
            Clear();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger( MenuUpdate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger( MenuUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            st=sqlConn.createStatement();

            String name          = jtxtname.getText();
            String code          = jtxtcode.getText();
            String type          = jtxttype.getText();
            byte   quantity      = Byte.parseByte(jtxtquantity.getText());
            short  price         = Short.parseShort(jtxtprice.getText());

            
            

            String query = "UPDATE updatemenu SET name='" + name + "', code='" + code + "', type='" + type + "', quantity=" + quantity + ", price=" + price + " WHERE name='" + name + "' OR code='" + code + "'";

            int result = st.executeUpdate(query);

            JOptionPane.showMessageDialog(this, "record updated");
            UpdateDB();
            Clear();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger( MenuUpdate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger( MenuUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoveActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            st=sqlConn.createStatement();

            String name          = jtxtname.getText();
            String code          = jtxtcode.getText();
                   
            
            String query = "DELETE FROM updatemenu WHERE name='" + name + "' OR code='" + code + "'";

            int result = st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, result+"record deleted!");
            UpdateDB();
            Clear();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger( MenuUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (sqlConn != null) {
                    sqlConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger( MenuUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbtnRemoveActionPerformed

    private void jTableupdatemenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableupdatemenuMouseClicked
        // TODO add your handling code here:
         DefaultTableModel RecordTable = (DefaultTableModel)jTableupdatemenu.getModel();
        int selectedRows = jTableupdatemenu.getSelectedRow();
        
        jtxtname.setText(RecordTable.getValueAt(selectedRows, 0).toString());
        jtxtcode.setText(RecordTable.getValueAt(selectedRows, 1).toString());
        jtxttype.setText(RecordTable.getValueAt(selectedRows, 2).toString());
        jtxtquantity.setText(RecordTable.getValueAt(selectedRows, 3).toString());
        jtxtprice.setText(RecordTable.getValueAt(selectedRows, 4).toString());
    }//GEN-LAST:event_jTableupdatemenuMouseClicked

    private void jComboBoxtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxtypeActionPerformed
        // TODO add your handling code here:
        selectedvalue = jComboBoxtype.getSelectedItem().toString();
        jtxttype.setText(selectedvalue);
    }//GEN-LAST:event_jComboBoxtypeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ManagerHomePage().setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(MenuUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableupdatemenu;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnRemove;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JTextField jtxtcode;
    private javax.swing.JTextField jtxtname;
    private javax.swing.JTextField jtxtprice;
    private javax.swing.JTextField jtxtquantity;
    private javax.swing.JTextField jtxttype;
    // End of variables declaration//GEN-END:variables
}
