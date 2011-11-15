package com.clouway.testing.service;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/7/11
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */


public class ServiceTest {
    private YearValidator yearValidator;
    private DataBase dataBase;
    private Service service;

    Mockery context = new JUnit4Mockery();

    @Before
    public void createTestableData(){
        yearValidator = context.mock(YearValidator.class);
        dataBase = context.mock(DataBase.class);
        service = new Service(yearValidator,dataBase);

    }

    /*
     *This test is not working and i am to ignorant to see why! (you can comment service.validateYears or save person and it will still pass
     */
    @Test
    public void happyPath() {

       final Person person = new Person("Krasimir", "8912141403", "20");

        context.checking(new Expectations() {{
            oneOf(yearValidator).validate(person.getYears());
           oneOf(dataBase).savePerson(person);
        }});

      service.validateYears("20");
      service.savePerson(person);
    }

    @Test (expected = YearOutOfRangeException.class)
    public void yearsLessThan10OrBiggerThan100AreNotSave() {
;
        final Person person = new Person("Krasimir", "8912141403", "1");

        context.checking(new Expectations() {{
            oneOf(yearValidator).validate(person.getYears());
        }});

        service.validateYears(person.getYears());
    }


    @Test
    public void getYearsFromDataBaseAndReturnTrueIfMoreThan18(){

      //  final Person person = new Person("Krasimir", "8912141403", "1");

        context.checking(new Expectations(){{
            oneOf(dataBase).getYearsFromDb("8912141403");
            will(returnValue("19"));
        }});

       assertTrue(service.getPersonYearsByEgn("8912141403"));
    }

}
