package com.clouway.jspandservlet.registrationform;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Use the validation methods from RegistrationValidator
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class ValidationHandler {
 private RegistrationValidator validator;
 private Resources resources;

  public ValidationHandler(RegistrationValidator registrationValidator, Resources res){
    validator = registrationValidator;
    resources = res;
  }

  /**
   * Do all the validation and fill the request with error messages if any
   * @param request the request from which we take all the data that need validation
   */
  public void validateAll(HttpServletRequest request) {
    Class validatorClass = RegistrationValidator.class;
    Method method;
    boolean booleanValue;
    try {
      for (int i = 0; i < resources.getAttributes().length - 1; i++) {

        method = validatorClass.getDeclaredMethod(resources.getMethods()[i], String.class);
        booleanValue = (Boolean) method.invoke(validator, request.getParameter(resources.getAttributes()[i]));
        if (!booleanValue) {
          request.setAttribute(resources.getAttributes()[i] + "Message", resources.getMessages()[i]);
        } else {
          request.setAttribute(resources.getAttributes()[i] + "Message", "");
        }
      }
      method = validatorClass.getDeclaredMethod(resources.getMethods()[6], String.class, String.class);
      booleanValue = (Boolean) method.invoke(validator, request.getParameter(resources.getAttributes()[5]), request.getParameter(resources.getAttributes()[6]));
      if (!booleanValue) {
        request.setAttribute(resources.getAttributes()[6] + "Message", resources.getMessages()[6]);
      } else {
        request.setAttribute(resources.getAttributes()[6] + "Message", "");
      }
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
