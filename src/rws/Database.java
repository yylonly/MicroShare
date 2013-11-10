package rws;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class Database 
{	
	public Database()
	{
		
	}
	public String Query(String SQL)
	{
		result = "";
		try 
		{
    		Class.forName(driverName);
    		
    		Connection conn = (Connection) DriverManager.getConnection(urls);
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(SQL);
			
			int colnum = rs.getMetaData().getColumnCount();
			result += "<tr>";
			for (int i = 1; i <= colnum; i++)
			{
				result += "<td>" + rs.getMetaData().getColumnName(i) + "</td>";
			}
			result += "</tr>";
		    while (rs.next())
		    {
		    	result += "<tr>";
		    	for (int i = 1; i <= colnum; i++)
		    	{
		    		result += "<td>" + rs.getString(i) + "</td>";
		    	}
		    	result += "</tr>"; 
		    }			
		} 	
		catch (Exception e) 
		{
			e.printStackTrace();
		}
    	return "<html><body><table border=\"0\">" +  result + "</table></body></html>";
	}
	
	private String result;
    public static final String driverName = "org.gjt.mm.mysql.Driver";
	public static final String urls = "jdbc:mysql://localhost/ehr?user=root&password=" +
			"&useUnicode=true&characterEncoding=UTF-8";

}
