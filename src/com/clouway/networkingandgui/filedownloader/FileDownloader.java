package com.clouway.networkingandgui.filedownloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Krasimir Dimitrov
 * Date: 11/29/11
 * Time: 11:31 AM
 */
public class FileDownloader implements Runnable {

    private InputStream inputStream;
    private OutputStream outputStream;
    private URL url;
    private URLConnection urlConnection;
    private DownloadProgressListener listener;

    public void run() {
        downloadFile();
    }

    /**
     * Download the file
     */
    private void downloadFile() {
        int byteRead;
        int progressCounter = 0;
        int maxProgress = urlConnection.getContentLength();

        try {
            while ((byteRead = inputStream.read()) != -1) {
                outputStream.write(byteRead);
                progressCounter++;
                listener.onProgress(new DownloadProgressEvent(progressCounter, maxProgress));
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * add a Progress listener
     *
     * @param listener the listener that we are going to add
     */
    public void addProgressListener(DownloadProgressListener listener) {

        this.listener = listener;
    }

    /**
     * Take the url, prepare everything for the download and start the download
     *
     * @param urlString    the url from which we are going to download
     * @param saveLocation the location to which we are going to save our file
     */
    public synchronized void downloadStart(String urlString, String saveLocation) {
        try {
            outputStream = new FileOutputStream(saveLocation);
            url = new URL(urlString);
            urlConnection = url.openConnection();
            inputStream = urlConnection.getInputStream();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(this).start();
    }
}