package com.clouway.testing.service;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/7/11
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {

    private final String name;
    private final String egn;
    private final String years;


    public Person(String name, String egn, String years){
        this.name = name;
        this.egn = egn;
        this.years = years;
    }

    public String getName(){
        return name;
    }

    public String getEgn(){
        return egn;
    }

    public String getYears(){
        return years;
    }
}
