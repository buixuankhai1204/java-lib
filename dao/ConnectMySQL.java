package qltv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectMySQL {
	private static final String hostName = "localhost";
	private static final String dbName = "taikhoan";
	public static Connection connect;
	public ConnectMySQL()
	{
		try
		{
//			connect=DriverManager.getConnection("jdbc:mysql://127.0.0.1/qlsach", "root", "");
			connect=DriverManager.getConnection("jdbc:mysql://" + hostName + ":3306/" + dbName);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
