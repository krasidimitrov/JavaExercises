package com.clouway.testing.service;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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

    Mockery context = new JUnit4Mockery();

    @Before
    public void createTestableData(){
        yearValidator = context.mock(YearValidator.class);
        dataBase = context.mock(DataBase.class);

    }

    private void validate(String years) {
        new Service(yearValidator, dataBase).validate(years);
    }

    private void save(Person person){
        new Service(yearValidator,dataBase).savePerson(person);
    }

    @Test
    public void happyPath() {

        final Person person = new Person("Krasimir", "8912141403", "20");

        context.checking(new Expectations() {{
            oneOf(yearValidator).validate(person.getYears());
            oneOf(dataBase).savePerson(person);
        }});

       validate("20");
       save(person);
    }

    @Test (expected = YearOutOfRangeException.class)
    public void yearsLessThan10OrBiggerThan100AreNotSave() {
;
        final Person person = new Person("Krasimir", "8912141403", "9");

        context.checking(new Expectations() {{
            oneOf(yearValidator).validate(person.getYears());
        }});

        validate(person.getYears());
    }


    @Test
    public void getYearsFromDataBaseAndReturnTrueIfMoreThan18(){

      //  final Person person = new Person("Krasimir", "8912141403", "1");

        context.checking(new Expectations(){{
            oneOf(dataBase).getYearsFromDb("8912141403");
            will(returnValue("19"));
        }});

       assertTrue(new Service(yearValidator, dataBase).getPersonYears("8912141403"));
    }

}
