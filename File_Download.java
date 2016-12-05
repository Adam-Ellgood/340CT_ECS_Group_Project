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
        //varibles defined for connect, prepared statement, result set, input and output streams. Values will be stored against these during execution.	
        Connection myConnection = null;
	Statement myStatement = null;
	ResultSet myResultset = null;
	InputStream input = null;
	FileOutputStream output = null;
        
        try {
        /* Line 42, 43 and 47 need to be altered to your local database for testing */
            //Get a connection to database
		myConnection = DriverManager.getConnection(
                "jdbc:mysql://dbhost","root","password");

            //get a connection to the database and execute the sql statement to select file column from table, include users entered id.
            myStatement = myConnection.createStatement();
            String sql = "select FILECOMULN from TABLENAME where id='"+txtID340CT.getText()+"'";
        
	    //Execute sql query against the database
            myResultset = myStatement.executeQuery(sql);			

	    //set up a file handle for the output of the file written to the db
            File chosenFile = new File("Coursework_Upload_from_db.docx");
            output = new FileOutputStream(chosenFile);
    
	    //process the result set, gather the blob data from the db column
            if (myResultset.next()) {

		input = myResultset.getBinaryStream("fileupload340CT"); 
		//print statements not visible to the end user.
                System.out.println("Reading file from database...");
		System.out.println(sql);
	        //buffer set up, reading binary bytes of the size of 1024. Writing it to the output file. Keep going until no more bytes can be read.
		byte[] buffer = new byte[1024];
		while (input.read(buffer) > 0) 
                        {
                        output.write(buffer);
			}
				
		System.out.println("\nSaved to file: " + chosenFile.getAbsolutePath());	
		System.out.println("\nCompleted successfully!");				
	
                JOptionPane.showMessageDialog(null, "File Downloaded, Please go to the file location " + txtPath340CT.getText());
                }
                //If there is no chosenFile for the binary input, close the binary input/output stream to the database column and call close method to close the connection to the database		
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
