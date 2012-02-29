package onlinebank;

import com.clouway.jspandservlet.onlinebank.AccountLogic;
import com.clouway.jspandservlet.onlinebank.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.BankRepository;
import com.clouway.jspandservlet.onlinebank.DatabaseHelper;
import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/29/12
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountLogicTest {

  Mockery context = new JUnit4Mockery();
  BankRepository bank = context.mock(BankRepository.class);
  AccountLogic accountLogic;
  final String userName = "Krasi";

  @Before
  public void createTestableData() {
    accountLogic = new AccountLogicImpl(bank);
  }


  @Test
  public void happyPathRegister() throws SQLException {
    final String password = "123456";

    context.checking(new Expectations() {
      {
        oneOf(bank).getUsername(userName);
        will(returnValue(""));
        oneOf(bank).saveUser(userName, password);
      }
    });

    accountLogic.register(userName, password);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldThrowExceptionIfUserNameIsShorterThanFiveCharacters() throws SQLException {
    final String shortUsername = "Ok";
    final String password = "123456";

    accountLogic.register(shortUsername, password);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldThrowExceptionIfUserNameIsLongerThanTwelveCharacters() throws SQLException {
    final String longUsername = "IamMuchLongerThanTwelveCharacters";
    final String password = "12345";

    accountLogic.register(longUsername, password);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldThrowExceptionIfUserNameContainsOtherSymbolsThanNumbersAndLetters() throws SQLException {
    final String incorectUserName = "Hello!";
    final String password = "12345";

    accountLogic.register(incorectUserName, password);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldThrowExceptionIfPaswordIsShorterThanFiveCharacters() throws SQLException {
    final String shortPassword = "123";

    accountLogic.register(userName, shortPassword);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldThrowExceptionIfPaswordIsLongerThanTwelveCharacters() throws SQLException {
    final String longPassword = "123456789abc123456789";

    accountLogic.register(userName, longPassword);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldThrowExceptionIfPaswordContainsOtherSymbolsThanNumbersAndLetters() throws SQLException {
    final String longPassword = "123@";

    accountLogic.register(userName, longPassword);
  }

  @Test(expected = DuplicateUserNameException.class)
  public void shouldThrowExceptionIfUserNameAlreadyExistInTheDataRepository() throws SQLException {
    final String password = "12345";
    
    context.checking(new Expectations(){{
    oneOf(bank).getUsername(userName);
      will(returnValue(userName));
    }
    });
    accountLogic.register(userName,password);
  }



  @Test
  public void happyPathWithdraw() throws SQLException {
    final String withdraw = "10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("20"));
        oneOf(bank).updateBalance(userName, Integer.parseInt("10"));
      }
    });

    accountLogic.withdraw(userName, withdraw);
  }


  @Test
  public void shouldNotUpdateBalanceIFWithdrawIsANegativeNumber() throws SQLException {
    final String withdraw = "-10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("5"));
      }
    });

    accountLogic.withdraw(userName, withdraw);
  }

  @Test
  public void shouldNotUpdateBalanceIfWithdrawIsNotANumber() throws SQLException {
    final String withdraw = "haha";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10"));
      }
    });
  }

  @Test
  public void shouldNotUpdateBalanceIfWithdrawIsBiggerThan99999() throws SQLException {
    final String withdraw = "999990";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10"));
      }
    });
  }

  @Test
  public void happyPathDeposit() throws SQLException {
    final String withdraw = "10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("20"));
        oneOf(bank).updateBalance(userName, Integer.parseInt("30"));
      }
    });

    accountLogic.deposit(userName, withdraw);
  }

  @Test
  public void shouldNotUpdateBalanceIfDepositIsANegativeNumber() throws SQLException {
    final String withdraw = "-10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10"));
      }
    });
  }

  @Test
  public void shouldNotUpdateBalanceIfDepositIsNotANumber() throws SQLException {
    final String withdraw = "haha";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10"));
      }
    });
  }

  @Test
  public void shouldNotUpdateBalanceIfDepositIsBiggerThan99999() throws SQLException {
    final String withdraw = "199999";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10"));
      }
    });
  }

}
