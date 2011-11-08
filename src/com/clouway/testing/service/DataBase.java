package com.clouway.testing.service;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/7/11
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DataBase {
   public void savePerson(Person person);

   public String getYearsFromDb(String egn);
}
