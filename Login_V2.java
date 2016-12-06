
package Login;

import Modules.Module_Upload;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mustafa 
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Module_Upload Modules_Upload;
    public Connection cn; 
    public Statement st; 
    
    public Login() {
        initComponents();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3300/ecs_database?zeroDateTimeBehavior=convertToNull","root","");
            st=cn.createStatement();
            JOptionPane.showMessageDialog(null, "Connected");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Sorry, Not Connected - Database Issue");
            this.dispose();
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

        lblStudentTitle = new javax.swing.JLabel();
        lblStudentUsername = new javax.swing.JLabel();
        lblStudentPassword = new javax.swing.JLabel();
        txtStudentUser1 = new javax.swing.JTextField();
        txtStudentPass1 = new javax.swing.JPasswordField();
        btnStudentLogin = new javax.swing.JButton();
        lblStaffTitle1 = new javax.swing.JLabel();
        lblStaffUsername1 = new javax.swing.JLabel();
        lblStaffPassword1 = new javax.swing.JLabel();
        txtStaffUser1 = new javax.swing.JTextField();
        txtStaffPass1 = new javax.swing.JPasswordField();
        btnStaffLogin1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblStudentTitle.setText("Student Login");

        lblStudentUsername.setText("Username");

        lblStudentPassword.setText("Password");

        btnStudentLogin.setText("Login");
        btnStudentLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentLoginActionPerformed(evt);
            }
        });

        lblStaffTitle1.setText("Staff Login");

        lblStaffUsername1.setText("Username");

        lblStaffPassword1.setText("Password");

        btnStaffLogin1.setText("Login");
        btnStaffLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffLogin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStudentPassword)
                                .addGap(18, 18, 18)
                                .addComponent(txtStudentPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStudentUsername)
                                .addGap(18, 18, 18)
                                .addComponent(txtStudentUser1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnStudentLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(lblStudentTitle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStaffPassword1)
                        .addGap(18, 18, 18)
                        .addComponent(txtStaffPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStaffUsername1)
                        .addGap(18, 18, 18)
                        .addComponent(txtStaffUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnStaffLogin1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblStaffTitle1)))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStaffTitle1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStaffUsername1)
                            .addComponent(txtStaffUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStaffPassword1)
                            .addComponent(txtStaffPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnStaffLogin1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStudentTitle)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStudentUsername)
                            .addComponent(txtStudentUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStudentPassword)
                            .addComponent(txtStudentPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnStudentLogin)))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudentLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentLoginActionPerformed
        try {
            String sql=" select *from users where username = '"+txtStudentUser1.getText()+"'and password = '"+String.valueOf(txtStudentPass1.getPassword())+"'";
            ResultSet rss=st.executeQuery(sql);
            if (rss.next()) {
                Modules_Upload = new Module_Upload();
                Modules_Upload.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error1: Incorrect Login/n Error2: Database servers downtime");
        }
    }//GEN-LAST:event_btnStudentLoginActionPerformed

    private void btnStaffLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffLogin1ActionPerformed
        try {
            String sql=" select *from staff where username = '"+txtStaffUser1.getText()+"'and password = '"+String.valueOf(txtAdminPass1.getPassword())+"'";
            ResultSet rss=st.executeQuery(sql);
            if (rss.next()) {
                Modules_Upload = new Module_Upload();
                Modules_Upload.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error1: Incorrect Login/n Error2: Database servers downtime");
        }
    }//GEN-LAST:event_btnStaffLogin1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStaffLogin1;
    private javax.swing.JButton btnStudentLogin;
    private javax.swing.JLabel lblStaffPassword1;
    private javax.swing.JLabel lblStaffTitle1;
    private javax.swing.JLabel lblStaffUsername1;
    private javax.swing.JLabel lblStudentPassword;
    private javax.swing.JLabel lblStudentTitle;
    private javax.swing.JLabel lblStudentUsername;
    private javax.swing.JPasswordField txtStaffPass1;
    private javax.swing.JTextField txtStaffUser1;
    private javax.swing.JPasswordField txtStudentPass1;
    private javax.swing.JTextField txtStudentUser1;
    // End of variables declaration//GEN-END:variables
}
