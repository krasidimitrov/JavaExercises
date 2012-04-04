package com.clouway.jspandservlet.registrationform;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public final class Injector {
  
  public static Resources injectResources(){
    return new Resources();
  }

  public static RegistrationValidator injectRegistrationValidator(){
    return new RegistrationValidator();
  }

  public static ValidationHandler injectValidatorHandler(){
    return new ValidationHandler(injectRegistrationValidator(), injectResources());
  }
}
