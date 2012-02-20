package loginform;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/15/12
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userId;
    String password;
    LoginService loginService = new LoginService();

    userId = request.getParameter("userId");
    password = request.getParameter("password");

    boolean result = loginService.authenticate(userId, password);
    if(result){
      User user = loginService.getUserDetails(userId);
      request.setAttribute("user", user);
    //  request.getSession().setAttribute("user",user);
     // response.sendRedirect("/war/loginform/success.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher("/loginform/success.jsp");
      dispatcher.forward(request,response);
    } else {
      response.sendRedirect("/war/loginform/login.jsp");
    }
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
