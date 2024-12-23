package com.databasemanagament.studentmanagment.dao;
import java.sql.*;

import java.util.*;

import com.databasemanagament.studentmanagment.entity.StudentEntities;
import com.databasemanagament.studentmanagment.utility.StudentUtility; /*Mandate to import package of entities or were you stored values in entity program as it is encapsulated / private*/

public class StudentDAO 
{
	public int insertStudent(Connection conRef, StudentEntities studentEntityObj) 
	{
		int rows = 0;
		try 
		{
			if (conRef != null) 
			{
				/*----Creating PreparedStatement---*/
				PreparedStatement preStmtObj = conRef.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
				/*------------------------------------------------------------------------------*/
				/*-----Setting data into prepared statement------*/
				preStmtObj.setString(1, studentEntityObj.getStdName());     //Invoked from getter and setter from entity class
				preStmtObj.setInt(2, studentEntityObj.getStdAge());         //Invoked from getter and setter from entity class
				preStmtObj.setInt(3, studentEntityObj.getStdId()); 		    //Invoked from getter and setter from entity class
				preStmtObj.setString(4, studentEntityObj.getStdAddress());  //Invoked from getter and setter from entity class
				/*----------------------------------------------------------*/
				/*--------To execute query-------*/
				rows = preStmtObj.executeUpdate();
				return rows;
			} 
			else 
			{
				return rows;
			}
		} 
		catch (SQLException SQLObj) 
		{
			System.out.println(SQLObj);
			return rows;
		}
	}
	/* Method to update Age */
	public int updateStudentData(String stdAddress,String stdName,int stdAge,int sId) //Need to pass Parameters must for updating if no object is used of a class
	{
		int rows = 0;
		try
		{
			Connection conRef = StudentUtility.getConnection();
			/*----------Creating Prepared statement ------------*/
			PreparedStatement preStmtRef = conRef.prepareStatement("UPDATE student SET stdAge = ?,studentName = ? ,stdAddress = ?  WHERE stdId = ?");
			/*----------------------------------------------------------------------------------------------------------------*/
			/*-----------------------Setting data into prepared statement-------------------------*/
			preStmtRef.setInt(1, stdAge);
			preStmtRef.setString(2, stdName);
			preStmtRef.setString(3, stdAddress);
			preStmtRef.setInt(4, sId);
			/*-----------------------------------------------------*/
			/*--------------------------To execute query---------------------------*/
			rows = preStmtRef.executeUpdate();
 			return rows;
		}
		catch(SQLException SQLObj)
		{
			System.out.println(SQLObj);
			return rows;
		}
	}
    /* Method to update Address */
	public int updateStudentAddress(int stdId,String stdAddress) //Need to pass Parameters must for updating if no object is used of a class
	{
		int rows = 0;
		try
		{
			Connection conRef = StudentUtility.getConnection();
			/*----------Creating Prepared statement ------------*/
			PreparedStatement preStmtRef = conRef.prepareStatement("UPDATE student SET stdAddress = ? WHERE stdId = ?");
			/*----------------------------------------------------------------------------------------------------------------*/
			/*-----------------------Setting data into prepared statement-------------------------*/
			preStmtRef.setString(1, stdAddress); //Maintain set attributes then where attributes According to query
			preStmtRef.setInt(2,stdId );
			/*-----------------------------------------------------*/
			/*--------------------------To execute query---------------------------*/
			rows = preStmtRef.executeUpdate();
 			return rows;
		}
		catch(SQLException SQLObj)
		{
			System.out.println(SQLObj);
			return rows;
		}
	}
//	/*------------------Method for fetching all student list-----------*/
	/*----- Method for fetching all student List -----*/
	public ArrayList<StudentEntities> getStudentList()
	{
		/*---- creating blank student list ---*/
		ArrayList<StudentEntities> studentList=new ArrayList<StudentEntities>();
		try
		{
			/*------------------------------------------------*/
			Connection con=StudentUtility.getConnection();
			/*----- Creating Statement -----*/
			Statement stmt=con.createStatement();
			/*---- executing query ----*/
			ResultSet resultSetObj=stmt.executeQuery("select * from student");
			/*---- Traversing result set -----*/
			while(resultSetObj.next())
			{
				/*--- Creating student object -----*/
				StudentEntities studentEntitiesObj=new StudentEntities();
				/*--- setting data into student object from result set -----*/
				studentEntitiesObj.setStdId(resultSetObj.getInt("stdId")); //From Student entity class
				studentEntitiesObj.setStdName(resultSetObj.getString("studentName"));  
				studentEntitiesObj.setStdAge(resultSetObj.getInt("stdAge"));
				studentEntitiesObj.setStdAddress(resultSetObj.getString("StdAddress"));
				/*-----------------------------------------------*/
				/*---- Inserting this student into student list -----*/
				studentList.add(studentEntitiesObj);
			}
			/*--- return the Array list ----*/
			return studentList;
		}
		catch (SQLException e)
		{
			System.out.println(e);
			return studentList;
		}
	}
//	/*----- Method for fetching student List of particular standard -----*/
	public ArrayList<StudentEntities> getStudentListAgeWise(int stdAge)
	{
		/*---- creating blank student list and Object for Array List ---*/
		ArrayList<StudentEntities> studentList=new ArrayList<StudentEntities>();
		try
		{
			/*------------------------------------------------*/
			Connection conRef=StudentUtility.getConnection();
			/*----- Creating Statement -----*/
			PreparedStatement stmtRef=conRef.prepareStatement("select * from student where stdAge = ?");
			/*---- Setting data into query parameter ------*/
			stmtRef.setInt(1, stdAge);
			/*---- executing query ----*/
			ResultSet resultSetObj=stmtRef.executeQuery();
			/*---- Traversing result set -----*/
			while(resultSetObj.next())
			{
				/*--- Creating student object -----*/
				StudentEntities studentEntitiesObj=new StudentEntities();
				/*--- setting data into student object from resultset -----*/
				studentEntitiesObj.setStdId(resultSetObj.getInt("stdId")); //From Student entity class
				studentEntitiesObj.setStdName(resultSetObj.getString("studentName"));
				studentEntitiesObj.setStdAge(resultSetObj.getInt("stdAge"));
				studentEntitiesObj.setStdAddress(resultSetObj.getString("StdAddress"));
				/*-----------------------------------------------*/
				/*---- Inserting this student into student list -----*/
				studentList.add(studentEntitiesObj);
			}
			/*--- return the Array list ----*/
			return studentList;
		}
		catch (SQLException e)
		{
			System.out.println(e);
			return studentList;
		}
	}
//	/*----- Method for fetching details of Particular Student -----*/
	public StudentEntities getStudentDetailsById(int stdId) 
	{
		StudentEntities student=new StudentEntities();
		try
		{
			/*------------------------------------------------*/
			Connection con=StudentUtility.getConnection();
			/*----- Creating Statement -----*/
			PreparedStatement stmt=con.prepareStatement("select * from student where stdId = ?");
			/*---- Setting data into query parameter ------*/
			stmt.setInt(1, stdId);
			/*---- executing query ----*/
			ResultSet resultSetRef=stmt.executeQuery();
			/*---- Traversing resultset -----*/
			while(resultSetRef.next())
			{
				/*--- setting data into student object from resultset -----*/
				student.setStdId(resultSetRef.getInt("stdId")); //use only coloumn names or index
				student.setStdName(resultSetRef.getString("studentName"));
				student.setStdAge(resultSetRef.getInt("stdAge"));
				student.setStdAddress(resultSetRef.getString("stdAddress"));
				/*-----------------------------------------------*/	
			}
			/*--- return the arraylist ----*/
			return student;
		}
		catch (SQLException e)
		{
			System.out.println(e);
			return student;
		}
	}	
}
