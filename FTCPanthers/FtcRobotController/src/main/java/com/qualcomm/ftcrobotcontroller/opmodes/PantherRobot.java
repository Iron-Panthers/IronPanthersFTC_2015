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

        joystick = new Joystick(gamepad1);
        zipline = new Zipline(hardwareMap);
        pullupBar = new PullUpBar(hardwareMap);
    }

    @Override public void loop () {
        frontLeftMotor.setPower(-joystick.leftStickY());
        backLeftMotor.setPower(-joystick.leftStickY());

        frontRightMotor.setPower(joystick.rightStickY());
        backRightMotor.setPower(joystick.rightStickY());

        if (joystick.leftBumper()) {
            zipline.toggleLeft();
        }

        if (joystick.rightBumper()) {
            zipline.toggleRight();
        }

        if(joystick.buttonA())
        {
            pullupBar.retractArms();
        }

        if (joystick.buttonX())
        {
            pullupBar.extendArms();
        }

        if(joystick.buttonB())
        {
            pullupBar.swingArmsIn();
        }

        if (joystick.buttonY())
        {
            pullupBar.swingArmsOut();
        }

        if (joystick.back()) //Resets all servos and motors
        {
            zipline.resetServos();
        }
    }
}