package com.regapp.model;

import java.sql.ResultSet;

public interface DAOService {
	
	public void connectDB();
public boolean verifyCredentials(String user,String pass);

public void saveRegistration(String name,String city, String email, String mobile);

public   ResultSet getAllReg();

public void delete(String email);
public void Update(String email, String mobile);


}
