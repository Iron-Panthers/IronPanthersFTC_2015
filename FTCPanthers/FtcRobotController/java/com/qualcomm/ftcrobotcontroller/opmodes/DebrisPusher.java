package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

public class DebrisPusher {
    public Servo leftDebris;
    public Servo rightDebris;

    public static final String LEFT_DEBRIS_SERVO = "leftDebrisServo";
    public static final String RIGHT_DEBRIS_SERVO = "rightDebrisServo";

    public static final double LEFT_UP_POSITION = 0.0;
    public static final double LEFT_DOWN_POSITION = 0.8;

    public static final double RIGHT_UP_POSITION = 1.0;
    public static final double RIGHT_DOWN_POSITION = 0.1;

    public boolean debrisUp;
    ElapsedTime timerDebrisServo;

    public DebrisPusher (HardwareMap hardwareMap){
        leftDebris = hardwareMap.servo.get(LEFT_DEBRIS_SERVO);
        rightDebris = hardwareMap.servo.get(RIGHT_DEBRIS_SERVO);
        timerDebrisServo = new ElapsedTime();
    }

    public void setDebrisUp() {
        rightDebris.setPosition(RIGHT_UP_POSITION);
        leftDebris.setPosition(LEFT_UP_POSITION);
        debrisUp = true;
    }

    public void setDebrisDown() {
        rightDebris.setPosition(RIGHT_DOWN_POSITION);
        leftDebris.setPosition(LEFT_DOWN_POSITION);
        debrisUp = false;
    }
    public void toggleDebris(){
        if(timerDebrisServo.time() > 0.5){
            if(debrisUp){
                setDebrisDown();
                timerDebrisServo.reset();
            } else {
                setDebrisUp();
                timerDebrisServo.reset();
            }
        }
    }


}
