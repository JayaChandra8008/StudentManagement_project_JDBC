package com.databasemanagament.studentmanagment.services;

import com.databasemanagament.studentmanagment.entity.*;
import java.util.*;

public interface StudentService 
{
    int insertStudent(StudentEntities studentEntityObj);

	int updateStudentData(String sAddress, String sName, int sAge, int sId);
	
	int updateStudentAddress(int stdId,String stdAddress);

//	ArrayList<StudentEntities> getStudentList();

	StudentEntities getStudentDetailsById(int sId);
	
}
