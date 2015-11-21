package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

public class Zipline
{
    public Servo leftServo;
    public Servo rightServo;

    public static final String LEFT_CLIMBER_SERVO = "leftClimberServo";
    public static final String RIGHT_CLIMBER_SERVO = "rightClimberServo";

    public static final double LEFT_OUT_POSITION = 1.0;
    public static final double LEFT_IN_POSITION = 0.5;

    public static final double RIGHT_OUT_POSITION = 1.0;
    public static final double RIGHT_IN_POSITION = 0.5;

    public boolean leftOut = false;
    public boolean rightOut = false;

    public Zipline(HardwareMap hardwareMap)
    {
        leftServo = hardwareMap.servo.get(LEFT_CLIMBER_SERVO);
        rightServo = hardwareMap.servo.get(RIGHT_CLIMBER_SERVO);
    }

    public void setRightServoOut()
    {
        rightServo.setPosition(RIGHT_OUT_POSITION);
    }

    public void setRightServoIn()
    {
        rightServo.setPosition(RIGHT_IN_POSITION);
    }

    public void setLeftServoOut()
    {
        leftServo.setPosition(LEFT_OUT_POSITION);
    }

    public void setLeftServoIn()
    {
        leftServo.setPosition(LEFT_IN_POSITION);
    }

    public void resetServos()
    {
        setLeftServoIn();
        leftOut = false;
        setRightServoIn();
        rightOut= false;
    }

    public void toggleLeft(){
        if (leftOut)
        {
            setLeftServoIn();
            leftOut = false;
        }
        else
        {
            setLeftServoOut();
            leftOut = true;
        }
    }

    public void toggleRight(){
        if (rightOut)
        {
            setRightServoIn();
            rightOut = false;
        }
        else
        {
            setRightServoOut();
            rightOut = true;
        }
    }
}
