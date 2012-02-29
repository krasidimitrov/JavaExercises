package task6;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Handle the register action
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com
 * Date: 2/17/12
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServlet extends HttpServlet {
  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private IBankRepository bank = new DatabaseBankRepository(databaseHelper);

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("userName");
    String password = req.getParameter("password");
    try {
      if (bank.checkIfUserNameExists(userName) || !validateData(userName, password)) {
        resp.sendRedirect("/war/task6/register.jsp");
      } else {
        bank.saveUser(userName, password);
        resp.sendRedirect("/war/task6/index.jsp");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Chech if a data is in the correct format
   * @param userName the first thing that we are going to check(the userName from the register form)
   * @param password the second thing that we are going to check(the password from the register form)
   * @return  true if everything is correct and false if something is not correct
   */
  private boolean validateData(String userName, String password) {
    //Pattern pattern = Pattern.compile("^[A-Za-z0-9]{5,20}$");
    if (!userName.matches("^[A-Za-z0-9]{5,20}$") || !password.matches("^[A-Za-z0-9]{5,20}$")) {
      return false;
    } return true;
  }
}
