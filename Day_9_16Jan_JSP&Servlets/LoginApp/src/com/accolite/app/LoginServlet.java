package com.accolite.app;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public LoginServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/studentdatabase","root","root");  
			PreparedStatement stmt=con.prepareStatement("Select * from student_management"); 
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  
				System.out.println(rs.getInt("student_id")+ rs.getString("student_name"));
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getCo			PreparedStatement stmt=con.prepareStatement("INSERT INTO student_management (student_id,student_name) VALUES (?,?)"); 
nnection(  
			"jdbc:mysql://localhost:3306/studentdatabase","root","root");  
			
			stmt.setInt(1,Integer.parseInt(request.getParameter("userpass")));
			stmt.setString(2, request.getParameter("username"));
			stmt.executeUpdate();
			System.out.println("Added user");
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
	}
	
	public void showData() {
		
			
	}
}
