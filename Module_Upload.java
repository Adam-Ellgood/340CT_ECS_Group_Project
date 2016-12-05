//ECS Group Project - Semester 1 340CT

//Module_Upload java file is part of the Modules package.
package Modules;

//Required imports for the Module_Upload.java file. Integrated by Adam Ellgood and Aaron Reay
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/** @author adam [ellgooda@uni.coventry.ac.uk]
 *  @author aaron [reaya2@uni.coventry.ac.uk]
 * Public class Module_Upload declared for use of a java swing JFrame. 
 * The class contains public methods which can be triggered/ called when compiled. 
 */
public class Module_Upload extends javax.swing.JFrame {

    //Main method contains look and feel of the JFrame. 
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
            java.util.logging.Logger.getLogger(Module_Upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Module_Upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Module_Upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Module_Upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        // Create and display the JFrame 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Module_Upload().setVisible(true);
            }
        });
    }
    
    //Java form elements are hidden from the user as they are not required on initial form load.
    public Module_Upload() {
        initComponents();
        //all elements become visible once the users file has been uploaded to the database.
        
        lblModuleCode.setVisible(false);
        lblModuleDetails.setVisible(false);
        btnBrowse340CT.setVisible(false);
        txtPath340CT.setVisible(false);
        lblModuleDetails.setVisible(false);
        btnBrowse340CT.setVisible(false);
        lblNote340CT.setVisible(false);
        lblSID340CT.setVisible(false);
        txtID340CT.setVisible(false);
        btnUpload340CT.setVisible(false);
        lbUploadFeedback340CT.setVisible(false);
        lblUploadTime340CT.setVisible(false);
        btnDownload340CT.setVisible(false);
    }
    
    //adam [ellgooda@uni.coventry.ac.uk]
    //Write method is for writing blobs(binary large object) to the users table in the database
    //In the ECS scenario, the blob is a coursework document submitted by the user
    public void write340CT (String[] args) throws Exception {
        
        //varibles defined for connect, prepared statement and file input stream. Values will be stored against these during execution.
 	Connection myConnection = null;
	PreparedStatement myStatement = null;
	FileInputStream input = null;
		
	try {
	// 1. Get a connection to database, otherwise the file will not be stored anywhere.
            myConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecs_database?zeroDateTimeBehavior=convertToNull","root","");
                        
	// 2. Prepare statement -  SQL statement needed to update users table file upload column, looking up the student record based on their student ID.                                       
            String sql=" update users set fileupload340CT=? where id='"+txtID340CT.getText()+"'";  
            myStatement = myConnection.prepareStatement(sql);
			
	// 3. Set parameter for file - creating a file thats an actual handel for the local file. 
	    File chosenFile = new File("Coursework_Upload.docx");
	    // 3a. Set binary input stream for the chosenFile
            input = new FileInputStream(chosenFile);
	    // 3b. Set up parameter for the binary stream prepare statement
            myStatement.setBinaryStream(1, input);
	    // 3c. System message to system output screen, not visible for the end user.	
	    System.out.println("Reading input file: " + chosenFile.getAbsolutePath());
		                    
	// 4. Execute statement - system messages to system output screen, not visible for end user.
	    System.out.println("\nStoring file in database: " + chosenFile);
	    System.out.println(sql);
	    //4a. update database with the binary data of the chosenFile into the the fileuplod column declared above.		
	    myStatement.executeUpdate();	
	    System.out.println("\nCompleted successfully!");
			
        // 5. Display confirmation - messagebox to confirm the upload to user.
            JOptionPane.showMessageDialog(null, "Upload Successful for student, " + txtID340CT.getText() + ". File download available.");
        
        // 6. If there is no chosenFile for the binary input, close the binary input stream to the database column and call close method to close the connection to the database.             
            } catch (Exception exc) {
		exc.printStackTrace();
		} finally {			
                            if (input != null) {
				input.close();
                                }
                        
                                close(myConnection, myStatement);			
                            }
    }
    
    //aaron [reaya2@uni.coventry.ac.uk]
    //Read method is for reading blobs(binary large object) from the users table in the database
    //As mentioned above, the blob read is a coursework document
    public void read340CT (String[] args) throws Exception {
        
        //varibles defined for connect, prepared statement, result set, input and output streams. Values will be stored against these during execution.
	Connection myConnection = null;
	Statement myStatement = null;
	ResultSet myResultset = null;
	InputStream input = null;
	FileOutputStream output = null;
        
        try {
        // 1. Get a connection to database, else the file will have no where to upload to.
            myConnection = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/ecs_database?zeroDateTimeBehavior=convertToNull","root","");

	// 2. Prepare statement -  SQL statement needed to select fileupload column from the users table from the database. Looking up the student record based on their student ID entry.
            myStatement = myConnection.createStatement();
            String sql = "select fileupload340CT from users where id='"+txtID340CT.getText()+"'";
        
        // 3. Execute sql query against the database connected to in section 1.    
            myResultset = myStatement.executeQuery(sql);
			
	// 4. Set up a file handle for the output of the file written to the database in the write method.
            File chosenFile = new File("Coursework_Upload_from_db.docx");
            output = new FileOutputStream(chosenFile);

        // 5. Process the result set, gather the blob data from on the database column, file upload.    
            if (myResultset.next()) {

		input = myResultset.getBinaryStream("fileupload340CT"); 
		// 5a. System output, not visible for the end user.
                System.out.println("Reading file from database...");
		System.out.println(sql);
		
                // 5b. Java input output imports required. Buffer setup, reading in binary bytes of size 1024. Writing it to the output file. Keep going until no more bytes can be read.
		byte[] buffer = new byte[1024];
		while (input.read(buffer) > 0) 
                        {
                        output.write(buffer);
			}
		// 5c. System output, not visible for the end user.		
		System.out.println("\nSaved to file: " + chosenFile.getAbsolutePath());	
		System.out.println("\nCompleted successfully!");				
			
                // 5d. Display message box to user, message box shows the file path of where to find the file.
                JOptionPane.showMessageDialog(null, "File Downloaded, Please go to the file location " + txtPath340CT.getText());
                }
        
        // 6. If there is no chosenFile for the binary input, close the binary input/output stream to the database column and call close method to close the connection to the database.
		} catch (Exception exc) {
			exc.printStackTrace();
                        } finally {
                            if (input != null) {
				input.close();
                               }

			if (output != null) {
				output.close();
                                }
			
			close(myConnection, myStatement);
		}
}
   
    //adam [ellgooda@uni.coventry.ac.uk]
    //aaron [reaya2@uni.coventry.ac.uk] 
    public void close(Connection myConn, Statement myStatement) throws SQLException {

        //Close method can throw an exception, in the event of this method being executed it closes the connection to the database and sql statements from methods read/write.
                if (myStatement != null) {
			myStatement.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
    
    //Java generated code, no effort needed by the team members.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBrowse340CT = new javax.swing.JButton();
        txtPath340CT = new javax.swing.JTextField();
        btnUpload340CT = new javax.swing.JButton();
        btnDownload340CT = new javax.swing.JButton();
        lbUploadFeedback340CT = new javax.swing.JLabel();
        lblSID340CT = new javax.swing.JLabel();
        txtID340CT = new javax.swing.JTextField();
        lblNote340CT = new javax.swing.JLabel();
        lblUploadTime340CT = new javax.swing.JLabel();
        lblFormTitle = new javax.swing.JLabel();
        lblModuleCode = new javax.swing.JLabel();
        lblModuleDetails = new javax.swing.JLabel();
        btn340CT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBrowse340CT.setText("Browse");
        btnBrowse340CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowse340CTActionPerformed(evt);
            }
        });

        btnUpload340CT.setText("Upload");
        btnUpload340CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpload340CTActionPerformed(evt);
            }
        });

        btnDownload340CT.setText("Download File");
        btnDownload340CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownload340CTActionPerformed(evt);
            }
        });

        lbUploadFeedback340CT.setText("xFeedbackx");

        lblSID340CT.setText("Student ID:");

        lblNote340CT.setText("To submit your assignment, please provide your credentials:");

        lblUploadTime340CT.setText("xTimex");

        lblFormTitle.setText("Module Coursework Hand In");

        lblModuleCode.setText("Module Code: ");

        lblModuleDetails.setText("Module Details:");

        btn340CT.setText("340CT Handin");
        btn340CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn340CTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModuleDetails)
                            .addComponent(lblModuleCode)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNote340CT)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSID340CT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtID340CT, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpload340CT))
                                    .addComponent(lbUploadFeedback340CT, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUploadTime340CT)
                                    .addComponent(btnDownload340CT)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBrowse340CT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPath340CT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btn340CT))
                            .addComponent(lblFormTitle))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFormTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn340CT)
                .addGap(26, 26, 26)
                .addComponent(lblModuleCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblModuleDetails)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBrowse340CT)
                    .addComponent(txtPath340CT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNote340CT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSID340CT)
                    .addComponent(txtID340CT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload340CT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbUploadFeedback340CT, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUploadTime340CT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDownload340CT)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //adam [ellgooda@uni.coventry.ac.uk]
    private void btnBrowse340CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowse340CTActionPerformed
        
        //Button triggers new fileChooser window
        JFileChooser fileChooser = new JFileChooser();
        
        // For Directory selections from the fileChooser only.
        /**fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);*/
 
        // For File selections from the fileChooser
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
 
        //selection variable declared, the users file selection path is gathered and is displayed in textbox path.
        int selection = fileChooser.showOpenDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
          txtPath340CT.setText(fileChooser.getSelectedFile().toString());
        }  
    }//GEN-LAST:event_btnBrowse340CTActionPerformed

    //adam [ellgooda@uni.coventry.ac.uk]
    private void btnUpload340CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpload340CTActionPerformed
        
        //Hide Jform elements when button action event is triggered
        btnBrowse340CT.setVisible(false);
        txtPath340CT.setVisible(false);
        lblNote340CT.setVisible(false);
        lblSID340CT.setVisible(false);
        txtID340CT.setVisible(false);
        btnUpload340CT.setVisible(false);
              
        //call clock method function.
        clock();
        
        //Java built function, calls write method passing parameter values. To begin the process of uploading the users file.
        try {
            write340CT(new String[0]);
        } catch (Exception ex) {
            Logger.getLogger(Module_Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpload340CTActionPerformed

    //aaron [reaya2@uni.coventry.ac.uk]
    private void btnDownload340CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownload340CTActionPerformed
        
        //Java built function, calls read method passing parameter values. To begin the process of downloading the users file.
        try {
            read340CT(new String[0]);
        } catch (Exception ex) {
            Logger.getLogger(Module_Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDownload340CTActionPerformed

    private void btn340CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn340CTActionPerformed
        
        //Show Jform elements when button action event is triggered
        
        lblModuleCode.setVisible(true);
        lblModuleDetails.setVisible(true);
        btnBrowse340CT.setVisible(true);
        txtPath340CT.setVisible(true);
        lblModuleDetails.setVisible(true);
        btnBrowse340CT.setVisible(true);
        lblNote340CT.setVisible(true);
        lblSID340CT.setVisible(true);
        txtID340CT.setVisible(true);
        btnUpload340CT.setVisible(true);
        
        //Change JForm elements values when button action event is triggered
        
        lblModuleCode.setText("340CT Module Hand In");
        lblModuleDetails.setText("Sofware Quality & Process Management Coursework Hand In December 2016");
        
    }//GEN-LAST:event_btn340CTActionPerformed

    //adam [ellgooda@uni.coventry.ac.uk]
    //aaron [reaya2@uni.coventry.ac.uk]
    public void clock() {
        
        //adam [ellgooda@uni.coventry.ac.uk]
        //making use of the caldendar imports. Variables declared to hold day, month, year, minute and hour values.
        Calendar cal=new GregorianCalendar();
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        int minute=cal.get(Calendar.MINUTE);
        int hour=cal.get(Calendar.HOUR);
        
        //adam [ellgooda@uni.coventry.ac.uk]
        //setting labels to display, showing system date and time of coursework submission through variable values set above.
        lbUploadFeedback340CT.setVisible(true);
        lbUploadFeedback340CT.setText("Coursework Submitted!");
        lblUploadTime340CT.setVisible(true);
        lblUploadTime340CT.setText("Time: "+hour+":"+minute+" | Date: "+day+"/"+month+"/"+year);
        
        //aaron [reaya2@uni.coventry.ac.uk]
        //Retrieve file download button, visible.
        btnDownload340CT.setVisible(true);
    }
    
    //Java generated code, no effort required from the team members.
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn340CT;
    private javax.swing.JButton btnBrowse340CT;
    private javax.swing.JButton btnDownload340CT;
    private javax.swing.JButton btnUpload340CT;
    private javax.swing.JLabel lbUploadFeedback340CT;
    private javax.swing.JLabel lblFormTitle;
    private javax.swing.JLabel lblModuleCode;
    private javax.swing.JLabel lblModuleDetails;
    private javax.swing.JLabel lblNote340CT;
    private javax.swing.JLabel lblSID340CT;
    private javax.swing.JLabel lblUploadTime340CT;
    private javax.swing.JTextField txtID340CT;
    private javax.swing.JTextField txtPath340CT;
    // End of variables declaration//GEN-END:variables
}
