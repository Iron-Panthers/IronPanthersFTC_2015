package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.ftccommon.DbgLog;

public class PantherRobot extends PushBotTelemetry
{
    public DcMotor frontLeft;
    public DcMotor backLeft;

    public DcMotor frontRight;
    public DcMotor backRight;

    public Joystick joystick;
    public Zipline zipline;
    public PullUpBar pullupBar;
    public DebrisPusher debrisPusher;

    public PantherRobot(){}

    @Override public void init()
    {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");

        zipline = new Zipline(hardwareMap);
        zipline.resetServos();
        pullupBar = new PullUpBar(hardwareMap);
        pullupBar.stopArm();
        debrisPusher = new DebrisPusher(hardwareMap);
        debrisPusher.setDebrisUp();
    }

    @Override public void loop () {

        frontLeft.setPower(-gamepad1.left_stick_y);
        backLeft.setPower(-gamepad1.left_stick_y);

        frontRight.setPower(gamepad1.right_stick_y);
        backRight.setPower(gamepad1.right_stick_y);

        if (gamepad2.y || gamepad1.y) {
            zipline.toggleLeft();
        }

        if (gamepad2.b || gamepad1.b) {
            zipline.toggleRight();
        }

        if(gamepad1.dpad_up || gamepad2.dpad_up)
        {
            debrisPusher.setDebrisUp();
        }

        if(gamepad1.dpad_down || gamepad2.dpad_down)
        {
            debrisPusher.setDebrisDown();
        }

        if(gamepad2.right_trigger > 0.1 || gamepad1.right_trigger > 0.1) {
            pullupBar.swingArmIn();
        }

        else if(gamepad2.left_trigger > 0.1 || gamepad1.left_trigger > 0.1)
        {
            pullupBar.swingArmOut();
        }
        else
        {
            pullupBar.stopArm();
        }

        if(gamepad2.left_bumper || gamepad1.left_bumper)
        {
            pullupBar.extendArm();
        }

        else if(gamepad2.right_bumper || gamepad1.right_bumper)
        {
            pullupBar.retractArm();
        }
        else
        {
            pullupBar.stopClaw();
        }

        if (gamepad1.back) //Resets all servos and motors
        {
            zipline.resetServos();
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
            //pullupBar.stopArm();
            //pullupBar.stopClaw();
            debrisPusher.setDebrisUp();
        }
    }
}