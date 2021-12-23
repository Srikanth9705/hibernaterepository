package com.createiq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * =-0987654321`-*r*v   let implementation class Empdatabase
 */
public class Empdatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Empdatabase() {
        super();
        // TODO Auto-generated constructor stub
    }
      
	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		System.out.println(id+" "+name+" "+salary);
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");
	
	preparedStatement=connection.prepareStatement("insert into employee(id,name,salary)values(?,?,?)");
	preparedStatement.setInt(1, id);
	preparedStatement.setString(2, name);
	preparedStatement.setDouble(3,salary);
	preparedStatement.executeUpdate();
	System.out.println("inserted"); 

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
