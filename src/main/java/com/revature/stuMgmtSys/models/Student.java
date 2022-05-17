package com.revature.stuMgmtSys.models;
/* also called as entity
 * models package  - has the classes which table in my database
 * student table in my school databese
 * if have others tables, those tables class representation will be in models package
 * each table in my database has each class
 */
//step 1
// this class is a representation of my student table
// rows will be my object (each row will be each object)
public class Student {
	
	// using encapsulation (oo concepts/ design)
	// cols -> are the data members of this class
	// by making data members as private and using public setter and getters
	//getter -> used to get/return the data store in the variable/data member
	// setter -> used to update/set the data to the variable/data membere
	
	
	private int id; // id column
	private String name; //name column
	private int cls; //class column
	private String city;  /// city column
	
	//to have getters and setters
	// right click -> source -> generate getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
