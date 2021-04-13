
package webprj;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Signupserv extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("<html>");
          out.print("<body>");
          out.print("<center>");
          out.print("<form action='Signupserv1'>");
          out.print("<h1>signup here...............</h1><br>");
          out.print("name:");
          out.print("<input type='text' name='t1' placeholder='enter name here'><br>");
          out.print("mobile_no:");
          out.print("<input type='number' name='t2' placeholder='enter phone number here'><br>");
          out.print("<br>password:");
          out.print("<input type='password' name='p1'/>");
          out.print("<br>confirm_password:");
          out.print("<input type='password' name='p2' placeholder='enter confirm password here'><br>");
          out.print("<br><input type='submit' value='submit'>");
          out.print("</form></center></body></html>");
   
       //    response.sendRedirect("Success.html");
          // response.sendRedirect("Signupserv1");   
        //  out.print("entered succesfully");
          
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
