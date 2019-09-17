package edu.ht.Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	private static String url="jdbc:sqlserver://localhost:1433;databasename=ht";
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String name="sa";
	private static String pwd="12345";
	private static Connection con=null;
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			if(con==null||con.isClosed()){
				con=DriverManager.getConnection(url,name,pwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
