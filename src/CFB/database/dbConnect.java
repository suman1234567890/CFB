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
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

/*
 * 
	static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	private static String databaseName = "tgmc11cfb";
	private static String databaseUsername = "suman123456789";
	private static String databasePassword = "internet";
	private static String driver = "com.mysql.jdbc.Driver";
	
	public DbConnection()
	{
		initialize();		
	
	}
	void initialize()
	{
		
		try
		{
			Class.forName(driver);
            String url = "jdbc:mysql://208.11.220.249:3306/" + databaseName;
            connection = DriverManager.getConnection(url, databaseUsername, databasePassword);
            
        } 
		catch (Exception e) 
		{
			System.out.print(e);
        }
	}
	public ResultSet executeQueryString(String string)
	{
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery(string);
			return rs;
		}
		catch(Exception e)
		{
			System.out.print("Excection in Query:");
		
		}
		return null;
	}
	public int ChangeIntoDatabase(String string)
	{
		try{
			stmt=connection.createStatement();
			return(stmt.executeUpdate(string));
			
		}
		catch(Exception e){
			System.out.println("msg(DBConnection.java):"+e+"Exception in Insertion into Database");
		}
		return 0;
		
	}
	public ResultSet getResultSet()
	{
		return rs;
	
	}
 * 
 * */
