package com.qualcomm.ftcrobotcontroller.opmodes;

import java.util.ArrayList;

/**
 * Created by BHS on 12/4/2015.
 */
public class Queue {
    private ArrayList<Routine> tasks = new ArrayList<Routine>();
    //top of list (index: 0) is the fifo point

    public void unshift (Routine task){
        tasks.add(0, task);
    }

    private void shift(){
        tasks.remove(0);
    }

    public void update(){

    }
}
