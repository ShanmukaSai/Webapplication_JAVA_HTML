package serwrk;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class signupserv extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
 
          out.print("<html>");
          out.print("<body bgcolor=orange>");
          out.print("<center><form action='Loginhere'>");
          out.print("<h1>signup here...............</h1><br>");
          out.print("Full Name:");
          out.print("<input type='text' name='t1' placeholder='enter name here'><br>");
          out.print("<br>mobile_no:");
          out.print("<input type='number' name='t2' placeholder='enter phone number here'><br>");
          out.print("<br>password:");
          out.print("<input type='password' name='p1'placeholder='enter your password here'><br>");
          out.print("<br>confirm_password:");
          out.print("<input type='password' name='p2' placeholder='enter confirm password here'><br>");
          out.print("<br><input type='submit' value='submit'>&nbsp;&nbsp;");
          out.print("<input type='reset' value='clear'>");
          out.print("</form></center></body></html>");
            String name=request.getParameter("t1");
          String mobile=request.getParameter("t2");
          String pass=request.getParameter("p1");
          String cpass=request.getParameter("p2");
          
          if(pass.equals(cpass))
          {
              Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/datastore","root","root");
            Statement st= con.createStatement();
           st.executeQuery("insert into datavalues(username,mobile_no,password,confirm_password) values('"+name+"',"+mobile+",'"+pass+"','"+cpass+"')");
           out.print("Data entered succesfully");
           response.sendRedirect("Loginhere");
           response.sendRedirect("success.html");
          
          }
          else
          { 
              out.print("The value password and current password is not same");
              response.sendRedirect("signupserv");
          }
          
          
            
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(signupserv.class.getName()).log(Level.SEVERE, null, ex);
        }
        //response.sendRedirect("signup.html");

        catch (SQLException ex) {
            Logger.getLogger(signupserv.class.getName()).log(Level.SEVERE, null, ex);
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
