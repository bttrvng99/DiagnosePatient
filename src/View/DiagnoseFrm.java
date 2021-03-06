/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Patient;
import Model.Diagnosis;
import Model.Test;
import DAO.*;
import Model.TestList;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trung
 */
public class DiagnoseFrm extends javax.swing.JFrame {

    /**
     * Creates new form DiagnoseFrm
     */
    private Patient patient;
    private DiagnosisDAO dd;
    private Diagnosis d;
    private TestList tl;
    private DefaultTableModel tbl1;
    private DefaultTableModel tbl2;
    private ArrayList<TestList> selected_tests;
    public DiagnoseFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        selected_tests = new ArrayList<TestList>();
        Object[] columns = {"ID", "Tên", "Giá thành", "Buồng"};
        Object[][] data = new Object[0][];
        tbl2 = new DefaultTableModel(data, columns);
    }
    
    public void initDiagnosis(int key){
        PatientDAO pd = new PatientDAO();
        patient = pd.getPatientByID(key);
        System.out.println(patient.getId());
        jLabel2.setText(String.valueOf(key));
        jLabel4.setText(patient.getName());
        DefaultList();
        Object[] columns = {"ID", "Tên", "Giá thành", "Buồng"};
        Object[][] data = new Object[0][];
        tbl2 = new DefaultTableModel(data, columns){
                @Override
		    public boolean isCellEditable(int row, int column) {
		       //unable to edit cells
                    return false;
        	}
            };
    }
    
    private void DefaultList(){
        TestDAO td = new TestDAO();
        ArrayList<Test> test_list = td.getAllTest();
        Object[] columns = {"ID", "Tên", "Giá thành", "Buồng"};
        Object[][] value = new String[test_list.size()][4];
        for(int i=0 ;i<test_list.size(); i++){
            value[i][0] = test_list.get(i).getId()+"";
            value[i][1] = test_list.get(i).getName();
            value[i][2] = test_list.get(i).getCost()+"";
            value[i][3] = test_list.get(i).getRoom_num()+"";
            tbl1 = new DefaultTableModel(value, columns){
                @Override
		    public boolean isCellEditable(int row, int column) {
		       //unable to edit cells
                    return false;
        	}
            };
            jTable1.setModel(tbl1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddTest = new javax.swing.JButton();
        RemoveTest = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        SearchTest = new javax.swing.JButton();
        RestTestList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID bệnh nhân");

        jLabel2.setText("jLabel2");

        jLabel3.setText("Tên bệnh nhân");

        jLabel4.setText("jLabel4");

        jLabel5.setText("Triệu chứng");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel6.setText("Các loại xét nghiệm đang có");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        AddTest.setText("Thêm xét nghiệm");
        AddTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTestActionPerformed(evt);
            }
        });

        RemoveTest.setText("Xóa xét nghiệm");
        RemoveTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveTestActionPerformed(evt);
            }
        });

        NextButton.setText("Tiếp");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Cost", "Booth"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel7.setText("Các loại xét nghiệm đã chọn");

        jLabel8.setText("Tìm theo tên");

        SearchTest.setText("Tìm");
        SearchTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTestActionPerformed(evt);
            }
        });

        RestTestList.setText("Xóa toàn bộ");
        RestTestList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestTestListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddTest))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RemoveTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RestTestList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NextButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchTest)
                    .addComponent(AddTest))
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemoveTest)
                    .addComponent(NextButton)
                    .addComponent(RestTestList))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTestActionPerformed
        // TODO add your handling code here:
        if((jTextField1.getText()==null)||((jTextField1.getText().length())==0)) DefaultList();
        TestDAO t = new TestDAO();
        ArrayList<Test> test_list = t.SearchTest(jTextField1.getText().trim());
        String[] columns = {"ID", "Tên", "Giá thành", "Buồng"};
        String[][] value = new String[test_list.size()][4];
        for(int i=0 ;i<test_list.size(); i++){
            value[i][0] = test_list.get(i).getId()+"";
            value[i][1] = test_list.get(i).getName();
            value[i][2] = test_list.get(i).getCost()+"";
            value[i][3] = test_list.get(i).getRoom_num()+"";
            tbl1 = new DefaultTableModel(value, columns){
                @Override
		    public boolean isCellEditable(int row, int column) {
		       //unable to edit cells
                    return false;
        	}
            };
            jTable1.setModel(tbl1);
        }
    }//GEN-LAST:event_SearchTestActionPerformed

    private void RestTestListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestTestListActionPerformed
        // TODO add your handling code here:
        DefaultList();
        tbl2.setRowCount(0);
    }//GEN-LAST:event_RestTestListActionPerformed

    private void AddTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTestActionPerformed
        // TODO add your handling code here:
        Test selected = new Test();
        int row = jTable1.getSelectedRow();
