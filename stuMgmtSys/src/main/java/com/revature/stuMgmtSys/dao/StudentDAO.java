package com.revature.stuMgmtSys.dao;

import java.util.List;

import com.revature.stuMgmtSys.models.Student;

public interface StudentDAO {
	
	// Input -> no need
	//Output/ return -> all the rows in the table
	// each row is an object so list of rows -> list of object
	List<Student> viewAllStudent();
	
	// input -> id -> int
	//return -> a row -> an object -> student
	Student findStudentByID(int idToSearch);
	
	// input -> city -> string
	//return -> zero or more than one rows
	// 4 rows -> list of rows  -> list of object -> student
	List<Student> findStudentByCity(String cityToSearch);
	
	//input -> id, name, cls, city -> object 
	// return -> not 
	//says -> sucessfully inserted (take care method implementation)
	void insertStudent (Student s);
	
	//input -> id, name (for the id given update the newname)
	//return -> not
	void updateNameUsingID(int idToUpdate, String newName);
	
	//input -> id
	//return -> not
	void deleteStudentByID(int idToDelete);

}
