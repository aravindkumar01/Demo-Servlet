package com.demoservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoservelt.model.User;
import com.demoservelt.service.ServiceDaoImp;
import com.demoservlet.db.Dbconn;

/**
 * Servlet implementation class insertservlet
 */
@WebServlet("/insertservlet")
public class insertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private ServiceDaoImp service=new ServiceDaoImp();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*PrintWriter out=response.getWriter();
		out.print("<html>");*/
		Connection conn;
		User user=User.getUser();
		try {
			conn = Dbconn.getSqlConnection();
			user.setLname(request.getParameter("Lname"));
			user.setFname(request.getParameter("Fname"));
			user.setUname(request.getParameter("Uname"));
			user.setMail(request.getParameter("Mail"));	
		    user.setPassword(request.getParameter("Password"));		
		    if(!service.checkLogin(user.getUname(),user.getPassword())){
		    	PreparedStatement pst=conn.prepareStatement ("insert into regacc(fname,lname,uname,mail,password,status) values(?,?,?,?,?,?)");
				 
				 pst.setString(1, user.getFname());
				 pst.setString(2, user.getLname());
				 pst.setString(3, user.getUname());
				 pst.setString(4, user.getMail());
				 pst.setString(5, user.getPassword());
				 pst.setInt(6,1);
				
				 pst.execute();
				 request.getRequestDispatcher("index.html").include(request, response);
	             conn.close();
				 pst.close();
				
			}
			else {
				//System.out.println("Fail");
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Error</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Error!!!!!<h1>");
				out.println("</body>");
				out.println("</html>");			
				
			}
			
			 
		} catch (Exception e) {
			System.out.println();// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
