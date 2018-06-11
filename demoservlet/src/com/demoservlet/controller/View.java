package com.demoservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoservelt.model.User;
import com.demoservelt.service.ServiceDaoImp;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ServiceDaoImp service=new ServiceDaoImp();
	   /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			List<User> users=service.findAll();
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html class='bg'>");
			out.println("<head>");
			out.println("<title>All Users</title>");
			out.println("<link rel='stylesheet' type='text/css' href='style.css'> ");
			out.println("</head>");
			out.println("<body >");
			out.println("<div class='cen '>");
			out.println("<h1><u>All Users</u></h1>");
			out.println("<table class='table table-bordered table-striped table' id='table' border='3'>");
			out.print("<tr><th>lname</th><th>FName</th><th>uname</th><th>mail</th><th>password</th>");
			for(User user:users){
				out.print("<tr><td>"+user.getLname()+"</td><td>"+user.getFname()+"</td><td>"+
			user.getUname()+"</td><td>"+user.getMail()+"</td><td>"+user.getPassword()+"</td><td></tr>");
						}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");			
		
			out.close();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
