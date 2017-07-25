/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meetd
 */

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add_b
 */
@WebServlet("/Fine_Serv")
public class Fine_Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fine_Serv() {
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
//                                String n =  request.getParameter("isbn");
                                String n =  request.getParameter("fine_disp");
                                String n1 = request.getParameter("task");
                                //n1="2";
                                System.out.println(n+" "+n1);
                                String query = null;
                                String query1 = null, query45 = null;
                                int avail = 0,cout = 0, count = 0, b = 0, b1 = 0, b2 = 0, b7 = 0;
                                int flag=0;
                                ResultSet rs = null; 
                                //out.println(n+" "+n1);
 				Class.forName("com.mysql.jdbc.Driver");
 				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd","root","admin");
 				Statement st1 = con.createStatement();
                                System.out.println("inside fine class connection");
                                if (n1.equals("1")){
                                    System.out.println("Inside 1");
                                query = "Select fines.loan_id, fines.fine_amt, fines.paid, borrower.fname, borrower.lname, book.title, "
                                        + "book.isbn from borrower, book, fines, book_loans where (fines.loan_id = book_loans.loan_id and "
                                        + "book_loans.card_id = borrower.card_id and book_loans.isbn = book.isbn)"
                                        + " and borrower.card_id = '"+n+"' and fines.paid = '1';";
                                rs = st1.executeQuery(query);
                                List<FineBean> list = new ArrayList<FineBean>();
                                System.out.print("Hi");
                                while(rs.next()){
                                    System.out.print("In first block");
                                FineBean temp1 = new FineBean();
                                    temp1.setloanid(rs.getInt(1));
                                    temp1.setfineamt(rs.getFloat(2));
                                    temp1.setpaid(rs.getInt(3)==0?"No":"Yes");
                                    temp1.setfname(rs.getString(4));
                                    temp1.setlname(rs.getString(5));
                                    temp1.settitle(rs.getString(6));
                                    temp1.setisbn(rs.getString(7));
                                    System.out.print(temp1);
                                    list.add(temp1);
                                }
                                request.setAttribute("number_of_result",list.size());
                                con.close();
                                request.setAttribute("search_result",list);
                                }
                                else if (n1.equals("2")){
                                    System.out.print("2nd if");
                                   
                                query = "Select fines.loan_id, fines.fine_amt, fines.paid,"
                                        + " borrower.fname, borrower.lname, book.title, "
                                        + "book.isbn from borrower, book, fines, book_loans"
                                        + " where (fines.loan_id = book_loans.loan_id and"
                                        + " book_loans.card_id = borrower.card_id and book_loans.isbn = book.isbn)"
                                        + " and borrower.card_id = '"+ n + "' and fines.paid = '0';";
                                rs = st1.executeQuery(query);
                                System.out.print("2nd if");
                                List<FineBean> list = new ArrayList<FineBean>();
                                System.out.print("2nd if");
                                while(rs.next()){
                                    System.out.print("in 2nd block");
                                FineBean temp1 = new FineBean();
                                    temp1.setloanid(rs.getInt(1));
                                    temp1.setfineamt(rs.getFloat(2));
                                    temp1.setpaid(rs.getInt(3)==0?"No":"Yes");
                                    temp1.setfname(rs.getString(4));
                                    temp1.setlname(rs.getString(5));
                                    temp1.settitle(rs.getString(6));
                                    temp1.setisbn(rs.getString(7));
                                    list.add(temp1);
                                    System.out.print(temp1.getisbn());
                                }
                                request.setAttribute("number_of_result",list.size());
                                con.close();
                                request.setAttribute("search_result",list);
                                }
                                else if (n1.equals("3")){
                                query = "Select fines.loan_id, fines.fine_amt, fines.paid, borrower.fname, "
                                        + "borrower.lname, book.title, book.isbn from borrower, book, fines, "
                                        + "book_loans where (fines.loan_id = book_loans.loan_id and "
                                        + "book_loans.card_id = borrower.card_id and book_loans.isbn = book.isbn)"
                                        + " and borrower.card_id = '"+n+"';";
                                rs = st1.executeQuery(query);
                                List<FineBean> list = new ArrayList<FineBean>();
                                while(rs.next()){
                                FineBean temp1 = new FineBean();
                                    temp1.setloanid(rs.getInt(1));
                                    temp1.setfineamt(rs.getFloat(2));
                                    temp1.setpaid(rs.getInt(3)==0?"No":"Yes");
                                    temp1.setfname(rs.getString(4));
                                    temp1.setlname(rs.getString(5));
                                    temp1.settitle(rs.getString(6));
                                    temp1.setisbn(rs.getString(7));
                                    list.add(temp1);
                                }
                                request.setAttribute("number_of_result",list.size());
                                con.close();
                                request.setAttribute("search_result",list);
                                }
                                
                                else if (n1.equals("4")){
                                    //String status="'Null'";
                                    
                                   query45="Select book_loans.due_date, book_loans.loan_id, book_loans.card_id,"
                                           + " book.isbn, book.title from book, book_loans where "
                                           + "book.isbn = book_loans.isbn and book_loans.date_in is null"
                                           + " and book_loans.card_id = '"+n+"'";
                                    Statement st2 = con.createStatement();
                                //    query2 = "select due_date from book_loans where card_id="+n+";";
                                    ResultSet rs1 = st2.executeQuery(query45);
                                    List<FineBean> list = new ArrayList<FineBean>();
                                    while(rs1.next()){
                                    String duedate = rs1.getString(1);
                                    Date d = new Date();
                                    Date d2 = null;
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    d2=sdf.parse(duedate);
                                    int diff = (int)((d2.getTime()-d.getTime()))/(1000*60*60*24);
                                    if (diff<0)
                                    {   float fine=(float)(-2*diff+diff)/4;
                                        
                                        FineBean temp1 = new FineBean();
                                        temp1.setloanid(rs1.getInt(2));
                                        temp1.setisbn(rs1.getString(4));
                                        temp1.settitle(rs1.getString(5));
                                        temp1.setfineamt(fine);
                                        temp1.setpaid("No");
                                        list.add(temp1);
                                        
                                    
                                    }
                                    }
                                    request.setAttribute("search_result",list);
                                    //RequestDispatcher rd=request.getRequestDispatcher("/overdue.jsp");
                                    //rd.forward(request, response);
                                    //System.out.print("good going");
                                //    query2 = "select due_date from book_loans where card_id="+n+";";
                                    

                                }

                                else if (n1.equals("5")){
                                //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/payfines.jsp");
                                response.sendRedirect("./Pay_Fine_Serv?fine_disp="+n+"&task="+n1);
                                }
                                
                                
                                
                                if (b7>=1){
//                                PrintWriter out2 = response.getWriter();
                                out.println("<html><body>");
                                out.println("<script type=\"text/javascript\">");
                                out.println("var popwin = window.alert(\"Fine Paid Successfully!)");
                                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                                out.println("</script>");
                                out.println("</body></html>");
                                }
                                
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fines.jsp");
                                dispatcher.forward(request, response);
                        }
 		 catch(Exception e){
 			 System.out.println(e);
 		 }
 	
 	}   

 }
