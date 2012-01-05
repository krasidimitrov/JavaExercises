package com.clouway.jdbc.triplog;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/3/12
 * Time: 2:47 PM
 */
public class People implements PeopleBase {

    private final DatabaseHelper databaseHelper;

    public People(DatabaseHelper databaseHelper){
        this.databaseHelper = databaseHelper;
    }

    public void save(Person person) throws SQLException {
        databaseHelper.executeQuery("INSERT INTO People VALUES (?,?,?,?)", person.getName(),person.getEgn(),(person.getAge()),person.getEmail());
    }

    public void update(String egn, String email) throws SQLException {
        databaseHelper.executeQuery("UPDATE People SET email=? WHERE egn=?", email,egn);
    }

    public List<Person> getAllPersons() throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM People", new PersonRowMapper());
    }

    public List<Person> getPersonsByStartingLetters(String letters) throws SQLException {
        String text = letters + '%';
        return databaseHelper.executeQuery("SELECT * FROM People WHERE name LIKE ?", new PersonRowMapper(),text);
    }

    public List<Person> getPersonsInCityAtSameTime(String date) throws SQLException{

        return databaseHelper.executeQuery("SELECT People.* FROM People INNER JOIN Trip ON People.egn = Trip.egn WHERE departureDate<=? AND arrivalDate>=?;", new PersonRowMapper(), date, date);
    }

}
