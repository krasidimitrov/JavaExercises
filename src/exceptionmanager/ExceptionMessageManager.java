package exceptionmanager;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/21/11
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionMessageManager {

    public Hashtable<String, String> exceptions;

    /**
     * constructor with one parameter
     *
     * @param newHashTable the hashTable we are creating.
     */
    public ExceptionMessageManager(Hashtable<String, String> newHashTable) {
        exceptions = newHashTable;
        exceptions.put("ex1", "WARNING: Critical mass!");
        exceptions.put("ex2", "WARNING: Temperature rising!");
        exceptions.put("ex3", "WARNIG: An idiot is operating!");
    }

    /**
     * add a key-value pair to the hashTable if the key and value doesn't exist
     *
     * @param messageCode the key of the key-value pair which we want to add;
     * @param message     the value of the key-value pair we want to add
     * @throws KeyOfHashTableExistException   if a key-value pair with this key already exist;
     * @throws ValueOfHashTableExistException if a key-value pair with this value already exist;
     */
    public void registerErrorMessage(String messageCode, String message) throws KeyOfHashTableExistException, ValueOfHashTableExistException {


        if (exceptions.containsKey(messageCode)) {
            throw new KeyOfHashTableExistException();
        } else if (exceptions.containsValue(message)) {
            throw new ValueOfHashTableExistException();
        } else {
            exceptions.put(messageCode, message);

        }

    }

    /**
     * @param messageCode the key of the key-value pair on which we want to take the message
     * @return the value of the key-value pair
     * @throws HashTableKeyNotFoundException
     */
    public String raiseError(String messageCode) throws HashTableKeyNotFoundException {
        if ((exceptions.containsKey(messageCode))) {
            return exceptions.get(messageCode);
        } else {
            throw new HashTableKeyNotFoundException();
        }
    }

    public String getErrorMessages() {
        String combined = "";
        Enumeration<String> e = exceptions.elements();
        while (e.hasMoreElements()) {
            String nextElement = e.nextElement();
            combined = combined + nextElement + "\n";
        }
        return combined;
    }

    public static void main(String[] args) {

        ExceptionMessageManager tester = new ExceptionMessageManager(new Hashtable<String, String>());

        try {
            tester.registerErrorMessage("das", "gsa");
            tester.registerErrorMessage("ex1", "dasda");
        } catch (KeyOfHashTableExistException e) {
            System.err.println("Key already exist. Choose another key.");

        } catch (ValueOfHashTableExistException e) {
            System.err.println("Value already exist. Choose another value/");
        }

        System.out.println(tester.getErrorMessages());
    }
}