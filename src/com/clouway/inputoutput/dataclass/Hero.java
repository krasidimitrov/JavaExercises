package com.clouway.inputoutput.dataclass;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/4/11
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hero implements Serializable{
    public String name;
    public int damage;
    public double speed;

    public Hero(String heroName, int heroDamage, double heroSpeed){
        name=heroName;
        damage=heroDamage;
        speed=heroSpeed;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
      return damage;
    }

}
