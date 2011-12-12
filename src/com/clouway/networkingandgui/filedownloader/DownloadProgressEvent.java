package com.clouway.networkingandgui.filedownloader;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/8/11
 * Time: 1:29 PM
 */
public class DownloadProgressEvent {

    private final int currentProgress;
    private final int maxProgress;

    public DownloadProgressEvent(int currentProgress, int maxProgress) {
        this.currentProgress = currentProgress;
        this.maxProgress = maxProgress;
    }

    public int getCurrentProgress() {
        return currentProgress;
    }

    public int getMaxProgress() {
        return maxProgress;
    }
}
