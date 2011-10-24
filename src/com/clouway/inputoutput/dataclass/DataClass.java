package com.clouway.inputoutput.dataclass;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/6/11
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataClass {

    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    /**
     *
     * @param out   the outputstream in which we are going to store the object
     * @param o    the object that we are going to write in the output stream
     * @throws IOException
     */
    public void saveObject(OutputStream out, Object o) throws IOException {
        try {
            oos = new ObjectOutputStream(out);
            oos.writeObject(o);
        } finally {
            oos.close();
        }
    }

    /**
     *
     * @param in  the inputstream  used to read an instance of an object
     * @return   the instance of an object read by the inputstream
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object getObject(InputStream in) throws IOException, ClassNotFoundException {
        Object obj = null;
        try {
            ois = new ObjectInputStream(in);
            obj = ois.readObject();
        } finally {
            ois.close();

        }

        return obj;

    }
}
