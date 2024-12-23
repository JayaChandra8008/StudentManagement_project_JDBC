package com.databasemanagament.studentmanagment.services;

import com.databasemanagament.studentmanagment.entity.*;

import java.util.*;

public interface StudentService 
{
	/*------------Register Student Data-----------*/
    int insertStudent(StudentEntities studentEntityObj);
    /*------------Update Student Data-----------*/
	int updateStudentData(String sAddress, String sName, int sAge, int sId);
	/*------------Update Student ID and Address-----------*/
	int updateStudentAddress(int stdId,String stdAddress);
	/*------------Retrieve all Student Data-----------*/
	ArrayList<StudentEntities> getStudentList();
	/*------------Retrieve all Student Data according to Age-----------*/
	ArrayList<StudentEntities> getStudentListAgeWise(int sAge);
	/*------------Retrieve all Student Data according to ID-----------*/
	StudentEntities getStudentDetailsById(int sId);
	
}
