package loginform;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 2/15/12
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginService {
  Map<String,String> users = new HashMap<String,String>();
  
  public LoginService(){
    users.put("johndoe", "John Doe");
    users.put("janedoe", "Jane Doe");
    users.put("jguru", "Java Guru");

  }
  
  public boolean authenticate(String userId, String password){
    if(password == null || password.trim() == ""){
      return false;
    }
    return true;
  }
  
  public User getUserDetails(String userId){
    User user = new User();
    user.setUserName(users.get(userId));
    user.setUserId(userId);
    return user;
  }
  
}
