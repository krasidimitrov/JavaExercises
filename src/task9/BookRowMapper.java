package task9;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/23/12
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookRowMapper implements RowMapper<Book>{
  
  public Book map(ResultSet resultSet) throws SQLException {
    int bookId = resultSet.getInt("bookId");
    String title = resultSet.getString("title");
    String publisher = resultSet.getString("publisher");
    int yearOfPublishing = resultSet.getInt("yearOfRelease");
    String description = resultSet.getString("description");
    
    return new Book(bookId, title, publisher, yearOfPublishing, description);
  }
}
