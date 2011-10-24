package com.clouway.inputoutput.directorybrowser;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/6/11
 * Time: 6:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        DirectoryBrowser dirBrowser = new DirectoryBrowser();
        dirBrowser.listContent("/home/clouway/");
    }
}
