package com.sreejith;

import java.io.IOException;

public class MyMain {

    public static void main(String [] args)
    {
        MyController myc = new MyController();
        try {
            myc.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myc.doWork();
    }
}
