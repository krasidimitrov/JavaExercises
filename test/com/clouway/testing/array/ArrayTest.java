package com.clouway.testing.array;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/28/11
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayTest {
    private Array array;
    private int[] testArray = {2, 5, 1, 3, -1, 4};
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void testCreatableArray() {
        array = new Array();
    }

    @Test
    public void getMinElementShouldReturnTheMinimalElementFromArray() {
        assertEquals("The minamal element is not correct", -1, array.getMinElement(testArray));
    }

    @Test
    public void getSumShouldReturnSumOfTheElementsOfArray() {
        assertEquals("The sum of the array is not correct", 14, array.getSum(testArray));
    }

    @Test
    public void printArrayShouldPrintAnArrayOnTheScreen() {
        System.setOut(new PrintStream(outContent));
        array.printArray(testArray);
        assertEquals("2 5 1 3 -1 4 ", outContent.toString());
        System.setOut(null);
    }


}
