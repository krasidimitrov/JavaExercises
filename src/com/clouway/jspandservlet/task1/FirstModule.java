package com.clouway.jspandservlet.task1;

import com.google.inject.AbstractModule;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class FirstModule extends AbstractModule{

  @Override
  protected void configure() {
    bind(Dependency.class).annotatedWith(FirstImpl.class).to(DependencyFirstImpl.class);
  }
}
