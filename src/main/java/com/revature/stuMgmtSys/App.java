package com.revature.stuMgmtSys;

import java.util.List;
import java.util.Scanner;

import com.revature.stuMgmtSys.dao.StudentDAO;
import com.revature.stuMgmtSys.dao.StudentDAOImpl;
import com.revature.stuMgmtSys.models.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void printDetails(Student s) {
		
		int id = s.getId();
		String name = s.getName();
		int cls = s.getCls();
		String city = s.getCity();
		
		if (id != 0)
		System.out.println(id +  " " + name + " " + cls + " " + city);
		
	}
    public static void main( String[] args )
   
    {
    	String choice; // since i'm using it in the while
    	// if i declare it inside, scopes - block {} - so i can't use it in while
        do {
        	
        	Scanner sc = new Scanner(System.in);
        	System.out.println("-----MENU-----"
        			+ "\n 1. View All Students"
        			+ "\n 2. Find Student By ID"
        			+ "\n 3. Find Student By City"
        			+ "\n 4. Insert Student"
        			+ "\n 5. Update Student name using id"
        			+ "\n 6. Delete Student By ID");
        	
        	System.out.println("Enter your option");
        	int option = sc.nextInt();
        	
        	//to access the methods inside the studentDaoImpl class
        	// i'm creating an object
        	StudentDAO  dao = new StudentDAOImpl();
        	
        	switch(option) {
        	
        	case 1:
        		System.out.println("::::Listing all the students:::::");
        		List<Student> sList = dao.viewAllStudent();
        		for (Student student : sList) {
					printDetails(student);
				}
        		break;
        		
        	case 2:
        		System.out.println("Enter the idToSearch: ");
        		int idToSearch = sc.nextInt();
        		Student s = dao.findStudentByID(idToSearch);
        		printDetails(s);
        		break;
        		
        	case 3:
        		System.out.println("Enter the cityToSearch: ");
        		String cityToSearch = sc.next();
        		List<Student> sListByCity = dao.findStudentByCity(cityToSearch);
        		for (Student student : sListByCity) {
					printDetails(student);
				}
        		break;
        		
        	case 4:
        		System.out.println("For Inserting a student..");
        		System.out.println("Enter id : ");
        		int id = sc.nextInt();
        		System.out.println("Enter name: ");
        		String name = sc.next();
        		System.out.println("Enter class: ");
        		int cls = sc.nextInt();
        		System.out.println("Enter city: ");
        		String city = sc.next();
        		
        		Student s1 = new Student();
        		s1.setId(id);
				s1.setName(name);
				s1.setCls(cls);
				s1.setCity(city);
				
				dao.insertStudent(s1);
				break;
				
        	case 5:
        		System.out.println("Enter idToUpdate: ");
        		int idToUpdate = sc.nextInt();
        		System.out.println("Enter name: ");
        		String newName = sc.next();
        		
        		dao.updateNameUsingID(idToUpdate, newName);
				break;
			
        	case 6:
        		System.out.println("Enter idToDelete: ");
        		int idToDelete = sc.nextInt();
        		
        		dao.deleteStudentByID(idToDelete);
        		break;
        		
        	default:
        		System.out.println("You entered invalid Option");
        		
        	}
        	
        	
        	
        	
        	System.out.println("Do you want to continue (yes/no)");
        	choice = sc.next();
        	
        }while(choice.equalsIgnoreCase("yes"));
        
        System.out.println("Thank you!!!!");
    }
}
