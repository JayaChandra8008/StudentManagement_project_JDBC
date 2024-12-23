package com.databasemanagament.studentmanagment.servicesimplementation;

import com.databasemanagament.studentmanagment.utility.*;

import com.databasemanagament.studentmanagment.dao.StudentDAO;
import com.databasemanagament.studentmanagment.entity.StudentEntities;
import com.databasemanagament.studentmanagment.services.StudentService;
import java.util.*;

public class ServiceImplementation implements StudentService 
{
    private StudentDAO studentDao;

    public ServiceImplementation()
    {
        studentDao = new StudentDAO();
    }
    /*-------------------------1-----------------------------------*/
    public int insertStudent(StudentEntities studentEntityObj) 
    {
        return studentDao.insertStudent(StudentUtility.getConnection(), studentEntityObj);
    }
    /*-------------------------2-----------------------------------*/
    public int updateStudentData(String sAddress, String sName, int sAge, int sId) 
    {
        return studentDao.updateStudentData(sAddress, sName, sAge, sId);
    }
    /*-------------------------3-----------------------------------*/
	public int updateStudentAddress(int stdId, String stdAddress) 
	{
		return studentDao.updateStudentAddress(stdId, stdAddress);
	}
//	/*-------------------------4-----------------------------------*/
	public ArrayList<StudentEntities> getStudentList() {
		// TODO Auto-generated method stub
		return studentDao.getStudentList();
	}
	/*-------------------------5-----------------------------------*/
	@Override
	public ArrayList<StudentEntities> getStudentListAgeWise(int sAge) 
	{
		// TODO Auto-generated method stub
		return studentDao.getStudentListAgeWise(sAge);
	}
	 
	/*-------------------------6-----------------------------------*/
	public StudentEntities getStudentDetailsById(int sId) 
	{
		return studentDao.getStudentDetailsById(sId);
	}
	
}
