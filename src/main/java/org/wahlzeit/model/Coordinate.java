package org.wahlzeit.model;

import java.util.DoubleSummaryStatistics;

/**
 * Coordinate.java
 *
 * Created by CFPrulez on 20.10.15.
 */

public class Coordinate {
    public static final double radius = 6371000.785; // earth radius in m

    private double longitude;
    private double latitude;

    public Coordinate() {}

    public Coordinate(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double longitudeDistance(double longitude) {
        return this.longitude - longitude;
    }

    public double longitudeDistance(Coordinate c) {
       return (c == null) ? Double.MIN_VALUE : longitudeDistance(c.getLongitude());
    }

    public double latitudeDistance(double latitude) {
        return this.latitude - latitude;
    }

    public double latitudeDistance(Coordinate c) {
        return (c == null) ? Double.MIN_VALUE : latitudeDistance(c.getLatitude());
    }

    public double distanceInMeter(double longitude, double latitude) {
        // https://en.wikipedia.org/wiki/Haversine_formula
        double radianLat = Math.toRadians(latitudeDistance(latitude));
        double radianLon = Math.toRadians(longitudeDistance(longitude));

        double a = Math.sin(radianLat / 2) * Math.sin(radianLat / 2) +
                Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(latitude)) * Math.sin(radianLon / 2) *
                        Math.sin(radianLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Math.abs(radius * c);
    }

    public double distanceInMeter(Coordinate c) {
        return (c == null) ? Double.MIN_VALUE : distanceInMeter(c.getLongitude(), c.getLatitude());
    }
}
