package com.databasemanagament.studentmanagment.controller;
import com.databasemanagament.studentmanagment.services.*;
import com.databasemanagament.studentmanagment.servicesimplementation.*;
import com.databasemanagament.studentmanagment.entity.*;

import java.io.*;
import java.util.*;

public class StudentController 
{
	//member variable
	private BufferedReader br;
	private StudentService studentserviceObj;
	
	/*---- Constructor ---*/
	public StudentController() 
	{
		/*---- Initializing BufferedReader object -----*/
		br = new BufferedReader(new InputStreamReader(System.in)); //Object creation
		/*---- Initializing StudentService -------*/
		studentserviceObj = new ServiceImplementation(); //Object creation
	}
	/*------ Method for student operation ------*/
	public void studentOperation()throws IOException
	{
		int choice,operation;
		do
		{
			/*----- Displaying menu to the user ------*/
			System.out.println("------------------------------------------");
			System.out.println("------- Student Management Portal --------");
			System.out.println("-------------------------------------------");
			System.out.println("1. Register New Student");
			System.out.println("2. Update Standard, Age and Roll Number");
			System.out.println("3. Update Address");
//			System.out.println("4. Display All Student");
		//	System.out.println("5. Display Student List Standard wise");
			System.out.println("4. Display Details of One Student");
			System.out.println("--------------------------------------------");
			/*----- Asking user to select any one operation ------*/
			System.out.print("Select any one operation : ");
			operation =Integer.parseInt(br.readLine());
			System.out.println("-------------------------------------------");
			/*---- Executing the task as per user's input -----*/
			switch(operation)
			{
			case 1: registerStudent();
			break;
			case 2: updateStudentData();
			break;
			case 3: updateStudentAddress();
			break;
			case 4: getStudentDetailsById();
			break;
			default: System.out.println("Invalid selection");
			}
			System.out.println("---------------------------------------------------------");
			/*---- Asking user whether he wants to continue or exit -----*/
			System.out.print("Press 0 to exit or any other number to continue : ");
			choice = Integer.parseInt(br.readLine());			
		}
		while(choice!=0);
	}
	/*------------------------------------------------------*/
	/*1---- Method to register student ----*/
	public void registerStudent()throws IOException
	{
		/*----------------- Receiving data from User through keyboard------------------------*/
		System.out.println("---------- Student Data Entry -------");
		
		System.out.print("Student Name : ");
		String sName = br.readLine();
		
		System.out.print("Student Id : ");
		int sId = Integer.parseInt(br.readLine());
		System.out.print("age : ");
		int sAge = Integer.parseInt(br.readLine());
		
		System.out.print("Address : ");
		String sAddress = br.readLine();
		
		System.out.println("---------------------------------------------------");
		/*----------------------Creating Student object ------------------------*/
		StudentEntities student = new StudentEntities(sName, sId, sAge, sAddress);
		/*------- Calling service layer to register student -----*/
		int row = studentserviceObj.insertStudent(student);
		if(row > 0)
		{
			System.out.println("Student data successfully inserted into database");
		}
		else
		{
			System.out.println("Unable to insert data into database");
		}
	}
	/*2---- Method to update standard,age and roll of student ----*/
	public void updateStudentData()throws IOException //Method name should be same as DAO class Methods
	{
		/*----------------- Receiving data from User through keyboard------------------------*/
		System.out.println("---------- Standard and Age ,Address updation-------");
		System.out.print("Enter Student NAme : ");
		String sName= br.readLine();
		
		System.out.print("Enter Address : ");
		String sAddress = br.readLine();
		
		System.out.print("Age : ");
		int sAge = Integer.parseInt(br.readLine());
		
		System.out.print("id : ");
		int sId = Integer.parseInt(br.readLine());
		
		System.out.println("---------------------------------------------------");
		/*------- Calling service layer to update student -----*/
		int row = studentserviceObj.updateStudentData(sAddress, sName,sAge,sId);
		if(row > 0)
		{
			System.out.println("Student data successfully updated into database");
		}
		else
		{
			System.out.println("Unable to update data into database");
		}
	}
	
	/*3---- Method to update Address of student ----*/
	public void updateStudentAddress()throws IOException //Method name should be same as DAO class Methods
	{
		/*----------------- Receiving data from User through keyboard------------------------*/
		System.out.println("---------- Address updation-------");
		
		System.out.print("Enter Address : ");
		String sAddress = br.readLine();
		
		System.out.print("id : ");
		int sId = Integer.parseInt(br.readLine());
		
		System.out.println("---------------------------------------------------");
		/*------- Calling service layer to update student -----*/
		int row = studentserviceObj.updateStudentAddress(sId,sAddress);
		if(row > 0)
		{
			System.out.println("Student data successfully updated into database");
		}
		else
		{
			System.out.println("Unable to update data into database");
		}
	}
	/*4---- Method to Retrieve all student data -----*/
//	public void getStudentList()
//	{
//		/*---- calling service layer to retrieve all student data -----*/
//		ArrayList<StudentEntities> studentArrayList=studentserviceObj.getStudentList();
//		if(studentArrayList.size() > 0)
//		{
//			/*---- Record found -----*/
//			System.out.println("------------ Student List ------------");
//			for (StudentEntities studentEntityObj : studentArrayList) 
//			{
//				System.out.println(studentEntityObj);
//			}
//		}
//		else
//		{
//			/*--- no record found ----*/
//			System.out.println("No record found ");
//		}
//	}
	/*4---- Method to Retreive data by ID of student ----*/
	public void getStudentDetailsById() throws IOException //Method name should be same as DAO class Methods
	{
		/*----------------- Receiving data from User through keyboard------------------------*/
		System.out.println("---------- To Retreive data by ID of student  -------");
		
		System.out.print("id : ");
		int sId = Integer.parseInt(br.readLine());
		
		System.out.println("---------------------------------------------------");
		/*------- Calling service layer to Retrieve student -----*/
		StudentEntities studentEntitiesObj=studentserviceObj.getStudentDetailsById(sId);
		if(studentEntitiesObj != null)
		{
				System.out.println("Student Id : "+studentEntitiesObj.getStdId());
				System.out.println("Name : "+studentEntitiesObj.getStdName());
				System.out.println("Age : "+studentEntitiesObj.getStdAge()+" year");
				System.out.println("Address : "+studentEntitiesObj.getStdAddress());
				System.out.println("-------------------------------------------");
		}
		else
		{
			/*--- no record found ----*/
			System.out.println("No record found ");
		}
	}
	
}

