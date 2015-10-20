package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * CoordinateTest.java
 *
 * Created by CFPrulez on 20.10.15.
 */

public class CoordinateTest {
    Coordinate c1, c2, c3;

    @Before
    public void setUp() {
        c1 = new Coordinate(0,0);
        c2 = new Coordinate(5000.11, -37.66);
        c3 = null;
    }

    @Test
    public void testGetter() {
        assertTrue(c1.getLongitude() == 0);
        assertTrue(c1.getLatitude() == 0);
        assertTrue(c2.getLongitude() == 5000.11);
        assertTrue(c2.getLatitude() == -37.66);
    }

    @Test
    public void testDistance() {
        assertTrue(c1.longitudeDistance(c3) == Double.MIN_VALUE);
        assertTrue(c1.latitudeDistance(c1) == 0);

        assertTrue(c1.latitudeDistance(c2) == - c2.latitudeDistance(c1));
        assertTrue(c1.longitudeDistance(c2) == - c2.longitudeDistance(c1));
    }

    @Test
    public void testDistanceinMeter() {
        assertTrue(c1.distanceInMeter(c3) == Double.MIN_VALUE);
        assertTrue(c1.distanceInMeter(c1) == 0);

        assertTrue(c1.distanceInMeter(c2) == c2.distanceInMeter(c1));
        assertTrue((int) c1.distanceInMeter(c2) == 5848538);
    }
}
