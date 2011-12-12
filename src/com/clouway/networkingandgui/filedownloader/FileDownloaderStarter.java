package com.clouway.networkingandgui.filedownloader;

/**
 * Used to run the download agent
 * Created by Krasimir Dimitrov
 * Date: 12/9/11
 * Time: 5:11 PM
 */
public class FileDownloaderStarter {

    public static void main(String[] args) {

        FileDownloaderGUI downloadAgent = new FileDownloaderGUI(new FileDownloader());
    }
}
