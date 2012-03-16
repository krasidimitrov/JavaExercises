package onlinebank;

import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandler;
import com.clouway.jspandservlet.onlinebank.bussiness.UsersOnlineHandlerImpl;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/1/12
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsersOnlineHandlerImplTest {

  private Mockery context = new JUnit4Mockery();
  private UsersOnlineRepository usersOnline = context.mock(UsersOnlineRepository.class);
  private UsersOnlineHandler usersOnlineHandler;
  private final String userName = "Krasi";

  @Before
  public void createTestableData() {
    usersOnlineHandler = new UsersOnlineHandlerImpl(usersOnline);
  }


  @Test
  public void shouldSaveAUserInTheUsersOnlineDataSource() throws SQLException {

    context.checking(new Expectations(){{
    oneOf(usersOnline).save(userName,1000);
    }
    });

    usersOnlineHandler.saveUserAsOnline(userName,1000);
    
  }

  //Is it wrong that i don't use a real time ??
  @Test
  public void shouldUpdateTheOnlineTimeOfAUser() throws SQLException {

    context.checking(new Expectations(){{
    oneOf(usersOnline).updateExpirationTime(userName,"creation time here", 1000);
    }
    });

    usersOnline.updateExpirationTime(userName,"creation time here", 1000);
  }
  
  
}
