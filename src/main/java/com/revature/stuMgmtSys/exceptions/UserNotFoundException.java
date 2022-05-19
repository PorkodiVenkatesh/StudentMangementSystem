package com.revature.stuMgmtSys.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("User is not there in the database");
	}

}
