/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Staff;
import BUS.Staff_BUS;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vanhi
 */
public class EditStaff extends javax.swing.JDialog {
    StaffGUI sgui;
    Staff_BUS staff_bus = new Staff_BUS();
    Staff staff = null;
    AccountGUI1111 acgui;
    /**
     * Creates new form EditStaff
     */
    public EditStaff(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void infor(Staff s,StaffGUI SG,AccountGUI1111 a){
        System.out.println("staff :");
        acgui = a;
        sgui = SG;
        staff = s;
        if(s!=null){
            title.setText("Sửa thông tin nhân viên");
            label_password.setVisible(false);
            txtPassword.setVisible(false);
            txtUsername.setText(s.getUsername());
            txtUsername.setEditable(false);
            txtPassword.setText(s.getPassword());
            txtName.setText(s.getName());
            txtSdt.setText(s.getSdt());
            txtCmnd.setText(s.getCmnd());
            txtAddress.setText(s.getAddress());
            txtPosition.setText(s.getPosition());
            
        }else{
            title.setText("Thêm thông tin nhân viên");
        }
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        txtCmnd = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtManager = new javax.swing.JComboBox<>();
        btnConfirm = new javax.swing.JButton();
        label_password = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        jLabel3.setText("  Username :");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 420));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(700, 390));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 390));
        jPanel2.setLayout(null);

        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Sửa thông tin nhân viên");
        jPanel2.add(title);
        title.setBounds(10, 11, 682, 51);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("  Username :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 80, 96, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("  Cmnd :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(370, 120, 91, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("  Quyền truy cập :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(360, 240, 120, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("  Số điện thoại :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 160, 105, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("  Họ tên :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 120, 73, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("  Công việc :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 240, 90, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("  Địa chỉ :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(30, 200, 105, 30);

        txtSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtActionPerformed(evt);
            }
        });
        jPanel2.add(txtSdt);
        txtSdt.setBounds(150, 160, 500, 30);

        txtCmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCmndActionPerformed(evt);
            }
        });
        jPanel2.add(txtCmnd);
        txtCmnd.setBounds(460, 120, 191, 30);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName);
        txtName.setBounds(150, 120, 191, 30);

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsername);
        txtUsername.setBounds(150, 80, 191, 30);

        txtPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPositionActionPerformed(evt);
            }
        });
        jPanel2.add(txtPosition);
        txtPosition.setBounds(150, 240, 191, 32);

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel2.add(txtAddress);
        txtAddress.setBounds(150, 200, 500, 29);

        txtManager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));
        jPanel2.add(txtManager);
        txtManager.setBounds(490, 240, 160, 30);

        btnConfirm.setBackground(new java.awt.Color(52, 152, 219));
        btnConfirm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("Xác nhận");
        btnConfirm.setBorderPainted(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        jPanel2.add(btnConfirm);
        btnConfirm.setBounds(360, 300, 290, 33);

        label_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_password.setText("  Password :");
        jPanel2.add(label_password);
        label_password.setBounds(370, 80, 91, 30);
        jPanel2.add(txtPassword);
        txtPassword.setBounds(460, 80, 191, 30);

        getContentPane().add(jPanel2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtActionPerformed

    private void txtCmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCmndActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPositionActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String name = txtName.getText();
        String sdt = txtSdt.getText();
        String cmnd = txtCmnd.getText();
        String address = txtAddress.getText();
        String position = txtPosition.getText();
        if((name.length()==0)||(sdt.length()==0)||(cmnd.length()==0)||(address.length()==0)||(username.length()==0)||(password.length()==0)||(position.length()==0)){
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống thông tin");
        }else if(name.matches("^[0-9]+$")){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
        }else if(!cmnd.matches("^[0-9]{9,12}+$")){
            JOptionPane.showMessageDialog(this, "Cmnd không hợp lệ");
        }
        else if(!sdt.matches("^[0-9]{10}+$")){
            JOptionPane.showMessageDialog(this, "Sđt không hợp lệ");
        }
        else{
            if(staff!=null){
                staff_bus.editStaff(staff,txtName.getText(),txtSdt.getText(),txtCmnd.getText(),txtAddress.getText(),txtPosition.getText(), String.valueOf(txtManager.getSelectedItem())=="Quản lý");
                JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thông tin nhân viên thành công");
            }else{
                Staff s = new Staff(txtUsername.getText(),txtPassword.getText(),txtName.getText(),txtSdt.getText(),txtCmnd.getText(),txtAddress.getText(),txtPosition.getText(), String.valueOf(txtManager.getSelectedItem())=="Quản lý");
                staff_bus.addStaff(s);
                JOptionPane.showMessageDialog(rootPane, "Thêm thông tin nhân viên thành công");
            }
            if(acgui!=null){
                acgui.showInfor();                
            }
            sgui.showStaff();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditStaff dialog = new EditStaff(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnConfirm;
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
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JComboBox<String> txtManager;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
