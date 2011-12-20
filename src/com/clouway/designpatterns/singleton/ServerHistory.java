package com.clouway.designpatterns.singleton;

/**
 * Singleton class
 * Created by Krasimir Dimitrov
 * Date: 12/13/11
 * Time: 3:36 PM
 */
public class ServerHistory {

    private static ServerHistory instance;
    private int peopleOnline;

    /**
     * Private constructor
     */
    private ServerHistory(){
    }

    /**
     * Create an instance of this class if there isn't one
     * @return the instance created(or existing instance)
     */
    public  static ServerHistory createInstance(){
        if(instance == null){
            instance = new ServerHistory();
        }
        return instance;
    }


    public void setPeopleOnline(int peopleOnline) {
        this.peopleOnline = peopleOnline;
    }

    public int getPeopleOnline() {
        return peopleOnline;
    }
}
