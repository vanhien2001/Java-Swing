/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DTO.Room;
import BUS.Room_BUS;
import DTO.Staff;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vanhi
 */
public class EditRoom extends javax.swing.JFrame {
    RoomGUI rgui = null;
    Room_BUS room_bus = new Room_BUS();
    Room room = null;
    Staff staff = null;
    
    /**
     * Creates new form EditRoom
     */
    public EditRoom(Staff s) {
        initComponents();
        staff = s;
        rgui = new RoomGUI(s);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void infor(Room s,RoomGUI SG){
        rgui = SG;
        room = s;
        if(s!=null){
            title.setText("Sửa thông tin phòng");
            txtName.setText(s.getName());
            txtBed.setText(String.valueOf(s.getBed()));
            txtPrice.setText(String.valueOf(s.getPrice()));
            
        }else{
            title.setText("Thêm thông tin phòng");
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
        txtPrice = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtBed = new javax.swing.JTextField();
        txtVip = new javax.swing.JComboBox<>();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(424, 444));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Chỉnh sửa phòng");
        jPanel1.add(title);
        title.setBounds(60, 60, 310, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên phòng :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 130, 97, 32);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số giường :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 230, 97, 32);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Loại :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 270, 97, 32);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Giá :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 180, 97, 32);
        jPanel1.add(txtPrice);
        txtPrice.setBounds(170, 180, 200, 31);
        jPanel1.add(txtName);
        txtName.setBounds(170, 130, 200, 31);
        jPanel1.add(txtBed);
        txtBed.setBounds(170, 230, 200, 31);

        txtVip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thường", "Vip" }));
        jPanel1.add(txtVip);
        txtVip.setBounds(170, 280, 200, 31);

        btnConfirm.setBackground(new java.awt.Color(52, 152, 219));
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("Xác nhận");
        btnConfirm.setBorderPainted(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirm);
        btnConfirm.setBounds(60, 360, 310, 40);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String bed = txtBed.getText();
        String price = txtPrice.getText();
        if((name.length()==0)||(bed.length()==0)||(price.length()==0)){
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống thông tin");
        }else if(!name.matches("^[a-zA-Z0-9 ]+$")){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
        }
        else if(!bed.matches("^[0-9]+$")){
            JOptionPane.showMessageDialog(this, "Số giường không hợp lệ");
        }
        else if(!price.matches("^[0-9]+$")){
            JOptionPane.showMessageDialog(this, "Giá không hợp lệ");
        }
        else{
            if(room!=null){
            room_bus.editRoom(room,txtName.getText(),Integer.parseInt(txtBed.getText()),Integer.parseInt(txtPrice.getText()), String.valueOf(txtVip.getSelectedItem())=="Vip",room.isBooked());
            JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thông tin phòng thành công");
            }else{
            Room s = new Room(txtName.getText(),Integer.parseInt(txtBed.getText()),Integer.parseInt(txtPrice.getText()), String.valueOf(txtVip.getSelectedItem())=="Vip",false);
            room_bus.addRoom(s);
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin phòng thành công");
            }
            rgui.showRoom();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBed;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JComboBox<String> txtVip;
    // End of variables declaration//GEN-END:variables
}
