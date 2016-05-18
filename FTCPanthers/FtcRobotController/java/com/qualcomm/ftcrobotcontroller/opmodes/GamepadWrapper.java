package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by ibm on 11/3/2015.
 */
public class GamepadWrapper {
    public Gamepad controller;
    private Gamepad.GamepadCallback callback;

    public GamepadWrapper(){
        callback = new GamepadCallback();

        controller = new Gamepad(callback);
    }
}
