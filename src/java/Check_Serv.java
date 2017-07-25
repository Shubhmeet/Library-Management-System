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
@WebServlet("/Check_Serv")
public class Check_Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check_Serv() {
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
                                String n =  request.getParameter("isbn");
                                String n1 =  request.getParameter("card_id");
                                String query5 = null;
                                int avail = 0,cout = 0, count = 0, b = 0, b1 = 0, b2 = 0;
                                int flag=0;
 				Class.forName("com.mysql.jdbc.Driver");
 				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd","root","admin");
 				Statement st1 = con.createStatement();
                               System.out.print("COnnection success");
                                ResultSet rs = st1.executeQuery("Select book.availability from book where book.isbn = '"+n+"';");
                                System.out.println("Coonecction ok");
                                if(rs.next()){
                                    System.out.println("Query executed ");
                                avail = rs.getInt(1);}
                                //ResultSet rs1 = st1.executeQuery("Select borrower.act_co from borrower where borrower.card_id = '"+n1+"';");
                                //if(rs1.next()){
                                //cout = rs1.getInt(1);}
                                ResultSet rs2 = st1.executeQuery("Select count(*) from book_loans;");
                                if(rs2.next()){
                                count = rs2.getInt(1);}
                                //out.println(avail+" "+cout+" "+count);
                                Date date = new Date();
                                String dt= new SimpleDateFormat("yyyy-MM-dd").format(date);

                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                                Calendar c = Calendar.getInstance();
                                try {
                                c.setTime(sdf.parse(dt));
                                } catch (Exception e) {
                                e.printStackTrace();
                                }
                                c.add(Calendar.DATE, 14);  // number of days to add
                                String dt1 = sdf.format(c.getTime());
                                
                                query5=("Select due_date from book_loans where card_id= '"+n1+"' and date_in is null");
                                ResultSet rs3= st1.executeQuery(query5);
                                while(rs3.next()){
                                Date due= (Date) sdf.parse(rs3.getString(1));
                                if(date.after(due)){
                                flag=1;
                                }
                                }
                                
                                if ((avail == 1)&&(flag==0)){
//                                    if ((avail == 1)&&(cout<3)){
                                String query = "insert into book_loans(loan_id,isbn,card_id,date_out,due_date) "
                                        + "values('"+(count+1)+"','"+n+"','"+n1+"','"+dt+"','"+dt1+"');";
                                b=st1.executeUpdate(query);
                                //String query1 = "update borrower SET act_co=act_co+1 where borrower.card_id = '"+n1+"';";
                                //b1=st1.executeUpdate(query1);
                                String query2 = "update book SET availability = 0 where isbn = '"+n+"';";
                                b2=st1.executeUpdate(query2);
                                }
                                else if(avail == 0){
                                out.println("<html><body>");
                                out.println("<script type=\"text/javascript\">");
                                out.println("var popwin = window.alert(\"Book not Available\")");
                                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                                out.println("</script>");
                                out.println("</body></html>");
                                //response.sendRedirect("webpages/index.html");
                                response.setHeader("Refresh", "2;url=checkoutcheckin.jsp");
                                }
                                else{
                                out.println("<html><body>");
                                out.println("<script type=\"text/javascript\">");
                                out.println("var popwin = window.alert(\"Cannot issue more than 3 books!\")");
                                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                                out.println("</script>");
                                out.println("</body></html>");
                                //response.sendRedirect("webpages/index.html");
                                response.setHeader("Refresh", "2;url=checkoutcheckin.jsp");
                                }
                                
                                if(b2>=1)
            {
                //check = 1;
                //out.println("Success");
                out.println("<html><body>");
                out.println("<script type=\"text/javascript\">");
                out.println("var popwin = window.alert(\"Book Checked Out Successfully\")");
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
