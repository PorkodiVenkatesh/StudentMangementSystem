package com.revature.stuMgmtSys.exceptions;

public class CityNotThereException extends Exception {
	
	public  CityNotThereException() {
		super(" City is not there in the databas");
	}

}
