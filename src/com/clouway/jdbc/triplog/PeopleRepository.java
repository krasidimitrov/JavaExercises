package com.clouway.jdbc.triplog;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 2:47 PM
 */
public class PeopleRepository implements IPeopleRepository {

    private final DatabaseHelper databaseHelper;

    public PeopleRepository(DatabaseHelper databaseHelper){
        this.databaseHelper = databaseHelper;
    }

    /**
     * Save a Person object in the database
     * @param person is the one that we are going to save in the database
     * @throws SQLException
     */
    public void save(Person person) throws SQLException {
        databaseHelper.executeQuery("INSERT INTO People VALUES (?,?,?,?)", person.getName(),person.getEgn(),(person.getAge()),person.getEmail());
    }

    /**
     * Update the email of a person in the database for a person with a specific egn
     * @param egn the egn of the person that we want to update
     * @param email the email that is going to be the new email
     * @throws SQLException
     */
    public void update(String egn, String email) throws SQLException {
        databaseHelper.executeQuery("UPDATE People SET email=? WHERE egn=?", email,egn);
    }

    /**
     * Select all Persons from the database
     * @return List of type Person with all persons from the database
     * @throws SQLException
     */
    public List<Person> getAllPersons() throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM People", new PersonRowMapper());
    }

    /**
     * Select all Persons from the database which have names starting with same set of letters
     * @param letters the set of letters whit which the persons' names start
     * @return List of type Person with the persons who have names starting with same set of letters
     * @throws SQLException
     */
    public List<Person> getPersonsByStartingLetters(String letters) throws SQLException {
        String text = letters + '%';
        return databaseHelper.executeQuery("SELECT * FROM People WHERE name LIKE ?", new PersonRowMapper(),text);
    }

    /**
     * Select all people that are in an certain city at a certain date
     * @param date the date for which we want to show all people in a certain city
     * @param city  the city for which we want to show all people at the certain date
     * @return List of type Person with the persons who are in a certain city at a certain date
     * @throws SQLException
     */
    public List<Person> getPersonsInCityAtSameTime(String date,String city) throws SQLException{
        return databaseHelper.executeQuery("SELECT People.* FROM People INNER JOIN Trip ON People.egn = Trip.egn WHERE city=? AND departureDate<=? AND returnDate>=?;", new PersonRowMapper(),city, date, date);
    }

    /**
     * Select all cities from the database order descending by visits from people
     * @return List with all cities ordered by visits
     * @throws SQLException
     */
    public List<City> getAllCitiesByVisitorsCountDescending() throws SQLException{
        return databaseHelper.executeQuery("SELECT city, COUNT(*) as timesVisited FROM Trip GROUP BY city ORDER BY timesVisited DESC",new CityRowMapper());
    }


}
