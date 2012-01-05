package com.clouway.jdbc.triplog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/4/12
 * Time: 3:47 PM
 */
public class PeopleTest {

    private Person person,person2,person3;
    private DatabaseHelper databaseHelper = new DatabaseHelper();
    private RowMapper<Person> rowMapper = new PersonRowMapper();
    private List<Person> personList;
    PeopleBase people;


    @Before
    public void createTestableData() throws SQLException{
        person = new Person("Krasi", "8912141403", 22, "555@mail.bg");
        person2 = new Person("John", "8912141404", 24, "333@mail.bg");
        person3 = new Person("Joseph", "8912141402", 25, "111@mail.bg");
        people = new People(databaseHelper);
        people.save(person);
    }

    public void setHelpData(Person... person){
        personList= new ArrayList<Person>();
        Collections.addAll(personList, person);
    }


    @Test
    public void shouldInsertNewPersonInDatabase() throws SQLException {

        List<Person> personList = databaseHelper.executeQuery("SELECT * FROM People", rowMapper);

        assertEquals(personList.size(), 1);
        assertEquals(person.getName(), personList.get(0).getName());
        assertEquals(person.getEmail(), personList.get(0).getEmail());
    }


    @Test
    public void shouldUpdateExistingUserEmail() throws SQLException {
        people.update("8912141403", "444@mail.bg");

        List<Person> personList = databaseHelper.executeQuery("SELECT * FROM People", rowMapper);
        assertEquals("444@mail.bg", personList.get(0).getEmail());

    }

    @Test
    public void shouldReturnAllPersonsInList() throws SQLException {

        people.save(person2);
        people.save(person3);

        setHelpData(person3,person,person2);
        assertEquals(personList, people.getAllPersons());

    }

    @Test
    public void shouldReturnListOfPeopleWithNameStartingWithSpecificLetters() throws SQLException{
        people.save(person2);
        people.save(person3);

        setHelpData(person3,person2);
        assertEquals(personList,people.getPersonsByStartingLetters("Jo"));
    }

    @Test
    public void shouldReturnListOfPeopleInCityAtSameTime() throws SQLException{
        people.save(person2);
        people.save(person3);
        setHelpData(person,person2);
        databaseHelper.executeQuery("INSERT INTO Trip(egn, departureDate, arrivalDate, city) VALUES('8912141403', '2011-03-05', '2011-03-25', 'Varna');");
        databaseHelper.executeQuery("INSERT INTO Trip(egn, departureDate, arrivalDate, city) VALUES('8912141404', '2011-03-02', '2011-05-15', 'Varna');");
        databaseHelper.executeQuery("INSERT INTO Trip(egn, departureDate, arrivalDate, city) VALUES('8912141402', '2011-03-05', '2011-03-10', 'Varna');");
        databaseHelper.executeQuery("INSERT INTO Trip(egn, departureDate, arrivalDate, city) VALUES('8912141403', '2011-04-04', '2011-04-07', 'Burgas');");

        assertEquals(personList, people.getPersonsInCityAtSameTime("2011-03-15"));

    }

  @After
   public void clearTestableData() throws SQLException {
      databaseHelper.executeQuery("DELETE FROM Trip");
      databaseHelper.executeQuery("DELETE FROM People");
   }
}
