package com.clouway.jspandservlet.registrationform;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Called after submiting the registration form in /registrationform/register.jsp
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/20/12
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServlet extends HttpServlet {
  private ValidationHandler validationHandler;

  @Override
  public void init(ServletConfig config) throws ServletException {
    validationHandler = Injector.injectValidatorHandler();
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    validationHandler.validateAll(req);

    req.getRequestDispatcher("/registrationform/register.jsp").forward(req,resp);
  }
}
