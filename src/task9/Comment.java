package task9;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/28/12
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
  private int bookId;
  private String userName;
  private String comment;
  
  public Comment(int bookId, String userName, String comment){
    this.bookId = bookId;
    this.userName = userName;
    this.comment = comment;
  }

  public String getUserName() {
    return userName;
  }

  public String getComment() {
    return comment;
  }
}
