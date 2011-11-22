//package com.clouway.threads.autocleaningtablev2;
//
///**
// * Created by Krasimir Dimitrov
// * Date: 11/22/11
// * Time: 11:07 AM
// */
//
//import java.util.Hashtable;
//import java.util.Scanner;
//
//public class AutocleaningTable {
//
//    public interface RemovesObjectCallBack{
//        void remove(String key);
//    }
//
//
//    private Hashtable<String, Object> valuesStorage = new Hashtable<String, Object>();
//    private Hashtable<String, LifecycleThread> threadReferencesTable = new Hashtable<String, LifecycleThread>();
//    private LifecycleThread keyFollower;
//
//
//    Scanner in = new Scanner(System.in);
//
////    private RemovesObjectCallBack removesObjectCallBack = new RemovesObjectCallBack(){
////                public void remove(String key) {
////                   remove(key);
////                }
////            };
//
//    /**
//     * Put an object in the hash table and start a counter for the life time of the key if this is the first time this key is used
//     * @param key
//     * @param object
//     */
//    public void put(String key, Object object) {
//        if (valuesStorage.containsKey(key)) {
//            valuesStorage.put(key, object);
//            threadReferencesTable.get(key).setTimeCounter(0);
//        } else {
////            Thread thread = new Thread(keyFollower = new LifecycleThread(key,valuesStorage, threadReferencesTable));
////            Thread thread = new Thread(keyFollower = new LifecycleThread(key,this));
//            Thread thread = new Thread(keyFollower = new LifecycleThread(key,removesObjectCallBack));
//            threadReferencesTable.put(key, keyFollower);
//            thread.start();
//            valuesStorage.put(key, object);
//        }
//    }
//
//    /**
//     * Get an object from the table by its key and reset the timer
//     * @param key the key of the object we want to get
//     * @return the object if exist else return null
//     */
//    public Object get(String key) {
//        if (valuesStorage.containsKey(key)) {
//            threadReferencesTable.get(key).setTimeCounter(0);
//            return threadReferencesTable.get(key);
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     *Use the method get() from the console by typing any key we want
//     */
//    public void getInConsole() {
//        String checker;
//        while (!(checker = in.next()).equals("quit")) {
//            System.out.println(get(checker));
//        }
//    }
//
//    public void remove(String key) {
//        valuesStorage.remove(key);
//        threadReferencesTable.remove(key);
//    }
//}
