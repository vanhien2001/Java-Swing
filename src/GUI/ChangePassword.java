/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Staff;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vanhi
 */
public class ChangePassword extends javax.swing.JFrame {
    Staff staff = new Staff();
    /**
     * Creates new form ChangePassword
     */
    public ChangePassword(Staff s) {
        initComponents();
        this.setVisible(true);
        staff = s;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
//    public String getPass(){
//        return staff.getPassword();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOld = new javax.swing.JPasswordField();
        txtNew = new javax.swing.JPasswordField();
        txtNewConfirm = new javax.swing.JPasswordField();
        btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(421, 456));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đổi mật khẩu");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 50, 310, 39);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mật khẩu cũ :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 150, 118, 31);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu mới :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 210, 118, 31);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 270, 118, 31);
        jPanel1.add(txtOld);
        txtOld.setBounds(180, 150, 190, 30);
        jPanel1.add(txtNew);
        txtNew.setBounds(180, 210, 190, 30);
        jPanel1.add(txtNewConfirm);
        txtNewConfirm.setBounds(180, 270, 190, 30);

        btn.setBackground(new java.awt.Color(52, 152, 219));
        btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn.setForeground(new java.awt.Color(255, 255, 255));
        btn.setText("Xác nhận");
        btn.setBorderPainted(false);
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        jPanel1.add(btn);
        btn.setBounds(60, 350, 312, 40);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
        if(txtOld.getText().equalsIgnoreCase(staff.getPassword())){
            if(!txtNew.getText().equalsIgnoreCase("")){
                if(txtNew.getText().equalsIgnoreCase(txtNewConfirm.getText())){
                    Staff.ChangePass(staff,txtNew.getText());
                    JOptionPane.showMessageDialog(rootPane, "Thay đổi password thành công");
                    staff.setPassword(txtNew.getText());
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Mật khẩu mới không được để trống");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Mật khẩu không đúng");
        }
    }//GEN-LAST:event_btnActionPerformed

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChangePassword().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtNew;
    private javax.swing.JPasswordField txtNewConfirm;
    private javax.swing.JPasswordField txtOld;
    // End of variables declaration//GEN-END:variables
}
