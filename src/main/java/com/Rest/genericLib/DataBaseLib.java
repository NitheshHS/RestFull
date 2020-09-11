package com.Rest.genericLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseLib {
	static Connection conn;
	static Statement stmt;
	public static void connectToMySQL() {
		try {
			Driver regDriver=new Driver();
			DriverManager.registerDriver(regDriver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "nithesh@1998");
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
	
	public static Object exceuteQueryAndGetdata(String query,int column,Object expectedData) {
		boolean flag=false;
		try {
			stmt = conn.createStatement();
			ResultSet result=stmt.executeQuery(query);
			while(result.next()) {
				if(result.getObject(column).equals(expectedData)) {
					flag=true;
					break;
				}
			}
			
			
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		if(flag) {
			return expectedData;
		}
		else
		{
			return expectedData;
		}
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
