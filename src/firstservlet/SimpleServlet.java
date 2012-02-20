package firstservlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/13/12
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */

public class SimpleServlet extends HttpServlet{

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    String userName = request.getParameter("userName");
    HttpSession session = request.getSession();

    ServletContext context = getServletContext();

    if(userName != "" && userName != null){
    session.setAttribute("savedUserName", userName);
      context.setAttribute("savedUserName", userName);
    }
    
    writer.println("Request parameter has username as , "+userName);
    writer.println("Session parameter has username as "+(String) session.getAttribute("savedUserName"));
    writer.println("Contetx parameter has username as "+(String) context.getAttribute("savedUserName"));
    writer.println("Init parameter has default username as "+this.getServletConfig().getInitParameter("defaultUser"));
  }
}
