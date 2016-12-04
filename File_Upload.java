/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_upload;
//Required imports for the file upload functionality some of which assist with db connection
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
        //varibles defined for connect, prepared statement and file input stream. Values will be stored against these during execution.
 	Connection myConnection = null;
	PreparedStatement myStatement = null;
	FileInputStream input = null;
		
	try {
	    // 1. Get a connection to database, otherwise the file will not be stored anywhere.
            /* Line 37, 38 and 40 need to be altered to your local database for testing */
            myConnection = DriverManager.getConnection(
                "jdbc:mysql://dbhost","root","password");
            
	    // 2. Prepare statement -  SQL statement needed to update dbTABLE file upload column, looking up the student record based on their student ID.
            String sql=" update TABLENAME set COLUMNNAME=? where idCOLUMN='"+txtID340CT.getText()+"'";  
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
}

