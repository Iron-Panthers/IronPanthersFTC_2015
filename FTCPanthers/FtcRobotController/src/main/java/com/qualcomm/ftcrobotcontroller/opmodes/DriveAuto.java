package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.*;

public class DriveAuto
{
	public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

	public static final double BACK_WHEEL_DIAMETER = 4; //need to confirm
	public static final double ROBOT_WIDTH = 18;

	public DriveAuto(HardwareMap hardwareMap)
	{
		frontLeft = hardwareMap.dcMotor.get("frontLeft");
	    frontRight = hardwareMap.dcMotor.get("frontRight");
	    backLeft = hardwareMap.dcMotor.get("backLeft");
	    backRight = hardwareMap.dcMotor.get("backRight");
	}

	public void driveStraight(double distance, double power) //distance is in inches
	{
		double targetValue = distance/(BACK_WHEEL_DIAMETER * Math.PI);
		double leftStart = backLeft.getCurrentPosition();
        double rightStart = backRight.getCurrentPosition();

        double leftTargetValue = leftStart - targetValue; //negative since motor is on opposite side
        double rightTargetValue = rightStart + targetValue;

		while(backLeft.getCurrentPosition() < leftTargetValue && backRight.getCurrentPosition() < rightTargetValue)
		{
			backLeft.setPower(-power);
			backRight.setPower(-power);
			frontLeft.setPower(power);
			frontRight.setPower(power);
		}

        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
	}

	public void turnRight(double angle)
	{
		double leftStart = backLeft.getCurrentPosition();
        double rightStart = backRight.getCurrentPosition();

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / BACK_WHEEL_DIAMETER * Math.PI;

		double leftTargetValue = leftStart - targetValue; //negatives in place due to motor sides and turn direction
        double rightTargetValue = rightStart - targetValue;

		while(backRight.getCurrentPosition() > rightTargetValue && backLeft.getCurrentPosition() > leftTargetValue)
		{
			frontLeft.setPower(-0.5); //negatives due to motor sides
			backLeft.setPower(-0.5);
			frontRight.setPower(-0.5);
			backRight.setPower(-0.5);
		}
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
	}

	public void turnLeft(double angle)
	{
        double leftStart = backLeft.getCurrentPosition();
        double rightStart = backRight.getCurrentPosition();

        double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / BACK_WHEEL_DIAMETER * Math.PI;

        double leftTargetValue = leftStart + targetValue; //negatives in place due to motor sides and turn direction
        double rightTargetValue = rightStart + targetValue;

        while(backRight.getCurrentPosition() < rightTargetValue && backLeft.getCurrentPosition() < leftTargetValue)
        {
            frontLeft.setPower(0.5); //negatives due to motor sides
            backLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(0.5);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
	}
	
	public void wait(double seconds)
	{
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
		
		ElapsedTime elapsedTime = new ElapsedTime();
		elapsedTime.startTime();
		while(elapsedTime.time < seconds)
		{
			
		}
	}
}
