package com.clouway.jspandservlet.onlinebank.guice;

import com.clouway.jspandservlet.onlinebank.controllers.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class GuiceServletConfig extends GuiceServletContextListener{

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new DatabaseBankModule(),new ServletModule(){
      @Override
      protected void configureServlets() {
        serve("/registerServlet").with(RegisterServlet.class);
        serve("/loginServlet").with(LoginServlet.class);
        serve("/depositServlet").with(DepositServlet.class);
        serve("/withdrawServlet").with(WithdrawServlet.class);
        serve("/logoutServlet").with(LogoutServlet.class);

        filter("/*").through(DatabaseConnectionFilter.class);
        filter("/onlinebank/userpage.jsp").through(LoginVerificationFilter.class);
        filter("/onlinebank/userpage.jsp").through(BalanceFilter.class);
        filter("/onlinebank/userpage.jsp").through(UserOnlineTimeFilter.class);
        filter("/onlinebank/index.jsp", "/onlinebank/", "/loginServlet").through(UsersOnlineCountFilter.class);
      }
    });
  }
}
