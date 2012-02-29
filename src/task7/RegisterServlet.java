package task7;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/20/12
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServlet extends HttpServlet {
  RegistrationValidator validator = new RegistrationValidator();
  Resources resources = new Resources();
  HttpSession session;

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    session = req.getSession();
    Class validatorClass = RegistrationValidator.class;
    Method method;
    boolean booleanValue = true;
    try {
      for (int i = 0; i < resources.getAttributes().length - 1; i++) {

        method = validatorClass.getDeclaredMethod(resources.getMethods()[i], String.class);
        booleanValue = (Boolean) method.invoke(validator, req.getParameter(resources.getAttributes()[i]));
        if (!booleanValue) {
          session.setAttribute(resources.getAttributes()[i] + "Message", resources.getMessages()[i]);
        } else {
          session.setAttribute(resources.getAttributes()[i] + "Message", "");
        }
      }
      method=validatorClass.getDeclaredMethod(resources.getMethods()[6],String.class,String.class);
      booleanValue= (Boolean) method.invoke(validator, req.getParameter(resources.getAttributes()[5]),req.getParameter(resources.getAttributes()[6]));
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    if(!booleanValue){
      session.setAttribute(resources.getAttributes()[6] + "Message", resources.getMessages()[6]);
    } else {
      session.setAttribute(resources.getAttributes()[6] + "Message", "");
    }
    

    resp.sendRedirect("/war/task7/register.jsp");
  }
}
