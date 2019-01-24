package com.accolite.app.dao;

import java.sql.*;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.accolite.app.model.Login;
import com.accolite.app.model.User;
import java.util.*;

public class UserDao {
	@Autowired
	DataSource datasource;

//	@Autowired
//	JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.datasource = datasource;
	}

	public void register(User user) {

		try {
			Connection con = datasource.getConnection();
			PreparedStatement sql = con.prepareStatement("insert into test.users values(?,?,?,?)");
			sql.setString(1, user.getUsername());
			sql.setString(2, user.getPassword());
			sql.setString(3, user.getEmail());
			sql.setString(4, user.getCity());

			sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public User validateUser(Login login) {

		try {
			String sql = "select username,password,email,city from test.users where username='" + login.getUsername() + "' and password='"
					+ login.getPassword() + "'";
			Statement s = datasource.getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);

			if (rs.next() == false) {
				return null;
			} else {
				String username = rs.getString(1);
				String password = rs.getString(2);
				String email = rs.getString(3);
				String city = rs.getString(4);

//				System.out.println(username+" "+password+" "+email+" "+city);
				User user = new User(username, password, email, city);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public ArrayList<User> getAllUsers()
	{
		try {
			String sql = "select username,password,email,city from test.users";
			Statement s = datasource.getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);

			ArrayList<User> users = new ArrayList<User>();
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				String email = rs.getString(3);
				String city = rs.getString(4);
				
				User user = new User(username, password, email, city);
				 users.add(user);
			}
			
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUser(String username)
	{
		try {
			String sql = "select username,password,email,city from test.users where username='"+username+"'";
			Statement s = datasource.getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			User user = null;
			while(rs.next()) {
				String username1 = rs.getString(1);
				String password = rs.getString(2);
				String email = rs.getString(3);
				String city = rs.getString(4);
				
				user = new User(username1, password, email, city);
			}
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void updateUser(User user)
	{
		try {
			Connection con = datasource.getConnection();
			PreparedStatement sql = con.prepareStatement("update test.users set username=?,password=?,email=?,city=? where username=?");
			sql.setString(1, user.getUsername());
			sql.setString(2, user.getPassword());
			sql.setString(3, user.getEmail());
			sql.setString(4, user.getCity());
			sql.setString(5, user.getUsername());

			sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	
}