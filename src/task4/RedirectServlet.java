package task4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/16/12
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class RedirectServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.println("You are coming from servlet: "+req.getAttribute("servletName").toString());
  }
}
