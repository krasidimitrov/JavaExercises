package com.clouway.jspandservlet.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
public @interface OnlyEvenNumbers {
}
