package com.revature.stuMgmtSys.exceptions;

public class StudentIDNotThereException  extends Exception{
	
	public StudentIDNotThereException() {
		super("Student ID is not there in the database");
	}

}
