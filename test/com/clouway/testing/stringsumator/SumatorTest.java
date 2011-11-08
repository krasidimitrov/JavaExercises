package com.clouway.testing.stringsumator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/24/11
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */

public class SumatorTest {
    private Sumator sumator;

    @Before
    public void creatTestableSumator() {
        sumator = new Sumator();
    }

    @Test
    public void sumShouldSumTwoStringNumbers() {
        assertEquals("22.0", sumator.sum("12", "10"));
    }

    @Test(expected = NumberFormatException.class)
    public void sumShouldThrowNumberFormatException() {
        sumator.sum("A2", "12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumShouldThrowIllegalArgumentException() {
        sumator.sum("13", null);
    }
}
