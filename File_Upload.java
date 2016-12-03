/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_upload;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Adam Ellgood
 */
public class File_Upload {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void write340CT (String[] args) throws Exception {
        
 	Connection myConnection = null;
	PreparedStatement myStatement = null;
	FileInputStream input = null;
		
	try {
	
            /* Line 37, 38 and 40 need to be altered to your local database for testing */
            myConnection = DriverManager.getConnection(
                "jdbc:mysql://dbhost","root","password");
                                                               
            String sql=" update TABLENAME set COLUMNNAME=? where idCOLUMN='"+txtID340CT.getText()+"'";  
            myStatement = myConnection.prepareStatement(sql);
			 
	    File chosenFile = new File("Coursework_Upload.docx");
	    
            input = new FileInputStream(chosenFile);
	    
            myStatement.setBinaryStream(1, input);
	    	
	    System.out.println("Reading input file: " + chosenFile.getAbsolutePath());
		                    
	    System.out.println("\nStoring file in database: " + chosenFile);
	    System.out.println(sql);
	    		
	    myStatement.executeUpdate();	
	    System.out.println("\nCompleted successfully!");
			
            JOptionPane.showMessageDialog(null, "Upload Successful for student, " + txtID340CT.getText() + ". File download available.");
                     
            } catch (Exception exc) {
		exc.printStackTrace();
		} finally {			
                            if (input != null) {
				input.close();
                                }
                        
                                close(myConnection, myStatement);			
                            }
    }
}

