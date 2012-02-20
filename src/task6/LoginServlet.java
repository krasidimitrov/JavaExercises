package task6;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Handle the login action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet{
  DatabaseHelper helper = new DatabaseHelper();
  IBankRepository bank = new DatabaseBankRepository(helper);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("userName");
    String password = req.getParameter("password");
    HttpSession session= req.getSession();
    session.setAttribute("userName",userName);

    try {
      if(password.equals(bank.getPassword(userName))){
      session.setAttribute("balance",bank.getBalance(userName));
      resp.sendRedirect("/war/task6/userpage.jsp");
      } else {
        resp.sendRedirect("/war/task6/index.jsp");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
