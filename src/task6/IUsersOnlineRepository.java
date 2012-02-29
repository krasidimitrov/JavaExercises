package task6;

import java.sql.SQLException;
import java.sql.Time;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/24/12
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IUsersOnlineRepository {

  public void save(String userName, int timeLimit) throws SQLException;

  public void updateExpirationTime(String userName, String creationTime, int timeLimit) throws SQLException;

  public String getOnlineUsersCount() throws SQLException;
}
