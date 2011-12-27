package com.clouway.designpatterns.objectpool;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/26/11
 * Time: 9:21 AM
 */
public class CarPoolTest {
    private CarPool carPool;

    @Before
    public void createTestableData() {
        carPool = new CarPool(3);
    }

    @Test
    public void testIfObjectIsAcquired() {
        Car car = carPool.acquire();
        assertNotNull(car);
    }

    //Nameing this test??
    @Test
    public void testIfObjectIsTheSameAfterAcquiringAndReleasing() {
        Car car = carPool.acquire();
        carPool.release();
        assertEquals(car, carPool.acquire());
    }

    @Test(expected = PoolDoesNotHaveFreeElementsException.class)
    public void testIfExceptionIsThrownWhenPoolIsFool() {
        carPool.acquire();
        carPool.acquire();
        carPool.acquire();
        carPool.acquire();
    }

    @Test(expected = PoolDoesNotHaveFreeElementsException.class)
    public void testIfPoolIsFullObjectShouldNotBeCreated() {
        carPool.acquire();
        carPool.acquire();
        carPool.acquire();
        Car car = carPool.acquire();
        assertNull(car);
    }

    @Test(expected = NoTakenElementsToReleaseException.class)
    public void shouldThrowExceptionAfterReleasingWhenThereAreNoTakenElements() {
        carPool.release();
    }
}
