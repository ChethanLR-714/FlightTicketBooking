package com.regapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {

	private Connection con;
	private Statement stmnt;

	@Override
	public boolean verifyCredentials(String user, String pass) {
		try {
			ResultSet result = stmnt
					.executeQuery("select * from login where user='" + user + "' and pass='" + pass + "'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate(
					"insert into reg values('" + name + "','" + city + "','" + email + "','" + mobile + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "test");
			stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public ResultSet getAllReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from reg");
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void delete(String email) {
		try {
			stmnt.executeUpdate("delete from reg where email='" + email + "'");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void Update(String email, String mobile) {
		try {
			stmnt.executeUpdate("update reg set mobile='" + mobile + "' where email='" + email + "'");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
