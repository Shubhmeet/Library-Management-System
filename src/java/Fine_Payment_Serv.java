/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meetd
 */


import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add_b
 */
@WebServlet("/Fine_Payment_Serv")
public class Fine_Payment_Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fine_Payment_Serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}
    
    Connection con= null; 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //String title;
 		 try{
                     PrintWriter out = response.getWriter();
 				//ResultSet rs;
                                String n =  request.getParameter("check");
                                //int n1 = Integer.parseInt(n);
                                //out.println(n);
//                                String n1 =  request.getParameter("card_id");
                                int temp1=0,cout = 0, count = 0, b = 0, b1 = 0, b2 = 0, b3 = 0;
                                Class.forName("com.mysql.jdbc.Driver");
 				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd","root","admin");
 				Statement st1 = con.createStatement();
                                String query = "UPDATE fines SET paid = 1 WHERE loan_id = '"+n+"';";
                                b=st1.executeUpdate(query);
                                if(b>=1)
            {
                //check = 1;
                //out.println("Success");
                out.println("<html><body>");
                out.println("<script type=\"text/javascript\">");
                out.println("var popwin = window.alert(\"Fine Paid Successfully\")");
                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                out.println("</script>");
                out.println("</body></html>");
                //response.sendRedirect("webpages/index.html");
                response.setHeader("Refresh", "2;url=webpages/index.html");
                //response.sendRedirect("webpages/index.html");
            }
                 }
 		 catch(Exception e){
 			 System.out.println(e);
 		 }
 	
 	}

 }



