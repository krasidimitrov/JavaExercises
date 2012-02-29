package com.clouway.jspandservlet.registrationform;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/20/12
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationValidator {

  public boolean validateName(String name) {
    return name.matches("^[A-Za-z]{1,20}$");
  }

  public boolean validateEgn(String egn) {
    return egn.matches("^[0-9]{10}$");
  }

  public boolean validateAddress(String address) {
    return address.matches("^[A-Za-z0-9 ]{1,100}$");
  }

  public boolean validateUserName(String userName) {
    return userName.matches("^[A-Za-z0-9]{6,20}$");
  }

  public boolean validatePassword(String password) {
    return password.matches("^[A-Za-z0-9]{6,20}$");
  }

  public boolean confirmPassword(String password, String confirmPassword) {
    return password.equals(confirmPassword);
  }
}