//        selected.setId(Integer.parseInt(String.valueOf(jTable1.getModel().getValueAt(row, 0))));
//        selected.setName(String.valueOf(jTable1.getModel().getValueAt(row, 1)));
//        selected.setCost(Float.parseFloat(String.valueOf(jTable1.getModel().getValueAt(row, 2))));
//        selected.setRoom_num(Integer.parseInt(String.valueOf(jTable1.getModel().getValueAt(row, 3))));
//        System.out.println(selected.getName());
//        selected_tests.add(selected);
        if(row != -1){
                Object[] data = new Object[4];
            data[0] = jTable1.getModel().getValueAt(row, 0);
            data[1] = jTable1.getModel().getValueAt(row, 1);
            data[2] = jTable1.getModel().getValueAt(row, 2);
            data[3] = jTable1.getModel().getValueAt(row, 3);
            for (int i=0; i<jTable2.getModel().getRowCount(); i++){
                if(data[0] == jTable2.getModel().getValueAt(i, 0)){
                    JOptionPane.showMessageDialog(this, "Xét nghiệm đã chọn!");
                    return;
                }
            }
            tbl2.addRow(data);
            jTable2.setModel(tbl2);
        
        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn một loại xét nghiệm");
            return;
        }
    }//GEN-LAST:event_AddTestActionPerformed

    private void RemoveTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveTestActionPerformed
        // TODO add your handling code here:
        if(jTable2.getSelectedRow() != -1){
            tbl2.removeRow(jTable2.getSelectedRow());
        }
    }//GEN-LAST:event_RemoveTestActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        if((!jTextArea1.getText().isEmpty())&&(jTable2.getRowCount() != 0)){
            d = new Diagnosis();
            dd = new DiagnosisDAO();
            String s = jTextArea1.getText()+"";
            System.out.println(s);
            for(int i=0; i< jTable2.getModel().getRowCount(); i++){
                    Test t1 = new Test();
                TestList t2 = new TestList();
                t1.setId(Integer.parseInt((String) jTable2.getModel().getValueAt(i, 0)));
                t1.setName(String.valueOf(jTable2.getModel().getValueAt(i, 1)));
                t1.setCost(Float.parseFloat((String) jTable2.getModel().getValueAt(i, 2)));
                t1.setRoom_num(Integer.parseInt((String) jTable2.getModel().getValueAt(i, 3)));
                t2.setTest(t1);
                selected_tests.add(t2);
            }
            d.setTest_list(selected_tests);
            d.setSymptoms(s);
            d.setId(dd.GetDiagnosisID());
            d.setPatient(patient);
            ResultForm rf = new ResultForm();
            rf.initConclusion(d);
            rf.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Chưa điền triệu chứng hoặc lập danh sách xét nghiệm");
            return;
        }
    }//GEN-LAST:event_NextButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DiagnoseFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagnoseFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagnoseFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagnoseFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiagnoseFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTest;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton RemoveTest;
    private javax.swing.JButton RestTestList;
    private javax.swing.JButton SearchTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
