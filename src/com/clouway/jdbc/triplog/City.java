package com.clouway.jdbc.triplog;

/**
 * C.ass which create city objects
 * Created by Krasimir Dimitrov
 * Date: 1/5/12
 * Time: 1:39 PM
 */
public class City {
    private String cityName;
    private int timesVisited;

    public City(String cityName,int timesVisited){
        this.cityName = cityName;
        this.timesVisited = timesVisited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (timesVisited != city.timesVisited) return false;
        if (cityName != null ? !cityName.equals(city.cityName) : city.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityName != null ? cityName.hashCode() : 0;
        result = 31 * result + timesVisited;
        return result;
    }
}
