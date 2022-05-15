package model;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class consumption {
	
	public String insertConsumption(String CusName, String PeakHoursUnit, String NormalHoursUnit, String Month, String AccNumber) 
	{ 
		String output = ""; 
		try
		{ 
			connection con = new connection();
			Connection con1 = con.connect(); 
			if (con1 == null) 
			{return "Error while connecting to the database for inserting."; } 
			// create a prepared statement
			String query = " insert into consumptions(`TrackId`,`CusName`,`PeakHoursUnit`,`NormalHoursUnit`,`Month`,`AccNumber`)"
					+ " values (?, ?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con1.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, CusName);
			preparedStmt.setString(3, PeakHoursUnit);
			preparedStmt.setString(4, NormalHoursUnit);
			preparedStmt.setString(5, Month); 
			preparedStmt.setString(6, AccNumber); 
			// execute the statement
			preparedStmt.execute(); 
			con1.close(); 
			String newItems = readConsumptions();
			
			System.out.println(newItems);

			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";

		} 
		catch (Exception e) 
		{ 
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the inquiry.\"}";
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
	public String readConsumptions() 
	{ 
		String output = ""; 
		try
		{ 
			connection con = new connection();
			Connection con1 = con.connect(); 
			if (con1 == null) 
			{return "Error while connecting to the database for reading."; } 
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Track ID</th><th>Customer Name</th><th>Peak Hours Unit</th>" +
					"<th>Normal Hours Unit</th>" + 
					"<th>Month</th>" +
					"<th>Account Number</th>" +
					"<th>Update</th><th>Remove</th></tr>"; 

			String query = "select * from consumption"; 
			Statement stmt = con1.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
			// iterate through the rows in the result set
			while (rs.next()) 
			{ 
				String TrackId = Integer.toString(rs.getInt("TrackId"));
				String CusName = rs.getString("CusName");
				String PeakHoursUnit = rs.getString("PeakHoursUnit"); 
				String NormalHoursUnit = rs.getString("NormalHoursUnit"); 
				String Month = rs.getString("Month"); 
				String AccNumber = rs.getString("AccNumber");
				// Add into the html table
				output += "<tr>"
				+ "<td><input type='hidden' name='hidConsumptionIDUpdate' id='hidConsumptionIDUpdate' value=>" + TrackId + "</td>";
				 output += "<tr><td><input id=\'hidItemIDUpdate\' name=\'hidItemIDUpdate\' type=\'hidden\' value=\'"
							+ TrackId + "'>" + CusName + "</td>";
				 output += "<td>" + PeakHoursUnit + "</td>";
				 output += "<td>" + NormalHoursUnit + "</td>";
				 output += "<td>" + Month + "</td>";
				 output += "<td>" + AccNumber + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-consumptionid='"+TrackId+"'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-secondary' data-consumptionid='"+TrackId+"'></td></tr>"; 
			} 
			con1.close(); 
			// Complete the html table
			output += "</table>"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while reading the inquiries."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
	public String updateConsumption(String TrackId,String CusName, String PeakHoursUnit, String NormalHoursUnit, String Month, String AccNumber) 

	{ 
		System.out.println("came here as well");
		String output = ""; 
		try
		{ 
			connection con = new connection();
			Connection con1 = con.connect(); 
			if (con1 == null) 
			{return "Error while connecting to the database for updating."; } 
			// create a prepared statement
			String query = "UPDATE consumptions SET CusName=?, PeakHoursUnit=?,NormalHoursUnit=?,Month=?,AccNumber=?  WHERE TrackId=?"; 
			PreparedStatement preparedStmt = con1.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(TrackId));
			preparedStmt.setString(2, CusName);
			preparedStmt.setString(3, PeakHoursUnit); 
			preparedStmt.setString(4, NormalHoursUnit); 
			preparedStmt.setString(5, Month);
			preparedStmt.setString(6, AccNumber);
			// execute the statement
			preparedStmt.execute(); 
			con1.close(); 
			String newConsumption = readConsumptions();

			output = "{\"status\":\"success\", \"data\": \"" + newConsumption + "\"}";
		} 
		catch (Exception e) 
		{ 
			output =  "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}";
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
	public String deleteConsumptions(String TrackId) 
	{ 
		String output = ""; 
		try
		{ 
			connection con = new connection();
			Connection con1 = con.connect(); 
			if (con1 == null) 
			{return "Error while connecting to the database for deleting."; } 
			// create a prepared statement
			String query = "delete from Consumption where TrackId=?"; 
			PreparedStatement preparedStmt = con1.prepareStatement(query); 
			// binding values
			preparedStmt.setString(1, TrackId); 
			// execute the statement
			preparedStmt.execute(); 
			con1.close(); 
			String newConsumption = readConsumptions();

			output = "{\"status\":\"success\", \"data\": \"" + newConsumption + "\"}";
		} 
		catch (Exception e) 
		{ 
			output =  "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
}
