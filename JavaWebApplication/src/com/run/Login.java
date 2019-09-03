package com.run;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		DataBase obj=new DataBase();
		Statement bool=obj.getConnection();
		if(bool!=null) {
			
			  boolean b=obj.login(uname, password);
			  if(b)
				  response.sendRedirect("http://localhost:8888/JavaWebApplication/login.jsp");
			  else
				  response.sendRedirect("http://localhost:8888/JavaWebApplication/notlogin.jsp");
		  }
		else {response.sendRedirect("http://localhost:8888/JavaWebApplication/error.jsp");}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
