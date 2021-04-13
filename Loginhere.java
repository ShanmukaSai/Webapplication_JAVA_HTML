package serwrk;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loginhere extends HttpServlet {
   public Loginhere()
   {
    super();
}

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       String username=request.getParameter("name");
       String password=request.getParameter("pass");
       if(username.isEmpty()||password.isEmpty())
       {
          RequestDispatcher req=request.getRequestDispatcher("ex3.html");
          req.include(request,response);
       }
       else
       {
           RequestDispatcher req=request.getRequestDispatcher("ex4.html");
          req.forward(request,response);
       }
    }
}
        