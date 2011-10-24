package com.clouway.inputoutput.transferobject;

import java.io.*;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/5/11
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransferObject {

    /**
     * transfer an instance of InputStream to an OutputStream
     *
     * @param in            the InputStream that we are going to transfer
     * @param out           the OutputStream that we are going to transfer to.
     * @param numberOfBytes the number of the bytes we want to transfer
     * @param offset        the number of bytes skipped from the beginning of the InputStream
     * @return the number of bytes that are transfered
     */


     public int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset)  {
        int bytesRead =0;
        int availableSize=0;
         try {
             availableSize = in.available();
         } catch (IOException e) {
             System.out.println("Error. Program terminated!");
         }
         byte[] buf = new byte[availableSize];

         try {
            if (numberOfBytes == -1) {
                    bytesRead =  in.read(buf);
                    out.write(buf, 0, availableSize);

                }
            else {
                in.skip(offset);
                    bytesRead = in.read(buf, 0, numberOfBytes);
                    //out.write(buf);
                    out.write(buf,0,numberOfBytes);

                }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return bytesRead;
    }
}







