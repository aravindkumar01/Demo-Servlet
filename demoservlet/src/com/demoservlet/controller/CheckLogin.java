package com.demoservlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoservelt.model.User;
import com.demoservelt.service.ServiceDaoImp;
import com.demoservlet.db.Dbconn;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServiceDaoImp service=new ServiceDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn=Dbconn.getSqlConnection();
			Statement stmt=conn.createStatement();
			//String uname=;			
			//String password=
			User user=User.getUser();
			user.setPassword(request.getParameter("pass").trim());
			user.setUname(request.getParameter("user").trim());
			
			if(service.checkLogin(user.getUname(), user.getPassword())){
				//System.out.println("Success");
				if((user.getUname()).equals("admin")&&(user.getPassword()).equals("admin"))
						{
					request.getRequestDispatcher("viewUsers.html").include(request, response);
				
						}
					
				else
				{
					request.getRequestDispatcher("loginSuc.html").include(request, response);
				
				}
				
			}
			else {
				request.getRequestDispatcher("loginError.html").include(request, response);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			//e.printStackTrace();
		} 
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
