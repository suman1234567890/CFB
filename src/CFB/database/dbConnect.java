package CFB.database;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;

public class dbConnect {
	
	Connection con = null;
	Statement stmt = null;
	public dbConnect()
	{
		
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/MyDataSource");
			// Get a database connection
			con = ds.getConnection();
			} 
		catch(java.lang.Exception e) {
			e.printStackTrace();
			System.err.print(e.getClass().getName());
			System.err.println(e.getMessage());
			}
	}
	public ResultSet executeQueryString(String query)
	{
		ResultSet rs=null;
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.print(e.getClass().getName());
			System.err.println(e.getMessage());
		}
		return rs;
	}
	public int insertQueryString(String query)
	{
		try
		{
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			return 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.print(e.getClass().getName());
			System.err.println(e.getMessage());
			return 0;
		}
		
	}
	

}
