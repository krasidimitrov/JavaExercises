package com.clouway.designpatterns.singleton;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/13/11
 * Time: 3:36 PM
 */
public class ServerHistory {

    private static ServerHistory instance;
    private int peopleOnline;

    private ServerHistory(){
    }

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
