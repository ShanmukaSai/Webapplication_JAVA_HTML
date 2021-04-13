package surya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Loginserv extends HttpServlet {

    
    protected void doget(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String uname=request.getParameter("unme");
            String pass=request.getParameter("pwd");
           
            Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager .getConnection("jdbc:mysql://localhost:3306/kmm","root","root");
           Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select * from users where username ='"+uname+"'and password='"+pass+"' ");          
          if(rs.next())
          {
              response.sendRedirect("success.html");
          }
          else
          {
              response.sendRedirect("index.html");
          }
        }catch(SQLException ex){
            System.out.println(ex);
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Loginserv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
