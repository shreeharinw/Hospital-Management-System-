package room;
import javax.swing.*;

import com.mysql.jdbc.Connection;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.GridLayout;
import java.sql.*;

public class DConnection
{//implements ActionListener{

    /**
	 * 
	 */
	public static Connection dbConnector(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "abc123");
            JOptionPane.showMessageDialog(null,"Connection Successful");
            return conn;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		return null;
	}
	
        
   
		
   
}

