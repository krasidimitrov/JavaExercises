package task4;

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
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReceiverServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    HttpSession session = req.getSession();
    PrintWriter out = resp.getWriter();
    out.println("You are coming from servlet: " + req.getAttribute("servletName").toString());
  }
}
