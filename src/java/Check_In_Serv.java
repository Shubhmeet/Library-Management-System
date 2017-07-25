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
import java.util.ArrayList;
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
@WebServlet("/Check_In_Serv")
public class Check_In_Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check_In_Serv() {
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
                                String n =  request.getParameter("search_in");
                                
                                if (n!=null){
 				Class.forName("com.mysql.jdbc.Driver");
 				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd","root","admin");
 				Statement st1 = con.createStatement();
                                String temp = null;
                                String query1 = "SELECT distinct book_loans.loan_id, book.title, book_loans.isbn,"
                                        + " borrower.fname, borrower.lname,"
                                        + " book_loans.card_id, book_loans.date_out, book_loans.due_date, "
                                        + "book_loans.date_in FROM book_loans, book, borrower, authors,"
                                        + " book_authors where (book.isbn = book_loans.isbn and "
                                        + "borrower.card_id = book_loans.card_id and "
                                        + "(book.isbn = book_authors.isbn and "
                                        + "authors.author_id = book_authors.author_id)) and "
                                        + "(book.title LIKE '%" + n + "%' OR authors.name "
                                        + "LIKE '%" + n + "%' OR book.isbn LIKE '%" + n + "%' OR "
                                        + "borrower.fname LIKE '%" + n + "%' OR "
                                        + "borrower.lname LIKE '%" + n + "%' OR "
                                        + "borrower.ssn LIKE '%" + n + "%' OR borrower.card_id LIKE '%" + n + "%' OR "
                                        + "borrower.city LIKE '%" + n + "%')";
                                List<CheckInBean> list = new ArrayList<CheckInBean>();
                                ResultSet rs = st1.executeQuery(query1);
                                
                                //session.setAttribute("list",rs);
                                //System.out.println(n+n1);
                                //out.println("<h1>Title\t\t\t\t\t\tAvailable copies</h1>");
                                while(rs.next()){
                                temp = rs.getString(9);
                                if (temp==null){
                                    CheckInBean temp1 = new CheckInBean();
                                    temp1.setloanid(rs.getInt(1));
                                    temp1.settitle(rs.getString(2));
                                    temp1.setisbn(rs.getString(3));
                                    temp1.setfname(rs.getString(4));
                                    temp1.setlname(rs.getString(5));
                                    temp1.setcardid(rs.getInt(6));
                                    temp1.setdateout(rs.getString(7));
                                    temp1.setduedate(rs.getString(8));
                                    temp1.setdatein(rs.getString(9));
                                    
                                    list.add(temp1);
                                }
                                
                                }
                                    
                                request.setAttribute("number_of_result",list.size());
                                con.close();
                                request.setAttribute("search_in_result",list);
 				//response.sendRedirect("congrats5.jsp");
                                }
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checkin.jsp");
                                dispatcher.forward(request, response);
                                
                        }
 		 catch(Exception e){
 			 System.out.println(e);
 		 }
 	
 	}

 }
