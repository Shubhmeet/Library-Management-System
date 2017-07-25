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
@WebServlet("/Check_In_Update")
public class Check_In_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check_In_Update() {
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
                                //String n1 =  request.getParameter("card_id");
                                int temp1=0,cout = 0, count = 0, b = 0, b1 = 0, b2 = 0, b3 = 0;
                                String cardid1 = null;
                                String isbn1 = null;
                                String duedate = null;  
 				Class.forName("com.mysql.jdbc.Driver");
 				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd","root","admin");
 				Statement st1 = con.createStatement();
                                Statement st2 = con.createStatement();
                                ResultSet rs = st2.executeQuery("Select isbn from book_loans where book_loans.loan_id = '"+n+"';");
                                if(rs.next()){
                                    
                                Date date = new Date();
//                                String dt= new SimpleDateFormat("yyyy-MM-dd").format(date);
                                String dt = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                ResultSet rs1 = st1.executeQuery("Select book_loans.isbn from book_loans where book_loans.loan_id = '"+n+"';");
                                if(rs1.next()){
                                isbn1 = rs1.getString(1);}
                                ResultSet rs2 = st1.executeQuery("Select book_loans.card_id from book_loans where book_loans.loan_id = '"+n+"';");
                                if(rs2.next()){
                                cardid1 = rs2.getString(1);}
                                ResultSet rs3 = st1.executeQuery("Select book_loans.due_date from book_loans where book_loans.loan_id = '"+n+"';");
                                if(rs3.next()){
                                duedate = rs3.getString(1);}
                                //out.println("Found!! "+cardid1);
                                String query2 = "update book SET availability = 1 where isbn = '"+isbn1+"';";
                                b2=st1.executeUpdate(query2);
                                //String query1 = "update borrower SET act_co=act_co-1 where borrower.card_id = '"+cardid1+"';";
                                //b1=st1.executeUpdate(query1);
                                String query3 = "update book_loans SET date_in = '"+dt+"' where book_loans.loan_id = '"+n+"';";
                                b=st1.executeUpdate(query3);
                                Date d1 = null;
                                Date d2 = null;
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                try{
                                d1=format.parse(dt);
                                d2=format.parse(duedate);
                                }
                                catch (ParseException e){
                                    e.printStackTrace();
                                }
                                int days = (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
                                out.println(days);
                                int paid=0;
                                String query4 = "insert into fines(loan_id,fine_amt,paid) values('"+n+"','"+((days)*0.25*(-1))+"','"+ paid+ "');";
                                if(days<0){
                                    temp1=1;
//                                out.println(days);
//                                out.println("<html><body>");
//                                out.println("<script type=\"text/javascript\">");
//                                out.println("var popwin = window.alert(\"Book Checked In / Returned Successfully. Due date passed... Some Fine to be paid)");
//                                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
//                                out.println("</script>");
//                                out.println("</body></html>");
                                b3=st1.executeUpdate(query4);
                                con.close();
                                //response.setHeader("Refresh", "2;url=webpages/index.html");
                                }
                                else if(days>0){
                                    temp1=2;
                                    con.close();
//                                out.println("<html><body>");
//                out.println("<script type=\"text/javascript\">");
//                out.println("var popwin = window.alert(\"Book Checked In / Returned Successfully\")");
//                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
//                out.println("</script>");
//                out.println("</body></html>");
                //response.sendRedirect("webpages/index.html");
                //response.setHeader("Refresh", "2;url=webpages/index.html");
                //response.sendRedirect("webpages/index.html");
                                }
                                else{
                                    con.close();
                                    //PrintWriter out1 = response.getWriter();
                                out.println("<html><body>");
                out.println("<script type=\"text/javascript\">");
                out.println("var popwin = window.alert(\"Error! Something bad happened... We're trying to fix it!\")");
                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                out.println("</script>");
                out.println("</body></html>");
                //response.sendRedirect("webpages/index.html");
                //response.setHeader("Refresh", "2;url=webpages/index.html");
                //response.sendRedirect("webpages/index.html");
                                }
                                if (temp1==1){
                                PrintWriter out2 = response.getWriter();
                                out2.println("<html><body>");
                                out2.println("<script type=\"text/javascript\">");
                                out2.println("var popwin = window.alert(\"Book Checked In / Returned Successfully. Due date passed... Fine to be paid: $"+(0.25*days*(-1))+")");
                                out2.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                                out2.println("</script>");
                                out2.println("</body></html>");
                                }
                                else if (temp1==2){
                                //PrintWriter out3 = response.getWriter();
                                    out.println("<html><body>");
                                out.println("<script type=\"text/javascript\">");
                                out.println("var popwin = window.alert(\"Book Checked In / Returned Successfully\")");
                                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                                out.println("</script>");
                                out.println("</body></html>");
                                }
                                response.setHeader("Refresh", "2;url=webpages/index.html");
                                }
                        

                 }
 		 catch(Exception e){
 			 System.out.println(e);
 		 }
 	
 	}

 }
