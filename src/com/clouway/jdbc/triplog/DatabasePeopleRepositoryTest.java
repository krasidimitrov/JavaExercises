package com.clouway.jdbc.triplog;

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.swing.plaf.windows.ClassicSortArrowIcon;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/4/12
 * Time: 3:47 PM
 */
public class DatabasePeopleRepositoryTest {

    private Person person, person2, person3;
    private DatabaseHelper databaseHelper = new DatabaseHelper();
    private RowMapper<Person> rowMapper = new PersonRowMapper();
    private List<Person> expectedPersonList;
    IPeopleRepository repository;


    @Before
    public void createTestableData() throws SQLException {
        createPeopleForInsertion();
        repository = new DatabasePeopleRepository(databaseHelper);
    }

    private void createPeopleForInsertion() {
        person = new Person("Krasi", "8912141403", 22, "555@mail.bg");
        person2 = new Person("John", "8912141404", 24, "333@mail.bg");
        person3 = new Person("Joseph", "8912141402", 25, "111@mail.bg");
    }

    public void fillTripTableWithTestData() throws SQLException {
        File file = new File("TripData");

        databaseHelper.executeQuery("LOAD DATA LOCAL INFILE 'TripData' INTO TABLE Trip FIELDS TERMINATED BY ','");
    }

    private void savePersonsToDatabaseForTest() throws SQLException {
        repository.save(person);
        repository.save(person2);
        repository.save(person3);
    }

    @Test
    public void shouldInsertNewPersonInDatabase() throws SQLException {
        repository.save(person);

        List<Person> personList = databaseHelper.executeQuery("SELECT * FROM People", rowMapper);

        assertEquals(1, personList.size());
        assertEquals(person.getName(), personList.get(0).getName());
        assertEquals(person.getEmail(), personList.get(0).getEmail());
        assertEquals(person.getAge(), personList.get(0).getAge());
        assertEquals(person.getEgn(), personList.get(0).getEgn());
    }

    @Test
    public void shouldUpdateExistingUserEmail() throws SQLException {
        repository.save(person);
        repository.update("8912141403", "444@mail.bg");
        List<Person> personList = databaseHelper.executeQuery("SELECT * FROM People", rowMapper);

        assertEquals("444@mail.bg", personList.get(0).getEmail());
    }

    @Test
    public void shouldReturnAllPersonsInList() throws SQLException {
        //fillExpectedPersonList(person, person2, person3);

        savePersonsToDatabaseForTest();

        List<Person> actualPeople = repository.getAllPersons();

        expectedPersonList = Lists.newArrayList(person, person2, person3);


        assertEquals(expectedPersonList, actualPeople);

    }

    @Test
    public void shouldReturnListOfPeopleWithNameStartingWithSpecificLetters() throws SQLException {
        savePersonsToDatabaseForTest();

        expectedPersonList = Lists.newArrayList(person2, person3);
        assertEquals(expectedPersonList, repository.getPersonsByStartingLetters("Jo"));
    }

    @Test
    public void shouldReturnListOfPeopleInCityAtSameTime() throws SQLException {
        savePersonsToDatabaseForTest();

        expectedPersonList = Lists.newArrayList(person, person2);
        fillTripTableWithTestData();

        assertEquals(expectedPersonList, repository.getPersonsInCityAtSameTime("2011-03-15", "varna"));
    }

    @Test
    public void shouldReturnAllCitiesByCountOfVisitorsDescending() throws SQLException {
        savePersonsToDatabaseForTest();

        City city = new City("Varna", 3);
        City city2 = new City("Burgas", 2);
        List<City> listOfCities = Lists.newArrayList(city, city2);

        fillTripTableWithTestData();

        assertEquals(listOfCities, repository.getAllCitiesByVisitorsCountDescending());
    }

    @After
    public void clearTestableData() throws SQLException {
        databaseHelper.executeQuery("DELETE FROM Trip");
        databaseHelper.executeQuery("DELETE FROM People");
    }
}
