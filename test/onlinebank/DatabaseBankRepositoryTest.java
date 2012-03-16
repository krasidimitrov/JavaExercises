package onlinebank;

import com.clouway.jspandservlet.onlinebank.persistance.BankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseBankRepository;
import com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 3/7/12
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseBankRepositoryTest {
  private DatabaseHelper databaseHelper = new DatabaseHelper();
  private BankRepository bank;

  @Before
  public void createTestableData() throws SQLException {
    bank = new DatabaseBankRepository(databaseHelper);
    databaseHelper.executeQuery("CREATE TABLE IF NOT EXISTS Users (userName VARCHAR(20) PRIMARY KEY NOT NULL, password VARCHAR(20) NOT NULL, balance DECIMAL(11,2) NOT NULL) ENGINE = InnoDB;");
  }

  @After
  public void destroyTestableData() throws SQLException {
    databaseHelper.executeQuery("DROP TABLE Users");
  }

  @Test
  public void shouldSaveAnUserInTheDataBase() throws SQLException {
    String expectedUserName = "Krasi";
    String expectedPassword = "12345";
    String actualUserName;
    String actualPassword;
    bank.saveUser(expectedUserName,expectedPassword);
    actualUserName = databaseHelper.executeQueryWithResult("SELECT userName FROM Users WHERE userName=?;",expectedUserName);
    actualPassword = databaseHelper.executeQueryWithResult("SELECT password FROM Users WHERE userName=?;",expectedUserName);
    assertEquals(expectedUserName,actualUserName);
    assertEquals(expectedPassword,actualPassword);
  }

  /**
   * Every account starts with 0.00 balance
   * @throws SQLException
   */
  @Test
  public void shouldUpdateTheBalanceForTheGivenUser() throws SQLException {
    String userName = "Krasi";
    String password = "12345;";
    bank.saveUser(userName,password);
    bank.updateBalance(userName, new BigDecimal(10));
    BigDecimal result = new BigDecimal(databaseHelper.executeQueryWithResult("SELECT balance FROM Users WHERE userName = ?;", userName));
    assertEquals(new BigDecimal("10.00"),result);
  }
}
