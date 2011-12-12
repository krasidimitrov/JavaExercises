package floorexample;

import static java.lang.Math.floor;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/24/11
 * Time: 11:32 AM
 */
public class FloorExample {
    public static void main(String[] args) {
        double a = 35.000;
        String number = Double.toString(a);
        System.out.println(number.substring(0,number.length()-2));
    }
}
