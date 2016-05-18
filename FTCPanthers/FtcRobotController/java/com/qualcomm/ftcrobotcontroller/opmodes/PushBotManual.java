package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftccommon.DbgLog;
import com.qualcomm.robotcore.hardware.Servo;
//------------------------------------------------------------------------------
//
// PushBotManual
//
/**
 * Provide a basic manual operational mode that uses the left and right
 * drive motors, left arm motor, servo motors and gamepad input from two
 * gamepads for the Push Bot.
 *
 * @author SSI Robotics
 * @version 2015-08-01-06-01
 */
public class PushBotManual extends PushBotTelemetry
{
    public final float yJoystickScale = (float)0.75;
    public final float minTrigger = (float)0.1;
    public final float ziplineRetracted = (float)0.4;
    public final float ziplineExtended = (float)1.0;
    public final float pullupSpeed = (float)0.25;

    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public DcMotor leftMotor1;
    public DcMotor rightMotor1;

    public DcMotor pullUpMotor;

    public Servo ziplineServo;

    public Joystick joystick1;

    public PushBotManual ()
    {

    } // PushBotManual

    @Override public void init()
    {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        leftMotor1 = hardwareMap.dcMotor.get("leftMotor1");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        rightMotor1 = hardwareMap.dcMotor.get("rightMotor1");
        //ziplineServo = hardwareMap.servo.get("zipline");

        //pullUpMotor = hardwareMap.dcMotor.get("pullup");
    }

    @Override public void loop ()
    {
        //LEFT MOTORS ARE ON MOTOR CONTROLLER 1, NOW CALLED 'LEFT MOTORS', THIS WOULD BE IN PORT 1
        leftMotor.setPower(-leftStickY());
        leftMotor1.setPower(-leftStickY());

        // RIGHT MOTORS ARE ON MOTOR CONTROLLER 2, NOW CALLED 'RIGHT MOTORS', THIS WOULD BE IN PORT 0
        rightMotor.setPower(rightStickY());
        rightMotor1.setPower(rightStickY());

        //leftMotor.setPower(-0.3);
        //leftMotor1.setPower(-0.3);

        //rightMotor.setPower(0.3);
        //rightMotor.setPower(0.3);

        /*DbgLog.msg("Left:"+leftMotor.getCurrentPosition() + ", Rights:"+rightMotor.getCurrentPosition());

        if (leftButton()){
            ziplineServo.setPosition(ziplineRetracted);
        }
        else if (rightButton()){
            ziplineServo.setPosition(ziplineExtended);
        }

        if (leftTrigger() > minTrigger){
            pullUpMotor.setPower(pullupSpeed);
        }
        else if (rightTrigger() > minTrigger){
            pullUpMotor.setPower(pullupSpeed);
        }*/
    } // loop

    //Joystick Wrapper stuff

    public float leftStickX(){
        return gamepad1.left_stick_x;
    }

    public float rightStickX(){
        return gamepad1.right_stick_x;
    }

    public float leftStickY(){
        return yJoystickScale*gamepad1.left_stick_y;
    }

    public float rightStickY(){
        return yJoystickScale*gamepad1.right_stick_y;
    }

    public float leftTrigger(){
        return gamepad1.left_trigger;
    }

    public float rightTrigger(){
        return gamepad1.right_trigger;
    }

    public boolean leftButton(){
        return  gamepad1.left_bumper;
    }

    public boolean rightButton(){
        return  gamepad1.right_bumper;
    }



} // PushBotManual