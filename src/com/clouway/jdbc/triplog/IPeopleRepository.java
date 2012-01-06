package com.clouway.jdbc.triplog;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 4:50 PM
 */
public interface IPeopleRepository {

    /**
     * Save a person
     * @param person the person that we are going save
     * @throws SQLException
     */
    public void save(Person person) throws SQLException;

    /**
     * update an email for person selected with his egn
     * @param egn the egn of the person that we want to update his email
     * @param email the new email
     * @throws SQLException
     */
    public void update(String egn, String email) throws SQLException;

    /**
     *  Return a List with all Persons from a data source
     * @return a List with all Persons from a data source
     * @throws SQLException
     */
    List<Person> getAllPersons() throws SQLException;

    /**
     * Return a List with all Persons the name of who starts  with certain set of letters from a data source
     * @param letters the letters which will determine who people to be returned in the list
     * @return a List with all Persons the name of who starts  with certain set of letters
     * @throws SQLException
     */
    List<Person> getPersonsByStartingLetters(String letters) throws SQLException;

    /**
     *  Return a List with all Persons that are in a certain city at a certain time
     * @param date the date for which we want to see all people in a certain city
     * @param city  the city for which we want to see all people on a certain date
     * @return
     * @throws SQLException
     */
    List<Person> getPersonsInCityAtSameTime(String date, String city) throws SQLException;

    /**
     * Return a List with all Cities sorted descending by times visited
     * @return a List with all Cities sorted descending by times visited
     * @throws SQLException
     */
    List<City> getAllCitiesByVisitorsCountDescending() throws SQLException;
}
