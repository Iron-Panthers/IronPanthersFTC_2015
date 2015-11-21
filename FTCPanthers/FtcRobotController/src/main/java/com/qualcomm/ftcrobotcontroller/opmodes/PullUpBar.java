package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

public class PullUpBar
{
	public static final String PULLUP_SERVO = "pullupServo";

	public static final String PULLUP_MOTOR = "pullupMotor";

	public Servo pullUpServo;
	public DcMotor pullupMotor;

	public PullUpBar(HardwareMap hardwareMap) {
		pullUpServo = hardwareMap.servo.get(PULLUP_SERVO);
		pullupMotor = hardwareMap.dcMotor.get(PULLUP_MOTOR);
	}

	public void swingArmOut()
	{
		pullUpServo.setPosition(1.0);
	}

	public void swingArmIn()
	{
        pullUpServo.setPosition(0.0);
	}

	public void retractArm()
	{
        pullupMotor.setPower(-1.0);
	}

	public void extendArm()
	{
        pullupMotor.setPower(1.0);
	}
}