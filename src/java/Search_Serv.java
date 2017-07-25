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
@WebServlet("/Search_Serv")
public class Search_Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search_Serv() {
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
                                String n =  request.getParameter("search_key");
                                
                                if (n!=null){
 				Class.forName("com.mysql.jdbc.Driver");
 				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd","root","admin");
 				Statement st1 = con.createStatement();
                                
                                //String query = "SELECT title, availability from book where title like '%" + n + "%'";
                                //String query = "SELECT book.title, authors.name, book.isbn, book.availability FROM book, book_authors, authors where (book.isbn = book_authors.isbn and book_authors.author_id = authors.author_id) and (book.title LIKE '%" + n + "%' OR authors.name LIKE '%" + n + "%' OR book.isbn LIKE '%" + n + "%')"; 
                                String query1 = "SELECT book.title, authors.name, book.isbn ,  book.availability FROM book, "
                                        + "book_authors, authors where (book.isbn = book_authors.isbn and book_authors.author_id = authors.author_id) and (book.title LIKE '%" + n + "%' OR authors.name LIKE '%" + n + "%' OR book.isbn LIKE '%" + n + "%') order by book.isbn";
                                //String query = "SELECT book.title, book_extra.author_names, book.isbn, book.availability FROM book, book_extra where (book.isbn = book_extra.isbn) and (book.title LIKE '%" + n + "%' OR book_extra.author_names LIKE '%" + n + "%' OR book.isbn LIKE '%" + n + "%')";
                                List<SearchResultBean> list = new ArrayList<SearchResultBean>();
                                ResultSet rs = st1.executeQuery(query1);
                                //session.setAttribute("list",rs);
                                //System.out.println(n+n1);
                                //out.println("<h1>Title\t\t\t\t\t\tAvailable copies</h1>");
                                while(rs.next()){
                         SearchResultBean temp1 = new SearchResultBean();
                                    temp1.settitle(rs.getString(1));
                                    temp1.setauthor(rs.getString(2));
                                    temp1.setisbn(rs.getString(3));
                                    temp1.setavailability(rs.getString(4));
                                    while(rs.next()){
                                    if(temp1.getisbn().equals(rs.getString(3))){
                                        temp1.setauthor(temp1.getauthor()+", "+rs.getString(2));
                                    }
                                    else{
                                        rs.previous();
                                        break;
                                    }
                                    }
                                    list.add(temp1);
//                                    out.println(rs.getString(1)+"          ");
//                                    out.println(rs.getString(2)+"          ");
//                                    out.println("<br>");
//                                    title = rs.getString("title");
//                                    System.out.print(title + "\n");
//                                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//                                    rd.forward(request, response);
                                //response.sendRedirect("webpages/index.html");
                                }
                                
                                
                                    
                                request.setAttribute("number_of_result",list.size());
                                con.close();
                                request.setAttribute("search_result",list);
 				//response.sendRedirect("congrats5.jsp");
                                }
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/search1.jsp");
                                dispatcher.forward(request, response);
                                
                        }
 		 catch(Exception e){
 			 System.out.println(e);
 		 }
 	
 	}

 }
