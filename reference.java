
package uniqueid;

import java.util.UUID;

/**
 *
 * @author priors3
 * Due to the code only being JForm for configurations, I have altered the code to just the file upload button.
 * This code will not compile until the unique reference functionality is imbedded within the Module_Upload.java file.
 */
public class GenerateUniqueNumberTest extends javax.swing.JDialog {
    
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
        //Connection to database here
        
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
