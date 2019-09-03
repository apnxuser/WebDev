package com.run;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter(); 
		String uname1=request.getParameter("uname");
		String password1=request.getParameter("password");
		String cname1=request.getParameter("cname");
		String dept1=request.getParameter("dept");
		
		//System.out.println(uname1+" "+password1+" "+cname1+" "+dept1);
		
		DataBase db=new DataBase();
		Statement bool=db.getConnection();
		if(bool!=null) {
		boolean b=db.insertStudent(uname1, password1, cname1, dept1);
		if(b)
			response.sendRedirect("http://localhost:8888/JavaWebApplication/datainsert.jsp");
			else {response.sendRedirect("http://localhost:8888/JavaWebApplication/notinsert.jsp");}
		}
		else
		   response.sendRedirect("http://localhost:8888/JavaWebApplication/error.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
