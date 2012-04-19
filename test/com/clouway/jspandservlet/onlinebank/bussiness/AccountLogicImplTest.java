package com.clouway.jspandservlet.onlinebank.bussiness;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogic;
import com.clouway.jspandservlet.onlinebank.bussiness.AccountLogicImpl;
import com.clouway.jspandservlet.onlinebank.exceptions.InsufficientBalanceException;
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

import static org.junit.Assert.assertEquals;
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
    final BigDecimal withdraw = new BigDecimal("10");

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue(new BigDecimal("20")));
        oneOf(bank).updateBalance(userName, withdraw);
      }
    });

    accountLogic.withdraw(userName, withdraw);
  }

  @Test (expected = InsufficientBalanceException.class)
  public void shouldNotDecreaseTheTotalBalanceOfAnAccountIfTheBalanceIsLessThanTheWithdrawSum(){
    final BigDecimal withdraw = new BigDecimal("100");

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue(new BigDecimal("20")));
      }
    });

    accountLogic.withdraw(userName, withdraw);
  }


  @Test
  public void shouldIncreaseTheTotalBalanceOfAnAccount() throws SQLException {
    final String deposit = "10";

    context.checking(new Expectations() {
      {
        oneOf(bank).getBalance(userName);
        will(returnValue(new BigDecimal("20")));
        oneOf(bank).updateBalance(userName, new BigDecimal("30"));
      }
    });

    accountLogic.deposit(userName, new BigDecimal(deposit));
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
  public void shouldReturnFalseIfTheUserNameIsEmptyString() throws SQLException {
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

  @Test
  public void shouldReturnBigDecimalIfDataIsCorrect(){
    BigDecimal bigDecimal = accountLogic.getBigDecimalIfFormatIsCorrect("12",limit);
    assertEquals(new BigDecimal("12"), bigDecimal);
  }

  @Test (expected = IncorrectDataFormatException.class)
  public void shouldThrowExceptionIfTheNumberHasMoreDigitsThatTheLimit(){
    accountLogic.getBigDecimalIfFormatIsCorrect("123456",limit);
  }

  @Test (expected = IncorrectDataFormatException.class)
  public void shouldThrowExceptionIfThereAreOtherSymbolsExceptDigitsInTheString(){
    accountLogic.getBigDecimalIfFormatIsCorrect("12cd",limit);
  }

}
