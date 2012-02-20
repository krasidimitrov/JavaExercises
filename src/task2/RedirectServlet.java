package task2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/15/12
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class RedirectServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   // String page = req.getParameter("page");
    HttpSession session = req.getSession();
    session.setAttribute("page",req.getParameter("page"));
    resp.sendRedirect("/war/task2/result.jsp");
  }
}
