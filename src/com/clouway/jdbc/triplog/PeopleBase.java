package com.clouway.jdbc.triplog;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 4:50 PM
 */
public interface PeopleBase {

    public void save(Person person) throws SQLException;

    public void update(String egn, String email) throws SQLException;

    List<Person> getAllPersons() throws SQLException;

    List<Person> getPersonsByStartingLetters(String letters) throws SQLException;

    List<Person> getPersonsInCityAtSameTime(String date, String city) throws SQLException;
}
