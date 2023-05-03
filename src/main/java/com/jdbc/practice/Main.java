
package com.jdbc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
         try {
          //  System.out.println("This is Testing");
          
          Connection con = ConnectionProvider.getConnection();
          
          String q = "insert into image(pic) values(?)";
          
          PreparedStatement pstmt = con.prepareStatement(q);
          
          JFileChooser jfc= new JFileChooser(); 
          jfc.showOpenDialog(null); 
          File file = jfc.getSelectedFile();
          
          FileInputStream fis = new FileInputStream(file);
          
          pstmt.setBinaryStream(1, fis, fis.available());
          
          pstmt.executeUpdate();
          
    //      System.out.println("Done....");
    
          JOptionPane.showMessageDialog(null,"Success");  
          
          
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
