package com.clouway.networkingandgui.filedownloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GUI for the download agent
 * Created by Krasimir Dimitrov
 * Date: 11/29/11
 * Time: 11:10 AM
 */
public class FileDownloaderGUI extends JFrame {

    private FileDownloader fileDownloader;
    private JTextField urlTextField;
    private JTextField saveLocationTextField;
    private JButton saveButton;
    private JButton chooseLocationButton;
    private JProgressBar downloadStatusBar;
    private JFileChooser jFileChooser;

    public FileDownloaderGUI(FileDownloader fileDownloader) {

        this.fileDownloader = fileDownloader;

        urlTextField = new JTextField();
        urlTextField.setPreferredSize(new Dimension(480, 30));
        urlTextField.setBorder(null);
        add(urlTextField);

        SaveHandler saveHandler = new SaveHandler();
        saveButton = new JButton("Save");
        add(saveButton);
        saveButton.addActionListener(saveHandler);

        saveLocationTextField = new JTextField();
        saveLocationTextField.setPreferredSize(new Dimension(480, 30));
        saveLocationTextField.setBorder(null);
        saveLocationTextField.setEnabled(false);
        saveLocationTextField.setDisabledTextColor(Color.magenta);
        saveLocationTextField.setText("/home/clouway/ddd.jpg");
        add(saveLocationTextField);

        ChooseLocationHandler chooseLocationHandler = new ChooseLocationHandler();
        chooseLocationButton = new JButton("choose save location");
        add(chooseLocationButton);
        chooseLocationButton.addActionListener(chooseLocationHandler);

        jFileChooser = new JFileChooser();

        fileDownloader.addProgressListener(new DownloadProgressListener() {
            public void onProgress(DownloadProgressEvent event) {
                downloadStatusBar.setMaximum(event.getMaxProgress());
                downloadStatusBar.setValue(event.getCurrentProgress());
            }
        });

        downloadStatusBar = new JProgressBar();
        downloadStatusBar.setPreferredSize(new Dimension(480, 30));
        downloadStatusBar.setStringPainted(true);
        add(downloadStatusBar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.getHSBColor(172, 309, 199));
        setLayout(new FlowLayout());
        setSize(500, 220);
        setVisible(true);
    }

    /**
     * Event handler for the save button
     */
    private class SaveHandler implements ActionListener {
        private String urlText;

        public void actionPerformed(ActionEvent event) {
            fileDownloader.downloadStart(urlTextField.getText(), saveLocationTextField.getText());
        }
    }

    /**
     * Event handler for the choose save location button
     */
    private class ChooseLocationHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            int value = jFileChooser.showSaveDialog(null);

            if (value == JFileChooser.APPROVE_OPTION) {
                saveLocationTextField.setText(jFileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }
}