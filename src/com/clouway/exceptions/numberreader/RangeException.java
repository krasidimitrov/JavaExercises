package com.clouway.exceptions.numberreader;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 9/28/11
 * Time: 2:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class RangeException extends Exception{

    public String getMessage(){
       return "You are out of range [0;100]";
    }
}
