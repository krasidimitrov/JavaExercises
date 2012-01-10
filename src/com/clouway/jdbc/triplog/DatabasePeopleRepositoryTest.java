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
    private List<Person> actualPersonList;
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
    public void shouldSaveGivenPersonInTheDatabase() throws SQLException {
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

        actualPersonList = repository.getAllPersons();

        expectedPersonList = Lists.newArrayList(person, person2, person3);


        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnEmptyListFromEmptyTableWhenGetAllPersonsIsCalled() throws SQLException {

        actualPersonList = repository.getAllPersons();
        expectedPersonList = Lists.newArrayList();

        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfAllPeopleWithNameStartingWithSpecificLetters() throws SQLException {
        savePersonsToDatabaseForTest();

        expectedPersonList = Lists.newArrayList(person2, person3);
        actualPersonList = repository.getPersonsByStartingLetters("Jo");
        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfAllPeopleWithNameStartingWithSpecificLetters2() throws SQLException {
        savePersonsToDatabaseForTest();

        expectedPersonList = Lists.newArrayList(person3);
        actualPersonList = repository.getPersonsByStartingLetters("Jos");
        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfAllPeopleWithNameStartingWithSpecificLetters3() throws SQLException {
        savePersonsToDatabaseForTest();

        expectedPersonList = Lists.newArrayList();
        actualPersonList = repository.getPersonsByStartingLetters("A");
        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfAllPeopleWithNameStartingWithSpecificLetters4() throws SQLException {
        savePersonsToDatabaseForTest();

        expectedPersonList = Lists.newArrayList(person,person2,person3);
        actualPersonList = repository.getPersonsByStartingLetters("");
        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfAllPeopleWithNameStartingWithSpecificLetters5() throws SQLException {
        savePersonsToDatabaseForTest();

        expectedPersonList = Lists.newArrayList();
        actualPersonList = repository.getPersonsByStartingLetters(null);
        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfPeopleInCityAtSameTime() throws SQLException {
        savePersonsToDatabaseForTest();
        fillTripTableWithTestData();

        expectedPersonList = Lists.newArrayList(person, person2);
        actualPersonList = repository.getPersonsInCityAtSameTime("2011-03-15", "varna");
        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfPeopleInCityAtSameTime2() throws SQLException {
        savePersonsToDatabaseForTest();
        fillTripTableWithTestData();

        expectedPersonList = Lists.newArrayList();
        actualPersonList = repository.getPersonsInCityAtSameTime("2013-03-15", "varna");

        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfPeopleInCityAtSameTime3() throws SQLException {
        savePersonsToDatabaseForTest();
        fillTripTableWithTestData();

        expectedPersonList = Lists.newArrayList();
        actualPersonList = repository.getPersonsInCityAtSameTime(null, "varna");

        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnListOfPeopleInCityAtSameTime4() throws SQLException {
        savePersonsToDatabaseForTest();
        fillTripTableWithTestData();

        expectedPersonList = Lists.newArrayList();
        actualPersonList = repository.getPersonsInCityAtSameTime("2013-03-15", null);

        assertEquals(expectedPersonList, actualPersonList);
    }

     @Test
    public void shouldReturnListOfPeopleInCityAtSameTime5() throws SQLException {
        savePersonsToDatabaseForTest();
        fillTripTableWithTestData();

        expectedPersonList = Lists.newArrayList();
        actualPersonList = repository.getPersonsInCityAtSameTime("", "varna");

        assertEquals(expectedPersonList, actualPersonList);
    }

     @Test
    public void shouldReturnListOfPeopleInCityAtSameTime6() throws SQLException {
        savePersonsToDatabaseForTest();
        fillTripTableWithTestData();

        expectedPersonList = Lists.newArrayList();
        actualPersonList = repository.getPersonsInCityAtSameTime("2013-03-15", "");

        assertEquals(expectedPersonList, actualPersonList);
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
