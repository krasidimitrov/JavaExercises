package com.clouway.jspandservlet.task1;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class DependencyFirstImpl implements Dependency {

//  private final InnerDependency innerDependency;
//
//  public DependencyFirstImpl(InnerDependency innerDependency){
//    this.innerDependency = innerDependency;
//  }

  public void printMessage() {
    System.out.println("I am the FIRST implementation!");
  }
}
