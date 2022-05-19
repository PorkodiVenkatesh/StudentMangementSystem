package com.revature.stuMgmtSys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.stuMgmtSys.exceptions.CityNotThereException;
import com.revature.stuMgmtSys.exceptions.StudentIDNotThereException;
import com.revature.stuMgmtSys.models.Student;
import com.revature.stuMgmtSys.util.ConnectionUtil;

public class StudentDAOImpl implements StudentDAO {

	public List<Student> viewAllStudent() {
		List<Student> sList = new ArrayList<Student>();
		try {

			Connection con = ConnectionUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from student");
			while (rs.next()) {
				Student s = new Student();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int cls = rs.getInt(3);
				String city = rs.getString(4);
				s.setId(id);
				s.setName(name);
				s.setCls(cls);
				s.setCity(city);
				sList.add(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return sList;
	}

	public Student findStudentByID(int idToSearch) {
		Student s = new Student();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement("select * from student where id = ? ");
			preparedStmt.setInt(1, idToSearch);
			ResultSet rs = preparedStmt.executeQuery();
			
			boolean isIdFound = false;
			while (rs.next()) {
				isIdFound = true;
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int cls = rs.getInt(3);
				String city = rs.getString(4);
				s.setId(id);
				s.setName(name);
				s.setCls(cls);
				s.setCity(city);

			}
			if(isIdFound == false)
				throw new StudentIDNotThereException();
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
 
		return s;
	}

	public List<Student> findStudentByCity(String cityToSearch) {
		List<Student> sList = new ArrayList<Student>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement("select * from student where city = ? ");
			preparedStmt.setString(1, cityToSearch);
			ResultSet rs = preparedStmt.executeQuery();
			//System.out.println(preparedStmt.executeQuery());
			boolean isCityFound = false;
			while (rs.next()) {
			isCityFound = true;
				Student s = new Student();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int cls = rs.getInt(3);
				String city = rs.getString(4);

				s.setId(id);
				s.setName(name);
				s.setCls(cls);
				s.setCity(city);

				sList.add(s);

			}
			
			if (isCityFound == false)
				throw new CityNotThereException();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return sList;

	}

	public void insertStudent(Student s) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement("insert into student values(?, ?, ?, ?)");
			preparedStmt.setInt(1, s.getId());
			preparedStmt.setString(2, s.getName());
			preparedStmt.setInt(3, s.getCls());
			preparedStmt.setString(4, s.getName());

			// 1 means -> 1 rows affected (msg see in mysql workbench)
			// 1 row inserted to the table
			// exceuteUpdate method -> insert, delete, update - because make changes on the
			// table
			if (preparedStmt.executeUpdate() == 1)
				System.out.println("Inserted the student to the table");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updateNameUsingID(int idToUpdate, String newName) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(" update student set name = ? where id = ?");

			// 1nd -> newName -> String
			preparedStmt.setString(1, newName);

			// 2 st -> idToUpdate -> Int
			preparedStmt.setInt(2, idToUpdate);

			if (preparedStmt.executeUpdate() == 1)
				System.out.println("Name is updated for the given id");
			else
				throw new StudentIDNotThereException();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteStudentByID(int idToDelete) {
		try (Connection con = ConnectionUtil.getConnection()){
			//returning the object which is already created in Connection Util
			
			
			PreparedStatement preparedStmt = con.prepareStatement("delete from student where id = ?");
				
		  //1st question mark -> is a place holder of idToDelete -> and its a Integer
			preparedStmt.setInt(1, idToDelete);
		  
		
		 if(preparedStmt.executeUpdate() == 1)
			 System.out.println("deleted from table");
		 else
			 throw new  StudentIDNotThereException();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
