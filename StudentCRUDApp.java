package com.databasemanagament.studentmanagment;

import com.databasemanagament.studentmanagment.controller.StudentController;
import com.databasemanagament.studentmanagment.dao.*; /*Need to import as we are using DAO class object*/ /*Remember remaining lines represented as dots .. */
import com.databasemanagament.studentmanagment.entity.*; /*Need to import as we are using Entity class */
import com.databasemanagament.studentmanagment.utility.*; /*Need to import as we are using Utility class */

import java.io.*;

public class StudentCRUDApp 
{
	public static void main(String[] args) throws IOException
	{
		StudentController  stc=new StudentController ();
		stc.studentOperation();
	}
}
