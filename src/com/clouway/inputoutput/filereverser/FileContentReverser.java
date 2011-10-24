package com.clouway.inputoutput.filereverser;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/5/11
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileContentReverser {
    public BufferedReader bufferedReader;
    public BufferedWriter bufferedWriter;
    public StringBuffer stringBuf = new StringBuffer();

    /**
     * reverse the content of a text file
     * @param name  the name of the file which we will reverse.
     *  The reversed content overwrite the non-reversed..
     */
    public void readFile(String name) throws IOException {
        String line;

            bufferedReader = new BufferedReader(new FileReader(name));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuf.append(line).append("\n");
            }


        String text = stringBuf.reverse().toString();


            bufferedWriter = new BufferedWriter(new FileWriter(name));
            bufferedWriter.write(text);
            bufferedWriter.close();


    }


}
