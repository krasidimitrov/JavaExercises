package firstservlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/13/12
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */

public class XmlServlet extends HttpServlet {

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    String userName = req.getParameter("userName");
    out.print("get Hello "+userName);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    String userName = req.getParameter("userName");
    String fullName = req.getParameter("fullName");
    out.println("post Hello " + userName + "! We know your full name is " + fullName);
    String prof = req.getParameter("prof");
    out.println("You are a "+prof);
    //String location = req.getParameter("location");
    String[] location = req.getParameterValues("location");
    out.println("You are at "+location.length + " places");
    for(int i=0; i<location.length; i++){
    out.println(location[i]);
    }
  }
}
