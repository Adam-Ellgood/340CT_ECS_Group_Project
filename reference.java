
package uniqueid;

// additional imports will be needed to support the database and sql configurations.
import java.util.UUID;
//adam - I have added the required imports for this functionality to work
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author priors3
 * Due to the code only being JForm for configurations, I have altered the code to just the file upload button.
 * This code will not compile until the unique reference functionality is imbedded within the Module_Upload.java file.
 */
public class GenerateUniqueNumberTest extends javax.swing.JDialog {
    // required varibles declared for database connection
    Connection conn=null;
    PreparedStatement pst=null;
    
    private void btnUpload340CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //Adam's file upload - hide JForm elements on button trigger
        btnBrowse340CT.setVisible(false);
        txtPath340CT.setVisible(false);
        lblNote340CT.setVisible(false);
        lblSID340CT.setVisible(false);
        txtID340CT.setVisible(false);
        btnUpload340CT.setVisible(false);
        
        //call clock method function.
        clock();
        
        //Stephanie Integration 
        //
        String uniqueID = UUID.randomUUID().toString().substring(0, 10); 
        txt_refNum.setText("Upload Reference: "+uniqueID);
        txt_refNum.setVisible(true);
        
        //SQL required here
        try{
        
         String sql = "update users set 340CTSubmissionRef ="+ txt_refNum.getText()+"where id = " + txtID340CT.getText();

        //Connection to database initiated
        //please integrate by updating with the backend database 
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecs_database?zeroDateTimeBehavior=convertToNull","root","");
         pst=conn.prepareStatement(sql);
         pst = conn.prepareStatement(sql);
         //get the text value from textbox refNum, this value will be stored in the database against the user who is signed in   
         pst.setString(1, txt_refNum.getText());
        
         //display message box to user, confirming the unique reference number to them.
         JOptionPane.showMessageDialog(null, "Your Coursework Unique Reference Number Has Been Logged.");
    
        }  
           
         catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e); 
        }
        
        //Java built function, calls write method to begin the process of uploading the users file.
        try {
            write340CT(new String[0]);
        } catch (Exception ex) {
            Logger.getLogger(Module_Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
