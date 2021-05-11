/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DTO.Booking;
import BUS.Booking_BUS;
import BUS.Room_BUS;
import DTO.Customer;
import DTO.Room;
import DTO.Staff;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vanhi
 */
public class EditBooking extends javax.swing.JFrame {
    BookingGUI bgui = null;
    Booking_BUS booking_BUS = new Booking_BUS();
    Booking booking = null;
    Room room = null;
    Staff staff = null;
    RoomGUI rgui = null;
    /**
     * Creates new form EditRoom
     */
    public EditBooking() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void infor(Booking b,Room r,Staff s,BookingGUI BG,RoomGUI RG){
        rgui = RG;
        bgui = BG;
        booking = b;
        room = r;
        staff = s;
        if(b!=null){
            title.setText("Sửa thông tin phiếu đặt phòng");
            txtIdroom.setText(b.getRoom().getName());
            txtIdroom.setEditable(false);
            txtName.setText(b.getCustomer().getName());
            txtSdt.setText(b.getCustomer().getSdt());
            txtCmnd.setText(b.getCustomer().getCmnd());
            txtAddress.setText(b.getCustomer().getAddress());
            txtDays.setText(b.getTimestamp().toString());
            txtDays.setEditable(false);
            
        }else{
            title.setText("Đặt phòng");
            txtIdroom.setText(r.getName());
            txtIdroom.setEditable(false);
            txtDays.setVisible(false);
            jTime.setVisible(false);
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

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtIdroom = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        txtCmnd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jTime = new javax.swing.JLabel();
        txtDays = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(754, 393));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Chỉnh sửa đặt phòng");
        jPanel1.add(title);
        title.setBounds(40, 30, 660, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên phòng :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 100, 140, 32);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số điện thoại :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(400, 150, 100, 32);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cmnd:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(400, 100, 90, 32);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Họ tên khách hàng:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 150, 140, 32);
        jPanel1.add(txtName);
        txtName.setBounds(190, 150, 205, 31);

        txtSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtActionPerformed(evt);
            }
        });
        jPanel1.add(txtSdt);
        txtSdt.setBounds(490, 150, 210, 31);
        jPanel1.add(txtIdroom);
        txtIdroom.setBounds(190, 100, 205, 31);

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
        jPanel1.add(btnConfirm);
        btnConfirm.setBounds(490, 320, 210, 40);
        jPanel1.add(txtCmnd);
        txtCmnd.setBounds(490, 100, 210, 31);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Địa chỉ :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 200, 140, 32);

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel1.add(txtAddress);
        txtAddress.setBounds(190, 200, 510, 31);

        jTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTime.setText("Thời gian đặt phòng :");
        jPanel1.add(jTime);
        jTime.setBounds(40, 240, 132, 32);
        jPanel1.add(txtDays);
        txtDays.setBounds(190, 250, 510, 31);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String sdt = txtSdt.getText();
        String cmnd = txtCmnd.getText();
        String address = txtAddress.getText();
        if((name.length()==0)||(sdt.length()==0)||(cmnd.length()==0)||(address.length()==0)){
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống thông tin");
        }else if(name.matches("^[0-9]+$")){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
        }
        else if(!sdt.matches("^[0-9]{10}+$")){
            JOptionPane.showMessageDialog(this, "Sđt không hợp lệ");
        }
        else if(!cmnd.matches("^[0-9]{9,12}+$")){
            JOptionPane.showMessageDialog(this, "Cmnd không hợp lệ");
        }else if(!address.matches("^[a-zA-Z0-9/ ]+$")){
            JOptionPane.showMessageDialog(this, "Địa chỉ không hợp lệ");
        }
        else{
        if(booking!=null){
            booking_BUS.editBooking(booking,new Customer(txtName.getText(),txtSdt.getText(),txtCmnd.getText(),txtAddress.getText()),booking.getPayed());
            JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thông tin piếu đặt phòng thành công");
            bgui.showBooking();
        }else{
            room.setBooked(true);
            Booking s = new Booking(new Customer(txtName.getText(),txtSdt.getText(),txtCmnd.getText(),txtAddress.getText()),room,staff,false);
            new Room_BUS().editRoom(room,room.getName(),room.getBed(),room.getPrice(),room.isVip(),room.isBooked());
            booking_BUS.addBooking(s);
            JOptionPane.showMessageDialog(rootPane, "Đặt phòng thành công");
            rgui.showRoom();
        }
        this.setVisible(false);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void txtSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

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
            java.util.logging.Logger.getLogger(EditBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditBooking().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jTime;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JTextField txtDays;
    private javax.swing.JTextField txtIdroom;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
