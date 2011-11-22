//package com.clouway.threads.autocleaningtablev2;
//
//import java.util.Hashtable;
//
///**
// * Created by Krasimir Dimitrov
// * Date: 11/22/11
// * Time: 11:07 AM
// */
//public class LifecycleThread implements Runnable {
//    private int timeCounter = 0;
//    private AutocleaningTable autocleaningTable;
//    private String key;
//    private Hashtable<String, Object> valuesStorage;
//    private Hashtable<String, LifecycleThread> threadReferencesTable;
//    private AutocleaningTable.RemovesObjectCallBack removesObjectCallBack;
//
//    public LifecycleThread(String key, Hashtable<String, Object> valuesStorage, Hashtable<String, LifecycleThread> threadReferencesTable) {
//        this.key = key;
//        this.valuesStorage = valuesStorage;
//        this.threadReferencesTable = threadReferencesTable;
//    }
//
//    public LifecycleThread(String key, AutocleaningTable autocleaningTable) {
//        this.key = key;
//        this.autocleaningTable = autocleaningTable;
//    }
//
//    public LifecycleThread(String key, AutocleaningTable.RemovesObjectCallBack removesObjectCallBack) {
//        this.key = key;
//        this.removesObjectCallBack = removesObjectCallBack;
//    }
//
//
//    public void run(){
//        for(; timeCounter<100; timeCounter++){
//              try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " " + timeCounter);
//        }
////        valuesStorage.remove(key);
////        threadReferencesTable.remove(key);
////                   autocleaningTable.remove(key)
//removesObjectCallBack.remove(key);
//    }
//
//    public void setTimeCounter(int timeCounter) {
//        this.timeCounter = timeCounter;
//    }
//
//    public void setKeyFollowed(String keyFollowed) {
//        this.key = keyFollowed;
//    }
//}
