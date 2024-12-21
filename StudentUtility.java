package com.databasemanagament.studentmanagment.utility;

import java.sql.*;

import com.databasemanagament.studentmanagment.config.DataBaseConfig; /*Need to import from configuration package*/

public class StudentUtility 
{
	private static Connection connectionObj = null; //here using reference for Connection Interface which directing to use methods()
	//Object is the referenceVariable which we can Create using new KeyWord for a class
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  //For driver registration using Class.
			/*--------------------------------------------*/
			/*Creating variables*/
		//	String url = "jdbc:mysql://localhost:3306/mydatabase";
		//	String username = "root";
		//	String password = "Jaya@123";
			/*---------------------------------------------------*/
			/*---------------Create connection----------------------------*/
		//	connectionObj = DriverManager.getConnection(url, username, password);
			/*---------------Creating connection in this configuration way------------------*/
			connectionObj = DriverManager.getConnection(DataBaseConfig.DB_URL,DataBaseConfig.USER_NAME,DataBaseConfig.PASSWORD);
		}
		catch(ClassNotFoundException cnfeObj)
		{
			System.out.println("Driver not found");
		}
		catch(SQLException SQLExObj)
		{
			System.out.println(SQLExObj);
		}
	}
	/*--------------------------------------------------------------------*/
	/*-------------------------Method to return connection---------------------------*/
	public static Connection getConnection()
	{
		return connectionObj;
	}
	/*-----------------Method to close connection--------------------*/
	public static void closeConnection()
	{
		try
		{
			if(connectionObj != null)
			{
				connectionObj.close();
			}
		}
		catch(SQLException SQLObj)
		{
			System.out.println(SQLObj);
		}
	}
}
