
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
public class Borrower_Serv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int check = 0;
            String abc;
                try{
            /* TODO output your page here. You may use following sample code. */
            int count = 0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd","root","admin");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lcd?" + "user=root&password=admin");
            PreparedStatement ps1=con.prepareStatement("select count(*) from borrower");
            ResultSet rs=ps1.executeQuery();
            if(rs.next()){
            count = rs.getInt(1);
            }
            PreparedStatement ps=con.prepareStatement("insert into borrower values("+(count+1)+",?,?,?,?,?,?,?)");
            ps.setString(1, request.getParameter("ssn"));
            ps.setString(2, request.getParameter("first_name"));
            ps.setString(3, request.getParameter("last_name"));
            ps.setString(4, request.getParameter("address"));
            ps.setString(5, request.getParameter("city"));
            ps.setString(6, request.getParameter("state"));
            ps.setString(7, request.getParameter("phone_number"));
            
            
            int b=0;
            
            b=ps.executeUpdate();
            if(b>=1)
            {
                check = 1;
                //out.println("Success");
                out.println("<html><body>");
                out.println("<script type=\"text/javascript\">");
                out.println("var popwin = window.alert(\"Borrower added Successfully\")");
                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},3000)");
                out.println("</script>");
                out.println("</body></html>");
                //response.sendRedirect("webpages/index.html");
                response.setHeader("Refresh", "2;url=webpages/index.html");
                //response.sendRedirect("webpages/index.html");
            }
            else
            {
//                out.println("failure");
                out.println("<html><body>");
                out.println("<script type=\"text/javascript\">");
                out.println("var popwin = window.alert(e.getMessage())");
                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},5000)");
                out.println("</script>");
                out.println("</body></html>");
                response.sendRedirect("newborrower.jsp");

            }
        }
                catch(Exception e)
                {
                    check = 2;
                    out.println(e.getMessage());
                    out.println("<html><body>");
                out.println("<script type=\"text/javascript\">");
                out.println("var popwin = window.alert(e.getMessage())");
                out.println("setTimeout(function(){ popwin.close(); window.location.href='pageB.jsp';},5000)");
                out.println("</script>");
                out.println("</body></html>");
                response.setHeader("Refresh", "5;url=newborrower.jsp");
//                response.sendRedirect("newborrower.jsp");
//                    out.println(e.getMessage());
                    //abc = e.getMessage();
                }
                
                
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
