package com.clouway.designpatterns.objectpool;

/**
 * Created by Krasimir Dimitrov
 * Date: 12/16/11
 * Time: 5:13 PM
 */
public class Main {
    public static void main(String[] args) {
        Pool pool = new Pool(2);
        pool.acquire();
        pool.acquire();
        pool.release();
        pool.acquire();
        pool.acquire();
    }
}
