package com.clouway.inputoutput.directorybrowser;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/6/11
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class DirectoryBrowser {

    /**
     * print all files and directories in a chosen directory
     *
     * @param path the path for the directory we want to browse(i.e. "/home/clouway/")
     */

    public void listContent(String path) {

        File dir = new File(path);
        String[] list = dir.list();


        if (dir.isFile()) {
            System.out.print("This is a file not a directory");
        } else if (dir.isDirectory()) {
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        }

    }
}
