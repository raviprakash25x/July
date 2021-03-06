package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.SliderUI;

import org.json.simple.JSONObject;

import com.util.SLUtil;

/**
 * Servlet implementation class VM
 */
@WebServlet("/VM")
public class VM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SLUtil obj=new SLUtil();
		try
		{
			JSONObject message=obj.getVMInfo();
			request.setAttribute("message", message.toJSONString());
			request.getRequestDispatcher("JSP/ADMIN/VMInfo.jsp").forward(request, response);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("/Serverless/JSP/ADMIN/AdminHome.jsp?message=Unable to fetch VM details. Retry..");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
