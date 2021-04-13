
package betterlk;

 import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ashish
 */
public class loginserv extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String unm=request.getParameter("t1");
            String pass=request.getParameter("t2");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/surya", "root", "root");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from users where username='"+unm+"' and password='"+pass+"'" );
              if(rs.next())
              {
                  response.sendRedirect("success.html");
              }
              else
              {
                  RequestDispatcher rd=request.getRequestDispatcher("index.html");
                    out.print("<font color='red'>username or password is incorrect</font><br>");
                    rd.include(request, response);
              }
               }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);  
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
