package com.example;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AdditionServlet
 */
@WebServlet(urlPatterns ="/AdditionServlet",
        initParams = {
                @WebInitParam(name = "servletParam1", value = "FirstParam"),
                @WebInitParam(name = "servletParam2", value = "SecondParam")
            })
public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionServlet() {
        super();
       System.out.println("Initialising AdditionServlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletContext context = getServletContext();
        
		//ServletConfig is specific to servlet, not shared
        ServletConfig config=  getServletConfig();
        String appName = config.getInitParameter("servletParam1");
        System.out.println("servletParam1 is "+appName);
		int number1 =	Integer.parseInt(request.getParameter("num1"));
		int number2 =	Integer.parseInt(request.getParameter("num2"));
		int sum = number1 + number2 ;
		PrintWriter printWriter =  response.getWriter();
		printWriter.print("The Sum of numbers are: "+ sum);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
