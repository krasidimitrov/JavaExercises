package onlinebank;

import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.exceptions.DuplicateUserNameException;
import com.clouway.jspandservlet.onlinebank.exceptions.IncorrectDataFormatException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/29/12
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountLogicImplTest {

  private Mockery context = new JUnit4Mockery();
  private BankRepository bank = context.mock(BankRepository.class);
  private AccountLogic accountLogic;
  private final String userName = "Krasi";
  private final String password = "12345";
  private final int limit = 5;

  @Before
  public void createTestableData() {
    accountLogic = new AccountLogicImpl(bank);
  }


  @Test
  public void shouldRegisterANewAccountToTheDataSourceForRegistration() throws SQLException {

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
  public void shouldNotRegisterTheUserIfUserNameIsShorterThanFiveCharacters() throws SQLException {
    final String shortUsername = "Ok";

    accountLogic.register(shortUsername, password);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldNotRegisterTheUserIfUserNameIsLongerThanTwelveCharacters() throws SQLException {
    final String longUsername = "IamMuchLongerThanTwelveCharacters";

    accountLogic.register(longUsername, password);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldNotRegisterTheUserIfUserNameContainsOtherSymbolsThanNumbersAndLetters() throws SQLException {
    final String incorrectUserName = "Hello!";

    accountLogic.register(incorrectUserName, password);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldNotRegisterTheUserIfPasswordIsShorterThanFiveCharacters() throws SQLException {
    final String shortPassword = "123";

    accountLogic.register(userName, shortPassword);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldNotRegisterTheUserIfPasswordIsLongerThanTwelveCharacters() throws SQLException {
    final String longPassword = "123456789abc123456789";

    accountLogic.register(userName, longPassword);
  }

  @Test(expected = IncorrectDataFormatException.class)
  public void shouldNotRegisterTheUserIfPasswordContainsOtherSymbolsThanNumbersAndLetters() throws SQLException {
    final String longPassword = "123@";

    accountLogic.register(userName, longPassword);
  }

  @Test(expected = DuplicateUserNameException.class)
  public void shouldNotRegisterTheUserIfUserNameAlreadyExistInTheDataRepository() throws SQLException {

    context.checking(new Expectations(){{
    oneOf(bank).getUsername(userName);
      will(returnValue(userName));
    }
    });
    accountLogic.register(userName,password);
  }

  @Test
  public void shouldDecreaseTheTotalBalanceOfAnAccount() throws SQLException {
    final String withdraw = "10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("20"));
        oneOf(bank).updateBalance(userName, new BigDecimal("10"));
      }
    });

    accountLogic.withdraw(userName, withdraw, limit);
  }


  @Test
  public void shouldNotUpdateBalanceIFWithdrawIsANegativeNumber() throws SQLException {
    final String withdraw = "-10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("100"));
      }
    });

    accountLogic.withdraw(userName, withdraw, limit);
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

    accountLogic.withdraw(userName,withdraw,limit);
  }

  //FIX THIS TEST
  @Test
  public void shouldNotUpdateBalanceIfWithdrawIsBiggerThanTheGivenLimit() throws SQLException {
    final String withdraw = "123456";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10000000"));
      }
    });

    accountLogic.withdraw(userName,withdraw, limit);
  }

  @Test
  public void shouldIncreaseTheTotalBalanceOfAnAccount() throws SQLException {
    final String deposit = "10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("20"));
        oneOf(bank).updateBalance(userName, new BigDecimal("30"));
      }
    });

    accountLogic.deposit(userName, deposit, limit);
  }

  @Test
  public void shouldNotUpdateBalanceIfDepositIsANegativeNumber() throws SQLException {
    final String deposit = "-10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10"));
      }
    });

    accountLogic.deposit(userName, deposit, limit);
  }

  @Test
  public void shouldNotUpdateBalanceIfDepositIsNotANumber() throws SQLException {
    final String deposit = "haha";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10"));
      }
    });

    accountLogic.deposit(userName, deposit, limit);
  }

  @Test
  public void shouldNotUpdateBalanceIfDepositIsBiggerThanTheGivenLimit() throws SQLException {
    final String deposit = "199999";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue("10"));
      }
    });

    accountLogic.deposit(userName, deposit, limit);
  }

  @Test
  public void shouldReturnTrueIfTheUserExistsWithTheGivenPassword() throws SQLException {
    boolean result;
    context.checking(new Expectations() {
      {

        oneOf(bank).getPassword(userName);
        will(returnValue("12345"));
      }
    });

    result = accountLogic.checkIfPasswordForTheUsernameIsCorrect(userName, password);
    assertTrue(result);
  }

  @Test
  public void shouldReturnFalseIfPasswordDoesNotCorrespondsForTheUserName() throws SQLException {
    boolean result;

    context.checking(new Expectations(){{
      oneOf(bank).getPassword(userName);
      will(returnValue("otherPassword"));}
    });

    result = accountLogic.checkIfPasswordForTheUsernameIsCorrect(userName, password);
    assertFalse(result);
  }

  @Test
  public void shouldReturnFalseIfTheUserDoesNotExistInTheDataSource() throws SQLException {
    boolean result;

    context.checking(new Expectations() {
      {
        oneOf(bank).getPassword(userName);
        will(returnValue(""));

      }
    });

    result = accountLogic.checkIfPasswordForTheUsernameIsCorrect(userName, password);

    assertFalse(result);
  }

  @Test
  public void shouldReturnFalseIFTheUserNameIsEmptyString() throws SQLException {
    final String emptyUserName = "";
    boolean result;

    context.checking(new Expectations(){{
      oneOf(bank).getPassword(emptyUserName);
      will(returnValue(""));
    }
    });

    result = accountLogic.checkIfPasswordForTheUsernameIsCorrect(emptyUserName, password);
    assertFalse(result);
  }

}
