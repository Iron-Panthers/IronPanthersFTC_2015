package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.*;

public class Move extends Routine {
    public static final double SPROCKET_REVOLUTIONS_PER_TRACK_REVOLUTION = 36/(2.6 * Math.PI); //need to confirm
    public static final double ENCODER_VALUE_PER_REVOLUTION = 1440; // NEED TO CONFIRM STILL
    public static double ENCODER_VALUE_PER_TRACK_REVOLUTION;
    public static double ENCODER_VALUE_PER_INCH;
    //public static final double SPROCKET_REVOLUTIONS_PER_TRACK_REVOLUTION = 1440; //STILL NEED TO CONFIRM
    // APPARENTLY, THIS IS ACTUALLY 1440
    public static final double ROBOT_WIDTH = 18;
    public static final double TRACK_lENGTH = 36; //in inches

    private double distance = 0;
    private double power = 1;
    private double targetValue;

    private double startDist = 0;

    private DcMotor leftBackMotor;
    private DcMotor rightBackMotor;

    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;

    private int leftStart = 0;
    private int rightStart = 0;

    private boolean rightShouldMove = true;
    private boolean leftShouldMove = true;

    public Move(double inchesDistance, double pwr, HardwareMap map){
        distance = inchesDistance;
        power = pwr;
        ENCODER_VALUE_PER_TRACK_REVOLUTION = ENCODER_VALUE_PER_REVOLUTION * SPROCKET_REVOLUTIONS_PER_TRACK_REVOLUTION;
        ENCODER_VALUE_PER_INCH = ENCODER_VALUE_PER_TRACK_REVOLUTION / TRACK_lENGTH;

        targetValue = distance*SPROCKET_REVOLUTIONS_PER_TRACK_REVOLUTION/TRACK_lENGTH;

        leftBackMotor = map.dcMotor.get("leftBack");
        rightBackMotor = map.dcMotor.get("rightBack");

        leftFrontMotor = map.dcMotor.get("leftFront");
        rightFrontMotor = map.dcMotor.get("rightFront");

        leftStart = leftBackMotor.getCurrentPosition();
        rightStart = rightBackMotor.getCurrentPosition();
    }

    public boolean update(){
        if(leftShouldMove) {
            leftBackMotor.setPower(-power);
            leftFrontMotor.setPower(-power);
        }

        if(rightShouldMove){
            rightBackMotor.setPower(power);
            rightFrontMotor.setPower(power);
        }

        return isFinished();
    }

    public boolean isFinished(){
        int leftRotChange = leftStart - leftBackMotor.getCurrentPosition();
        int rightRotChange = rightBackMotor.getCurrentPosition() - rightStart;

        if(leftRotChange >= targetValue){
            leftShouldMove = false;
            leftBackMotor.setPower(0.0);
            leftFrontMotor.setPower(0.0);

        }

        if (rightRotChange >= targetValue){
            rightShouldMove = false;
            rightBackMotor.setPower(0.0);
            rightFrontMotor.setPower(0.0);
        }

        return !(leftShouldMove || rightShouldMove);
    }
}
