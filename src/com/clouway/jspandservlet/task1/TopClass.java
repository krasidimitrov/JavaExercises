package com.clouway.jspandservlet.task1;

import com.google.inject.Inject;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class TopClass {

  private final Dependency dependency;

  @Inject
  public TopClass(@FirstImpl Dependency dependency){

    this.dependency = dependency;
  }

  public void printWho(){
    dependency.printMessage();
  }
}
