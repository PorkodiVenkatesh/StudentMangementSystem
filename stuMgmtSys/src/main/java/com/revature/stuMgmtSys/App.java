package com.revature.stuMgmtSys;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.FileHandler;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.stuMgmtSys.dao.UserDAO;
import com.revature.stuMgmtSys.dao.UserDAOImpl;
import com.revature.stuMgmtSys.models.Users;

public class App {
	
	// Define a static logger variable so that it references the Logger instance named "logger".
	public static Logger log = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		
		// Set up a simple configuration that logs on the console.
	//	BasicConfigurator.configure();
		/*
		 * 16113 [main] INFO com.revature.stuMgmtSys.App  - Register User!! userName -123
				The first field is the number of milliseconds elapsed since the start of the program. 
				The second field is the thread making the log request. 
				The third field is the level of the log statement. 
				The fourth field is the name of the logger associated with the log request. 
				The text after the '-' is the message of the statement.
		 */
		
	//	FileHandler fH = new 
		
		try {
			Scanner sc = new Scanner(System.in);
			String choice;
			//System.out.println(LocalDateTime.now());

			do {
				System.out.println("Welcome to My app" 
									+ "\n 1. Sign Up" 
									+ "\n 2. Sign In");
				log.info("App Started!!");
				System.out.println("Enter your choice: ");
				int option = sc.nextInt();
				
			log.info("choice entered (1-SignUp/2-SignIn)" + option );
				
			UserDAO dao = new UserDAOImpl();
			
			switch(option) {
				case 1:
					System.out.println("Enter Name:");
					String nameToRegister = sc.next();
					System.out.println("Enter Password:");
					String pswdToRegister = sc.next();
					Users userToRegister = new Users();
					userToRegister.setName(nameToRegister);
					userToRegister.setPassword(pswdToRegister);
					dao.registerUser(userToRegister);
					log.info("Register User!! userName -" + nameToRegister);
					break;
				case 2:
					System.out.println("Enter Name:");
					String nameToLogin = sc.next();
					System.out.println("Enter Password:");
					String pswdToLogin = sc.next();
					Users userToLogin = new Users();
					userToLogin.setName(nameToLogin);
					userToLogin.setPassword(pswdToLogin);
					dao.loginUser(userToLogin);
					System.out.println("Back to Main!!!");
					log.info("User Logged out!! userName -" + nameToLogin);
					break;					
				default:
					System.out.println("Incorrect Choice");
				
			}
				System.out.println("Do you want to continue? (YES/NO)");
				choice = sc.next();

			} while (choice.equalsIgnoreCase("YES"));

			System.out.println("Thankyou!!!!");
			log.info("App terminated");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
