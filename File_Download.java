/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_download;

//Different imports than file upload. Adam, when collaborating we need both lots of imports else it will not work.
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron Reay
 */
public class File_Download {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void read340CT (String[] args) throws Exception {
        
	Connection myConnection = null;
	Statement myStatement = null;
	ResultSet myResultset = null;
	InputStream input = null;
	FileOutputStream output = null;
        
        try {
        /* Line 40, 41 and 45 need to be altered to your local database for testing */
            myConnection = DriverManager.getConnection(
                "jdbc:mysql://dbhost","root","password");

	
            myStatement = myConnection.createStatement();
            String sql = "select FILECOMULN from TABLENAME where id='"+txtID340CT.getText()+"'";
        
            myResultset = myStatement.executeQuery(sql);
			
            File chosenFile = new File("Coursework_Upload_from_db.docx");
            output = new FileOutputStream(chosenFile);
    
            if (myResultset.next()) {

		input = myResultset.getBinaryStream("fileupload340CT"); 
		
                System.out.println("Reading file from database...");
		System.out.println(sql);
	
		byte[] buffer = new byte[1024];
		while (input.read(buffer) > 0) 
                        {
                        output.write(buffer);
			}
				
		System.out.println("\nSaved to file: " + chosenFile.getAbsolutePath());	
		System.out.println("\nCompleted successfully!");				
	
                JOptionPane.showMessageDialog(null, "File Downloaded, Please go to the file location " + txtPath340CT.getText());
                }
        
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
    
}
