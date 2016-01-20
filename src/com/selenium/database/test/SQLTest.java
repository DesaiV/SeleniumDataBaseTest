package com.selenium.database.test;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;




public class SQLTest {
	
	@Test
	public void sqlDataTest() throws ClassNotFoundException, SQLException{
		
		//connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl="jdbc:mysql://localhost:3306/selenium";
		
		//DataBase UserName
		String username="root";
		
		//DataBase Password
		String password="root";
		
		//Load mySql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Create connection to DB
		Connection con=DriverManager.getConnection(dbUrl,username,password);
		
		//Create statement object
		Statement stmt = con.createStatement();
		
		//Execute the sql query
		ResultSet rs= stmt.executeQuery("Select * from employee");
		
		while(rs.next()){
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString(3);
			int phoneNum = rs.getInt(5);
			
			System.out.println(empFirstName + " " +" "+ empLastName+" "+phoneNum);
		}
		
		con.close();
		
	}

}
