package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by ibm on 11/3/2015.
 */
public class GamepadCallback implements Gamepad.GamepadCallback {
    public void gamepadChanged(Gamepad gamepad){
        System.out.println("Left stick x: " + gamepad.left_stick_x + ", y: " + gamepad.left_stick_y);
        System.out.println("Right stick x: " + gamepad.right_stick_x + ", y: " + gamepad.right_stick_y);
        int[] aDog = new int[5];
        int theDog = aDog[7];
    }
}
