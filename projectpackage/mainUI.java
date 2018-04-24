/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.*;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;

/**
 *
 * @author Josh
 */
public class mainUI extends javax.swing.JFrame {

    /**
     * Creates new form mainUI
     */
    public mainUI() {
        initComponents();
        DataBase.main();
       // TMModel.taskNames();
        DefaultTableModel model = (DefaultTableModel) jTaskTable.getModel();
        System.out.println(TMModel.taskNames());
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Log.db");
            c.setAutoCommit(false);

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        for(String s : TMModel.taskNames())
           model.addRow((new Object[]{s}));


        //jTaskTable.getColumnModel().getColumn(0).setPreferredWidth(40);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createTaskButton = new javax.swing.JButton();
        newTaskField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTaskTable = new javax.swing.JTable();
        editTaskButton = new javax.swing.JButton();
        stopTaskButton = new javax.swing.JButton();
        deleteTaskButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createTaskButton.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        createTaskButton.setText("Create Task");
        createTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskButtonActionPerformed(evt);
            }
        });

        newTaskField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Tasks");

        jTaskTable.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTaskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Size", "Timer"
            }
        ));
        jTaskTable.setRowHeight(23);
        jTaskTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTaskTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTaskTable);
        if (jTaskTable.getColumnModel().getColumnCount() > 0) {
            jTaskTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        editTaskButton.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        editTaskButton.setText("Edit Task");
        editTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTaskButtonActionPerformed(evt);
            }
        });

        stopTaskButton.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        stopTaskButton.setText("Stop Task");
        stopTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopTaskButtonActionPerformed(evt);
            }
        });

        deleteTaskButton.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        deleteTaskButton.setText("Delete Task");
        deleteTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newTaskField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(deleteTaskButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(stopTaskButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(newTaskField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(createTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(editTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(stopTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(deleteTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(950, 641));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void createTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTaskButtonActionPerformed
        // TODO add your handling code here:


 //       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   //     Date stopDate = new Date();
    //    String strStartDate = dateFormat.format(stopDate);

        

    }//GEN-LAST:event_createTaskButtonActionPerformed

    //taskUI taskRowData = new taskUI();

    private void jTaskTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTaskTableMouseClicked
        // TODO add your handling code here:

        //----------------------------------------
        /*  OLD CODE
        int rowNum = jTaskTable.getSelectedRow();
        
        TableModel model = jTaskTable.getModel();
        
        String selectedTask = model.getValueAt(rowNum, 0).toString();
        
        taskRowData.setVisible(true);
        taskRowData.pack();
        taskRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        taskRowData.taskNameLabel.setText(selectedTask);
        
        /*
        String selectedTask = model.getValueAt(rowNum, 0).toString();
        //JOptionPane.showMessageDialog(null, selectedTask);
        new taskUI(selectedTask).setVisible(true);
         */

    }//GEN-LAST:event_jTaskTableMouseClicked

    private void editTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTaskButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) jTaskTable.getModel();

        int selectedTask = jTaskTable.getSelectedRow();

        // keep
        String taskName = model.getValueAt(selectedTask, 0).toString();
        String taskDescription = model.getValueAt(selectedTask, 1).toString();
        String taskSize = model.getValueAt(selectedTask, 2).toString();
        String taskTimer = model.getValueAt(selectedTask, 3).toString();

        JTextField field1 = new JTextField(8);
        JTextField field2 = new JTextField(8);
        JTextField field3 = new JTextField(8);
        JTextField field4 = new JTextField(8);

      //  field1.setText(taskName);
      //  field2.setText(taskDescription);
      //  field3.setText(taskSize);
      //  field4.setText(taskTimer);
      //  field1.setFont(new Font("Arial", Font.BOLD, 24));
      //  field2.setFont(new Font("Arial", Font.BOLD, 24));
      //  field3.setFont(new Font("Arial", Font.BOLD, 24));
      //  field4.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel dataPanel = new JPanel();
      /*
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.add(new JLabel("Name: "));
        dataPanel.add(field1);
        dataPanel.add(Box.createHorizontalStrut(15));

        dataPanel.add(new JLabel("Description: "));
        dataPanel.add(field2);
        dataPanel.add(Box.createHorizontalStrut(15));

        dataPanel.add(new JLabel("Size: "));
        dataPanel.add(field3);
        dataPanel.add(Box.createHorizontalStrut(15));

        dataPanel.add(new JLabel("Timer:"));
        dataPanel.add(field4);
*/
        UIManager.put("OptionPane.minimumSize",new Dimension(400, 290));  
        JOptionPane.showConfirmDialog(null, dataPanel, "Task Editor", JOptionPane.OK_CANCEL_OPTION);

        String editName = field1.getText();
        String editDescription = field2.getText();
        String editSize = field3.getText();
        String editTimer = field4.getText();

        /*
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        Object[] fields = {
            "Name", field1,
            "Description", field2,
            "Size", field3,
            "Timer", field4
        };
        JOptionPane.showConfirmDialog(null, fields, "Edit Task Data", JOptionPane.OK_CANCEL_OPTION);
        
        String editName = field1.toString();
        String editDescription = field2.toString();
        String editSize = field3.toString();
        String editTimer = field4.toString();
         */
 /* keep
        String editName = JOptionPane.showInputDialog(null, "Task Name: ", taskName);
        String editDescription = JOptionPane.showInputDialog(null, "Task Description: ", taskDescription);
        String editSize = JOptionPane.showInputDialog(null, "Task Size: ", taskSize);
        String editTimer = JOptionPane.showInputDialog(null, "Task Timer: ", taskTimer);
         */
        //keep
        model.setValueAt(editName, selectedTask, 0);
        model.setValueAt(editDescription, selectedTask, 1);
        model.setValueAt(editSize, selectedTask, 2);
        model.setValueAt(editTimer, selectedTask, 3);
    }//GEN-LAST:event_editTaskButtonActionPerformed

    private void deleteTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTaskButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTaskTable.getModel();

        try {
            int selectedTask = jTaskTable.getSelectedRow();
            model.removeRow(selectedTask);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_deleteTaskButtonActionPerformed

    private void stopTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopTaskButtonActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date stopDate = new Date();
        String taskStop = dateFormat.format(stopDate);

        DefaultTableModel model = (DefaultTableModel) jTaskTable.getModel();
        int selectedTask = jTaskTable.getSelectedRow();

        String taskStart = model.getValueAt(selectedTask, 3).toString();

        //TIME CALCULATOR
        String dateStart = taskStart;
        String dateStop = taskStop;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            // in milliseconds
            long diff = d2.getTime() - d1.getTime();
            // PRINT BY SECONDS
            //System.out.println(diff);

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            NumberFormat formatter = new DecimalFormat("00");
            String hours = formatter.format(diffHours);
            String minutes = formatter.format(diffMinutes);
            String seconds = formatter.format(diffSeconds);

            String totaledTime = hours + ":" + minutes + ":" + seconds;

            model.setValueAt(totaledTime, selectedTask, 3);

        } catch (ParseException ioe) {
            ioe.printStackTrace();
        }

    }//GEN-LAST:event_stopTaskButtonActionPerformed

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
            java.util.logging.Logger.getLogger(mainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createTaskButton;
    private javax.swing.JButton deleteTaskButton;
    private javax.swing.JButton editTaskButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTaskTable;
    private javax.swing.JTextField newTaskField;
    private javax.swing.JButton stopTaskButton;
    // End of variables declaration//GEN-END:variables
}
