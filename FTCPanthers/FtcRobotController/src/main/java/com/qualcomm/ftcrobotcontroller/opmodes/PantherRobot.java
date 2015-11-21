package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.ftccommon.DbgLog;

public class PantherRobot extends PushBotTelemetry
{
    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;

    public DcMotor frontRightMotor;
    public DcMotor backRightMotor;

    public Joystick joystick;
    public Zipline zipline;
    public PullUpBar pullupBar;

    public PantherRobot(){}

    @Override public void init()
    {
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");

        //joystick = new Joystick(gamepad1);
        zipline = new Zipline(hardwareMap);
        zipline.resetServos();
        //pullupBar = new PullUpBar(hardwareMap);
    }

    @Override public void loop () {

        frontLeftMotor.setPower(-(gamepad1.left_stick_y));
        backLeftMotor.setPower(-gamepad1.left_stick_y);

        frontRightMotor.setPower(gamepad1.right_stick_y);
        backRightMotor.setPower(gamepad1.right_stick_y);

        if (gamepad1.left_bumper) {
            zipline.toggleLeft();
        }

        if (gamepad1.right_bumper) {
            zipline.toggleRight();
        }

        /*if(joystick.buttonA())
        {
            pullupBar.retractArm();
        }

        if (joystick.buttonX())
        {
            pullupBar.extendArm();
        }

        if(joystick.buttonB())
        {
            pullupBar.swingArmIn();
        }

        if (joystick.buttonY())
        {
            pullupBar.swingArmOut();
        }

*/
        if (gamepad1.back) //Resets all servos and motors
        {
            zipline.resetServos();
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
        }
    }
}