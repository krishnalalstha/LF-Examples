package com.lf.example.database;

/**
 * Created by krish on 29/11/15.
 */
public class Test {
    private static Test ourInstance = new Test();

    public static Test getInstance() {

        return ourInstance;
    }

    private Test() {
    }
}
