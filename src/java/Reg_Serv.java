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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add_b
 */
@WebServlet("/Reg_Serv")
public class Reg_Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg_Serv() {
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
 	
 		 try{
                     PrintWriter out = response.getWriter();
                     //ResultSet rs;
 				Class.forName("com.mysql.jdbc.Driver");
 				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd","root","admin");
 				Statement st1 = con.createStatement();
 				
 				 				String n =  request.getParameter("user_id");
                                                                String n1 = request.getParameter("pass");
                                                                String query = "Select login_id from login_details where Username = '"+n+"' and Password = '"+n1+"'";
                                                                //String query = "Select login_id from login_details where Username = 'admin' and Password = 'admin')";
 				//String u =  request.getParameter("username");
 				//String p =  request.getParameter("password");
 				//st1.executeUpdate("insert into login_details (Username, Password) values('"+n+"','"+n1+"');");
 				ResultSet rs = st1.executeQuery(query);
                                //System.out.println(n+n1);
                                if(rs.next()){
//                                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//                                    rd.forward(request, response);
                                response.sendRedirect("webpages/index.html");
                                }
                                else{
//                                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//                                    rd.forward(request, response);
out.println("<html><body>");
                                out.println("<script type=\"text/javascript\">");
                                out.println("var popwin = window.alert(\"Login Failed! Incorrect Username or Password!)");
                                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                                out.println("</script>");
                                out.println("</body></html>");
response.sendRedirect("index.html");
                                }
                                    
                                
                                con.close();
 				//response.sendRedirect("congrats5.jsp");
 		 }
 		 catch(Exception e){
 			 System.out.println(e);
 		 }
 	
 	}

 }
