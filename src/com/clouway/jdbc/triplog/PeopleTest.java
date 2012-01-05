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
    private List<Person> expectedPersonList;
    PeopleBase people;


    @Before
    public void createTestableData() throws SQLException{
        createPeopleForInsertion();
        people = new People(databaseHelper);
        databaseHelper.executeQuery("LOAD DATA LOCAL INFILE '/home/clouway/workspaces/idea/projects/src/com/clouway/jdbc/triplog/PeopleData' INTO TABLE People FIELDS TERMINATED BY ','");
    }

    public void fillExpectedPersonList(Person... person){
        expectedPersonList = new ArrayList<Person>();
        Collections.addAll(expectedPersonList, person);
    }

    public void createPeopleForInsertion(){
        person = new Person("Krasi", "8912141403", 22, "555@mail.bg");
        person2 = new Person("John", "8912141404", 24, "333@mail.bg");
        person3 = new Person("Joseph", "8912141402", 25, "111@mail.bg");
    }


    @Test
    public void shouldInsertNewPersonInDatabase() throws SQLException {
        List<Person> personList = databaseHelper.executeQuery("SELECT * FROM People", rowMapper);

        assertEquals(personList.size(), 3);
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
        fillExpectedPersonList(person, person2, person3);

        assertEquals(expectedPersonList, people.getAllPersons());

    }

    @Test
    public void shouldReturnListOfPeopleWithNameStartingWithSpecificLetters() throws SQLException{
        fillExpectedPersonList(person2, person3);

        assertEquals(expectedPersonList,people.getPersonsByStartingLetters("Jo"));
    }

    @Test
    public void shouldReturnListOfPeopleInCityAtSameTime() throws SQLException{
        fillExpectedPersonList(person, person2);
        databaseHelper.executeQuery("LOAD DATA LOCAL INFILE '/home/clouway/workspaces/idea/projects/src/com/clouway/jdbc/triplog/TripData' INTO TABLE Trip FIELDS TERMINATED BY ','");

        assertEquals(expectedPersonList, people.getPersonsInCityAtSameTime("2011-03-15", "varna"));
    }

  @After
   public void clearTestableData() throws SQLException {
      databaseHelper.executeQuery("DELETE FROM Trip");
      databaseHelper.executeQuery("DELETE FROM People");
   }
}
