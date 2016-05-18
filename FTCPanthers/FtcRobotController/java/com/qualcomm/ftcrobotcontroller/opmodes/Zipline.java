package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Zipline {
    public Servo leftServo;
    public Servo rightServo;

    public static final String LEFT_CLIMBER_SERVO = "leftClimberServo";
    public static final String RIGHT_CLIMBER_SERVO = "rightClimberServo";

    public static final double LEFT_OUT_POSITION = 0.1;
    public static final double LEFT_IN_POSITION = 0.7;

    public static final double RIGHT_OUT_POSITION = 0.4;
    public static final double RIGHT_IN_POSITION = 1.0;

    public boolean leftOut = false;
    public boolean rightOut = false;

    ElapsedTime leftTimer;
    ElapsedTime rightTimer;

    public Zipline(HardwareMap hardwareMap) {
        leftServo = hardwareMap.servo.get(LEFT_CLIMBER_SERVO);
        rightServo = hardwareMap.servo.get(RIGHT_CLIMBER_SERVO);
        leftTimer = new ElapsedTime();
        rightTimer = new ElapsedTime();
    }

    public void setRightServoOut() {
        rightServo.setPosition(RIGHT_OUT_POSITION);
    }

    public void setRightServoIn() {
        rightServo.setPosition(RIGHT_IN_POSITION);
    }

    public void setLeftServoOut() {
        leftServo.setPosition(LEFT_OUT_POSITION);
    }

    public void setLeftServoIn() {
        leftServo.setPosition(LEFT_IN_POSITION);
    }

    public void resetServos() {
        setLeftServoIn();
        leftOut = false;
        setRightServoIn();
        rightOut = false;
    }

    public void toggleLeft() {
        if(leftTimer.time() > 0.5)
        {
            if (leftOut) {
                setLeftServoIn();
                leftOut = false;
                leftTimer.reset();
            } else {
                setLeftServoOut();
                leftOut = true;
                leftTimer.reset();
            }
        }
    }

    public void toggleRight() {
        if(rightTimer.time() > 0.5)
        {
            if (rightOut) {
                setRightServoIn();
                rightOut = false;
                rightTimer.reset();
            } else {
                setRightServoOut();
                rightOut = true;
                rightTimer.reset();
            }
        }
    }
}