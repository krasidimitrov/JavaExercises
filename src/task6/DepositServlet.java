package task6;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Handle the deposit action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class DepositServlet extends HttpServlet{
  DatabaseHelper helper = new DatabaseHelper();
  IBankRepository bank = new DatabaseBankRepository(helper);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String deposit = req.getParameter("deposit");
    String currentBalance;
    int newBalance;
    HttpSession session = req.getSession();
    String userName = session.getAttribute("userName").toString();
    try {
      currentBalance = bank.getBalance(userName);
      newBalance = Integer.parseInt(currentBalance) + Integer.parseInt(deposit);
      bank.updateBalance(userName, newBalance);
      resp.sendRedirect("/war/task6/userpage.jsp");
    } catch (SQLException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }
}
