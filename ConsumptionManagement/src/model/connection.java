package model;
package model;

import java.sql.*;

public class connection {
	
	public connection connect() {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:330/consumption", "root", "");
			
			//for testing
			System.out.print("Successfully Connected");
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		return con;
		
	}

}

