package com.clouway.testing.service;


/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 11/7/11
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Service {

    private YearValidator yearValidator;
    private DataBase dataBase;

    public Service(YearValidator yearValidator, DataBase dataBase) {
        this.yearValidator = yearValidator;
        this.dataBase = dataBase;
    }

    /**
     * check if the year is in the appropriate range
     *
     * @param personYears the years that we check
     */
    private void validateYears(String personYears) {

        // lthe same Exception is thrown for parsing just for convenience in normal conditions there should be two different exceptions
        try {
            Integer.parseInt(personYears);
        } catch (NumberFormatException ex) {
            throw new YearOutOfRangeException();
        }
        int years = Integer.parseInt(personYears);

        if (years < 10 || years > 100)
            throw new YearOutOfRangeException();

        yearValidator.validate(personYears);
    }

    /**
     * save a person into the db
     *
     * @param person the person that we save
     */
    public void savePerson(Person person) {
       validateYears(person.getYears());
       dataBase.savePerson(person);
    }

    /**
     * take the years of a person from the db using his egn
     *
     * @param egn the egn of the the person for which we take the years
     * @return true if the person is over 18 years and false otherwise
     */
    public boolean getPersonYearsByEgn(String egn) {
        String years = dataBase.getYearsFromDb(egn);
        if (Integer.parseInt(years) >= 18) {
            return true;
        } else {
            return false;
        }
    }

}

