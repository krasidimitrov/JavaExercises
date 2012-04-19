package com.clouway.jspandservlet.onlinebank.guice;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class MainTest {



  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new DatabaseBankModule());
    //BankRepository bankRepository = injector.getInstance(DatabaseBankRepository.class);
    AccountLogic accountLogic = injector.getInstance(AccountLogicImpl.class);
    UsersOnlineHandler handler = injector.getInstance(UsersOnlineHandlerImpl.class);
  }
}
