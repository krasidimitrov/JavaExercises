package com.clouway.jspandservlet.onlinebank.inject;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.ConnectionProvider;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseBankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseUsersOnlineRepository;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;

import javax.servlet.http.HttpSession;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/19/12
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public final class Injector {

  public static DatabaseHelper injectHelper() {
    return new DatabaseHelper(new ConnectionProvider());
  }

  public static BankRepository injectBankRepository(DatabaseHelper databaseHelper) {
    return new DatabaseBankRepository(databaseHelper);
  }

  public static AccountLogic injectAccountLogic() {
    return new AccountLogicImpl(injectBankRepository(injectHelper()));
  }

  public static UsersOnlineRepository injectUsersOnlineRepository(DatabaseHelper databaseHelper) {
    return new DatabaseUsersOnlineRepository(databaseHelper);
  }

  public static UsersOnlineHandler injectUsersOnlineHandler() {
    return new UsersOnlineHandlerImpl(injectUsersOnlineRepository(injectHelper()));
  }

}
