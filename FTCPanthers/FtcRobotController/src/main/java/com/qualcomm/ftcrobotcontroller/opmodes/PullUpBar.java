package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

public class PullUpBar
{
	public static final String SERVO_L = "leftPullupServo";
	public static final String SERVO_R = "leftPullupServo";

	public static final String MOTOR_L = "leftPullupMotor";
	public static final String MOTOR_R = "rightPullupMotor";

	public Servo servoL;
    public Servo servoR;
	public DcMotor motorL;
    public DcMotor motorR;

	public PullUpBar(HardwareMap hardwareMap) {
		servoL = hardwareMap.servo.get(SERVO_L);
		servoR = hardwareMap.servo.get(SERVO_R);
		motorL = hardwareMap.dcMotor.get(MOTOR_L);
		motorR = hardwareMap.dcMotor.get(MOTOR_R);
	}

	public void swingArmsOut()
	{
		servoL.setPosition(1.0);
        servoR.setPosition(1.0);
	}

	public void swingArmsIn()
	{
        servoL.setPosition(0.0);
        servoR.setPosition(0.0);
	}

	public void retractArms()
	{
        motorL.setPower(-1.0);
        motorR.setPower(-1.0);
	}

	public void extendArms()
	{
        motorL.setPower(1.0);
        motorR.setPower(1.0);
	}
}