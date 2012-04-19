package com.clouway.jspandservlet.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public class OperationModule extends AbstractModule {

  @Override
  protected void configure() {
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(OnlyEvenNumbers.class), new OddNumberStopper());

    
    MapBinder<String,Operation> operationBinder = MapBinder.newMapBinder(binder(), String.class, Operation.class);//.newSetBinder(binder(), Operation.class);
    operationBinder.addBinding("+").to(OperationAddition.class);
    operationBinder.addBinding("-").to(OperationSubtraction.class);
    operationBinder.addBinding("*").to(OperationMultiplication.class);
  }
}
