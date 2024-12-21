package com.databasemanagament.studentmanagment.entity;

public class StudentEntities 
{
	private String studentName ;
	private int stdId ;
	private int stdAge;
	private String stdAddress;
	
	/*-------------------------Parameterised constructor--------------------------------*/
	public StudentEntities(String stdName, int stdId,  int stdAge, String stdAddress) 
	{
		super();
		this.studentName = stdName;
		this.stdId = stdId;
		this.stdAge = stdAge;
		this.stdAddress = stdAddress;
	}
	/*-----------------------------------------------------------------*/
	public StudentEntities() 
	{
		super(); 	// TODO Auto-generated constructor stub
	}
	/*------------------------------Getter and Setter-----------------------------------*/
	public String getStdName() {return studentName;}
	public void setStdName(String stdName) {this.studentName = stdName;}
	
	public int getStdId() {return stdId;}
	public void setStdId(int stdId) {this.stdId = stdId;}
	
	public int getStdAge() {return stdAge;}
	public void setStdAge(int age) {this.stdAge = age;}
	
	public String getStdAddress() {return stdAddress;}
	public void setStdAddress(String address) {this.stdAddress = address;}
	/*------------------------------To override and convert all data into strings-----------------------------------*/
	@Override
	public String toString() 
	{
		return "StudentEntities [studentName=" + studentName + ", stdId=" + stdId
				+ ", Stage=" + stdAge + ", address=" + stdAddress + "]";
	}		
}
