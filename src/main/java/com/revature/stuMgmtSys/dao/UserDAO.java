package com.revature.stuMgmtSys.dao;

import com.revature.stuMgmtSys.models.Users;

public interface UserDAO {
	
	 void registerUser(Users u);

	void loginUser(Users userToLogin);
	 
	 
}
