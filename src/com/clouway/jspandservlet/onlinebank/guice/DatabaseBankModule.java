package com.clouway.jspandservlet.onlinebank.guice;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.ConnectionProvider;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseBankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseUsersOnlineRepository;
import com.clouway.jspandservlet.onlinebank.persistance.Provider;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class DatabaseBankModule extends AbstractModule{

  @Override
  protected void configure() {
   // bind(new TypeLiteral<Provider.clas>).to(new TypeLiteral<ConnectionProvider<Connection>>());
//    bind(DatabaseHelper.class);

    bind(BankRepository.class).to(DatabaseBankRepository.class);
    bind(UsersOnlineRepository.class).to(DatabaseUsersOnlineRepository.class);
    bind(AccountLogic.class).to(AccountLogicImpl.class);
    bind(UsersOnlineHandler.class).to(UsersOnlineHandlerImpl.class);


  }

  @Provides
  DatabaseHelper provideDatabaseHelper(){
    return new DatabaseHelper(new ConnectionProvider());
  }

}
