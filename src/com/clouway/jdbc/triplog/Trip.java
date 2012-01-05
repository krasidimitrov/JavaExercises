package com.clouway.jdbc.triplog;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/4/12
 * Time: 2:55 PM
 */
public class Trip {
    private String egn;
    private String departureDate;
    private String returnDate;
    private String cityVisited;

    public Trip(String egn, String departureDate, String returnDate, String cityVisited) {
        this.egn = egn;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.cityVisited = cityVisited;
    }
}
