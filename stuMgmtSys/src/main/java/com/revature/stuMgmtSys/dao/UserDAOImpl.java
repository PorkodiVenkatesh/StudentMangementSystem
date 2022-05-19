package com.revature.stuMgmtSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.stuMgmtSys.Menu;
import com.revature.stuMgmtSys.exceptions.UserNotFoundException;
import com.revature.stuMgmtSys.models.Users;
import com.revature.stuMgmtSys.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{

	@Override
	public void registerUser(Users u) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement("insert into users (name, password) values(?, ?)");
			
			preparedStmt.setString(1,u.getName() );
			preparedStmt.setString(2,u.getPassword());

			// 1 means -> 1 rows affected (msg see in mysql workbench)
			// 1 row inserted to the table
			// exceuteUpdate method -> insert, delete, update - because make changes on the
			// table
			if (preparedStmt.executeUpdate() == 1)
				System.out.println("register users to the table");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void loginUser(Users userToLogin) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(" select * from users where name = ?");
			
			preparedStmt.setString(1,userToLogin.getName() );
			
			ResultSet rs = preparedStmt.executeQuery();
			
			boolean hasUser = false;
			while (rs.next()) {
				hasUser = true;
				String name = rs.getString(2);
				String pswd = rs.getString(3);
				if((name.equals(userToLogin.getName()))&& (pswd.equals(userToLogin.getPassword()))) {
					Menu.getMenu(userToLogin);
				}
				else
				{
					System.out.println("Incorrect Username and Password");
					
				}
			}
			if(!hasUser) {
				throw new UserNotFoundException();
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}
		
	}

}
