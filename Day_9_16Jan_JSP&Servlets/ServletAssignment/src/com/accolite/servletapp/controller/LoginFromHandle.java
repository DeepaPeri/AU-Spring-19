package com.accolite.servletapp;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet({"/LoginFromHandle", "/index"})
public class LoginFromHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginFromHandle() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/serverTest","root","root");  
			PreparedStatement stmt=con.prepareStatement("INSERT INTO userTable (username,passwordValue) VALUES (?,?)");  
			
			
			stmt.setString(1,request.getParameter("inputName"));
			stmt.setString(2, request.getParameter("inputPassword"));
			stmt.executeUpdate();
			System.out.println("Added user");
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
		request.getSession().invalidate();
		RequestDispatcher loginPage = request.getRequestDispatcher("index.jsp");
		loginPage.forward(request, response);
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = getServletContext().getInitParameter("url1");
				
				String username = getServletContext().getInitParameter("username");
				String password = getServletContext().getInitParameter("password");
				String inputname = request.getParameter("inputName");
				String inputpass = request.getParameter("inputPassword");
				
				Connection con = DriverManager.getConnection(url, username, password);
				
				Statement st = con.createStatement();
				String sql = "select * from userTable";
				
				ResultSet rs = st.executeQuery(sql);
				
				int flag = 0;
				
				while (rs.next()) {
			        String Name = rs.getString("username");
			        String Pass = rs.getString("passwordValue");
			        if(Name.equals(inputname) && Pass.equals(inputpass)) {
			        	flag = 1;
			        	break;
			        }
			     }
				if(flag == 0) {
					String message = "Given User name of password is invalid";
					request.setAttribute("message", message);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				else {
					HttpSession hs = request.getSession();
					hs.setAttribute("check", "done");
					String unamep = inputname;
					request.setAttribute("username",inputname);
					RequestDispatcher rd = request.getRequestDispatcher("/Success.jsp");
					rd.forward(request, response);
				}
			} 
			catch (Exception cnfe) {
				System.out.println("cnfe.getMessage():  " + cnfe.getMessage());
				cnfe.getStackTrace();
			}
	}
}
